package org.com.formation.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// ... Other Imports

@Entity
@Table(name="enseignant")
public class Enseignant implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_enseignant;
    
    private String login;
    
	private String password;
    
	private String nom;
    
	private String prenom;
    
	private String email;
    
	private String adresse;
    
	private String tel;
    
	private String grade;
	
	@OneToMany(mappedBy ="enseignant",fetch = FetchType.LAZY)
	private Collection<Cours> cours;
	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Enseignant(String login,String password,String nom, String prenom, String email, String adresse, String tel, String grade) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.grade = grade;
		this.login=login;
		this.password=password;
		
	}
	
	// Getters / Setters
	
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}


	
	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Long getId_enseignant() {
		return id_enseignant;
	}

	public void setId_enseignant(Long id_enseignant) {
		this.id_enseignant = id_enseignant;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
