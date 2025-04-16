package itri.org.spring.service.impl;

import itri.org.spring.model.Patient;
import itri.org.spring.model.HistoryDisease;
import itri.org.spring.model.MedicalHistory;
import itri.org.spring.repository.PatientRepository;
import itri.org.spring.repository.HistoryDiseaseRepository;
import itri.org.spring.repository.MedicalHistoryRepository;
import itri.org.spring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final HistoryDiseaseRepository historyDiseaseRepository;
    private final MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    public PatientServiceImpl(
            PatientRepository patientRepository,
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
        return patientRepository.findByName(name);
    }

    @Override
    public List<Patient> findByNameContaining(String keyword) {
        return patientRepository.findByNameContaining(keyword);
    }

    @Override
    public List<Patient> findByGender(String gender) {
        return patientRepository.findByGender(gender);
    }

    @Override
    public List<Patient> findByCity(String city) {
        return patientRepository.findByCity(city);
    }

    @Override
    public List<Patient> findByDistrict(String district) {
        return patientRepository.findByDistrict(district);
    }

    @Override
    public List<Patient> findByBirthBetween(Date start, Date end) {
        return patientRepository.findByBirthBetween(start, end);
    }

    @Override
    public Patient addHistoryDisease(Long patientId, Long diseaseId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        Optional<HistoryDisease> diseaseOpt = historyDiseaseRepository.findById(diseaseId);
        
        if (patientOpt.isPresent() && diseaseOpt.isPresent()) {
            Patient patient = patientOpt.get();
            HistoryDisease disease = diseaseOpt.get();
            
            if (patient.getHistoryDisease() == null) {
                patient.setHistoryDisease(new ArrayList<>());
            }
            
            if (!patient.getHistoryDisease().contains(disease)) {
                patient.getHistoryDisease().add(disease);
                return patientRepository.save(patient);
            }
            return patient;
        }
        return null;
    }

    @Override
    public Patient removeHistoryDisease(Long patientId, Long diseaseId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        Optional<HistoryDisease> diseaseOpt = historyDiseaseRepository.findById(diseaseId);
        
        if (patientOpt.isPresent() && diseaseOpt.isPresent()) {
            Patient patient = patientOpt.get();
            HistoryDisease disease = diseaseOpt.get();
            
            if (patient.getHistoryDisease() != null) {
                patient.getHistoryDisease().remove(disease);
                return patientRepository.save(patient);
            }
            return patient;
        }
        return null;
    }

    @Override
    public List<HistoryDisease> getHistoryDiseases(Long patientId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (patientOpt.isPresent()) {
            Patient patient = patientOpt.get();
            return patient.getHistoryDisease();
        }
        return new ArrayList<>();
    }

    @Override
    public Patient addMedicalHistory(Long patientId, Long medicalHistoryId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        Optional<MedicalHistory> medicalHistoryOpt = medicalHistoryRepository.findById(medicalHistoryId);
        
        if (patientOpt.isPresent() && medicalHistoryOpt.isPresent()) {
            Patient patient = patientOpt.get();
            MedicalHistory medicalHistory = medicalHistoryOpt.get();
            
            if (patient.getMedicalHistory() == null) {
                patient.setMedicalHistory(new ArrayList<>());
            }
            
            if (!patient.getMedicalHistory().contains(medicalHistory)) {
                patient.getMedicalHistory().add(medicalHistory);
                return patientRepository.save(patient);
            }
            return patient;
        }
        return null;
    }

    @Override
    public Patient removeMedicalHistory(Long patientId, Long medicalHistoryId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        Optional<MedicalHistory> medicalHistoryOpt = medicalHistoryRepository.findById(medicalHistoryId);
        
        if (patientOpt.isPresent() && medicalHistoryOpt.isPresent()) {
            Patient patient = patientOpt.get();
            MedicalHistory medicalHistory = medicalHistoryOpt.get();
            
            if (patient.getMedicalHistory() != null) {
                patient.getMedicalHistory().remove(medicalHistory);
                return patientRepository.save(patient);
            }
            return patient;
        }
        return null;
    }

    @Override
    public List<MedicalHistory> getMedicalHistories(Long patientId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (patientOpt.isPresent()) {
            Patient patient = patientOpt.get();
            return patient.getMedicalHistory();
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
}