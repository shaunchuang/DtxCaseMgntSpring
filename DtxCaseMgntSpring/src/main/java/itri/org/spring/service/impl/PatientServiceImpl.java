package itri.org.spring.service.impl;

import itri.org.spring.model.HistoryDisease;
import itri.org.spring.model.MedicalHistory;
import itri.org.spring.model.Patient;
import itri.org.spring.repository.HistoryDiseaseRepository;
import itri.org.spring.repository.MedicalHistoryRepository;
import itri.org.spring.repository.PatientRepository;
import itri.org.spring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final HistoryDiseaseRepository historyDiseaseRepository;
    private final MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository,
                              HistoryDiseaseRepository historyDiseaseRepository,
                              MedicalHistoryRepository medicalHistoryRepository) {
        this.patientRepository = patientRepository;
        this.historyDiseaseRepository = historyDiseaseRepository;
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Optional<Patient> findByIdno(String idno) {
        return patientRepository.findByIdno(idno);
    }

    @Override
    public List<Patient> findByName(String name) {
        // 使用全量查詢並篩選指定名稱
        return patientRepository.findAll().stream()
                .filter(patient -> name.equals(patient.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Patient> findByNameKeyword(String nameKeyword) {
        // 使用全量查詢並篩選包含關鍵字的名稱
        return patientRepository.findAll().stream()
                .filter(patient -> patient.getName() != null && patient.getName().contains(nameKeyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<Patient> findByGender(String gender) {
        // 使用全量查詢並篩選指定性別
        return patientRepository.findAll().stream()
                .filter(patient -> gender.equals(patient.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Patient> findByCity(String city) {
        // 使用全量查詢並篩選指定城市
        return patientRepository.findAll().stream()
                .filter(patient -> city.equals(patient.getCity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Patient> findByDistrict(String district) {
        // 使用全量查詢並篩選指定區域
        return patientRepository.findAll().stream()
                .filter(patient -> district.equals(patient.getDistrict()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Patient> findByBirthRange(Date startDate, Date endDate) {
        // 使用全量查詢並篩選出生日期在指定範圍內的
        return patientRepository.findAll().stream()
                .filter(patient -> {
                    Date birth = patient.getBirth();
                    return birth != null && !birth.before(startDate) && !birth.after(endDate);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Patient addHistoryDisease(Long patientId, Long historyDiseaseId) {
        Optional<Patient> optPatient = patientRepository.findById(patientId);
        Optional<HistoryDisease> optHistoryDisease = historyDiseaseRepository.findById(historyDiseaseId);

        if (optPatient.isPresent() && optHistoryDisease.isPresent()) {
            Patient patient = optPatient.get();
            HistoryDisease historyDisease = optHistoryDisease.get();
            
            List<HistoryDisease> historyDiseases = patient.getHistoryDiseases();
            if (historyDiseases == null) {
                historyDiseases = new ArrayList<>();
                patient.setHistoryDiseases(historyDiseases);
            }
            
            if (!historyDiseases.contains(historyDisease)) {
                historyDiseases.add(historyDisease);
                patient.setHistoryDiseases(historyDiseases);
                return patientRepository.save(patient);
            }
            return patient;
        }
        return null;
    }

    @Override
    public Patient removeHistoryDisease(Long patientId, Long historyDiseaseId) {
        Optional<Patient> optPatient = patientRepository.findById(patientId);
        Optional<HistoryDisease> optHistoryDisease = historyDiseaseRepository.findById(historyDiseaseId);

        if (optPatient.isPresent() && optHistoryDisease.isPresent()) {
            Patient patient = optPatient.get();
            HistoryDisease historyDisease = optHistoryDisease.get();

            List<HistoryDisease> historyDiseases = patient.getHistoryDiseases();
            if (historyDiseases != null) {
                historyDiseases.remove(historyDisease);
                patient.setHistoryDiseases(historyDiseases);
                return patientRepository.save(patient);
            }
        }
        return null;
    }

    @Override
    public List<HistoryDisease> getHistoryDiseases(Long patientId) {
        Optional<Patient> optPatient = patientRepository.findById(patientId);
        if (optPatient.isPresent()) {
            Patient patient = optPatient.get();
            return patient.getHistoryDiseases();
        }
        return new ArrayList<>();
    }

    @Override
    public Patient addMedicalHistory(Long patientId, Long medicalHistoryId) {
        Optional<Patient> optPatient = patientRepository.findById(patientId);
        Optional<MedicalHistory> optMedicalHistory = medicalHistoryRepository.findById(medicalHistoryId);

        if (optPatient.isPresent() && optMedicalHistory.isPresent()) {
            Patient patient = optPatient.get();
            MedicalHistory medicalHistory = optMedicalHistory.get();

            List<MedicalHistory> medicalHistories = patient.getMedicalHistories();
            if (medicalHistories == null) {
                medicalHistories = new ArrayList<>();
                patient.setMedicalHistories(medicalHistories);
            }

            if (!medicalHistories.contains(medicalHistory)) {
                medicalHistories.add(medicalHistory);
                patient.setMedicalHistories(medicalHistories);
                return patientRepository.save(patient);
            }
            return patient;
        }
        return null;
    }

    @Override
    public Patient removeMedicalHistory(Long patientId, Long medicalHistoryId) {
        Optional<Patient> optPatient = patientRepository.findById(patientId);
        Optional<MedicalHistory> optMedicalHistory = medicalHistoryRepository.findById(medicalHistoryId);

        if (optPatient.isPresent() && optMedicalHistory.isPresent()) {
            Patient patient = optPatient.get();
            MedicalHistory medicalHistory = optMedicalHistory.get();

            List<MedicalHistory> medicalHistories = patient.getMedicalHistories();
            if (medicalHistories != null) {
                medicalHistories.remove(medicalHistory);
                patient.setMedicalHistories(medicalHistories);
                return patientRepository.save(patient);
            }
        }
        return null;
    }

    @Override
    public List<MedicalHistory> getMedicalHistories(Long patientId) {
        Optional<Patient> optPatient = patientRepository.findById(patientId);
        if (optPatient.isPresent()) {
            Patient patient = optPatient.get();
            return patient.getMedicalHistories();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> findByBirthBetween(Date start, Date end) {
        return patientRepository.findByBirthBetween(start, end);
    }
}