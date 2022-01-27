package net.mongo.api.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import net.mongo.api.model.Utilisateur;
import net.mongo.api.repository.Utilisateurrepository;
@CrossOrigin
@RestController
public class UtilisateurController {
@Autowired
private Utilisateurrepository repository;

@CrossOrigin(origins = "http://localhost:4200")
@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/addUtilisateur")
public  Utilisateur saveUtilisateur(@RequestBody Utilisateur u) {
	
	return (repository.save(u));
}

@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/login")
public  Utilisateur log(@RequestBody Utilisateur utilisateur) {
	Utilisateur a =new Utilisateur();
	List<Utilisateur> users=repository.findAll();
	a=utilisateur;
	for (Utilisateur user : users) {
	if(a.getPass().equals(user.getPass()) && a.getEmail().equals(user.getEmail()) ) {
	 return user;
	}
	 }
	return a;
}

@GetMapping("/findAllUtilisateurs")
public List<Utilisateur> getUtilisateurs(){
	return repository.findAll();
}
@GetMapping("/findAll")
public String getdata(){
	return "OK";
}
@PutMapping("/updateUtilisateur/{id}")
public Utilisateur update(@PathVariable String id,@RequestBody  Utilisateur u){
	Utilisateur UDB= repository.findById(id)
			.orElseThrow(RuntimeException::new);
	UDB.setNom(u.getNom());
	UDB.setEmail(u.getEmail());
	UDB.setUsername(u.getUsername());
	UDB.setAdmin(u.isAdmin());
	UDB.setPass(u.getPass());
	System.out.println(UDB);
	return repository.save(UDB);
}

@ResponseStatus(HttpStatus.CREATED)
@DeleteMapping("/deleteUtilisateur/{id}")
public void delete(@PathVariable String id) {
	Utilisateur UDB= repository
			.findById(id)
			.orElseThrow(RuntimeException::new);
	repository.delete(UDB);;
}

}
