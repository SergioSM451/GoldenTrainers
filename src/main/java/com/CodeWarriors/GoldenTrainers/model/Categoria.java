package com.CodeWarriors.GoldenTrainers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "nombre", length = 45, nullable = false, unique = true)
    private String nombre;

    @Column(name = "descripcion", length = 200, nullable = false, unique = true)
    private String descripcion;

    @ManyToMany
    @JoinTable(
        name = "categoria_has_producto",
        joinColumns = @JoinColumn(name = "categoria_id_categoria"),
        inverseJoinColumns = @JoinColumn(name = "producto_id_producto")
    )
    private Set<Producto> productos;

    // Constructor, getters, setters, hashCode, equals, toString
    public Categoria() {
    }

    public Categoria(Long idCategoria, String nombre, String descripcion, Set<Producto> productos) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    // Getters and Setters
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
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

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, nombre, descripcion, productos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(idCategoria, categoria.idCategoria) &&
               Objects.equals(nombre, categoria.nombre) &&
               Objects.equals(descripcion, categoria.descripcion) &&
               Objects.equals(productos, categoria.productos);
    }

    @Override
    public String toString() {
        return "Categoria{" +
               "idCategoria=" + idCategoria +
               ", nombre='" + nombre + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", productos=" + productos +
               '}';
    }
}
