package com.roshka.Proyecto.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
public class Reserva {
    @Id
    @GeneratedValue
    public Long id;
    public String nombre;
    public String apellido;
    public Integer telefono;
    public LocalDate fechaE;
    public LocalDate fechaS;
    public Integer cantidad;
    public String observaciones;
    public Boolean presupuesto;


    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaE() {
        return fechaE;
    }

    public void setFechaE(LocalDate fechaE) {
        this.fechaE = fechaE;
    }

    public LocalDate getFechaS() {
        return fechaS;
    }

    public void setFechaS(LocalDate fechaS) {
        this.fechaS = fechaS;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Boolean presupuesto) {
        this.presupuesto = presupuesto;
    }
}