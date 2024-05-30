package com.CodeWarriors.GoldenTrainers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

import java.util.Date;
/*import jakarta.persistence.ManyToOne;*/
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre", length = 45, nullable = false ,  unique = true)
    private String nombre;

    @Column(name = "descripcion", length = 300 , nullable = false ,  unique = true)
    private String descripcion;

    @Column(name = "stock", nullable = false ,  unique = true)
    private Integer stock;

    @Column(name = "precio", nullable = false ,  unique = true)
    private Double precio;

    @Column(name = "imagen", length = 200 , nullable = false ,  unique = true)
    private String imagen;

    @Column(name = "nivel_sesion_adiestramiento", length = 45)
    private String nivelSesionAdiestramiento;

    @Column(name = "fecha_sesion_adiestramiento", length = 45)
    private Date fechaSesionAdiestramiento;

    @ManyToMany
    @JoinTable(
        name = "administradores_has_producto",
        joinColumns = @JoinColumn(name = "producto_id_producto"),
        inverseJoinColumns = @JoinColumn(name = "administradores_id_administradores")    
    )
    private Set<Administradores> administradores;
    
    // Constructor, getters, setters, hashCode, equals, toString
    public Producto() {
    }

    public Producto(Long idProducto, String nombre, String descripcion, Integer stock, Double precio, String imagen, String nivelSesionAdiestramiento, Date fechaSesionAdiestramiento /* , Categoria categoria  */) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.imagen = imagen;
        this.nivelSesionAdiestramiento = nivelSesionAdiestramiento;
        this.fechaSesionAdiestramiento = fechaSesionAdiestramiento;
/*        this.categoria = categoria;   */
    }

    // Add your getters and setters here
    
    

    public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNivelSesionAdiestramiento() {
		return nivelSesionAdiestramiento;
	}

	public void setNivelSesionAdiestramiento(String nivelSesionAdiestramiento) {
		this.nivelSesionAdiestramiento = nivelSesionAdiestramiento;
	}

	public Date getFechaSesionAdiestramiento() {
		return fechaSesionAdiestramiento;
	}

	public void setFechaSesionAdiestramiento(Date fechaSesionAdiestramiento) {
		this.fechaSesionAdiestramiento = fechaSesionAdiestramiento;
	}
/*
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}*/
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idProducto, nombre, descripcion, stock, precio, imagen, nivelSesionAdiestramiento, fechaSesionAdiestramiento /* , categoria  */);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(idProducto, producto.idProducto) &&
               Objects.equals(nombre, producto.nombre) &&
               Objects.equals(descripcion, producto.descripcion) &&
               Objects.equals(stock, producto.stock) &&
               Objects.equals(precio, producto.precio) &&
               Objects.equals(imagen, producto.imagen) &&
               Objects.equals(nivelSesionAdiestramiento, producto.nivelSesionAdiestramiento) &&
               Objects.equals(fechaSesionAdiestramiento, producto.fechaSesionAdiestramiento);
    /*           Objects.equals(categoria, producto.categoria);  */
    }

    @Override
    public String toString() {
        return "Producto{" +
               "idProducto=" + idProducto +
               ", nombre='" + nombre + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", stock=" + stock +
               ", precio=" + precio +
               ", imagen='" + imagen + '\'' +
               ", nivelSesionAdiestramiento='" + nivelSesionAdiestramiento + '\'' +
               ", fechaSesionAdiestramiento=" + fechaSesionAdiestramiento +
    /*           ", categoria=" + categoria +     */
               '}';
    }
}