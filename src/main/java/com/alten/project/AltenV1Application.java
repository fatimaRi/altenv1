package com.alten.project;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.alten.project.Dao.AppUserRepository;
import com.alten.project.Dao.DemandeRepository;
import com.alten.project.entities.AppRole;
import com.alten.project.entities.AppUser;
import com.alten.project.entities.Demande;
import com.alten.project.service.AccountService;

@SpringBootApplication
public class AltenV1Application implements CommandLineRunner{

	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(AltenV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Stream.of("t1","t2").forEach(t->{
	            demandeRepository.save(new Demande(0, t));
	            });
	
		 demandeRepository.findAll().forEach(t->{
		 System.out.println(t.getIntitule());
		 
		
		 //accountService.saveUser(new AppUser( "fati", "fati", "fati@gmail.com", "123", "administrateur",null));
		// accountService.saveUser(new AppUser( "yoyo", "yoyo", "yoyo@gmail.com", "123", "member",null));

		
		 //accountService.saveRole(new AppRole(1,"admin"));
		// accountService.saveRole(new AppRole(2,"member"));


		 
	//	accountService.addRoleToUser("fati","admin");

		 });
		 

}
	
	@Bean
    public BCryptPasswordEncoder getBcpe() {
        return new BCryptPasswordEncoder();
	}
}