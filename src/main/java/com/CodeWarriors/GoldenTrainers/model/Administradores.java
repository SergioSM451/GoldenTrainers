package com.CodeWarriors.GoldenTrainers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "administradores")
public class Administradores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_administradores")
	private Long idAdministradores;

	@Column(name = "usuario", length = 45, nullable = false, unique = true)
	private String usuario;

	@Column(name = "password", length = 45, nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn(name = "clientes_id_clientes", nullable = false)
	private User cliente;

	@ManyToMany(mappedBy = "administradores")
	private Set<Producto> productos;

	// Constructor, getters, setters, hashCode, equals, toString
	public Administradores() {
	}

	public Administradores(Long idAdministradores, String usuario, String password) {
		this.idAdministradores = idAdministradores;
		this.usuario = usuario;
		this.password = password;
	}

	// Getters and Setters
	public Long getIdAdministradores() {
		return idAdministradores;
	}

	public void setIdAdministradores(Long idAdministradores) {
		this.idAdministradores = idAdministradores;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAdministradores, usuario, password);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Administradores that = (Administradores) o;
		return Objects.equals(idAdministradores, that.idAdministradores) && Objects.equals(usuario, that.usuario)
				&& Objects.equals(password, that.password);
	}

	@Override
	public String toString() {
		return "Administradores{" + "idAdministradores=" + idAdministradores + ", usuario='" + usuario + '\''
				+ ", password='" + password + '\'' + '}';
	}
}