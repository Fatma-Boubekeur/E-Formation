package org.com.formation.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.com.formation.entities.Cours;
import org.com.formation.entities.Documentation;
import org.com.formation.metier.I_E_learning_Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Etudiant_Controller {

    @Autowired
	private I_E_learning_Metier metier;
	
    
	//Cours Disponibles 
	@RequestMapping({ "/CoursDisponibles"})
    public ModelAndView Afficher_All_cours(HttpServletRequest req) {
    ModelAndView mav = new ModelAndView("Etudiant/CoursDisponibles");
    List<Cours> list=metier.liste_des_cours();
    mav.addObject("all_cours",list);
    return mav;
	}
	
	
	//Success Etudiant inscrit
	@RequestMapping("/Success")
    public ModelAndView Success(HttpServletRequest request) {
        return new ModelAndView("Etudiant/Success");
    }
	
	//Fail Etudiant est déja inscrit au cours
	@RequestMapping("/Fail")
    public ModelAndView Fail(HttpServletRequest request) {
        return new ModelAndView("Etudiant/Fail");
    }
	
	
	//ActionRegisterCours (inscription étudiant aux cours)
	@RequestMapping(value="/ActionRegisterCourse/{id_cours}" , method = RequestMethod.GET)
	public ModelAndView Register_Etudiant_Cours(HttpServletRequest req,@PathVariable Long id_cours) {
	HttpSession session = req.getSession();
	Long id_etud=(Long) session.getAttribute("id_user");
	if(metier.Verif_etudiant_cours(id_etud, id_cours)==true) {
		metier.inscrire_etudiant_cours(id_etud, id_cours);
		ModelAndView m = new ModelAndView("redirect:/Success");  	
		return m;	
	}
	ModelAndView m = new ModelAndView("redirect:/Fail");  	
	return m;
	}
	
	
	
	//Mes cours (Afficher les cours suivit par l'étudiant)
	@RequestMapping({ "/Mes_Cours"})
    public ModelAndView Afficher_My_cours(HttpServletRequest req) {
    ModelAndView mav = new ModelAndView("Etudiant/Mes_Cours");
    HttpSession session = req.getSession();
	Long id_etud=(Long) session.getAttribute("id_user");
    List<Cours> list=metier.listes_des_cours_suivi_par_etudiant(id_etud);
    mav.addObject("my_cours",list);
    return mav;
	}

	
	//Consulter documentation des cours 
	@RequestMapping(value="Documentation/{id_cours}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Documentation(HttpServletRequest req,@PathVariable Long id_cours,RedirectAttributes redir) {
	  
		ModelAndView mav = new ModelAndView("redirect:/Documents");
	    List<Documentation> list=metier.lists_doc_cours(id_cours);
	    redir.addFlashAttribute("all_docs",list);
		return mav;
	}
	
	//Documents
	@RequestMapping("/Documents")
    public ModelAndView Documents(HttpServletRequest request) {
        return new ModelAndView("Etudiant/Documentation");
    }
	
	
	
	
}
