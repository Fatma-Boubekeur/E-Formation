package org.com.formation.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
// ... Others Imports
@Entity
@Table(name="Cours")
public class Cours implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cours;
	
	@NotEmpty(message = "Veuillez remplir le nom du cours !")
	private String nom;
	
	@NotEmpty(message = "Veuillez remplir la description du cours ! ")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="id_enseignant")
	private Enseignant enseignant;
	
	@ManyToMany(mappedBy = "cours")
    private Collection<Etudiant> etudiants;
	
	@OneToMany(mappedBy = "cours",fetch = FetchType.LAZY)
    private Collection<Documentation> docs;
	
	@OneToMany(mappedBy = "cours",fetch = FetchType.LAZY)
	private Collection<Quiz> quizes;

	
	// Constructeur de la classe 
	public Cours(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cours(String nom, String description, Enseignant enseignant) {
		super();
		this.nom = nom;
		this.description = description;
		this.enseignant = enseignant;
	}

	// Getters / Setters
	
	
	public Long getId_cours() {
		return id_cours;
	}
	public void setId_cours(Long id_cours) {
		this.id_cours = id_cours;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Collection<Documentation> getDocs() {
		return docs;
	}
	public void setDocs(Collection<Documentation> docs) {
		this.docs = docs;
	}

	

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Collection<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(Collection<Quiz> quizes) {
		this.quizes = quizes;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
