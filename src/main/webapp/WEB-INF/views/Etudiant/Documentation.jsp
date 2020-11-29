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
    
    
    <link rel="stylesheet" type="text/css" href="resources/CSS_JS/Template_CSS_JS/css/consulter_cours_css/CSS_1/css.css">
    
<!--*****************************************************************************************************************************-->

<style type="text/css">
html,
body {
  -moz-box-sizing: border-box;
       box-sizing: border-box;
  height: 100%;
  width: 100%; 
  
  font-family: 'Roboto', sans-serif;
  font-weight: 400;
}
 
.wrapper {
  display: table;
  height: 100%;
  width: 100%;
}

.container-fostrap {
  display: table-cell;
  padding: 1em;
  text-align: center;
  vertical-align: middle;
}
.fostrap-logo {
  width: 100px;
  margin-bottom:15px
}
h1.heading {
  color: #fff;
  font-size: 1.15em;
  font-weight: 900;
  margin: 0 0 0.5em;
  color: #505050;
}
@media (min-width: 450px) {
  h1.heading {
    font-size: 3.55em;
  }
}
@media (min-width: 760px) {
  h1.heading {
    font-size: 3.05em;
  }
}
@media (min-width: 900px) {
  h1.heading {
    font-size: 3.25em;
    margin: 0 0 0.3em;
  }
} 
.card {
  display: block; 
    margin-bottom: 20px;
    line-height: 1.42857143;
    background-color: #fff;
    border-radius: 2px;
    box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),0 2px 10px 0 rgba(0,0,0,0.12); 
    transition: box-shadow .25s; 
}
.card:hover {
  box-shadow: 0 8px 17px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
}
.img-card {
  width: 100%;
  height:200px;
  border-top-left-radius:2px;
  border-top-right-radius:2px;
  display:block;
    overflow: hidden;
}
.img-card img{
  width: 100%;
  height: 200px;
  object-fit:cover; 
  transition: all .25s ease;
} 
.card-content {
  padding:15px;
  text-align:left;
}
.card-title {
  margin-top:0px;
  font-weight: 700;
  font-size: 1.65em;
}
.card-title a {
  color: #000;
  text-decoration: none !important;
}
.card-read-more {
  border-top: 1px solid #D4D4D4;
}
.card-read-more a {
  text-decoration: none !important;
  padding:10px;
  font-weight:600;
  text-transform: uppercase
}
</style>


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
                     <a href="EspaceEtudiant" style="color: black;margin-left: 20px;">
                    Espace Etudiant
                    </a> 
                </div>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="main-nav" id="id5">
                <ul class="nav navbar-nav navbar-nav-margin-left">
                  <li> <a href="EspaceEtudiant"  style="font-size: 18px;font-family:'Playfair Display', serif;">Home</a></li>
                  <li> <a href="CoursDisponibles"  style="font-size: 18px;font-family:'Playfair Display', serif; ">Cours disponibles </a></li>
                  <li> <a href="Mes_Cours"  style="font-size: 18px;font-family:'Playfair Display', serif;background-color:#cce6ff; ">Mes cours </a></li>
                  <li> <a href="Choisir_Cours"  style="font-size: 18px;font-family:'Playfair Display', serif; ">Passer quiz</a></li>
                </ul>
          
              

                     <div class="navbar-right" id="id6">
                    <ul class="nav navbar-nav navbar-nav-bordered navbar-nav-margin-right">
                      
                        <li> <a href="#" style="font-size: 18px;font-family:'Playfair Display', serif;">
                       <img src="resources/CSS_JS/Template_CSS_JS/images/apprenant.PNG" style="width: 60px; height: 60px;"> 
                          ${login.username} 
                            </a>
                      </li>

  

                      <li><a href="/formation/" style="font-size: 16px;font-family:'Playfair Display', serif;"><img src="resources/CSS_JS/Template_CSS_JS/images/logout-256.png" style="width: 35px; height: 35px;"></a></li>
                    </ul>
                   
                </div> 
            </div>
         
        </div>
    </div>
    



<section class="wrapper" style="height:40px;margin-top:50px;">
    <div class="container-fostrap" style="height: 40px;" >
    
    <c:forEach var="doc" items="${all_docs}">
    
            <div class="col-xs-12 col-sm-4" style="margin-top:0px;margin-bottom: 50px;">
                <div class="card">
                          <a class="img-card" href="">
                            <img src="resources/CSS_JS/Template_CSS_JS/images/Citation_Icon.png" />
                          </a>
                            <div class="card-content">
                                <h4 class="card-title">
                                    <a href="#" style="font-size: 22px; margin-top:20px;">${doc.nom_doc} </a>
                                </h4>
                              <p style="font-size: 16px;"><b>Ajouté le ${doc.date_creation}</b></p> 
                            </div>
                            <div class="card-read-more" style="padding-top: 20px;padding-bottom:20px;">
                                <a href="Save_Display/${doc.id_doc}" style="font-size: 18px;">
                                Cliquer ici pour consulter le document  
                                </a>
                            </div>
                </div>         
            </div> 
            
   </c:forEach>
            



    </div>
 </section> 





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



















