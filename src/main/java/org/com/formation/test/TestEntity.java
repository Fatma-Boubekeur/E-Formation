package org.com.formation.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.com.formation.Encryption;
import org.com.formation.entities.Cours;
import org.com.formation.entities.Documentation;
import org.com.formation.entities.Enseignant;
import org.com.formation.entities.Etudiant;
import org.com.formation.entities.EtudiantReponse;
import org.com.formation.entities.Reponse;
import org.com.formation.metier.I_E_learning_Metier;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestEntity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    
	   ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[] {"applicationContexte.xml"});
	   I_E_learning_Metier metier=(I_E_learning_Metier) context.getBean("metier");

		// Test les méthodes :)
		/*
		 * // Etudiant
		 */		
		// Tester ajouter un étudiant ***Work***
		//metier.ajouter_etudiant(new Etudiant("fatma","boubekeur","fatma-bob@hotmail.com","informatique","SII","Master"));
		
		//Get etudiant  ***Work***
        //Etudiant e=metier.get_etudiant(3L);
        //System.out.println("nom \t"+e.getNom()+"\t prenom \t"+e.getPrenom()+"\t email \t"+e.getEmail()+"\t filiére \t"+e.getFiliere()+"\t specialité \t"+e.getSpecialite()+"\t niveau \t"+e.getNiveau());
		
		//Afficher la liste de tous les étudiants ***Works!!***
//        List<Etudiant>	etudiants=metier.liste_des_etudiants();	
//		for(Etudiant e:etudiants) {
//			System.out.println("****************************");
//			System.out.println(e.getNom());
//			System.out.println(e.getPrenom());
//			System.out.println(e.getEmail());
//            System.out.println(e.getFiliere());
//            System.out.println(e.getSpecialite());
//            System.out.println(e.getNiveau());
//		}
//		
////  Tester la méthode : inscrire_étudiant-cours ***Works!!*** 
//	metier.inscrire_etudiant_cours(6L,3L); //Fatma suit le cours archi
//	metier.inscrire_etudiant_cours(6L,4L); //Fatma suit le cours J2EE
//	metier.inscrire_etudiant_cours(7L,4L); //Maya suit le cours archi et J2EE
//	metier.inscrire_etudiant_cours(8L,5L); //Maha suit le cours archi et J2EE

/*******************************Fini avec les méthodes de l'étudiant ******************************/	

		
		
		/* Enseignant */
		
//		Tester ajouter un enseignant ***Works!!***
		
//	    metier.ajouter_enseignant(new Enseignant("Gendouzi","wassila","email@exemple.com","adresseexemple","MAA","08764444"));
//      	metier.ajouter_enseignant(new Enseignant("Gasma","I dont know","email@exemple.com","adresseexemple","MAA","08764444"));

		
//		Tester la méthode get_Enseignant(Long id_enseignant) ***Works!***
//		Enseignant ens=metier.get_enseignant(2L);
//      System.out.println("nom \t"+ens.getNom()+"\t prenom \t"+ens.getPrenom()+"\t email \t"+ens.getEmail()+"\t Adresse \t"+ens.getAdresse()+"\t Grade \t"+ens.getGrade()+"\t niveau \t"+ens.getTel());

		
////		Tester la méthode afficher la liste des enseignants ***Works fine***
//		
//       List<Enseignant>enseignants=metier.liste_des_enseignants();	
//		for(Enseignant ens:enseignants) {
//			System.out.println("****************************");
//			System.out.println(ens.getNom());
//			System.out.println(ens.getPrenom());
//			System.out.println(ens.getEmail());
//            System.out.println(ens.getAdresse());
//            System.out.println(ens.getGrade());
//            System.out.println(ens.getTel());
//		}		
		
			
////      Tester la méthode pour Récupérer le cours d'un enseignant  ***Work!***
//		
//       Enseignant ens=metier.get_enseignant_cours(6L); //Récupérer l'enseignant du cours cryptographie 
//       System.out.println("nom \t"+ens.getNom()+"\t prenom \t"+ens.getPrenom()+"\t email \t"+ens.getEmail()+"\t Adresse \t"+ens.getAdresse()+"\t Grade \t"+ens.getGrade()+"\t niveau \t"+ens.getTel());
//       
//       Enseignant ens_2=metier.get_enseignant_cours(3L); //Récupérer l'enseignant du cours architecture logiciel
//       System.out.println("nom \t"+ens_2.getNom()+"\t prenom \t"+ens_2.getPrenom()+"\t email \t"+ens_2.getEmail()+"\t Adresse \t"+ens_2.getAdresse()+"\t Grade \t"+ens_2.getGrade()+"\t niveau \t"+ens_2.getTel());
//       
//       Enseignant ens_3=metier.get_enseignant_cours(4L); //Récupérer l'enseignant du cours J2EE
//       System.out.println("nom \t"+ens_3.getNom()+"\t prenom \t"+ens_3.getPrenom()+"\t email \t"+ens_3.getEmail()+"\t Adresse \t"+ens_3.getAdresse()+"\t Grade \t"+ens_3.getGrade()+"\t niveau \t"+ens_3.getTel());
//       
//       Enseignant ens_4=metier.get_enseignant_cours(5L); //Récupérer l'enseignant du cours qualité logiciel
//       System.out.println("nom \t"+ens_4.getNom()+"\t prenom \t"+ens_4.getPrenom()+"\t email \t"+ens_4.getEmail()+"\t Adresse \t"+ens_4.getAdresse()+"\t Grade \t"+ens_4.getGrade()+"\t niveau \t"+ens_4.getTel());
		
/****************************************Fini avec le test des methodes pour enseignant************************************************		
		
		
				
		/* Cours */
//		Tester ajouter un cours  ***Works!!***
//		metier.ajouter_cours(new Cours("Architecture logiciel","description exemple"),1L);
//	metier.ajouter_cours(new Cours("J2EE","description exemple"),2L);
//    metier.ajouter_cours(new Cours("Qualité logiciel","description exemple"),2L);


//////	Tester la méthode afficher la liste des cours ***Works fine***
////	
//    List<Cours>cours=metier.liste_des_cours();	
//	for(Cours  c:cours) {
//		System.out.println("****************************");
//		System.out.println(c.getNom());
//		System.out.println(c.getDescription());
//     }		
	

		
////		Tester la méthode get_Cours(Long id_cours) ***Works!***
//		Cours c=metier.get_cours(3L);
//       System.out.println("nom \t"+c.getNom()+"\t description \t"+c.getDescription());

		
		
////	Tester la méthode la liste des cours assuré par un enseignant ***Work!!!***
//List<Cours> cours=metier.listes_des_cours_par_enseignant(3L);
//for(Cours  c:cours) {
//System.out.println("****************************");
//System.out.println(c.getNom());
//}		

//// Tester la méthode la liste des cours suivi par un étudiant donnée ***Works Fine :)***
//List<Cours>cours=metier.listes_des_cours_suivi_par_etudiant(10L);
//for(Cours  c:cours) {
//System.out.println("****************************");
//System.out.println(c.getNom());
//System.out.println(c.getDescription());
//}
	
		
/************************************Fini avec le test des méthodes pour l'entité Cours*******************************/	
		
		/* Documentation */
		
		
////	Tester ajouter un document pour un cours  ***Works!!***
//  Documentation doc=new Documentation("doc_3","contenue_3");
//  metier.ajouter_doc(doc,1L);
	
//// Tester la méthode supprimer documentation   ***Work***
////metier.supp_doc(1L);		
//		
		
//Tester la méthode éditer /Modifier une documentation	
// Vérification de la modification du document d =(id_doc=5L,nom=doc_1,doc_contenue=contenue_1)
//Documentation d=metier.get_doc(1L); // Obtenir l'objet d
//d.setNom("document_1");
//d.setContenue("Contenue_2");
//metier.modifier_doc(d);
//		

// Tester la méthode getDoc ***Work***
//  Documentation doc=metier.get_doc(1L);
//  System.out.println("nom \t"+doc.getNom()+"\t Contenue \t"+doc.getContenue());	
		
// Tester Afficher les documentations d'un cours	
//List<Documentation>docs=metier.lists_doc_cours(1L);
//for(Documentation  d:docs) {
//System.out.println("****************************");
//System.out.println(d.getNom());
//System.out.println(d.getContenue());
//}		
//		


//Long id_user=(Long) metier.GetUserId("Fatma_Boubekeur","123");
//System.out.println(id_user);

//boolean v=metier.Verif_etudiant_cours(10L, 23L);
//System.out.println(v);

//Long id_rep=metier.Trouver_ID_Reponse_QST(4L);	   
//System.out.println(id_rep);
	   
	   
	   List<EtudiantReponse> r=metier.Listes_reponses_etudiant(2L,15L);
for(EtudiantReponse rep:r) {
	
	System.out.println(rep.getReponse().getRep_contenue());
	System.out.println(rep.getReponse().getCorrecte());
	
	
	
	
	
}
}
	}

