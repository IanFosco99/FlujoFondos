/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.Entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author monse
 */
public class FlujosMov {
    
    private Long idFlujoMovimineto;
    private Date fechaMovimiento;
    private Long idMovimiento;
    private Long idCuenta;
    private BigDecimal importe;
    private String observacionesMovimiento;
    private Long idCheque;

    
    public FlujosMov(Long idFlujoMovimineto, Date fechaMovimiento, Long idMovimiento, Long idCuenta, BigDecimal importe, String observacionesMovimiento, Long idCheque) {
        this.idFlujoMovimineto = idFlujoMovimineto;
        this.fechaMovimiento = fechaMovimiento;
        this.idMovimiento = idMovimiento;
        this.idCuenta = idCuenta;
        this.importe = importe;
        this.observacionesMovimiento = observacionesMovimiento;
        this.idCheque = idCheque;
    }

    public FlujosMov() {
    }

    public Long getIdFlujoMovimineto() {
        return idFlujoMovimineto;
    }

    public void setIdFlujoMovimineto(Long idFlujoMovimineto) {
        this.idFlujoMovimineto = idFlujoMovimineto;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getObservacionesMovimiento() {
        return observacionesMovimiento;
    }

    public void setObservacionesMovimiento(String observacionesMovimiento) {
        this.observacionesMovimiento = observacionesMovimiento;
    }

    public Long getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(Long idCheque) {
        this.idCheque = idCheque;
    }
    
    
    
}
