package org.com.formation.Controllers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.com.formation.entities.Cours;
import org.com.formation.entities.EtudiantQuiz;
import org.com.formation.entities.EtudiantReponse;
import org.com.formation.entities.Question;
import org.com.formation.entities.Quiz;
import org.com.formation.entities.Reponse;
import org.com.formation.metier.I_E_learning_Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Passer_Quiz_Controller {

	@Autowired
	private I_E_learning_Metier metier;
	
	//Choisir le cours
	@RequestMapping({ "/Choisir_Cours"})
    public ModelAndView Choisir_Cours(HttpServletRequest req) {
    ModelAndView mav = new ModelAndView("Etudiant/PasserQuiz/ChoisirCours");
    HttpSession session = req.getSession();
	Long id_etud=(Long) session.getAttribute("id_user");
    List<Cours> list=metier.listes_des_cours_suivi_par_etudiant(id_etud);
    mav.addObject("cours_list",list);
    return mav;
	}
	
	//Choisir le quiz
	@RequestMapping(value = "/Choisir_Quiz", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Choisir_Quiz(HttpServletRequest req){ 
	
	//Récupérer id du cours choisi 	
	String value=req.getParameter("c");
	Long id_cours=Long.parseLong(value);

	//Stocker id du cours choisi dans la session
    HttpSession session = req.getSession();
    session.setAttribute("id_cours",id_cours);
	
	List<Quiz> list=metier.lists_quiz_cours(id_cours);
	ModelAndView m = new ModelAndView("Etudiant/PasserQuiz/Choisir_Quiz");    
    m.addObject("quiz_list",list);
	return m;
	}
	
	
	//Passer_Quiz
	@RequestMapping(value = "/Passer_Quiz", method = { RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Passer_Quiz(HttpServletRequest req){ 
	
	//Récupérer id du quiz choisi 	
	String value=req.getParameter("q");
	Long id_quiz=Long.parseLong(value);
	
	//Listes des qustions du cours 
	List<Question> list_qst=metier.lists_questions_quiz(id_quiz);
	int nbr_qst=list_qst.size();
	
	//Pour spécifier le nom du cours
    HttpSession session = req.getSession();
	Long id_cours=(Long) session.getAttribute("id_cours");
	String nom_cours=metier.get_cours(id_cours).getNom();
	session.setAttribute("id_quiz",id_quiz);
	
	//Pour spécifier la date du création / la date limite du quiz 
	Date date_creation=metier.get_quiz(id_quiz).getDate();
	Date date_limite=metier.get_quiz(id_quiz).getDate_limite();
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    String creation=format.format(date_creation);
	String limite=format.format(date_limite);
	
	ModelAndView m = new ModelAndView("Etudiant/PasserQuiz/Passer_Quiz");
	m.addObject("list_qst",list_qst);
	m.addObject("nbr_qst",nbr_qst);
	m.addObject("nom_cours",nom_cours);
	m.addObject("date_creation",creation);
    m.addObject("date_limite",limite);
	return m;
	}

	
	
    //Submit questions (Action)
	@RequestMapping(value = "/QuestionSubmit", method = { RequestMethod.GET, RequestMethod.POST})
    public ModelAndView QuestionSubmit(HttpServletRequest req){ 

		
	String [] questionIds=req.getParameterValues("questionId");
	
	
	int note=0;
	
	for(String questionId : questionIds) {
				
	    Long id_rep_corr=metier.Trouver_ID_Reponse_QST(Long.parseLong(questionId));//La réponse correcte
			    
		Long id_rep_etud=Long.parseLong(req.getParameter("question_"+questionId));//La réponse de l'étudiant
		
		Question q=metier.get_question(Long.parseLong(questionId));
		int note_qst=q.getNote();
		
		if(id_rep_corr.equals(id_rep_etud)) {
			note=note+note_qst;	
		}
		
		
	}
	
	req.setAttribute("score",note);
	Date d=new Date();
	HttpSession session = req.getSession();
	Long id_etudiant=(Long) session.getAttribute("id_user");

	EtudiantQuiz o=new EtudiantQuiz(note,d);
	Long id_quiz=(Long) session.getAttribute("id_quiz");
	
    metier.ajouter_etud_quiz(o,id_etudiant, id_quiz);
    
    EtudiantReponse rep_etud=new EtudiantReponse();
   
    for(String questionId : questionIds) {
	Long id_reponse=Long.parseLong(req.getParameter("question_"+questionId));//La réponse de l'étudiant	
    metier.reponses_etudiant(rep_etud, id_etudiant, id_reponse,id_quiz);
    }	
    
    ModelAndView m = new ModelAndView("Etudiant/PasserQuiz/Resultat");
    return m;

	}
	
	
	
	
}
