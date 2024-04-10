package cl.company.center.medical.repository;

import cl.company.center.medical.model.Doctor;
import cl.company.center.medical.model.MedicalRecord;
import cl.company.center.medical.model.Patient;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MedicalRepositoryImpl implements MedicalRepository{

    private final Map<String, Patient> patients = new HashMap<>();


    @Override
    public List<Patient>dataSource(){

        Doctor doctor1 = new Doctor("D001", "Dr. Smith", "Cardiología", "+123456789", "dr.smith@example.com", "Lunes a Viernes 9:00-17:00", "Hospital Central");
        Doctor doctor2 = new Doctor("D002", "Dr. Johnson", "Pediatría", "+987654321", "dr.johnson@example.com", "Lunes a Viernes 8:00-16:00", "Hospital Infantil");
        Doctor doctor3 = new Doctor("D003", "Dr. Martinez", "Neurología", "+112233445", "dr.martinez@example.com", "Martes y Jueves 10:00-18:00", "Hospital Neurológico");
        Doctor doctor4 = new Doctor("D004", "Dra. Garcia", "Dermatología", "+554433221", "dra.garcia@example.com", "Lunes, Miércoles y Viernes 8:30-16:30", "Hospital Dermatológico");
        Doctor doctor5 = new Doctor("D005", "Dr. Fernandez", "Oftalmología", "+778899001", "dr.fernandez@example.com", "Lunes y Jueves 9:30-17:30", "Hospital Oftalmológico");
        Doctor doctor6 = new Doctor("D006", "Dra. Lopez", "Ginecología", "+112233445", "dra.lopez@example.com", "Lunes, Miércoles y Viernes 8:00-16:00", "Hospital de la Mujer");


        List<Patient> patientList = new ArrayList<>();
        List<MedicalRecord> medicalRecords1 = new ArrayList<>();
        MedicalRecord record1 = new MedicalRecord();
        record1.setDate("2022-01-15");
        record1.setDoctor(doctor1);
        record1.setDiagnosis("Gripe");
        record1.setTreatment("Descanso y medicación");

        MedicalRecord record2 = new MedicalRecord();
        record2.setDate("2022-02-05");
        record2.setDoctor(doctor2);
        record2.setDiagnosis("Esguince de tobillo");
        record2.setTreatment("Inmovilización y fisioterapia");

        MedicalRecord record3 = new MedicalRecord();
        record3.setDate("2022-03-20");
        record3.setDoctor(doctor3);
        record3.setDiagnosis("Dolor abdominal");
        record3.setTreatment("Estudios para diagnóstico");
        medicalRecords1.add(record1);
        medicalRecords1.add(record2);
        medicalRecords1.add(record3);

        List<MedicalRecord> medicalRecords2 = new ArrayList<>();

        // Creación de registros médicos dummy adicionales
        MedicalRecord record4 = new MedicalRecord();
        record4.setDate("2022-04-10");
        record4.setDoctor(doctor4);
        record4.setDiagnosis("Fiebre alta");
        record4.setTreatment("Antibióticos y reposo");

        MedicalRecord record5 = new MedicalRecord();
        record5.setDate("2022-05-22");
        record5.setDoctor(doctor5);
        record5.setDiagnosis("Lesión en la rodilla");
        record5.setTreatment("Cirugía reconstructiva");

        MedicalRecord record6 = new MedicalRecord();
        record6.setDate("2022-06-18");
        record6.setDoctor(doctor6);
        record6.setDiagnosis("Conjuntivitis");
        record6.setTreatment("Gotas oftálmicas y lavados");


        medicalRecords2.add(record4);
        medicalRecords2.add(record5);
        medicalRecords2.add(record6);



        Patient patient1 = new Patient("1", "John", 30,"Avenida 456",medicalRecords1);
        Patient patient2 = new Patient("2", "Jane",  25,"Calle Principal",medicalRecords2);

        patientList.add(patient1);
        patientList.add(patient2);

        return patientList;
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(dataSource());
    }

    public MedicalRecord getMedicalRecord(String patientId) {
        // Supongamos que aquí obtienes el historial médico de una fuente de datos
        // En este ejemplo, devolvemos un historial médico dummy
        return new MedicalRecord();
    }

    public List<Doctor> getAttendingDoctors(String patientId) {
        // Supongamos que aquí obtienes la lista de médicos que han atendido al paciente de una fuente de datos
        // En este ejemplo, devolvemos una lista de médicos dummy
        List<Doctor> doctors = new ArrayList<>();
        //doctors.add(new Doctor("Dr. Smith", "Cardiología"));
        //doctors.add(new Doctor("Dr. Johnson", "Oftalmología"));
        return doctors;
    }

    private static List<Patient> mapToList(Map<String, Patient> patientMap) {
        return patientMap.values().stream().collect(Collectors.toList());
    }
}
