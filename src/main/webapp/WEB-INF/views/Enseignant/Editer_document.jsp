<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
   <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/text/javascript"/>"></script>
   <link href="resources/CSS_JS/Template_CSS_JS/css/dataTables.bootstrap.min.css" />
 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/01/css.css" rel="stylesheet"> 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/02/css.css" rel="stylesheet"> 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/03/css.css" rel="stylesheet"> 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/07/css.css" rel="stylesheet"> 
    <link href="resources/CSS_JS/Template_CSS_JS/css/Google Font/08/css.css" rel="stylesheet"> 
    
    <link rel="stylesheet" type="text/css" href="resources/CSS_JS/Template_CSS_JS/css/My css/3d_button.css">
    
<!--*****************************************************************************************************************************-->


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
                  <li> <a href="EspaceEnseignant"  style="font-size: 18px;font-family:'Playfair Display', serif; ">Home</a></li>
                  <li> <a href="Gestion_des_Cours"  style="font-size: 18px;font-family:'Playfair Display', serif;background-color:#cce6ff; ">Gestion des cours </a></li>
                  <li> <a href="Choisir_Cours_Enseignant"  style="font-size: 18px;font-family:'Playfair Display', serif; ">Gestion des quiz</a></li>                
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
    
    

<div class="col-md-4" style="margin-top: 100px;">
                    <div class="panel panel-default" data-toggle="panel-collapse" data-open="true">
                        <div class="panel-heading panel-collapse-trigger">
                            <h4 class="panel-title" style="font-family:'Playfair Display', serif;font-size: 37px;">Gestion des cours</h4>
                        </div>
                        <div class="panel-body list-group">
                            <ul class="list-group list-group-menu">
                                <li class="list-group-item active"><a class="link-text-color" href="AjouterDocumentation" style="font-size: 22px;font-family: 'Merriweather Sans', sans-serif; margin-top: 10px; margin-left: 10px; margin-right: 10px; margin-bottom: 10px;">Ajouter une documentation</a></li>
                               <li class="list-group-item"><a class="link-text-color" href="Lists_Cours_Enseignants" style="font-size: 22px;font-family: 'Merriweather Sans', sans-serif; margin-top: 10px; margin-left: 10px; margin-right: 10px; margin-bottom: 10px;">Afficher la liste des cours</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                        
    
                <div class="col-md-8 col-lg-8 " style="background-color: ;">            
                    <h1 class="page-section-heading" style="font-family:'Playfair Display', serif; text-align: center; font-size: 37px; margin-left: 40px;">�diter le document</h1>
                    <div class="panel panel-default">
                    <div class="panel-body">
                    
      <!--  Form begin     -->               
      <form:form action="Action_Modifier_Document/${Doc.id_doc}"   modelAttribute="Doc"  class="form-horizontal" role="form" method="post" enctype="multipart/form-data">


       <!-- Nom documentation -->
        <div class="form-group">
                             <label for="inputEmail3" class="col-sm-3 control-label" style="font-size: 24px;font-family:'Playfair Display', serif;text-align: left; ">Nom  </label>
                             <div class="col-sm-9">
                                 <div class="form-control-material">
                                     <form:input path="nom_doc" type="text" class="form-control" placeholder="Nom de la documentation" style="font-size: 22px;" /> 
                                     <span></span>
                                 </div>
                             </div>
         </div>



      <!-- Contenue de la documentation -->                
         <div class="form-group">
                             <label for="inputEmail3" class="col-sm-3 control-label" style="font-size: 24px;font-family:'Playfair Display', serif;text-align: left; ">Contenue </label>
                             <div class="col-sm-9">
                                 <div class="form-control-material">
                                 <input type='file'  name="file" class="form-control" id="file" style="color:transparent;" onchange="this.style.color = 'black';"/>
                                 <span id="nom_contenue">
                                 ${Doc.nom_contenue}  
                                 </span>
                                 </div>
                             </div>
                             
                             
                             
                             <script type="text/javascript">
                             $('#file').change(function(){
                            	 $('#nom_contenue').hide(); 
                             });
                             </script>
         </div>


             
          <!-- Submit   -->                    
          <div class="form-group margin" style="margin-top: 40px; margin-bottom: 20px;">
              <div class="col-sm-offset-3 col-sm-9">
              <button type="submit" name="btn_ajouter" id="btn_ajouter" 
              class="btn btn-primary btn-lg btn3d"  style=" font-size: 20px ; background-color: DodgerBlue;border-color: DodgerBlue;font-family: goargia;" >Valider</button>
           
           <!--  Annuler  -->        
              <input type="reset" name="reset" id="reset" 
               class="btn btn-primary btn-lg btn3d"  value="Annuler"
                style=" font-size: 20px ; background-color: DodgerBlue;border-color: DodgerBlue;font-family: goargia;">

              </div>
           </div>
  
      
      </form:form><%--End form --%>
                    
                   
   </div>
</div>
</div>

            
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
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/vendor-core.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/countdown.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template JS/vendor-tables.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/vendor-forms.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/vendor-carousel-slick.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/vendor-player.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/vendor-charts-flot.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/vendor-nestable.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-essentials.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-material.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-layout.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-sidebar.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-carousel-slick.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-player.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-messages.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-maps-google.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/module-charts-flot.min.js"/>"></script>
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/Template JS/theme-core.min.js"/>"></script>


</body>
</html>


<!--****************************************************************************************************************************-->



















