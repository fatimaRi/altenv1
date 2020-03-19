package com.alten.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alten.project.Dao.DemandeRepository;
import com.alten.project.entities.Demande;

@RestController
	public class TestRestController {
	   @Autowired
	    private DemandeRepository demandeRepository;

	    @GetMapping("/demandes")
	    public List<Demande> liste() {
	        return  demandeRepository.findAll();
	    }
	    @PostMapping("/demandes")
	    public Demande save(@RequestBody Demande d){
	        return demandeRepository.save(d);
	    }
}
