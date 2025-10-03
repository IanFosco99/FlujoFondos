/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.Entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Ian
 */
public class Cheque {
 private Long idCheque;
 private Integer numCheque;
 private BigDecimal importeCheque;
 private Date fechaCobroCheque;
 private String tipoCheque;
 private Integer estadoCheque;
 private String observacionCheque;
 private Date fechaEntregaCheque;
 private Long titularCheque;
 private Long titularDestino;
 private String usoCheque;

    public Cheque(Long idCheque, Integer numCheque, BigDecimal importeCheque, Date fechaCobroCheque, String tipoCheque, Integer estadoCheque, String observacionCheque, Date fechaEntregaCheque, Long titularCheque, Long titularDestino, String usoCheque) {
        this.idCheque = idCheque;
        this.numCheque = numCheque;
        this.importeCheque = importeCheque;
        this.fechaCobroCheque = fechaCobroCheque;
        this.tipoCheque = tipoCheque;
        this.estadoCheque = estadoCheque;
        this.observacionCheque = observacionCheque;
        this.fechaEntregaCheque = fechaEntregaCheque;
        this.titularCheque = titularCheque;
        this.titularDestino = titularDestino;
        this.usoCheque = usoCheque;
    }

    public Cheque() {
    }

    public Long getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(Long idCheque) {
        this.idCheque = idCheque;
    }

    public Integer getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(Integer numCheque) {
        this.numCheque = numCheque;
    }

    public BigDecimal getImporteCheque() {
        return importeCheque;
    }

    public void setImporteCheque(BigDecimal importeCheque) {
        this.importeCheque = importeCheque;
    }

    public Date getFechaCobroCheque() {
        return fechaCobroCheque;
    }

    public void setFechaCobroCheque(Date fechaCobroCheque) {
        this.fechaCobroCheque = fechaCobroCheque;
    }

    public String getTipoCheque() {
        return tipoCheque;
    }

    public void setTipoCheque(String tipoCheque) {
        this.tipoCheque = tipoCheque;
    }

    public Integer getEstadoCheque() {
        return estadoCheque;
    }

    public void setEstadoCheque(Integer estadoCheque) {
        this.estadoCheque = estadoCheque;
    }

    public String getObservacionCheque() {
        return observacionCheque;
    }

    public void setObservacionCheque(String observacionCheque) {
        this.observacionCheque = observacionCheque;
    }

    public Date getFechaEntregaCheque() {
        return fechaEntregaCheque;
    }

    public void setFechaEntregaCheque(Date fechaEntregaCheque) {
        this.fechaEntregaCheque = fechaEntregaCheque;
    }

    public Long getTitularCheque() {
        return titularCheque;
    }

    public void setTitularCheque(Long titularCheque) {
        this.titularCheque = titularCheque;
    }

    public Long getTitularDestino() {
        return titularDestino;
    }

    public void setTitularDestino(Long titularDestino) {
        this.titularDestino = titularDestino;
    }

    public String getUsoCheque() {
        return usoCheque;
    }

    public void setUsoCheque(String usoCheque) {
        this.usoCheque = usoCheque;
    }
    
    
}