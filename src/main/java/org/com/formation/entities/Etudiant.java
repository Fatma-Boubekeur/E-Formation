package org.com.formation.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;
//......others imports


@Entity
@Table(name="Etudiant")
public class Etudiant implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_etudiant;
	
	@NotBlank(message = "Nom d'utilisateur ne peut pas être vide !")
	private String login;
	
	@NotBlank(message = "Mot de passe ne peut pas être vide !")
	private String password;
	
	//Ne pas ajouter cette colonne à notre table
	//Pour vérifier si les deux mot de passes saisis
	//Dans le formulaire sont identiques
	@Column(name="confirm_password", insertable=false) 
	private String confirm_password;                    
	                                                      	
	@NotBlank(message = "Veuillez saisir votre nom svp !")
	private String Nom;

	@NotBlank(message = "Veuillez saisir votre prénom svp !")
	private String prenom;
	
	@NotBlank(message = "Veuillez saisir votre adresse email  svp !")
	@Email
	private String email;
	
	@NotBlank(message = "Veuillez saisir votre filiére svp !")
	private String filiere;
	
	@NotBlank(message = "Veuillez saisir votre spécialité svp !")
	private String specialite;
	
	@NotBlank(message="Veuillez saisir votre niveau svp !")
	private String niveau;
	
	@ManyToMany
	@JoinTable(name="inscription_etud_cours", joinColumns = @JoinColumn(name="id_etudiant"),inverseJoinColumns =@JoinColumn(name="id_cours"))
	private Collection<Cours> cours;

	// Avec l'entité EtudiantQuiz
	// Pour récupérer l'étudiant qui a passer quiz
	@OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
	private Collection<EtudiantQuiz> EtudiantQuiz;
	

	//Avec entity EtudiantReponse
	@OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
	private Collection<EtudiantReponse> EtudiantReponse;
	
	
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Etudiant(String login,String password,String nom, String prenom, String email, String filiere, String specialite, String niveau) {
		super();
		Nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.filiere = filiere;
		this.specialite = specialite;
		this.niveau = niveau;
		this.login=login;
		this.password=password;
	}
	
	// Getters / Setters ... 

	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
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
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
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

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public Long getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(Long id_etudiant) {
		this.id_etudiant = id_etudiant;
	}



	public Collection<EtudiantQuiz> getEtudiantQuiz() {
		return EtudiantQuiz;
	}

	public void setEtudiantQuiz(Collection<EtudiantQuiz> etudiantQuiz) {
		EtudiantQuiz = etudiantQuiz;
	}



	public Collection<EtudiantReponse> getEtudiantReponse() {
		return EtudiantReponse;
	}

	public void setEtudiantReponse(Collection<EtudiantReponse> etudiantReponse) {
		EtudiantReponse = etudiantReponse;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
