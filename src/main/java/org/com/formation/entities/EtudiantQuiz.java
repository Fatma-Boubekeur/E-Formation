package org.com.formation.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="passer_quiz")
public class EtudiantQuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private int score_quiz; // Score de l'étudiant qui passe le quiz
	private Date date_passer_quiz;
	
	
	// Avec l'entité Etudiant
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_etudiant") 
    private Etudiant etudiant;
	
	
    // Avec l'entité Quiz
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_quiz") 
    private Quiz quiz;
   
    

	public EtudiantQuiz(int score_quiz, Date date_passer_quiz) {
		super();
		this.score_quiz = score_quiz;
		this.date_passer_quiz = date_passer_quiz;
	}

	public EtudiantQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Getter and Setters ...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getScore_quiz() {
		return score_quiz;
	}

	public void setScore_quiz(int score_quiz) {
		this.score_quiz = score_quiz;
	}

	public Date getDate_passer_quiz() {
		return date_passer_quiz;
	}

	public void setDate_passer_quiz(Date date_passer_quiz) {
		this.date_passer_quiz = date_passer_quiz;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


    
    
    
    
    
    
    
    
    
    
	
}
