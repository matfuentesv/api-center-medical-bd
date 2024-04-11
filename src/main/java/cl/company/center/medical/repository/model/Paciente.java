package cl.company.center.medical.repository.model;

import jakarta.persistence.*;

@Entity
public class Paciente {
    @Id
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "EDAD")
    private int edad;
    @Column(name = "DIRECCION")
    private String direccion;


    public Long getId() {
        return id;
    }

    public Paciente setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Paciente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Paciente setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public int getEdad() {
        return edad;
    }

    public Paciente setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Paciente setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

}