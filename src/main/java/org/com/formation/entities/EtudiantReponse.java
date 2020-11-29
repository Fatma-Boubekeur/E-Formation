package org.com.formation.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="etudiant_reponses")
public class EtudiantReponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long id_quiz;// pour spécifier le quiz 
	
	// Avec l'entité Etudiant
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_etudiant") 
    private Etudiant etudiant;
	
	
    // Avec l'entité Reponse
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_reponse") 
    private Reponse reponse;

    
    

	public EtudiantReponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Reponse getReponse() {
		return reponse;
	}


	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}


	public Long getId_quiz() {
		return id_quiz;
	}


	public void setId_quiz(Long id_quiz) {
		this.id_quiz = id_quiz;
	}
	
	
}
