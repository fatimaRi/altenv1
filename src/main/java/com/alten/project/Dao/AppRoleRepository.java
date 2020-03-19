package com.alten.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alten.project.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole,Integer> {
	    public AppRole  findByRoleName(String role);
	
}
