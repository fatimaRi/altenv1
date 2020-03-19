package com.alten.project.service;

import com.alten.project.entities.AppRole;
import com.alten.project.entities.AppUser;

public interface AccountService {
	  public AppUser saveUser(AppUser user);
	    public AppRole saveRole(AppRole user);
	    public void addRoleToUser(String nom,String role);
	    public AppUser findUserByNom(String nom);

}
