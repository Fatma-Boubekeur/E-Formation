package org.com.formation.metier;

import java.util.List;
import org.com.formation.DAO.I_E_learningDAO;
import org.com.formation.entities.Cours;
import org.com.formation.entities.Documentation;
import org.com.formation.entities.Enseignant;
import org.com.formation.entities.Etudiant;
import org.com.formation.entities.EtudiantQuiz;
import org.com.formation.entities.EtudiantReponse;
import org.com.formation.entities.Question;
import org.com.formation.entities.Quiz;
import org.com.formation.entities.Reponse;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class E_learning_Metier_Implementation  implements I_E_learning_Metier{
	
	private I_E_learningDAO dao;
	
	public void setDao(I_E_learningDAO dao) {
		this.dao = dao;
	}
	
	/* Login Validation */
	@Override
	public String LoginValidation(String login, String password) {
		String validation=dao.LoginValidation(login,password);
		return validation;
	}

	
	/* Etudiant */
	
	@Override
	public Etudiant ajouter_etudiant(Etudiant e) {
		
		return dao.ajouter_etudiant(e);
	}

	@Override
	public Etudiant get_etudiant(Long id_etudiant) {
		
		return dao.get_etudiant(id_etudiant);
	}

	@Override
	public List<Etudiant> liste_des_etudiants() {
		
		return dao.liste_des_etudiants();
	}

	@Override
	public void inscrire_etudiant_cours(Long id_etudiant, Long id_cours) {

		dao.inscrire_etudiant_cours(id_etudiant, id_cours);
		
	}

	@Override
	public List<Etudiant> Listes_etudiants_suiv_cours(Long id_cours) {
		
		return dao.Listes_etudiants_suiv_cours(id_cours);
	}

	
	/* Enseignant */
	
	@Override
	public Enseignant ajouter_enseignant(Enseignant ens) {
		
		return dao.ajouter_enseignant(ens);
	}

	@Override
	public Enseignant get_enseignant(Long id_enseignant) {
		
		return dao.get_enseignant(id_enseignant);
	}

	
	@Override
	public List<Enseignant> liste_des_enseignants() {
		
		return dao.liste_des_enseignants();
	}
	
    // Recupérer l'enseignant d'un cours 
	@Override
	public Enseignant get_enseignant_cours(Long id_cours) {
		
		return dao.get_enseignant_cours(id_cours);
	}
	
	
	
	/* Cours */

	@Override
	public Cours ajouter_cours(Cours c, Long id_enseignant) {

		return dao.ajouter_cours(c, id_enseignant);
	}

	@Override
	public List<Cours> liste_des_cours() {
		
		return dao.liste_des_cours();
	}

	@Override
	public Cours get_cours(Long id_cours) {
		
		return dao.get_cours(id_cours);
	}

	@Override
	public List<Cours> listes_des_cours_par_enseignant(Long id_enseignant) {
		
		return dao.listes_des_cours_par_enseignant(id_enseignant);
	}

	@Override
	public List<Cours> listes_des_cours_suivi_par_etudiant(Long id_etudiant) {
		
		return dao.listes_des_cours_suivi_par_etudiant(id_etudiant);
	}
	
	/* Documentation */

	@Override
	public Documentation ajouter_doc(Documentation doc, Long id_cours) {
		
		return dao.ajouter_doc(doc, id_cours);
	}

	@Override
	public void supp_doc(Long id_doc) {
		dao.supp_doc(id_doc);
	}

	@Override
	public Documentation modifier_doc(Documentation d) {
		
		return dao.modifier_doc(d);
	}

	@Override
	public Documentation get_doc(Long id_doc) {
		
		return dao.get_doc(id_doc);
	}

	@Override
	public List<Documentation> lists_doc_cours(Long id_cours) {
		
		return dao.lists_doc_cours(id_cours);
	}


		@Override
		public boolean check_exist_Enseignant(Enseignant ens) {
		List<Enseignant> enseignants=dao.liste_des_enseignants();
		boolean not_exist=true;
		for(Enseignant s:enseignants){
		if(s.getLogin().equals(ens.getLogin()) && s.getPassword().equals(ens.getPassword()) && s.getNom().equals(ens.getNom()) && s.getPrenom().equals(ens.getPrenom()) && s.getAdresse().equals(ens.getAdresse()) && s.getEmail().equals(ens.getEmail()) && s.getGrade().equals(ens.getGrade()) && s.getTel().equals(ens.getTel())) {
		not_exist=false; 	
		}
		}
		return not_exist;
		}
		
		
		public boolean check_exist_Cours(Cours cs) {
		List<Cours> cours=dao.liste_des_cours();
		boolean not_exist=true;
		for(Cours c:cours){
		if (c.getNom().equals(cs.getNom()) && c.getDescription().equals(cs.getDescription()) && c.getEnseignant().equals(cs.getEnseignant())) {
		not_exist=false; 	
		}
		}
		return not_exist;
		}





		@Override
		public Long GetUserId(String username, String password) {
			String type=LoginValidation(username, password);
            if(type.equals("Etudiant")) {
            	Etudiant e=dao.Get_Etudiant_By_Login_Password(username, password);
            	return e.getId_etudiant();
            }else if(type.equals("Enseignant")) {
            	Enseignant s=dao.Get_Enseignant_By_Login_Password(username, password);
            	return s.getId_enseignant();
            }else {
            	return null;
            }		
		}


		@Override
		public boolean Verif_etudiant_cours(Long id_etudiant, Long id_cours) {
			List<Cours> list=dao.listes_des_cours_suivi_par_etudiant(id_etudiant);
			Cours get_c=dao.get_cours(id_cours);
			boolean v=true;
			for(Cours c:list ) {
				if(c.equals(get_c)) {
					v=false;
				}
			}
				return v;
		}



	    /* Quiz */
		
        // Ajouter Quiz
		@Override
		public Quiz ajouter_quiz(Quiz q, Long id_cours) {
			
			return dao.ajouter_Quiz(q, id_cours);
		}		
		
        // Get Quiz		
		@Override
		public Quiz get_quiz(Long id_quiz) {
			
			return dao.get_quiz(id_quiz);
		}
		
		
		// Supprier quiz
		@Override
		public void supp_quiz(Long id_quiz) {
			
			dao.supp_quiz(id_quiz);
		}

        // Modifier quiz
		@Override
		public Quiz modifier_quiz(Quiz q) {
	
			return dao.modifier_quiz(q);
		}

		
        //Afficher la liste des quiz du cours 		
		@Override
		public List<Quiz> lists_quiz_cours(Long id_cours) {
			return dao.lists_quiz_cours(id_cours);
		}


		/* Question */
		
        // Ajouter une question
		@Override
		public Question ajouter_Question(Question qst, Long id_quiz) {
			
			return dao.ajouter_Question(qst, id_quiz);
		}

		//Get question		
		@Override
		public Question get_question(Long id_question) {
			
			return dao.get_question(id_question);
		}		
		
        // Supprimer une question 
		@Override
		public void supp_question(Long id_question) {
			dao.supp_question(id_question);
	
		}

        // Modifier une question 
		@Override
		public Question modifier_question(Question qst) {
			
			return dao.modifier_question(qst);
		}
		
        //Afficher les questions du quiz
		@Override
		public List<Question> lists_questions_quiz(Long id_quiz) {	
			return dao.lists_questions_quiz(id_quiz);
		}


        //Trouver Id de la réponse correcte d'une question donnée
		@Override
		public Long Trouver_ID_Reponse_QST(Long id_question) {
			
			Question question=dao.get_question(id_question);
			
	     	for(Reponse rep : question.getReponses()) {
				if(rep.getCorrecte().equals("1")) {
					return rep.getId_reponse();
				}
			}
	     	
			return -1L;
			
		}



	    /* Réponse */
		
		// Ajouter une réponse
		@Override
		public Reponse ajouter_Reponse(Reponse r, Long id_question) {
			
			return dao.ajouter_Reponse(r, id_question);
		}




        // Get réponse
		@Override
		public Reponse get_reponse(Long id_reponse) {
			
			return dao.get_reponse(id_reponse);
		}


        // Supprimer réponse
		@Override
		public void supp_reponse(Long id_reponse) {
			dao.supp_reponse(id_reponse);
			
		}

        // Modifier réponse
		@Override
		public Reponse modifier_reponse(Reponse r) {
			
			return dao.modifier_reponse(r);
		}


        // Afficher la liste des réponses d'une question donnée
		@Override
		public List<Reponse> lists_reponses_question(Long id_question) {
			
			return dao.lists_reponses_question(id_question);
		}

		@Override
		public List<EtudiantReponse> Listes_reponses_etudiant(Long id_etudiant,Long id_quiz) {
			// TODO Auto-generated method stub
			return dao.Listes_reponses_etudiant(id_etudiant,id_quiz);
		}

		@Override
		public EtudiantQuiz ajouter_etud_quiz(EtudiantQuiz o, Long id_etudiant, Long id_quiz) {
			return dao.ajouter_etud_quiz(o, id_etudiant, id_quiz);
		}

		@Override
		public List<EtudiantQuiz> etudiant_passer_quiz(Long id_quiz) {
			
			return dao.etudiant_passer_quiz(id_quiz);
		}

		@Override
		public EtudiantReponse reponses_etudiant(EtudiantReponse o, Long id_etudiant, Long id_reponse,Long id_quiz) {
			
			return dao.reponses_etudiant(o, id_etudiant, id_reponse,id_quiz);
		}


}

