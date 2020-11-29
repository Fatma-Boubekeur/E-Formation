package org.com.formation.Controllers;



import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.com.formation.entities.Cours;
import org.com.formation.entities.Documentation;
import org.com.formation.metier.I_E_learning_Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;




@Controller
public class EnseignantController {

	 @Autowired
	 private I_E_learning_Metier metier;
	
	//Gestion des cours
	@RequestMapping("/Gestion_des_Cours")
    public ModelAndView Gestion_des_cours(HttpServletRequest request) {
        return new ModelAndView("Enseignant/Gestion_des_Cours");
    }
	
	
	//Afficher la liste des cours assuré par l'enseignant
	@RequestMapping("/Lists_Cours_Enseignants")
    public ModelAndView Lists_Cours_Enseignants(HttpServletRequest req) {
	    ModelAndView mav = new ModelAndView("Enseignant/Lists_Cours_Enseignants");
	    HttpSession session = req.getSession();
		Long id_enseignant=(Long) session.getAttribute("id_user");
	    List<Cours> list=metier.listes_des_cours_par_enseignant(id_enseignant);
	    mav.addObject("all_cours",list);
        return mav;
    }
	
	
	//Ajouter une documentation (Afficher formulaire ajouter documenation)
	@RequestMapping(value="/AjouterDocumentation",method = RequestMethod.GET)
    public ModelAndView Ajouter_Documentation(HttpServletRequest req)throws IOException{
	    ModelAndView mav = new ModelAndView("Enseignant/AjouterDocumentation");
	    HttpSession session = req.getSession();
		Long id_enseignant=(Long) session.getAttribute("id_user");
	    List<Cours> list=metier.listes_des_cours_par_enseignant(id_enseignant);
	    
	    try {
	    mav.addObject("Doc", new Documentation());
	    mav.addObject("all_cours",list);
	    
	    }catch(Exception e) {
			e.printStackTrace();
		}    
        return mav;
    }
	
	
	// SaveDocument Ajouter le document !!
	@RequestMapping(value = "/SaveDocument", method = RequestMethod.POST)
	public ModelAndView Save_Doc(HttpServletRequest req,@ModelAttribute("document") Documentation document,@RequestParam("file") MultipartFile file){ 
	
	String value=req.getParameter("c");
	Long id_cours=Long.parseLong(value);
	
	try {
	    document.setContenue(file.getBytes()); 
		document.setNom_contenue(file.getOriginalFilename());
		document.setContenue_type(file.getContentType());
		
		//Date creation
		Date current_date = new Date();
		java.sql.Date date_creation= new java.sql.Date(current_date.getTime());
        document.setDate_creation(date_creation);
	
	
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	try {
	  metier.ajouter_doc(document,id_cours);
	} catch(Exception e) {
		e.printStackTrace();
	}
	ModelAndView m = new ModelAndView("redirect:/SuccessDocument");    
	return m;
	}
		
	//Success Document ajouté 
	@RequestMapping("/SuccessDocument")
    public ModelAndView SuccessDocumentadd(HttpServletRequest request) {
        return new ModelAndView("Enseignant/SuccessDocumentadd");
    }
	
	
	//Liste des documentations d'un cours
	@RequestMapping(value="ListesDocuments/{id_cours}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Listes_Documentations(HttpServletRequest req,@PathVariable Long id_cours,RedirectAttributes redir) {
	  
		ModelAndView mav = new ModelAndView("redirect:/Listes_docs");
	    List<Documentation> list=metier.lists_doc_cours(id_cours);
	    redir.addFlashAttribute("all_docs",list);
		return mav;
	}
	
	//Listes docs 
	@RequestMapping("/Listes_docs")
    public ModelAndView Listes_docs(HttpServletRequest request) {
        return new ModelAndView("Enseignant/Listes_Documentations");
    }
	
	
	//Sauvegarder/Consulter le document 
	@RequestMapping("/Save_Display/{id_doc}")
	public String Save_Display(@PathVariable("id_doc") Long id_doc, HttpServletResponse response) {

    Documentation doc = metier.get_doc(id_doc);
    try {
		response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getNom_contenue()+ "\"");
		OutputStream out = response.getOutputStream();
		response.setContentType(doc.getContenue_type());
		Blob blob = new javax.sql.rowset.serial.SerialBlob(doc.getContenue());
		IOUtils.copy(blob.getBinaryStream(), out);		
		out.flush();
		out.close();
	
	} catch (IOException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
	
	
	//Modifier_Document 
	//Afficher le formulaire pour éditer la documentation 
	@RequestMapping(value="/Modifier_Document/{id_doc}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Modifier_Doc(@PathVariable("id_doc") Long id_doc, HttpServletResponse response,RedirectAttributes redir) {
    ModelAndView mav = new ModelAndView("redirect:/Edit_Doc");
    Documentation doc =metier.get_doc(id_doc);
    redir.addFlashAttribute("Doc",doc);
    return mav;	
	}
	
	//Edit_Doc
	@RequestMapping("/Edit_Doc")
    public ModelAndView Edit_Doc(HttpServletRequest request) {
        return new ModelAndView("Enseignant/Editer_document");
    }
	
	//Action Modifier document
	@RequestMapping(value = "/Action_Modifier_Document/{id_doc}",method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Action_Modifier_Doc(HttpServletRequest req,@PathVariable("id_doc") Long id_doc,@ModelAttribute("Doc") Documentation doc,@RequestParam("file") MultipartFile file) throws IOException{ 
    Documentation d=metier.get_doc(id_doc);	
	Long id_cours =d.getCours().getId_cours();
	if(!file.isEmpty()){ 
		  // Le document a été modifier (update du fichier) 
		   d.setContenue(file.getBytes());
		   d.setNom_contenue(file.getOriginalFilename());	
		   d.setContenue_type(file.getContentType());	
		   d.setNom_doc(req.getParameter("nom_doc"));

	}
	else{ //Aucun update du document (file) 
	    d.setContenue(d.getContenue());
		d.setNom_contenue(d.getNom_contenue());
		d.setContenue_type(d.getContenue_type());	
		d.setNom_doc(req.getParameter("nom_doc"));
	}
    metier.modifier_doc(d);
	return new ModelAndView("redirect:/ListesDocuments/"+id_cours);
	}
	
	
	
	//Supprimer un document
	@RequestMapping("Supprimer_Doc/{id_doc}")
	public ModelAndView Supprimer_Documents(@PathVariable("id_doc") Long id_doc) {
		
		Documentation d=metier.get_doc(id_doc);
		Long id_cours=d.getCours().getId_cours();
	
		metier.supp_doc(id_doc); 
				
		return new ModelAndView("redirect:/ListesDocuments/"+id_cours);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
