/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.flujos.Entidades;

/**
 *
 * @author monse
 */
public class ClienteProveedor {
    
    private Long idClienteProveedor;
    private String nomRazonSocial;
    private Integer dniCuit;
    private String telefono;
    private String email;
    private String tipoClienteProveedor;
    
    
    public ClienteProveedor(Long idClienteProveedor, String nomRazonSocial, Integer dniCuit, String telefono, String email, String tipoClienteProveedor) {
        this.idClienteProveedor = idClienteProveedor;
        this.nomRazonSocial = nomRazonSocial;
        this.dniCuit = dniCuit;
        this.telefono = telefono;
        this.email = email;
        this.tipoClienteProveedor = tipoClienteProveedor;
    }

    public ClienteProveedor() {
        
    }

    public Long getIdClienteProveedor() {
        return idClienteProveedor;
    }

    public void setIdClienteProveedor(Long idClienteProveedor) {
        this.idClienteProveedor = idClienteProveedor;
    }

    public String getNomRazonSocial() {
        return nomRazonSocial;
    }

    public void setNomRazonSocial(String nomRazonSocial) {
        this.nomRazonSocial = nomRazonSocial;
    }

    public Integer getDniCuit() {
        return dniCuit;
    }

    public void setDniCuit(Integer dniCuit) {
        this.dniCuit = dniCuit;
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

    public String getTipoClienteProveedor() {
        return tipoClienteProveedor;
    }

    public void setTipoClienteProveedor(String tipoClienteProveedor) {
        this.tipoClienteProveedor = tipoClienteProveedor;
    }   


}
