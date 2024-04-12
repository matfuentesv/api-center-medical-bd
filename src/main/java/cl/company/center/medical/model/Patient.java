package cl.company.center.medical.model;

import jakarta.persistence.*;

@Entity(name = "Paciente")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "run")
    private String run;


    public Long getId() {
        return id;
    }

    public Patient setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Patient setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Patient setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Patient setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Patient setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public String getRun() {
        return run;
    }

    public Patient setRun(String run) {
        this.run = run;
        return this;
    }
}