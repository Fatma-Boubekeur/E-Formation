package org.com.formation.entities;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
// ... Others Imports 
@Entity
@Table(name="documentation")
public class Documentation implements Serializable {
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_doc;
	
	
	private String nom_doc; //Nom de la documentation 
    	
	@Lob
	private byte[]  contenue; // le contenue de la docmentation (fichier)
	
	private String nom_contenue;//Nom du contenue 
	
	private String contenue_type; // type de contenue
	
	private Date date_creation; // Date de creation 
	
	
	@ManyToOne
	@JoinColumn(name="id_cours")
	private Cours cours;
	
	public Documentation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Documentation(String nom_doc, byte[] contenue, String nom_contenue, String contenue_type, Date date_creation,
			Cours cours) {
		super();
		this.nom_doc = nom_doc;
		this.contenue = contenue;
		this.nom_contenue = nom_contenue;
		this.contenue_type = contenue_type;
		this.date_creation = date_creation;
		this.cours = cours;
	}

	// Getters and Setters
	
	
	
	public Long getId_doc() {
		return id_doc;
	}

	public void setId_doc(Long id_doc) {
		this.id_doc = id_doc;
	}

	public String getNom_doc() {
		return nom_doc;
	}

	public void setNom_doc(String nom_doc) {
		this.nom_doc = nom_doc;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}


	public String getContenue_type() {
		return contenue_type;
	}


	public void setContenue_type(String contenue_type) {
		this.contenue_type = contenue_type;
	}

	public String getNom_contenue() {
		return nom_contenue;
	}

	public void setNom_contenue(String nom_contenue) {
		this.nom_contenue = nom_contenue;
	}

	public byte[] getContenue() {
		return contenue;
	}

	public void setContenue(byte[] contenue) {
		this.contenue = contenue;
	}


	public Date getDate_creation() {
		return date_creation;
	}


	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}





	
	
	
	
}
