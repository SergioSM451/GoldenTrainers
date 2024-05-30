package com.CodeWarriors.GoldenTrainers.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", length = 200, nullable = false, unique = true)
	private String name;
	@Column(name = "number", length = 10, nullable = false, unique = true)
	private String number;
	@Column(name = "email", length = 200, nullable = false, unique = true)
	private String email;
	@Column(name = "password", length = 60, nullable = false, unique = false)
	private String password;
	
	
	@OneToMany(mappedBy = "idClientes", cascade = CascadeType.ALL, orphanRemoval = true )
	private List<Pedidos> orders;
	@OneToMany(mappedBy = "cliente")
	private List<Administradores> administradores;
	
	
	public User() {
	}

	public User(Long id, String name, String number, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public User(Long id, String name, String number, String email, String password, List<Pedidos> orders) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		this.password = password;
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, number, orders, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(number, other.number) && Objects.equals(orders, other.orders)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email + ", password="
				+ password + ", orders=" + orders + "]";
	}

	public List<Pedidos> getOrders() {
		return orders;
	}


	public void setOrders(List<Pedidos> orders) {
		this.orders = orders;
	}
}
