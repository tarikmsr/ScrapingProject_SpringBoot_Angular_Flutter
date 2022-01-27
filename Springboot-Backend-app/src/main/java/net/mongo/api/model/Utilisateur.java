package net.mongo.api.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Document(collection="utilisateur")
public class Utilisateur  {
	    @Id
	    private String id;
	    private String nom;
	    private String username;
	    private String email;
	    private String pass;
	    private boolean admin;
  
	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String email,String username,String pass,boolean B) {
		super();
		this.id=UUID.randomUUID().toString();
		this.nom = nom;
		this.setEmail(email);
		this.setUsername(username);
		this.setAdmin(B);
		this.setPass(pass);
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = UUID.randomUUID().toString();
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
