package com.alten.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
	
	public class Demande {
	        @Id
	        @GeneratedValue
	        private int id;
	       
			public Demande() {
				// TODO Auto-generated constructor stub
			}
			
			public Demande(int id, String intitule) {
				this.id = id;
				this.intitule = intitule;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getIntitule() {
				return intitule;
			}
			public void setIntitule(String intitule) {
				this.intitule = intitule;
			}
			private String intitule;
	       /* private String type_demande;
	        private String descriptif;
	        private String echeance;
	        private String periodicite;
	        private String proprietaire;
	        */
}
