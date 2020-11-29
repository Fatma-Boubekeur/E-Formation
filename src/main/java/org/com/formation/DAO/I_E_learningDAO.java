package org.com.formation.DAO;

import java.util.Date;
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
// ... Others imports

public interface I_E_learningDAO {
	
	/* Login */ 
	public String LoginValidation(String username,String password);
	
	
	/*
	 * Etudiant
	 */
	public Etudiant ajouter_etudiant(Etudiant e);
	public Etudiant get_etudiant(Long id_etudiant);
	public List<Etudiant>liste_des_etudiants();
	// Inscrire un étudiant à un cours 
	public void inscrire_etudiant_cours(Long id_etudiant,Long id_cours);
	// La liste des étudiants qui suivent un cours 
	public List<Etudiant>Listes_etudiants_suiv_cours(Long id_cours);
	public Etudiant Get_Etudiant_By_Login_Password(String username,String password);
	
	/* Enseignant */
	public Enseignant ajouter_enseignant(Enseignant ens);
    public Enseignant get_enseignant(Long id_enseignant);	
	public List<Enseignant>liste_des_enseignants();
	// Obtenir l'enseignant qui enseigne le cours
	public Enseignant get_enseignant_cours(Long id_cours);
	public Enseignant Get_Enseignant_By_Login_Password(String username,String password);

	/* Cours */
	public Cours ajouter_cours(Cours c,Long id_enseignant);
	public List<Cours> liste_des_cours();
	public Cours get_cours(Long id_cours);
    // Récupérer la liste des cours assuré par un enseignant
	public List<Cours> listes_des_cours_par_enseignant(Long id_enseignant);
	// Récupérer la liste des cours suivi par un étudiant
    public List<Cours> listes_des_cours_suivi_par_etudiant(Long id_etudiant);
	
	
	
	/* Documentation */
	public Documentation ajouter_doc(Documentation doc,Long id_cours);
	public void supp_doc(Long id_doc);
	public Documentation modifier_doc(Documentation d);
	public Documentation get_doc(Long id_doc);
	//Afficher les documentations d'un cours
	public List<Documentation>lists_doc_cours(Long id_cours);
	
	
	
	/*
	 * Quiz :)
	 */	 	
	public Quiz ajouter_Quiz(Quiz q,Long id_cours);	
	public Quiz get_quiz(Long id_quiz); 
	public List<Quiz> lists_quiz_cours(Long id_cours); //Afficher la liste des quiz du cours
	public void supp_quiz(Long id_quiz);
	public Quiz modifier_quiz(Quiz q);
	
	/* Question */
	public Question ajouter_Question(Question qst,Long id_quiz);
    public Question get_question(Long id_question);
    public void supp_question(Long id_question);
	public Question modifier_question(Question qst);
	//Afficher la liste des questions du quiz 
	public List<Question> lists_questions_quiz(Long id_quiz); 
	
	
	/* Réponse */
	public Reponse ajouter_Reponse(Reponse r,Long id_question);
	public Reponse get_reponse(Long id_reponse);
	public void supp_reponse(Long id_reponse);
	public Reponse modifier_reponse(Reponse r );
	//Afficher tous les réponses d'une question donnée
	public List<Reponse> lists_reponses_question(Long id_question);
	
	/* Etudiant Quiz (Passer Quiz) */
	
	// Ajouter un étudiant qui a passé un quiz dans la table EtudiantQuiz
	public EtudiantQuiz ajouter_etud_quiz(EtudiantQuiz o,Long id_etudiant,Long id_quiz);
	// Récupérer les étudiants qui passer le quiz 
	public List<EtudiantQuiz> etudiant_passer_quiz(Long id_quiz);
	
	/* Réponses Etudiant */
	// Ajouter la réponse de l'étudiant
	public EtudiantReponse reponses_etudiant(EtudiantReponse o,Long id_etudiant,Long id_reponse,Long id_quiz);
	// Liste des réponses d'un étudiant
	public List<EtudiantReponse> Listes_reponses_etudiant(Long id_etudiant,Long id_quiz);
	
	
	
	
}
