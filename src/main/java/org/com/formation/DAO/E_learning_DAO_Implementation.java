package org.com.formation.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.com.formation.Encryption;
import org.com.formation.entities.Cours;
import org.com.formation.entities.Documentation;
import org.com.formation.entities.Enseignant;
import org.com.formation.entities.Etudiant;
import org.com.formation.entities.EtudiantQuiz;
import org.com.formation.entities.EtudiantReponse;
import org.com.formation.entities.Question;
import org.com.formation.entities.Quiz;
import org.com.formation.entities.Reponse;

public class E_learning_DAO_Implementation implements I_E_learningDAO {
	
	/* Objet EntityManager */
	@PersistenceContext
	private EntityManager em;
	
		
	/* Login Validation */
	@Override
	public String LoginValidation(String username, String password) {
		String login=username;
	    String mdp=Encryption.encrypt(password);//Crypter en md5 
	    
	    //Query 1 Vérifier dans la table étudiant 
	    Query req1=em.createQuery("select e from Etudiant e where e.login=:x and e.password=:y");
		req1.setParameter("x",login);
		req1.setParameter("y",mdp);
		List<Etudiant> etuds=req1.getResultList();
	
	    //Query 2 Vérifier dans la table enseignant 
		Query req2=em.createQuery("select ens from Enseignant ens where ens.login=:x and ens.password=:y");
		req2.setParameter("x",login);
		req2.setParameter("y",mdp);
		List<Enseignant> ens=req2.getResultList();
		
		if(etuds.size()==1 && ens.size()==0) return "Etudiant";
			
		else if(ens.size()==1 && etuds.size()==0) return "Enseignant"; else {
			
			return "Compte introuvable ! ";
		}
	}


	
	/* Etudiant */
	// Ajouter un étudiant
	@Override
	public Etudiant ajouter_etudiant(Etudiant e) {
        em.persist(e);
		return e;
	}
    // Récupérer un étudiant par l'Id 
	@Override
	public Etudiant get_etudiant(Long id_etudiant) {
        Etudiant e=em.find(Etudiant.class,id_etudiant);
        if(e==null) {
        	throw new RuntimeException("Etudiant introuvable");
        }        
		return e;
	}
    // Afficher la liste de tous les étudiants
	@Override
	public List<Etudiant> liste_des_etudiants() {
		Query req=em.createQuery("SELECT e FROM Etudiant e");
		return req.getResultList();
	}
    // Inscrire un étudiant à un cours 
	@Override
	public void inscrire_etudiant_cours(Long id_etudiant, Long id_cours) {
           Etudiant e=em.find(Etudiant.class,id_etudiant);
		   Cours c=em.find(Cours.class,id_cours);
		   e.getCours().add(c);
	       c.getEtudiants().add(e);
	}
	// la liste des étudiants d'un cours 
	@Override
	public List<Etudiant> Listes_etudiants_suiv_cours(Long id_cours) {
        Query req=em.createQuery("select e from Etudiant e where e.cours.id_cours=:x ");
		req.setParameter("x",id_cours);
		return req.getResultList();
	}
	
	/* Enseignant */
	// Ajouter un enseignant 
	@Override
	public Enseignant ajouter_enseignant(Enseignant ens) {
		em.persist(ens);
		return ens;
	}
    // Récupérer un enseignant par Id 
	@Override
	public Enseignant get_enseignant(Long id_enseignant) {
        Enseignant ens=em.find(Enseignant.class,id_enseignant);	
        if(ens==null) {
        	throw new RuntimeException("Enseignant introuvable");
        }
		return ens;
	}
    // Afficher la liste de tous les enseignants
	@Override
	public List<Enseignant> liste_des_enseignants() {
       Query req=em.createQuery("select e from Enseignant e");
		return req.getResultList();
	}
	// Récupérer l'enseignant du cours 
	@Override
	public Enseignant get_enseignant_cours(Long id_cours) {
     Query req=em.createQuery("select e from Enseignant e inner join e.cours c where c.id_cours=:x");
     req.setParameter("x",id_cours);
     return (Enseignant) req.getSingleResult();
		
	}
	
	

	/* Cours */
	//Ajouter un cours
	@Override
	public Cours ajouter_cours(Cours c, Long id_enseignant) {
		if(id_enseignant!=null){
			Enseignant ens=em.find(Enseignant.class,id_enseignant);
			c.setEnseignant(ens);
		}
		em.persist(c);
		return c;
	}
    // Afficher la liste des cours 
	@Override
	public List<Cours> liste_des_cours() {
       Query req=em.createQuery("select c from Cours c");
		return req.getResultList();
	}
    // Récupérer un cours par Id
	@Override
	public Cours get_cours(Long id_cours) {
        Cours c=em.find(Cours.class,id_cours);
        if(c==null) {
        	throw new RuntimeException("Cours introuvable");
        }
        
		return c;
	}
	// La liste des cours assuré par un enseignant 
	@Override
	public List<Cours> listes_des_cours_par_enseignant(Long id_enseignant) {
        Query req=em.createQuery("select c from Cours c where c.enseignant.id_enseignant=:x");
        req.setParameter("x",id_enseignant);
		return req.getResultList();
	}
    // La liste des cours suivit par un etudiant 
	@Override
	public List<Cours> listes_des_cours_suivi_par_etudiant(Long id_etudiant) {
        Query req=em.createQuery("select c from Cours c inner join c.etudiants e  where e.id_etudiant=:x");
        req.setParameter("x",id_etudiant);
		return req.getResultList();
	}

	/* Documentation */
	// Ajouter une document
	@Override
	public Documentation ajouter_doc(Documentation doc, Long id_cours) {
        if(id_cours!=null) {
        	Cours c=em.find(Cours.class,id_cours);
        	doc.setCours(c);
        }
        em.persist(doc);
		return doc;
	}
    // Supprimer un document
	@Override
	public void supp_doc(Long id_doc) {
      Documentation doc=em.find(Documentation.class,id_doc);
      em.remove(doc);     
	}
    // Modifier un document 
	@Override
	public Documentation modifier_doc(Documentation d) {
		return em.merge(d);
	}
	// Récupérer un document par Id
	@Override
	public Documentation get_doc(Long id_doc) {
		Documentation d=em.find(Documentation.class,id_doc);
        if(d==null) {
        	throw new RuntimeException("Documentation introuvable");
        }
		return d;
	}
	// Afficher la liste des documents d'un cours 
	@Override
	public List<Documentation> lists_doc_cours(Long id_cours) {
        Query req=em.createQuery("select d from Documentation d where d.cours.id_cours=:x");
        req.setParameter("x",id_cours);
		return req.getResultList();
	}
	
	
    /* Quiz */
	//Ajouter Quiz
	@Override
	public Quiz ajouter_Quiz(Quiz q, Long id_cours) {

		if(id_cours!=null){
			Cours c=em.find(Cours.class,id_cours);
			q.setCours(c);
		}
		em.persist(q);
		return q;
	
	}
	// Récupérer le quiz par Id
	@Override
	public Quiz get_quiz(Long id_quiz) {
		
		Quiz q=em.find(Quiz.class,id_quiz);
        if(q==null) {
        	throw new RuntimeException("Quiz introuvable");
        }
        
		return q;	
	}	
	// Supprimer quiz
	@Override
	public void supp_quiz(Long id_quiz) {
		
		Quiz q=em.find(Quiz.class,id_quiz);
	    em.remove(q);  
	}
    // Modifier quiz 
	@Override
	public Quiz modifier_quiz(Quiz q) {
		
		return em.merge(q);
	}
    //	Afficher la liste des quiz du cours
	@Override
	public List<Quiz> lists_quiz_cours(Long id_cours) {
	
		    Query req=em.createQuery("select q from Quiz q where q.cours.id_cours=:x");
	        req.setParameter("x",id_cours);
			return req.getResultList();
	}


	
    /* Question */
	//Ajouter une question 
	@Override
	public Question ajouter_Question(Question qst, Long id_quiz) {
		if(id_quiz!=null){
			Quiz q=em.find(Quiz.class,id_quiz);
			qst.setQuiz(q);
		}
		em.persist(qst);
		return qst;
	}
    // Supprimer une question
	@Override
	public void supp_question(Long id_question) {
		Question q=em.find(Question.class,id_question);
	    em.remove(q);  
		
	}
	// Modifier une question 
	@Override
	public Question modifier_question(Question qst) {
		return em.merge(qst);
	}
	//Get question
	@Override
	public Question get_question(Long id_question) {
		Question qst=em.find(Question.class,id_question);
	    if(qst==null) {
	    	throw new RuntimeException("Question introuvable");
	    }
	    
		return qst;
		
	}
	//	Afficher la liste des questions du quiz 
		@Override
		public List<Question> lists_questions_quiz(Long id_quiz) {
			
			Query req=em.createQuery("select qst from Question qst where qst.quiz.id_quiz=:x");
	        req.setParameter("x",id_quiz);
			return req.getResultList();
			
		}

	
		
		
	/* Réponse */		
	// Ajouter réponse	
	@Override
	public Reponse ajouter_Reponse(Reponse r, Long id_question) {
		if(id_question!=null){
			Question q=em.find(Question.class,id_question);
			r.setQuestion(q);
		}
		em.persist(r);
		return r;
	}
    // Récupérer la réponse par Id
	@Override
	public Reponse get_reponse(Long id_reponse) {
		Reponse r=em.find(Reponse.class,id_reponse);
	    if(r==null) {
	    	throw new RuntimeException("Reponse introuvable");
	    }
	    
		return r;
		
	}
	// Supprimer une réponse
	@Override
	public void supp_reponse(Long id_reponse) {
		Reponse r=em.find(Reponse.class,id_reponse);
	    em.remove(r);  
		
	}
    // Modifier une réponse
	@Override
	public Reponse modifier_reponse(Reponse r) {
		return em.merge(r);
	}
    // Afficher la liste des réponses d'une question donnée 
	@Override
	public List<Reponse> lists_reponses_question(Long id_question) {
		Query req=em.createQuery("select r from Reponse r where r.question.id_qst=:x");
        req.setParameter("x",id_question);
		return req.getResultList();
	}



	@Override
	public Enseignant Get_Enseignant_By_Login_Password(String username, String password) {
		String login=username;
	    String mdp=Encryption.encrypt(password);//Crypter en md5 
  		Query req=em.createQuery("select ens from Enseignant ens where ens.login=:x and ens.password=:y");
  		req.setParameter("x",login);
  		req.setParameter("y",mdp);
        Enseignant ens=(Enseignant) req.getSingleResult();	  		
		return ens;
	}



	@Override
	public Etudiant Get_Etudiant_By_Login_Password(String username, String password) {
		String login=username;
	    String mdp=Encryption.encrypt(password);//Crypter en md5 
	    Query req=em.createQuery("select e from Etudiant e where e.login=:x and e.password=:y");
		req.setParameter("x",login);
		req.setParameter("y",mdp);
	    Etudiant e=(Etudiant) req.getSingleResult();
		return e;
	}



    /* Etudiant Quiz (Passer Quiz) */
	
	// Ajouter un étudiant qui a passé un quiz dans la table EtudiantQuiz
	@Override
	public EtudiantQuiz ajouter_etud_quiz(EtudiantQuiz o, Long id_etudiant, Long id_quiz) {
		
		if(id_etudiant!=null){
			Etudiant e=em.find(Etudiant.class,id_etudiant);
			o.setEtudiant(e);
		}
		
		if(id_quiz!=null){
			Quiz z=em.find(Quiz.class,id_quiz);
			o.setQuiz(z);
		}
		
		em.merge(o);
		return o;
	}



	@Override
	public List<EtudiantQuiz> etudiant_passer_quiz(Long id_quiz) {
		
		Query req=em.createQuery("select o from EtudiantQuiz o where  o.quiz.id_quiz=:x");
        req.setParameter("x",id_quiz);
		return req.getResultList();
		

	}



	@Override
	public EtudiantReponse reponses_etudiant(EtudiantReponse o,Long id_etudiant, Long id_reponse,Long id_quiz) {
		
		o.setId_quiz(id_quiz);
		if(id_etudiant!=null){
			Etudiant e=em.find(Etudiant.class,id_etudiant);
			o.setEtudiant(e);
		}
		
		if(id_reponse!=null){
			Reponse r=em.find(Reponse.class,id_reponse);
			o.setReponse(r);
		}
		
		em.merge(o);
		return o;
	}



	@Override
	public List<EtudiantReponse> Listes_reponses_etudiant(Long id_etudiant,Long id_quiz) {
		Query req=em.createQuery("SELECT r FROM EtudiantReponse r where  r.etudiant.id_etudiant=:x and r.id_quiz=:y");
		req.setParameter("x",id_etudiant);
		req.setParameter("y",id_quiz);
		return req.getResultList();
		
		
	}






}
