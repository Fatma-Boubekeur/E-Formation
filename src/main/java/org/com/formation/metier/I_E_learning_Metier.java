package org.com.formation.metier;

import java.util.List;

import org.com.formation.entities.Cours;
import org.com.formation.entities.Documentation;
import org.com.formation.entities.Enseignant;
import org.com.formation.entities.Etudiant;
import org.com.formation.entities.EtudiantQuiz;
import org.com.formation.entities.EtudiantReponse;
import org.com.formation.entities.Question;
import org.com.formation.entities.Quiz;
import org.com.formation.entities.Reponse;

public interface I_E_learning_Metier {
	
	//Check data 
	boolean check_exist_Enseignant(Enseignant ens);
	boolean check_exist_Cours(Cours cs);

	
	/* Login Validation */
	public String LoginValidation(String login,String password);

	
	/*
	 *  GetUser Etudiant
	 */	
	public Object GetUserId(String username,String password);
	
	
	/* Etudiant */ 
	public Etudiant ajouter_etudiant(Etudiant e);
	public Etudiant get_etudiant(Long id_etudiant);
	public List<Etudiant>liste_des_etudiants();
	// Inscrire un �tudiant � un cours 
	public void inscrire_etudiant_cours(Long id_etudiant,Long id_cours);
	// La liste des �tudiants qui suivent un cours 
	public List<Etudiant>Listes_etudiants_suiv_cours(Long id_cours);
	//V�rifier si l'�tudiant est d�ja inscrit au cours ?  
	public boolean Verif_etudiant_cours(Long id_etudiant,Long id_cours);
	
	
	/* Enseignant */
	public Enseignant ajouter_enseignant(Enseignant ens);
    public Enseignant get_enseignant(Long id_enseignant);	
	public List<Enseignant>liste_des_enseignants();
	// Obtenir l'enseignant qui enseigne le cours
	public Enseignant get_enseignant_cours(Long id_cours);
	
	/* Cours */
	public Cours ajouter_cours(Cours c,Long id_enseignant);
	public List<Cours> liste_des_cours();
	public Cours get_cours(Long id_cours);
    // R�cup�rer la liste des cours assur� par un enseignant
	public List<Cours> listes_des_cours_par_enseignant(Long id_enseignant);
	// R�cup�rer la liste des cours suivi par un �tudiant
    public List<Cours> listes_des_cours_suivi_par_etudiant(Long id_etudiant);
    
    
	/* Documentation */
	public Documentation ajouter_doc(Documentation doc,Long id_cours);
	public void supp_doc(Long id_doc);
	public Documentation modifier_doc(Documentation d);
	public Documentation get_doc(Long id_doc);
	//Afficher les documentations d'un cours
	public List<Documentation>lists_doc_cours(Long id_cours);

	
	/* Quiz */
	
	
	// Ajouter Quiz
	public Quiz ajouter_quiz(Quiz q , Long id_cours);

	// Get Quiz
	public Quiz get_quiz(Long id_quiz); 
	
	// Supprimer quiz
	public void supp_quiz(Long id_quiz);

	// Modifier Quiz
	public Quiz modifier_quiz(Quiz q);
	
	//	Afficher la liste des quiz du cours 
	public List<Quiz> lists_quiz_cours(Long id_cours);

	
	
	/* Question */
	
	public Question ajouter_Question(Question qst,Long id_quiz);
	public Question get_question(Long id_question);	
	public void supp_question(Long id_question);
	public Question modifier_question(Question qst);
    //	Afficher les questions du quiz
	public List<Question> lists_questions_quiz(Long id_quiz);
	
	/* R�ponse */
	public Reponse ajouter_Reponse(Reponse r,Long id_question);
	public Reponse get_reponse(Long id_reponse);
	public void supp_reponse(Long id_reponse);
	public Reponse modifier_reponse(Reponse r );
	//Afficher tous les r�ponses d'une question donn�e
	public List<Reponse> lists_reponses_question(Long id_question);
		
    //Trouver Id de la r�ponse correcte d'une question donn�e
	public Long Trouver_ID_Reponse_QST(Long id_question);
	// Ajouter un �tudiant qui a pass� un quiz dans la table EtudiantQuiz
	public EtudiantQuiz ajouter_etud_quiz(EtudiantQuiz o,Long id_etudiant,Long id_quiz);
	// R�cup�rer les �tudiants qui passer le quiz 
	public List<EtudiantQuiz> etudiant_passer_quiz(Long id_quiz);
	// Ajouter la r�ponse de l'�tudiant
	public EtudiantReponse reponses_etudiant(EtudiantReponse o,Long id_etudiant,Long id_reponse,Long id_quiz);
	// Liste des r�ponses d'un �tudiant	
	public List<EtudiantReponse> Listes_reponses_etudiant(Long id_etudiant,Long id_quiz);
	
	
	
	
}
