package org.com.formation.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.com.formation.Encryption;
import org.com.formation.Model.Login;
import org.com.formation.entities.Cours;
import org.com.formation.entities.Enseignant;
import org.com.formation.entities.Etudiant;
import org.com.formation.metier.I_E_learning_Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



@Controller
@SessionAttributes("login")
public class E_Learning_Controller {
	
     @Autowired
	 private I_E_learning_Metier metier;
     
	/* Login is our welcome page */
     
	     @RequestMapping({ "/", "/Login"})
	     public ModelAndView hello(HttpServletRequest request) {
	    	 
         //Initialisation des donnees pour enseignant et cours au demarrage de l'application
    	 
    	 Enseignant ens=new Enseignant("Gendouzi_Wassila",Encryption.encrypt("1234"),"Gendouzi","wassila","email@exemple.com","adresse","Docteur","Exemple tel");
         Enseignant ens2=new Enseignant("Aoudia_formateur123",Encryption.encrypt("4567"),"Aoudia","Chafika","cha_aoudia@yahoo.fr","adresse exemple","MCB","tel exemple");
    	 
    	 boolean verif_enseignant=metier.check_exist_Enseignant(ens);
         boolean verif_enseignant2=metier.check_exist_Enseignant(ens2);
    	 
         if(verif_enseignant==true) {//return true s'il n'existe pas déjà 
         //Ajouter un enseignant dans la base de données ! 
         Enseignant ens_nv=metier.ajouter_enseignant(ens);	

         //Ajouter un cours 
	     Long id=ens_nv.getId_enseignant();
         Cours c=new Cours("Architecture Logicielle","Description du cours archi ",ens_nv);
         Cours c2=new Cours("Java EE","Description du cours java EE ",ens_nv);
         Cours c3=new Cours("Qualité logiciel","Description du cours qualité logiciel ",ens_nv);


         boolean verif_cours=metier.check_exist_Cours(c); //Verifier que le cours n'existe pas déja dans la bdd
         
         if(verif_cours==true) {// return true s'il n'existe pas déjà
         metier.ajouter_cours(c,id);
         metier.ajouter_cours(c2, id);
         metier.ajouter_cours(c3, id);
         
    	 }//fin if verif_cours
         
         }//fin if verif_enseignant
         
         
         if(verif_enseignant2==true) {//return true s'il n'existe pas déjà 
         //Ajouter un enseignant dans la base de données ! 
         Enseignant ens_nv2=metier.ajouter_enseignant(ens2);	

         //Ajouter un cours 
	     Long id=ens_nv2.getId_enseignant();
         Cours c4=new Cours("BDD avancées","Description Cours",ens_nv2);

         boolean verif_cours=metier.check_exist_Cours(c4); //Verifier que le cours n'existe pas déja dans la bdd
         
         if(verif_cours==true) {// return true s'il n'existe pas déjà
         metier.ajouter_cours(c4,id);
         
    	 }//fin if verif_cours
         
         }//fin if verif_enseignant
         
         ModelAndView mav = new ModelAndView("Login");
         mav.addObject("login", new Login());
         return mav;
         
     }//fin methode
    
     
     
	/* Inscription Etudiant */
     
     @RequestMapping(value = "/EtudiantRegister", method = RequestMethod.GET)
     public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
       ModelAndView mav = new ModelAndView("EtudiantRegister");
       mav.addObject("Etudiant", new Etudiant());
       return mav;
     }
     
     //Validation du formulaire apres le bouton submit 
     @RequestMapping(value = "/RegisterAction", method = RequestMethod.POST)
     public ModelAndView AjouterEtudiant(HttpServletRequest req,@ModelAttribute("Etudiant") @Valid Etudiant e,BindingResult error) {
    	 
    //Vérfier la confirmation du mot de passe (si les 2 mdps sont identiques)
     boolean v=false;
     String password=req.getParameter("password");
     String confirm_password=req.getParameter("confirm_password"); 
     if(password.equals(confirm_password)==true) {
    	 v=true;
     }  
     
     //Afficher les erreurs sur le formulaire
     if(error.hasErrors()||v==false) {
    	 ModelAndView model=new ModelAndView("EtudiantRegister"); 
    	 
    	 if(password!= null && !password.equals("") ||confirm_password != null && !confirm_password.equals(""))
    	 {
    	 model.addObject("mdp_confirm_error","Les deux mots de passe saisis ne correspondent pas !");
    	 }
    	 
    	 return model;
     }
     
     //Crypter le mot de passe md5
     String mdp=req.getParameter("password");
     mdp=Encryption.encrypt(mdp);//Crypter
     e.setPassword(mdp); //Pour stocker le mot de passe en md5 dans la bdd 
   
     //Ajouter l'etudiant à la bdd 
     metier.ajouter_etudiant(e);
     
     //Javascript pour afficher un alert aprés la validation de formulaire 
     ModelAndView m = new ModelAndView("EtudiantRegister");     
     String script="<script type=\"text/javascript\">alert(\"Inscription effectuée avec succées !\");setTimeout(location.href='Login', '2000');\r\n" + 
     		"</script>";
     m.addObject("js",script);
     
     return m;
     
     }
     
     
     
     //Espace Etudiant ! :) 
     @RequestMapping("/EspaceEtudiant")
     public ModelAndView EspaceEtudiant(HttpServletRequest request) {
         return new ModelAndView("Etudiant/Acceuil_Etudiant");
     }
     
     //Espace Enseignant ! :) 
     @RequestMapping("/EspaceEnseignant")
     public ModelAndView EspaceEnseignant(HttpServletRequest request) {
         return new ModelAndView("Enseignant/Acceuil_Enseignant");
     }
    
     
	/* Validation login */
     
     @RequestMapping(value = "/ActionLogin", method = RequestMethod.POST)
     public ModelAndView Login(HttpServletRequest req,@ModelAttribute("login") @Valid Login login,BindingResult error) {
    	 
    	 String username=req.getParameter("username");
    	 String password=req.getParameter("password");
    	 
    	// Avoir id de user de la session !!! 
         HttpSession session = req.getSession();
         Long id_user=(Long) metier.GetUserId(username,password);
         
         session.setAttribute("id_user",id_user);
   
    	 
    	 String verif=metier.LoginValidation(username, password);

    	 //Si c'est un étudiant afficher la vue Acceuil_Etudiant
    	 if(verif.equals("Etudiant")) { ModelAndView m= new ModelAndView("redirect:/EspaceEtudiant");m.addObject("username", username); 
    	 return m;
    	 }
    	 //Sinon si c'est un enseignant afficher la vue Enseignant 
    	 else if(verif.equals("Enseignant")) { ModelAndView m= new ModelAndView("redirect:/EspaceEnseignant"); m.addObject("username",username); return m;}
    	 //Sinon erreur Login/Mot de passe incorrecte 
    	 else {
    	        ModelAndView m = new ModelAndView("Login");     
    		    String script="<script type=\"text/javascript\">alert(\"Le nom d'utilisateur ou le mot de passe est incorrect !\");" + 
    		     		"</script>";
    		     m.addObject("js",script);
    		 return  m;
    	 } 
     }    
     
     

     
     
     
}
