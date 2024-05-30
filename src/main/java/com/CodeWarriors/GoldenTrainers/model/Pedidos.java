package com.CodeWarriors.GoldenTrainers.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "fecha" , length = 60, nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	@Column(name = "total", length = 20, nullable = false, unique = false)
	private Double total;
	@Enumerated(EnumType.STRING)
	@Column(name = "estatus", length = 20, nullable = false, unique = false)
	private OrderStatus	estatus;
	@ManyToOne
	@JoinColumn(name = "clientes_id", nullable = false)
	private User idClientes;
	
	public Pedidos() {
	}
	public Pedidos(Long id, Date fecha, Double total, OrderStatus estatus, User idClientes) {
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.estatus = estatus;
		this.idClientes = idClientes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public OrderStatus getEstatus() {
		return estatus;
	}
	public void setEstatus(OrderStatus estatus) {
		this.estatus = estatus;
	}
	public User getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(User idClientes) {
		this.idClientes = idClientes;
	}
	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", fecha=" + fecha + ", total=" + total + ", idClientes=" + idClientes + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, idClientes, total);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedidos other = (Pedidos) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(idClientes, other.idClientes) && Objects.equals(total, other.total);
	}
	
}