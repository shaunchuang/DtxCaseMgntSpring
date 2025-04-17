package itri.org.spring.controller;

import itri.org.spring.model.Appointment;
import itri.org.spring.model.AvailableSlot;
import itri.org.spring.model.Patient;
import itri.org.spring.service.AppointmentService;
import itri.org.spring.service.AvailableSlotService;
import itri.org.spring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"}, allowCredentials = "true")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AvailableSlotService availableSlotService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/today")
    public List<Map<String, Object>> getTodayAppointments() {
        Calendar cal = Calendar.getInstance();
        // reset to start of today
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date start = cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date end = cal.getTime();

        List<Appointment> appointments = appointmentService.findAllAppointments();
        List<Map<String, Object>> events = new ArrayList<>();

        for (Appointment ap : appointments) {
            Optional<AvailableSlot> optSlot = availableSlotService.findById(ap.getAvailableSlotId());
            if (optSlot.isEmpty()) continue;
            AvailableSlot slot = optSlot.get();
            Date slotDate = slot.getSlotDate();
            if (slotDate.before(start) || !slotDate.before(end)) {
                continue;
            }
            Long caseNo = ap.getCaseNo();
            Optional<Patient> optPatient = patientService.findById(caseNo);
            String patientName = optPatient.map(Patient::getName).orElse("");
            String genderAge = optPatient.map(p -> p.getGender() + "/" + p.getAge()).orElse("");
            Long condition = optPatient.map(Patient::getDiseaseId).orElse(null);
            List<Appointment> caseAppts = appointmentService.findByCaseNo(caseNo);
            String type = caseAppts.size() > 1 ? "複診" : "初診";
            String appointmentTime = slot.getSlotBeginTime() + " - " + slot.getSlotEndTime();
            String status = ap.getCheckinTime() != null ? "已報到" : "未報到";

            Map<String, Object> event = new HashMap<>();
            event.put("caseNo", caseNo);
            event.put("slot", ap.getAvailableSlotId());
            event.put("type", type);
            event.put("patientName", patientName);
            event.put("genderAge", genderAge);
            event.put("condition", condition);
            event.put("appointmentTime", appointmentTime);
            event.put("status", status);
            events.add(event);
        }
        return events;
    }
}