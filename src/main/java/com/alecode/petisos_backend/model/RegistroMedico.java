package com.alecode.petisos_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Entidad que representa la tabla 'registros_medicos' en PostgreSQL.
 * Almacena el historial clínico por categoría (peso, vacunas, medicamentos, chequeos, etc.)[cite: 3].
 */

@Entity 
@Table(name = "registros_medicos")
public class RegistroMedico {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotBlank(message = "La categoría no puede estar vacía")
    @Column(nullable = false, length = 100)
    private String categoria; // Ejemplo: peso, vacunas, medicamentos, chequeos, etc.

    @NotBlank(message = "La descripción no puede estar vacía")
    @Column(nullable = false, length = 500)
    private String descripcion; // Detalles del registro médico

    @Column(name = "valor_kilogramos")
    private Double valorKilogramos; // Valor en kilogramos

    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaNacimiento; // Fecha de nacimiento de la mascota

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mascota_id", nullable = false)
    @JsonIgnoreProperties ({"registrosMedicos",  "tutor"})
    private Mascota mascota; // Relación con la entidad Mascota 

    // CONSTRUCTOR VACÍO
    public RegistroMedico() {
    }

    // CONSTRUCTOR CON PARÁMETROS
    public RegistroMedico(String categoria, String descripcion, Double valorKilogramos, String fechaNacimiento, Mascota mascota) {
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.valorKilogramos = valorKilogramos;
        this.fechaNacimiento = fechaNacimiento;
        this.mascota = mascota;
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValorKilogramos() {
        return valorKilogramos;
    }

    public void setValorKilogramos(Double valorKilogramos) {
        this.valorKilogramos = valorKilogramos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
