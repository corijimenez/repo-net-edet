package com.mycompany.proyecto.edet.domain.entities;

import java.sql.Time;

public class CodigoConfirmacion{
private String codigo;
private Time horaCreacion;
private Time horaCaducidad;
private int intentosRestantes = 3;

    public CodigoConfirmacion(String codigo, Time horaCreacion, Time horaCaducidad) {
        this.codigo = codigo;
        this.horaCreacion = horaCreacion;
        this.horaCaducidad = horaCaducidad;
    }
    

    public CodigoConfirmacion(String codigo) {
    this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Time getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(Time horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public Time getHoraCaducidad() {
        return horaCaducidad;
    }

    public void setHoraCaducidad(Time horaCaducidad) {
        this.horaCaducidad = horaCaducidad;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public void setIntentosRestantes(int intentosRestantes) {
        this.intentosRestantes = intentosRestantes;
    }

    @Override
    public String toString() {
        return "CodigoConfirmacion{" + "codigo=" + codigo + '}';
    }


}