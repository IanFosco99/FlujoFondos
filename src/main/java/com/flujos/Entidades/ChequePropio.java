/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.Entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Sol
 */
public class ChequePropio {
    
    private Long idCheque;
    private Long numCheque;
    private BigDecimal importeCheque;
    private Date fechaCobroCheque;
    private Integer estadoCheque;
    private String observacionCheque;
    private Long titularDestino;
    private String usoCheque;
    private Long idCuentaSalida;
    private Date fechaEntregaCheque;

    public ChequePropio(Long idCheque, Long numCheque, BigDecimal importeCheque, Date fechaCobroCheque, Integer estadoCheque, String observacionCheque, Long titularDestino, String usoCheque, Long idCuentaSalida, Date fechaEntregaCheque) {
        this.idCheque = idCheque;
        this.numCheque = numCheque;
        this.importeCheque = importeCheque;
        this.fechaCobroCheque = fechaCobroCheque;
        this.estadoCheque = estadoCheque;
        this.observacionCheque = observacionCheque;
        this.titularDestino = titularDestino;
        this.usoCheque = usoCheque;
        this.idCuentaSalida = idCuentaSalida;
        this.fechaEntregaCheque = fechaEntregaCheque;
    }

    public ChequePropio() {
    }

    public Long getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(Long idCheque) {
        this.idCheque = idCheque;
    }

    public Long getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(Long numCheque) {
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

    public Long getIdCuentaSalida() {
        return idCuentaSalida;
    }

    public void setIdCuentaSalida(Long idCuentaSalida) {
        this.idCuentaSalida = idCuentaSalida;
    }

    public Date getFechaEntregaCheque() {
        return fechaEntregaCheque;
    }

    public void setFechaEntregaCheque(Date fechaEntregaCheque) {
        this.fechaEntregaCheque = fechaEntregaCheque;
    }
    
    
    
}
