package com.praticando.pokemonsDb.entities;

import java.io.Serializable;
import java.util.Objects;

public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer age;
	
	public Trainer() {}
	public Trainer(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		return Objects.equals(id, other.id);
	}
}
