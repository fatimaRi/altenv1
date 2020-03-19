package com.alten.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alten.project.Dao.AppRoleRepository;
import com.alten.project.Dao.AppUserRepository;
import com.alten.project.entities.AppRole;
import com.alten.project.entities.AppUser;
@Service
@Transactional
public class AccountServiceImp implements AccountService {

	@Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public AppUser saveUser(AppUser user) {
		  String hushPw=bCryptPasswordEncoder.encode(user.getPassword());
	       user.setPassword(hushPw);
	     return appUserRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String nom, String roleName) {
		 AppUser user=appUserRepository.findByNom(nom);
	        AppRole role=appRoleRepository.findByRoleName(roleName);
	        user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByNom(String nom) {
		   return appUserRepository.findByNom(nom);
	}

}
