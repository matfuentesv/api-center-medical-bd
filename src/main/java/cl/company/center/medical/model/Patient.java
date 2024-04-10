package cl.company.center.medical.model;

import java.util.List;

public class Patient {

    private String id;
    private String name;
    private int age;
    private String address;
    private List<MedicalRecord> medicalRecords;

    public Patient(String id, String name, int age, String address, List<MedicalRecord> medicalRecords) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.medicalRecords = medicalRecords;
    }

    public String getId() {
        return id;
    }

    public Patient setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Patient setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Patient setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Patient setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public Patient setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
        return this;
    }
}
