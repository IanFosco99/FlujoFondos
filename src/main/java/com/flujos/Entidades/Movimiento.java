/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.Entidades;

/**
 *
 * @author monse
 */
public class Movimiento {
    private Long idMovimiento;
    private String descripcionMovimiento;

    public Movimiento(Long idMovimiento, String descripcionMovimiento) {
        this.idMovimiento = idMovimiento;
        this.descripcionMovimiento = descripcionMovimiento;
    }

    public Movimiento() {
        
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public void setDescripcionMovimiento(String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }

}
