package com.alten.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class AppRole {
    @Id
    @GeneratedValue
    private int id;
    private String roleName;
	/**
	 * @param id
	 * @param roleName
	 */
	public AppRole(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public AppRole() {
		// TODO Auto-generated constructor stub
	}


}
