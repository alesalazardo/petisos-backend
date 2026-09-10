package com.alecode.petisos_backend.model;

// IMPORTACION DE CLASES DE JAVA
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

// IMPORTACION DE CLASES PARA LA SERIALIZACION JSON
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// ANOTACIONES DE LA CLASE
@Entity
@Table(name = "mascotas")
public class Mascota {
    // ANOTACIONES DE LOS ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "El nombre no puede estar vacío")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo debe contener letras")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank (message = "La especie no puede estar vacía")
    @Column(nullable = false, length = 30)
    private String especie;
    
    @Column(nullable = false, length = 30)
    private String raza;

    @PastOrPresent(message = "La fecha de nacimiento no puede ser una fecha futura")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tutor_id", nullable = false)
    @JsonIgnoreProperties("mascotas")
    private Tutor tutor;

    // CONSTRUCTOR VACÍO
    public Mascota() {
    }
    // CONSTRUCTOR CON PARÁMETROS
    public Mascota(String nombre, String especie, String raza, LocalDate fechaNacimiento, String color, String descripcion, Tutor tutor) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.color = color;
        this.descripcion = descripcion;
        this.tutor = tutor;
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
