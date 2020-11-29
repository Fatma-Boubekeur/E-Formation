package org.com.formation.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
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
// Others Imports

@Entity
@Table(name="quiz")

public class Quiz implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_quiz;
	@NotEmpty(message = "Veuillez entrer le nom du quiz ! ")
	private String nom;
	
	@NotEmpty(message = "Veuiller entrer le type du quiz !")
	private String type;
	
	private Date date;
	
	private Date date_limite;
	
	@ManyToOne
	@JoinColumn(name="id_cours")
	private Cours cours;
	
	@OneToMany(mappedBy = "quiz",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Collection<Question> questions;
	
	//Avec entity EtudiantQuiz
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Collection<EtudiantQuiz> EtudiantQuiz;
	
	
	
	
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quiz(String nom, String type, Date date, Date date_limite) {
		super();
		this.nom = nom;
		this.type = type;
		this.date = date;
		this.date_limite = date_limite;
	}
	
	// Getters / Setters
	
	
	public Long getId_quiz() {
		return id_quiz;
	}
	public void setId_quiz(Long id_quiz) {
		this.id_quiz = id_quiz;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate_limite() {
		return date_limite;
	}
	public void setDate_limite(Date date_limite) {
		this.date_limite = date_limite;
	}
	public Collection<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}

	
}
