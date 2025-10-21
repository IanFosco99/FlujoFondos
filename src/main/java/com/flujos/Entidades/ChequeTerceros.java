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
public class ChequeTerceros {
    private Long idCheque;
    private Long nroCheque;
    private BigDecimal importeCheque;
    private Date fechaCobroCheque;
    private String tipoCheque;
    private Integer estadoCheque;
    private String observacionCheque;
    private Date fechaEntregaCheque;
    private Long titularCheque;
    private Long titularDestino;
    private String usoCheque;
    private Long idCuentaEntrada;
    private Long idCuentaSalida;

    public ChequeTerceros(Long idCheque, Long nroCheque, BigDecimal importeCheque, Date fechaCobroCheque, String tipoCheque, Integer estadoCheque, String observacionCheque, Date fechaEntregaCheque, Long titularCheque, Long titularDestino, String usoCheque, Long idCuentaEntrada, Long idCuentaSalida) {
        this.idCheque = idCheque;
        this.nroCheque = nroCheque;
        this.importeCheque = importeCheque;
        this.fechaCobroCheque = fechaCobroCheque;
        this.tipoCheque = tipoCheque;
        this.estadoCheque = estadoCheque;
        this.observacionCheque = observacionCheque;
        this.fechaEntregaCheque = fechaEntregaCheque;
        this.titularCheque = titularCheque;
        this.titularDestino = titularDestino;
        this.usoCheque = usoCheque;
        this.idCuentaEntrada = idCuentaEntrada;
        this.idCuentaSalida = idCuentaSalida;
    }

    public ChequeTerceros() {
    }

    public Long getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(Long idCheque) {
        this.idCheque = idCheque;
    }

    public Long getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(Long nroCheque) {
        this.nroCheque = nroCheque;
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

    public Long getIdCuentaEntrada() {
        return idCuentaEntrada;
    }

    public void setIdCuentaEntrada(Long idCuentaEntrada) {
        this.idCuentaEntrada = idCuentaEntrada;
    }

    public Long getIdCuentaSalida() {
        return idCuentaSalida;
    }

    public void setIdCuentaSalida(Long idCuentaSalida) {
        this.idCuentaSalida = idCuentaSalida;
    }      
    
}
