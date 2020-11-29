package org.com.formation.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
// Others imports ...

@Entity
@Table
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_qst;
	
	private String contenue_qst;

	private int note;
	
	@ManyToOne
	@JoinColumn(name="id_quiz")
	private Quiz quiz;

	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Collection<Reponse> reponses;
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question(String contenue_qst, int note) {
		super();
		this.contenue_qst = contenue_qst;
		this.note = note;
	}
	
	// Getters / Setters
	
	public Long getId_qst() {
		return id_qst;
	}
	public void setId_qst(Long id_qst) {
		this.id_qst = id_qst;
	}
	public String getContenue_qst() {
		return contenue_qst;
	}
	public void setContenue_qst(String contenue_qst) {
		this.contenue_qst = contenue_qst;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Collection<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(Collection<Reponse> reponses) {
		this.reponses = reponses;
	}


	
	
	
	
}
