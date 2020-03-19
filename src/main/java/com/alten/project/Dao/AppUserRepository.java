package com.alten.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alten.project.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
	    public AppUser findByNom(String nom);
	}

