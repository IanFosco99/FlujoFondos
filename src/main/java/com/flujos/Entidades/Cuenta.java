/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.Entidades;

/**
 *
 * @author monse
 */
public class Cuenta {
    
    private Long idCuenta;
    private String codConcepto;
    private String nombreConcepto;
    private String claseConcepto;
    private Long idMovimiento;
    private String Ingreso;

    public Cuenta(Long idCuenta, String codConcepto, String nombreConcepto, String claseConcepto, Long idMovimiento, String Ingreso) {
        this.idCuenta = idCuenta;
        this.codConcepto = codConcepto;
        this.nombreConcepto = nombreConcepto;
        this.claseConcepto = claseConcepto;
        this.idMovimiento = idMovimiento;
        this.Ingreso = Ingreso;
    }

    public Cuenta() {
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCodConcepto() {
        return codConcepto;
    }

    public void setCodConcepto(String codConcepto) {
        this.codConcepto = codConcepto;
    }

    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    public String getClaseConcepto() {
        return claseConcepto;
    }

    public void setClaseConcepto(String claseConcepto) {
        this.claseConcepto = claseConcepto;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getIngreso() {
        return Ingreso;
    }

    public void setIngreso(String Ingreso) {
        this.Ingreso = Ingreso;
    }
    
    
}
