<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<!--******************************************************************************************************************************-->
<!DOCTYPE html>
<html class="transition-navbar-scroll top-navbar-xlarge bottom-footer" lang="fr">
  <head>
  <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <title> E-Formation </title>

   <link href="resources/CSS_JS/Template_CSS_JS/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
   <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/bootstrap.min.js"/>"></script>

    <!-- Jquery -->
   <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/jquery-1.12.4.min.js"/>"></script>
   
   
   <!--fontawesome-->
   <link href="resources/CSS_JS/Template_CSS_JS/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
 
   <!--CSS Template-->
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/vendor.min.css" rel="stylesheet">
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/theme-core.min.css" rel="stylesheet">
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-essentials.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-material.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-layout.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-sidebar.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-sidebar-skins.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-navbar.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-messages.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/carousel-slick.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-charts.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-maps.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-colors-alerts.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-colors-background.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-colors-buttons.min.css" rel="stylesheet" />
    <link href="resources/CSS_JS/Template_CSS_JS/css/Template CSS/module-colors-text.min.css" rel="stylesheet" />

   <!--jquery datatable-->
   <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/jquery.dataTables.min.js"/>"></script> 
   <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/dataTables.bootstrap.min.js"/>"></script> 
   <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/text/javascript"/>"></script>
   <link href="resources/CSS_JS/Template_CSS_JS/css/dataTables.bootstrap.min.css" />
 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/01/css.css" rel="stylesheet"> 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/02/css.css" rel="stylesheet"> 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/03/css.css" rel="stylesheet"> 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/07/css.css" rel="stylesheet"> 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/08/css.css" rel="stylesheet"> 
<!--*****************************************************************************************************************************-->


<style type="text/css">
    
     #body{
        background-color: #fff;
    }

    th{
        background-color:#1E90FF;
        font-size: 20px;
        font-family: Georgia, serif;
        text-align: center;
    }

    td{
        font-size: 20px;
        font-family: Georgia, serif;
        text-align: left;

    }

#topbar li{
    list-style:none;
    padding:10px;
    display:inline-block; 
}
#topbar li a {
      
}

</style>

<link rel="stylesheet" type="text/css" href="resources/CSS_JS/Template_CSS_JS/css/My css/3d_button.css">

<!--*****************************************************************************************************************************-->

<body style="padding:0px;">

<!-- Fixed navbar -->
    <div class="navbar navbar-default  navbar-size-large navbar-size-xlarge paper-shadow" data-z="0" data-animated role="navigation" style="margin-bottom: 0px;">
        <div class="container" style=" width: auto;" id="id2">
            <div class="navbar-header" id="id3">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-nav">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="navbar-brand navbar-brand-logo" style="font-size: 25px; font-family: 'Playfair Display', serif; " id="id4">
                     <a href="EspaceEnseignant" style="color: black;margin-left: 20px;">
                    Espace Enseignant
                    </a> 
                </div>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="main-nav" id="id5">
                <ul class="nav navbar-nav navbar-nav-margin-left">
                  <li> <a href="EspaceEnseignant"  style="font-size: 18px;font-family:'Playfair Display', serif;">Home</a></li>
                  <li> <a href="Gestion_des_Cours"  style="font-size: 18px;font-family:'Playfair Display', serif; ">Gestion des cours </a></li>
                  <li> <a href="Choisir_Cours_Enseignant"  style="font-size: 18px;font-family:'Playfair Display', serif;background-color:#cce6ff;">Gestion des quiz</a></li>                
                </ul>
          
              

                     <div class="navbar-right" id="id6">
                    <ul class="nav navbar-nav navbar-nav-bordered navbar-nav-margin-right">
                      
                        <li> <a href="#" style="font-size: 18px;font-family:'Playfair Display', serif;">
                        <img src="resources/CSS_JS/Template_CSS_JS/images/Formateur.png" style="width: 60px; height: 60px;">
                        ${login.username}

                            </a>
                      </li>

  

                      <li><a href="/formation/" style="font-size: 18px;font-family:'Playfair Display', serif;"><img src="resources/CSS_JS/Template_CSS_JS/images/logout-256.png" style="width: 35px; height: 35px;"></a></li>
                    </ul>
                   
                </div> 
            </div>
         
        </div>
    </div>
    
    



<!-- Nom du cours  -->
     
    <div style="margin-top: 30px;margin-right: 20px;">
            <ul class="breadcrumb">
              <li class="breadcrumb-item" style="font-size: 35px; font-weight: bold; font-family:'Playfair Display', serif; ">
              Cours :  ${nom_cours}
              </li>

            </ul>
     </div>
     

<!-- Menu -->

<div class="col-md-4" style="margin-top: 60px; margin-left: 40px; ">

       
   <div class="panel panel-default" data-toggle="panel-collapse" data-open="true">
       <div class="panel-heading panel-collapse-trigger">
           <h4 class="panel-title" style="font-family:'Playfair Display', serif;font-size: 37px;">Gestion des quizs </h4>
       </div>
       
       
        <div class="panel-body list-group">
            <ul class="list-group list-group-menu">
                
               <li class="list-group-item"><a class="link-text-color" href="Ajouter_Quiz" style="font-size: 22px;font-family: 'Merriweather Sans', sans-serif; margin-top: 10px; margin-left: 10px; margin-right: 10px; margin-bottom: 10px;">Ajouter un nouveau quiz</a></li>
               
               <li class="list-group-item"><a class="link-text-color" href="Listes_Quiz" style="font-size: 22px;font-family: 'Merriweather Sans', sans-serif; margin-top: 10px; margin-left: 10px; margin-right: 10px; margin-bottom: 10px;">Afficher la liste des quizs</a></li>
            </ul>
        </div>
   </div>
               
</div>                        

<h1 align="center" style="font-family: 'Playfair Display', serif; font-size: 28px;">Liste des réponses de la question
<br>
*** { ${contenue_qst} }***
</h1>  
                <br />  

            
                <div class="table-responsive" style="height:1000px;">  
              
                     <table id="table_question" class="table table-striped table-bordered mytable">  
                          <thead >  
                               <tr>  
                                    <th style="color: white; width: auto;">Réponse</th> 
                                    <th style="color: white; width: auto;">Correcte ?   </th> 
                                    <th style="color: white; width: auto;">Actions</th>
                                    
                                                      
                               </tr>  
                          </thead>  
                      <tbody>
                        <c:forEach var="rep" items="${list_reponse}">
                        <tr> 
                                      
                        <td style="text-align: center;"> 
                           ${rep.rep_contenue}
                        </td> 
                        
                        <td style="text-align: center"> 
                           <c:if test="${rep.correcte == '1'}">
                           Oui
                           </c:if>
                           
                          <c:if test="${rep.correcte == '0'}">
                           Non
                          </c:if>
                           
                        </td> 
    
                        
                        <td style="text-align: center;">
               
                         
                        <!-- Modifier Reponse -->
                        <a href="Modifier_Reponse/${rep.id_reponse}" > 
                        <img src="resources/CSS_JS/Template_CSS_JS/images/education-fill-04-512.png" border="0" title="Modifier la réponse" style="width: 48px; height: 48px;"/>
                        </a>
                         
                         
                        <!-- Supprimer Reponse-->
		                <a href="Supprimer_Reponse/${rep.id_reponse}"
						onclick="return confirm('Etes-vous sûr de vouloir supprimer cette réponse ?')"><img 
						src="resources/CSS_JS/Template_CSS_JS/images/delete-48.ico" border="0" title="Supprimer la réponse"/></a> 
		                        
                         
                         </td> 
                                    
                        </tr>
                        </c:forEach>
              
                      </tbody>
                     </table>  
                </div>  
           












    


<script>
$(document).ready(function() {
    $('#table_question').DataTable( {
        "language": {
           
    "sProcessing":     "Traitement en cours...",
    "sSearch":         "Rechercher&nbsp;:",
    "sLengthMenu":     "Afficher _MENU_ &eacute;l&eacute;ments",
    "sInfo":           "Affichage de l'&eacute;lement _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
    "sInfoEmpty":      "Affichage de l'&eacute;lement 0 &agrave; 0 sur 0 &eacute;l&eacute;ments",
    "sInfoFiltered":   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
    "sInfoPostFix":    "",
    "sLoadingRecords": "Chargement en cours...",
    "sZeroRecords":    "Aucun &eacute;l&eacute;ment &agrave; afficher",
    "sEmptyTable":     "Aucune donn&eacute;e disponible dans le tableau",
    "oPaginate": {
        "sFirst":      "Premier",
        "sPrevious":   "Pr&eacute;c&eacute;dent",
        "sNext":       "Suivant",
        "sLast":       "Dernier"
    },
    "oAria": {
        "sSortAscending":  ": activer pour trier la colonne par ordre croissant",
        "sSortDescending": ": activer pour trier la colonne par ordre d&eacute;croissant"
    }
        }
    } );
} );

 </script>  






















<!-- Footer -->
   
    <footer class="footer">
        <strong>E-Formation </strong> &copy; Copyright 2019
    </footer>
   






   <script>
    var colors = {
        "danger-color": "#e74c3c",
        "success-color": "#81b53e",
        "warning-color": "#f0ad4e",
        "inverse-color": "#2c3e50",
        "info-color": "#2d7cb5",
        "default-color": "#6e7882",
        "default-light-color": "#cfd9db",
        "purple-color": "#9D8AC7",
        "mustard-color": "#d4d171",
        "lightred-color": "#e15258",
        "body-bg": "#f6f6f6"
    };
    var config = {
        theme: "html",
        skins: {
            "default": {
                "primary-color": "#42a5f5"
            }
        }
    };
    </script>
    
    <script src="js/Template JS/vendor-core.min.js"></script>
    <script src="js/Template JS/countdown.min.js"></script>
    <script src="js/Template JS/vendor-tables.min.js"></script>
    <script src="js/Template JS/vendor-forms.min.js"></script>
    <script src="js/Template JS/vendor-carousel-slick.min.js"></script>
    <script src="js/Template JS/vendor-player.min.js"></script>
    <script src="js/Template JS/vendor-charts-flot.min.js"></script>
    <script src="js/Template JS/vendor-nestable.min.js"></script>
    <script src="js/Template JS/module-essentials.min.js"></script>
    <script src="js/Template JS/module-material.min.js"></script>
    <script src="js/Template JS/module-layout.min.js"></script>
    <script src="js/Template JS/module-sidebar.min.js"></script>
    <script src="js/Template JS/module-carousel-slick.min.js"></script>
    <script src="js/Template JS/module-player.min.js"></script>
    <script src="js/Template JS/module-messages.min.js"></script>
    <script src="js/Template JS/module-maps-google.min.js"></script>
    <script src="js/Template JS/module-charts-flot.min.js"></script>
    <script src="js/Template JS/theme-core.min.js"></script>


</body>
</html>


<!--****************************************************************************************************************************-->















