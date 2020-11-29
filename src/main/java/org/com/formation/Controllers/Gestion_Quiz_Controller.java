package org.com.formation.Controllers;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.com.formation.entities.Cours;
import org.com.formation.entities.EtudiantQuiz;
import org.com.formation.entities.EtudiantReponse;
import org.com.formation.entities.Question;
import org.com.formation.entities.Quiz;
import org.com.formation.entities.Reponse;
import org.com.formation.metier.I_E_learning_Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Gestion_Quiz_Controller {
	
	@Autowired
	private I_E_learning_Metier metier;
	
	
    //Choisir le cours
	@RequestMapping({ "/Choisir_Cours_Enseignant"})
    public ModelAndView Choisir_Cours(HttpServletRequest req) {
    ModelAndView mav = new ModelAndView("Enseignant/Gestion_Quiz/Choisir_Cours");
    HttpSession session = req.getSession();
	Long id_enseignant=(Long) session.getAttribute("id_user");
    List<Cours> list=metier.listes_des_cours_par_enseignant(id_enseignant);
    mav.addObject("cours_list",list);
    return mav;
	}
		
	//Gestion_Quiz
	@RequestMapping(value = "/Gestion_Quiz", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Gestion_Quiz(HttpServletRequest req){ 
	
	//Récupérer id du cours choisi 	
	String value=req.getParameter("c");
	Long id_cours=Long.parseLong(value);

	//Stocker id du cours choisi dans la session
    HttpSession session = req.getSession();
    session.setAttribute("id_cours",id_cours);
	
    //Get nom du cours 
    Cours c=metier.get_cours(id_cours);
    String nom_cours=c.getNom();
    session.setAttribute("nom_cours",nom_cours);
    
	ModelAndView m = new ModelAndView("Enseignant/Gestion_Quiz/Gestion_Quiz");  
	  
	return m;
	}
	


    //Ajouter un nouveau quiz
	//Afficher formulaire pour ajouter un quiz
	@RequestMapping({ "/Ajouter_Quiz"})
    public ModelAndView Ajouter_Quiz(HttpServletRequest req) {
		
    ModelAndView mav = new ModelAndView("Enseignant/Gestion_Quiz/Ajouter_Quiz");
    
    mav.addObject("quiz", new Quiz());
    
    return mav;
	}

	
	//Ajouter un quiz 
	//ActionQuiz (Submit) 
	@RequestMapping(value = "/ActionQuiz", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Ajouter_Quiz(HttpServletRequest req,@ModelAttribute("quiz") Quiz q,RedirectAttributes redir) throws ParseException{ 
		
	HttpSession session = req.getSession();
	Long id_cours=(Long) session.getAttribute("id_cours");

	String type_quiz=req.getParameter("type");
	Date date_creation = new Date(); //Current date
	
	q.setType(type_quiz);
    q.setDate(date_creation);
    
    
    Quiz quiz=metier.ajouter_quiz(q, id_cours);
    Long id_quiz=quiz.getId_quiz();
    session.setAttribute("id_quiz",id_quiz);
    
    
    
    
    if(type_quiz.equals("Vrai ou Faux")) {
    	ModelAndView mav = new ModelAndView("redirect:/Ajouter_QST_Vrai_Faux");	
    	return mav;
    	
    }else if(type_quiz.equals("Choix multiple")) {
    	ModelAndView mav = new ModelAndView("redirect:/Ajouter_QST_Choix_Multiple");
     	redir.addFlashAttribute("qst",new Question());
    	return mav;
    	
    }else {
    	
	return null;
	
    }
    
	}
	
	//Ajouter Question Vrai ou faux 
	@RequestMapping("/Ajouter_QST_Vrai_Faux")
    public ModelAndView Ajouter_sqt_vrai_faux(HttpServletRequest request) {
        ModelAndView m= new ModelAndView("Enseignant/Gestion_Quiz/Ajouter_Question_Vrai_Faux");
        m.addObject("qst",new Question());
        return m;
    }
	
	//Ajouter Question Choix multiple 
	@RequestMapping("/Ajouter_QST_Choix_Multiple")
    public ModelAndView Ajouter_Qst_choix_multiple(HttpServletRequest request) {
        ModelAndView m= new ModelAndView("Enseignant/Gestion_Quiz/Ajouter_Question_Choix_multiple");
        m.addObject("qst",new Question());
        return m;
    }

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
	}
	
	
	
	
	// Afficher la liste des questions type Vrai Faux
	@RequestMapping(value = "/Listes_Questions_Vrai_Faux/{id_quiz}", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Listes_Questions(HttpServletRequest req,@ModelAttribute("qst") Question qst,@PathVariable Long id_quiz,RedirectAttributes redir){ 
			
	Question question=metier.ajouter_Question(qst,id_quiz);
	Long id_question=question.getId_qst();
	
	String is_correct=req.getParameter("iscorrect");
	String rep1=req.getParameter("rep1");
	String rep2=req.getParameter("rep2");
	
	if(is_correct.equals("rep1")) {
		
		Reponse r=new Reponse();
		r.setRep_contenue(rep1);
		r.setCorrecte("1");
	    metier.ajouter_Reponse(r, id_question);
	    
	}else {
		
		Reponse r=new Reponse();
		r.setRep_contenue(rep1);
		r.setCorrecte("0");
	    metier.ajouter_Reponse(r, id_question);
	}
	
    if(is_correct.equals("rep2")) {
		
		Reponse r=new Reponse();
		r.setRep_contenue(rep2);
		r.setCorrecte("1");
	    metier.ajouter_Reponse(r, id_question);
	    
	}else {
		
		Reponse r=new Reponse();
		r.setRep_contenue(rep2);
		r.setCorrecte("0");
	    metier.ajouter_Reponse(r, id_question);
	}
	
	
    String nom_quiz=metier.get_quiz(id_quiz).getNom();
    ModelAndView mav = new ModelAndView("redirect:/Listes_questions/"+id_quiz+"/"+nom_quiz);
    
    return mav;
	}
	
	

	// Afficher la liste des questions type Choix multiple
	@RequestMapping(value = "/Listes_Questions_Choix_multiple/{id_quiz}", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Listes_Questions_Choix_multiple(HttpServletRequest req,@ModelAttribute("qst") Question qst,@PathVariable Long id_quiz,RedirectAttributes redir){ 
			
	Question question=metier.ajouter_Question(qst,id_quiz);

	Long id_question=question.getId_qst();
	
	String iscorrect=req.getParameter("iscorrect");
	String rep1=req.getParameter("rep1");
	String rep2=req.getParameter("rep2");
	String rep3=req.getParameter("rep3");

	if(iscorrect.equals("rep1")) {
		Reponse r=new Reponse();
		r.setRep_contenue(rep1);
		r.setCorrecte("1");
		metier.ajouter_Reponse(r, id_question);
	}else {
		Reponse r=new Reponse();
		r.setRep_contenue(rep1);
		r.setCorrecte("0");
		metier.ajouter_Reponse(r, id_question);
	}
	
	if(iscorrect.equals("rep2")) {
		Reponse r=new Reponse();
		r.setRep_contenue(rep2);
		r.setCorrecte("1");
		metier.ajouter_Reponse(r, id_question);
	}else {
		Reponse r=new Reponse();
		r.setRep_contenue(rep2);
		r.setCorrecte("0");
		metier.ajouter_Reponse(r, id_question);
	}
	
	if(iscorrect.equals("rep3")) {
		Reponse r=new Reponse();
		r.setRep_contenue(rep3);
		r.setCorrecte("1");
		metier.ajouter_Reponse(r, id_question);
	}else {
		Reponse r=new Reponse();
		r.setRep_contenue(rep3);
		r.setCorrecte("0");
		metier.ajouter_Reponse(r, id_question);
	}
	String nom_quiz=metier.get_quiz(id_quiz).getNom();
    ModelAndView mav = new ModelAndView("redirect:/Listes_questions/"+id_quiz+"/"+nom_quiz);
    
    return mav;
    
	}
	
	
	// Liste des questions d'un quiz donné 
	@RequestMapping("/Listes_questions/{id_quiz}/{nom_quiz}")
	public ModelAndView Listes_questions(HttpServletRequest req,@PathVariable Long id_quiz,@PathVariable String nom_quiz,RedirectAttributes redir) {
        
		Quiz q=metier.get_quiz(id_quiz);
		String type=q.getType();
		
		if(type.equals("Vrai ou Faux")) {
			ModelAndView mav = new ModelAndView("redirect:/Listes_questions_Vrai_Faux");
	    	List<Question> list=metier.lists_questions_quiz(id_quiz);
	    	redir.addFlashAttribute("list_qst_quiz",list);
	    	redir.addFlashAttribute("nom_quiz",nom_quiz);
	    	return mav;
		}else if(type.equals("Choix multiple")) {
			ModelAndView mav = new ModelAndView("redirect:/Listes_questions_Choix_multiple");
	    	List<Question> list=metier.lists_questions_quiz(id_quiz);
	    	redir.addFlashAttribute("list_qst_quiz",list);
	    	redir.addFlashAttribute("nom_quiz",nom_quiz);
			return mav;
			
		}else {
			return null;
		}
		
    }
	
	// Listes Questions de quiz type Vrai ou Faux 
	@RequestMapping("/Listes_questions_Vrai_Faux")
	public ModelAndView Listes_questions_Vrai_Faux(HttpServletRequest request) {
	    return new ModelAndView("Enseignant/Gestion_Quiz/Listes_Questions_Vrai_Faux");
	}
	
	// Listes Questions de quiz type Vrai ou Faux 
	@RequestMapping("/Listes_questions_Choix_multiple")
	public ModelAndView Listes_questions_Choix_multiple(HttpServletRequest request) {
	    return new ModelAndView("Enseignant/Gestion_Quiz/Listes_Questions_Choix_multiple");
	}


	// Supprimer une Question 
	
	@RequestMapping("Supprimer_Question/{id_question}")
	public ModelAndView Supprimer_Question(@PathVariable("id_question") Long id_question) {
		
		Question q=metier.get_question(id_question);
		Long id_quiz=q.getQuiz().getId_quiz();
	
		metier.supp_question(id_question);
				
		return new ModelAndView("redirect:/Listes_questions/"+id_quiz);
	}
	
	
	//Liste des quizs 
	@RequestMapping("/Listes_Quiz")
	public ModelAndView Listes_Quizs(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Long id_cours=(Long) session.getAttribute("id_cours");
		
		ModelAndView m= new ModelAndView("Enseignant/Gestion_Quiz/Listes_Quiz");
		List<Quiz> list=metier.lists_quiz_cours(id_cours);
		m.addObject("list_quiz",list);
		
		return m;
	}
	
	
	
	// Supprimer Quiz
	
	@RequestMapping("Supprimer_Quiz/{id_quiz}")
	public ModelAndView Supprimer_Quiz(@PathVariable("id_quiz") Long id_quiz) {


        metier.supp_quiz(id_quiz); 		
		
		return new ModelAndView("redirect:/Listes_Quiz");
	}
	
	
	// Modifier Quiz
	//Afficher le formulaire pour modifier quiz
	@RequestMapping(value="Modifier_Quiz/{id_quiz}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Modifier_Quiz(@PathVariable("id_quiz") Long id_quiz, HttpServletResponse response,RedirectAttributes redir) {
	ModelAndView mav = new ModelAndView("redirect:/Edit_Quiz");
	Quiz quiz =metier.get_quiz(id_quiz);
	redir.addFlashAttribute("quiz",quiz);
	return mav;	
	}
	
	//Edit_Quiz
	@RequestMapping("/Edit_Quiz")
    public ModelAndView Edit_Doc(HttpServletRequest request) {
        return new ModelAndView("Enseignant/Gestion_Quiz/Editer_Quiz");
    }
	
	//Action Modifier Quiz
	@RequestMapping(value = "Action_Modifier_Quiz/{id_quiz}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Action_Modifier_Quiz(HttpServletRequest req,@PathVariable("id_quiz") Long id_quiz,@ModelAttribute("quiz") Quiz quiz) { 
	Quiz q=metier.get_quiz(id_quiz);
	
	q.setNom(quiz.getNom());//Modifier nom quiz
	q.setDate_limite(quiz.getDate_limite()); // Modifier date limite de quiz
	
	metier.modifier_quiz(q); 
	
	return new ModelAndView("redirect:/Listes_Quiz");	
	}
	
	
	
	
	// Modifier Question 
	//Afficher le formulaire pour modifier question 
	@RequestMapping(value="Modifier_Question/{id_question}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Modifier_Question(@PathVariable("id_question") Long id_question, HttpServletResponse response,RedirectAttributes redir) {
	ModelAndView mav = new ModelAndView("redirect:/Editer_Question");
	Question question =metier.get_question(id_question);
	redir.addFlashAttribute("qst",question);
	return mav;	
	}
	//Editer_Question
	@RequestMapping("/Editer_Question")
    public ModelAndView Editer_Question(HttpServletRequest request) {
        return new ModelAndView("Enseignant/Gestion_Quiz/Editer_Question");
    }
	//Action Modifier Quiz
	@RequestMapping(value = "Action_Modifier_Question/{id_qst}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Action_Modifier_Question(HttpServletRequest req,@PathVariable("id_qst") Long id_qst,@ModelAttribute("qst") Question qst) { 
	Question q=metier.get_question(id_qst);

	q.setContenue_qst(qst.getContenue_qst()); // Modifier la question
    q.setNote(qst.getNote()); // Modifier note 
    
    metier.modifier_question(q);
    Long id_quiz=q.getQuiz().getId_quiz();
    String nom_quiz=metier.get_quiz(id_quiz).getNom();
	return new ModelAndView("redirect:/Listes_questions/"+id_quiz+"/"+nom_quiz);	
	}
	
	
    // Listes des réponses d'une question 
	@RequestMapping(value="Liste_Reponses_Qst/{id_qst}", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Listes_Reponses(HttpServletRequest req, @PathVariable("id_qst") Long id_qst , RedirectAttributes redir) {

		HttpSession session = req.getSession();

		Question qst=metier.get_question(id_qst);
		String contenue_qst=qst.getContenue_qst();
		
		session.setAttribute("contenue_qst",contenue_qst);
		
		ModelAndView m= new ModelAndView("redirect:/Listes_Reponses");
		List<Reponse> list=metier.lists_reponses_question(id_qst); // Listes des réponses d'une question donné 
    	redir.addFlashAttribute("list_reponse",list);
		
		return m;
	}
	
	// Listes Questions de quiz type Vrai ou Faux 
		@RequestMapping("/Listes_Reponses")
		public ModelAndView Listes_Réponses(HttpServletRequest request) {
		    return new ModelAndView("Enseignant/Gestion_Quiz/Listes_Reponses");
		}
	


	// Supprimer une réponse 
		
	@RequestMapping("Supprimer_Reponse/{id_reponse}")
	public ModelAndView Supprimer_Reponse(@PathVariable("id_reponse") Long id_reponse, RedirectAttributes redir) {

        
		Reponse r=metier.get_reponse(id_reponse);
		Long id_qst=r.getQuestion().getId_qst();
		
        metier.supp_reponse(id_reponse);
		
		ModelAndView m= new ModelAndView("redirect:/Listes_Reponses");
		
	
		List<Reponse> list=metier.lists_reponses_question(id_qst); // Listes des réponses d'une question donné 
    	redir.addFlashAttribute("list_reponse",list);
		
		return m;
	}
	
		
	// Modifier une Réponse Modifier_Reponse/${rep.id_reponse}
	
	// Modifier Réponse
	//Afficher le formulaire pour modifier réponse 
	@RequestMapping(value="Modifier_Reponse/{id_reponse}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Modifier_Reponse(@PathVariable("id_reponse") Long id_reponse, HttpServletResponse response,HttpServletRequest req,RedirectAttributes redir) {
	ModelAndView mav = new ModelAndView("redirect:/Editer_Reponse");
	
	String type_quiz;
	
	Reponse rep =metier.get_reponse(id_reponse);
	Long id_qst=rep.getQuestion().getId_qst();
	Long id_quiz=metier.get_question(id_qst).getQuiz().getId_quiz();
	type_quiz=metier.get_quiz(id_quiz).getType();	
	redir.addFlashAttribute("rep", rep);
	redir.addFlashAttribute("type_quiz",type_quiz);
	return mav;	
	}
	//Editer_Reponse
	@RequestMapping("/Editer_Reponse")
    public ModelAndView Editer_Reponse(HttpServletRequest request) {
        return new ModelAndView("Enseignant/Gestion_Quiz/Editer_Reponse");
    }

	//Action Modifier Reponse
	@RequestMapping(value = "Action_Modifier_Reponse/{id_reponse}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Action_Modifier_Reponse(HttpServletRequest req,@PathVariable("id_reponse") Long id_reponse,@ModelAttribute("rep") Reponse rep,RedirectAttributes redir) { 
	Reponse r=metier.get_reponse(id_reponse);
	
	r.setRep_contenue(req.getParameter("rep_contenue"));
	r.setCorrecte(req.getParameter("iscorrecte"));
	
	metier.modifier_reponse(r);
	
	ModelAndView m= new ModelAndView("redirect:/Listes_Reponses");
	
	List<Reponse> list=metier.lists_reponses_question(r.getQuestion().getId_qst()); 
	redir.addFlashAttribute("list_reponse",list);
	return m;
	
	}	
	
	
	// Afficher la liste des étudiants qui ont passé un quiz 
	
	@RequestMapping(value="Listes_etudiants/{id_quiz}/{nom_quiz}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Listes_Etudiants_Quiz(@PathVariable("id_quiz") Long id_quiz,@PathVariable("nom_quiz") String nom_quiz, HttpServletResponse response,RedirectAttributes redir) {
	
		ModelAndView m= new ModelAndView("redirect:/Listes_Etudiants_Quiz");
		List<EtudiantQuiz> list =metier.etudiant_passer_quiz(id_quiz);
        redir.addFlashAttribute("list_etud_quiz",list);
        redir.addFlashAttribute("nom_quiz",nom_quiz);

		return m;
	}
	
	// Listes etudiants quiz 
	@RequestMapping("/Listes_Etudiants_Quiz")
	public ModelAndView Listes_Etudiants_Quiz(HttpServletRequest request) {
	    return new ModelAndView("Enseignant/Gestion_Quiz/Listes_Etudiants_Quiz");
	}
	
	
	// Afficher les réponses d'un étudiant donné 
	@RequestMapping(value="Reponses_etudiants/{id_etudiant}/{nom_quiz}/{id_quiz}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Listes_Reponses_Etudiant(@PathVariable("id_etudiant") Long id_etudiant,@PathVariable("nom_quiz") String nom_quiz,@PathVariable("id_quiz") Long id_quiz, HttpServletResponse response,RedirectAttributes redir,HttpServletRequest req) {
	
		ModelAndView m= new ModelAndView("redirect:/Reponses_Etudiant");
		
		// Liste des réponses
	    List<EtudiantReponse> list=metier.Listes_reponses_etudiant(id_etudiant,id_quiz);
	    redir.addFlashAttribute("list_etud_rep",list);
	    redir.addFlashAttribute("nom_quiz",nom_quiz);
        
	    // Aficher la liste des questions du quiz
	    List<Question> list_qst=metier.lists_questions_quiz(id_quiz);
	    	    
	    int nbr_qst=list_qst.size();
	    redir.addFlashAttribute("list_qst",list_qst);
	    redir.addFlashAttribute("nbr_qst",nbr_qst);

        String nom=metier.get_etudiant(id_etudiant).getNom();
        String prenom=metier.get_etudiant(id_etudiant).getPrenom();
        HttpSession session = req.getSession();
        session.setAttribute("nom_etud",nom);
        session.setAttribute("prenom_etud",prenom);
        
        
     
	    return m;
	}
	
	// Listes etudiants quiz 
    @RequestMapping("/Reponses_Etudiant")
    public ModelAndView Reponses_Etudiants(HttpServletRequest request) {
		 return new ModelAndView("Enseignant/Gestion_Quiz/Reponses_Etudiant");
	}
	
    
    
    
	
	
	
	
	
	
	

	
	
	
	
	
	
}

