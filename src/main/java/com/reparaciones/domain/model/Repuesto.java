package com.reparaciones.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Repuesto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String codigo;
    private BigDecimal precioCosto;
    private BigDecimal precioVenta;
    private Integer stockActual;
    private Integer stockMinimo;
    private Long proveedorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;

    public Repuesto() {}

    public Repuesto(String nombre, String codigo, BigDecimal precioCosto, BigDecimal precioVenta, Integer stockActual, Integer stockMinimo, Long proveedorId) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.proveedorId = proveedorId;
    }

    public boolean necesitaReposicion() {
        return stockActual <= stockMinimo;
    }

    public void reducirStock(Integer cantidad) {
        if (this.stockActual >= cantidad) {
            this.stockActual -= cantidad;
        }
    }

    public void aumentarStock(Integer cantidad) {
        this.stockActual += cantidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public BigDecimal getPrecioCosto() { return precioCosto; }
    public void setPrecioCosto(BigDecimal precioCosto) { this.precioCosto = precioCosto; }
    public BigDecimal getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(BigDecimal precioVenta) { this.precioVenta = precioVenta; }
    public Integer getStockActual() { return stockActual; }
    public void setStockActual(Integer stockActual) { this.stockActual = stockActual; }
    public Integer getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }
    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}