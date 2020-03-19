package com.alten.project.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @NoArgsConstructor
@AllArgsConstructor
public class AppUser {
	  @Id @GeneratedValue
	    private int id;
	    private String nom;
	   
	    
	     private String prenom;
	    private String email;
	    private String password;
	    private String poste;
	    @ManyToMany(fetch = FetchType.EAGER )
	    private Collection<AppRole> roles=new ArrayList<>();
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
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

		public String getPoste() {
			return poste;
		}

		public void setPoste(String poste) {
			this.poste = poste;
		}

		public Collection<AppRole> getRoles() {
			return roles;
		}

		public void setRoles(Collection<AppRole> roles) {
			this.roles = roles;
		}

		public AppUser() {
			// TODO Auto-generated constructor stub
		}
	
		public AppUser( String nom, String prenom, String email, String password, String poste,
				Collection<AppRole> roles) {
		
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
			this.poste = poste;
			this.roles = roles;
		}
	
	    
}
