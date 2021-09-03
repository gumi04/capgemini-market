package com.capgemini.market.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {

    @Id //indicamos la llaveprimaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;


    @Column(name = "id_cliente")
    private String idCliente;

    private Date fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private  String comentario;

    private String estado;

    @ManyToOne
    @JoinColumn(name="id_cliente",insertable = false,updatable = false)
    private  Cliente cliente;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> productos;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ComprasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.productos = productos;
    }
}
