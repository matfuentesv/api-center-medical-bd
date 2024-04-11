package cl.company.center.medical.service;

import cl.company.center.medical.repository.model.Historial_Medico;
import cl.company.center.medical.repository.model.Paciente;
import cl.company.center.medical.repository.MedicalRecordRepository;
import cl.company.center.medical.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class MedicalServiceImpl implements MedicalService {


    @Autowired
    private PatientRepository doctorRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;


    @Override
    public List<Paciente> getAllPatients() {

        //Historial Medico
        final List<Historial_Medico> historialMedico = medicalRecordRepository
                                                        .findAll();

        List<Paciente>pacienteList =  historialMedico
                                     .stream()
                                     .map(Historial_Medico::getPaciente)
                                     .toList();


        List<Paciente>pacienteListAll = new ArrayList<>();
        pacienteList.forEach(x-> {

            List<Historial_Medico> historialMedicoP = historialMedico
                                                        .stream()
                                                        .filter(h-> Objects.equals(h.getPaciente().getId(), x.getId()))
                                                        .toList();

            Paciente paciente = new Paciente()
                    .setId(x.getId())
                    .setNombre(x.getNombre())
                    .setApellido(x.getApellido())
                    .setEdad(x.getEdad())
                    .setDireccion(x.getDireccion());

            pacienteListAll.add(paciente);

        });


        return   pacienteListAll;

    }
}
