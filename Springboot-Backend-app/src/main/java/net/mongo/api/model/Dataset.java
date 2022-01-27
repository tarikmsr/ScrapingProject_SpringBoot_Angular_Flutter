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
@Document(collection="data")
public class Dataset {
	
	@Id
    private String id;
	private String Titre;
	private double Price;
	private String Localisation;
	private int Size;
	private int Nb_pieces;
	private int Nb_chambre;
	private int Nb_Salles_bain;
	private String Etat;
	
	public Dataset() {
		super();
		this.id=UUID.randomUUID().toString();
		// TODO Auto-generated constructor stub
	}
	
	public Dataset(String id, String titre, double price, String localisation, int size, int nb_pieces,
			int nb_chambre, int nb_Salles_bain, String etat) {
		super();
		this.id = id;
		Titre = titre;
		Price = price;
		Localisation = localisation;
		Size = size;
		Nb_pieces = nb_pieces;
		Nb_chambre = nb_chambre;
		Nb_Salles_bain = nb_Salles_bain;
		Etat = etat;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getLocalisation() {
		return Localisation;
	}
	public void setLocalisation(String localisation) {
		Localisation = localisation;
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public int getNb_pieces() {
		return Nb_pieces;
	}
	public void setNb_pieces(int nb_pieces) {
		Nb_pieces = nb_pieces;
	}
	public int getNb_chambre() {
		return Nb_chambre;
	}
	public void setNb_chambre(int nb_chambre) {
		Nb_chambre = nb_chambre;
	}
	public int getNb_Salles_bain() {
		return Nb_Salles_bain;
	}
	public void setNb_Salles_bain(int nb_Salles_bain) {
		Nb_Salles_bain = nb_Salles_bain;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	
	
	@Override
	public String toString() {
		return "Dataset [id=" + id + ", Titre=" + Titre + ", Price=" + Price + ", Localisation=" + Localisation
				+ ", Size=" + Size + ", Nb_pieces=" + Nb_pieces + ", Nb_chambre=" + Nb_chambre + ", Nb_Salles_bain="
				+ Nb_Salles_bain + ", Etat=" + Etat + "]";
	}
	

}