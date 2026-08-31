package com.alecode.petisos_backend.model;

// IMPORTACIONES DE CLASES DE JAVA
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// IMPORTACIONES DE CLASES PARA LA SERIALIZACION JSON
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tutores")
public class Tutor {
    // ANOTACIONES DE LOS ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String telefono;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("tutor")
    private List<Mascota> mascotas = new ArrayList<>();

    // CONSTRUCTOR VACÍO
    public Tutor() {
    }

    // CONSTRUCTOR CON PARÁMETROS
    public Tutor(String nombre, String apellido, String telefono, String email, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
