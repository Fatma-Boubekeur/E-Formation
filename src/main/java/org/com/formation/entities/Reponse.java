package org.com.formation.entities;
// Others Imports ....

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

@Entity
@Table(name="reponse")
public class Reponse implements Serializable {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_reponse;
	
	@NotEmpty(message ="Veuilez saisir une réponse !")
	private String rep_contenue;
	
	@NotEmpty(message = "Veuillez spécifier si c'est une réponse correcte ou pas ")
	private String correcte;
	
    @ManyToOne
    @JoinColumn(name = "id_qst")
    private Question question;	
   
    //Avec entity EtudiantReponse
  	@OneToMany(mappedBy = "reponse",fetch = FetchType.LAZY)
  	private Collection<EtudiantReponse> EtudiantReponse;
  	
  
	public Reponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reponse(String rep_contenue, String correcte) {
		super();
		this.rep_contenue = rep_contenue;
		this.correcte = correcte;
	}
	
	// Getters / Setters 
	
	
	public Long getId_reponse() {
		return id_reponse;
	}
	public void setId_reponse(Long id_reponse) {
		this.id_reponse = id_reponse;
	}
	public String getRep_contenue() {
		return rep_contenue;
	}
	public void setRep_contenue(String rep_contenue) {
		this.rep_contenue = rep_contenue;
	}
	public String getCorrecte() {
		return correcte;
	}
	public void setCorrecte(String correcte) {
		this.correcte = correcte;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
