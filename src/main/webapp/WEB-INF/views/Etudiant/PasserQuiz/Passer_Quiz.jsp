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
    
    
    <link rel="stylesheet" type="text/css" href="resources/CSS_JS/Template_CSS_JS/css/style.css">
    <link rel="stylesheet" href="resources/CSS_JS/Template_CSS_JS/css/anythingslider.css">
    <script src="<c:url value="resources/CSS_JS/Template_CSS_JS/js/jquery.anythingslider.js"/>"></script>

    <link rel="stylesheet" type="text/css" href="resources/CSS_JS/Template_CSS_JS/css/My css/3d_button.css">
   


    <style type="text/css">
    	
	#QCM {
		list-style: none;
		
	}


    </style>
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
                  <li> <a href="Mes_Cours"  style="font-size: 18px;font-family:'Playfair Display', serif; ">Mes cours </a></li>
                  <li> <a href="Choisir_Cours"  style="font-size: 18px;font-family:'Playfair Display', serif; background-color:#cce6ff;">Passer quiz</a></li>
                
                </ul>
          
              

                     <div class="navbar-right" id="id6">
                    <ul class="nav navbar-nav navbar-nav-bordered navbar-nav-margin-right">
                      
                        <li> <a href="#" style="font-size: 18px;font-family:'Playfair Display', serif;">
                       <img src="resources/CSS_JS/Template_CSS_JS/images/apprenant.PNG" style="width: 60px; height: 60px;"> 
                          ${login.username}
                            </a>
                      </li>

  

                      <li><a href="/formation/" style="font-size: 18px;font-family:'Playfair Display', serif;"><img src="resources/CSS_JS/Template_CSS_JS/images/logout-256.png" style="width: 35px; height: 35px;"></a></li>
                    </ul>
                   
                </div> 
            </div>
         
        </div>
    </div>
    
    
    
   <!--  ************************** Passser Quiz *********************  -->
    
    <h1 style="text-align: center; font-family:'Playfair Display', serif; text-align: center; font-size: 37px;padding-bottom: 30px;padding-top:30px;">QCM cours  
 	${nom_cours}
 	</h1>


    <div class="header-content" style="margin-top: 180px; margin-right: 20px;font-size: 20px;color: green;font-family:'Merriweather Sans', sans-serif;">
			Date de création: ${date_creation}<br><br>
			Date limite: ${date_limite}
	</div>
	
	
	
	<form method="post" action="QuestionSubmit" style="margin-top:100px;">
	<ul id="QCM" style="text-align:left;font-size:18px;font-family:'Merriweather Sans', sans-serif;width:auto;height:auto;" >
	
	<% int q=0; %>
	<c:forEach var="qst" items="${list_qst}"> 	
	<% q++; %>
	<li>
	<h2> ${qst.contenue_qst} ?  (<% out.println(q); %> /${nbr_qst})   --  ${qst.note} Point(s)  -- </h2><br>
	<input type="hidden" name="questionId" value="${qst.id_qst}"> 
	   
	    <ol type="a">
		    <c:forEach var="reponse" items="${qst.reponses}">
		    <li style="font-size:18px;font-family:'Merriweather Sans', sans-serif;">
		    <input type="radio" name="question_${qst.id_qst}" value="${reponse.id_reponse}">
		    ${reponse.rep_contenue} 
		    </li><br>
		   
		    </c:forEach>
	    </ol>
	</li>
	</c:forEach>
	
	</ul>
	
	<br>
	
<div style="margin-bottom: 100px;text-align: center;">
	 
   <button type="submit" name="btn_ajouter" id="btn_ajouter" 
   class="btn btn-success btn-lg btn3d"  style=" font-size: 30px ;font-family:'Merriweather Sans', sans-serif;" >Résultat</button>

	
	
</div>
</form>
	


	

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


<script type="text/javascript">

$(document).ready(function(){

	$('#btn_ajouter').click(function(){
	valid=true;
	
	<c:forEach var="qst" items="${list_qst}"> 	
	if (!$("input[name='question_${qst.id_qst}']:checked").val()) {
	valid=false;
	alert("Au moins une réponse doit être sélectionnée !!!!")
	}
	</c:forEach>

	return valid;

	});
	});
</script>


</body>
</html>


<!--****************************************************************************************************************************-->



















