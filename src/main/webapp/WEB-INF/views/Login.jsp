<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>E-Formation</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Child Learn Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<link href="resources/CSS_JS/Login_Page_CSS_JS/css/css.css" rel="stylesheet">

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
	
	<!-- css files -->
    <link href="resources/CSS_JS/Login_Page_CSS_JS/css/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
    <link href="resources/CSS_JS/Login_Page_CSS_JS/css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
	<link href="resources/CSS_JS/Login_Page_CSS_JS/css/css_slider.css" type="text/css" rel="stylesheet" media="all">
    <link href="resources/CSS_JS/Login_Page_CSS_JS/css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
	<!-- //css files -->

</head>
<body>


<!-- banner -->
<div class="banner" id="home">
	<div class="layer">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 banner-text-w3pvt">
					<!-- banner slider-->
					<div class="csslider infinity" id="slider1">
						<ul class="banner_slide_bg">
							<li>
								<div class="container-fluid">
									<div class="w3ls_banner_txt">
										<h3 class="b-w3ltxt text-capitalize mt-md-4">E-Formation</h3>
										<h4 class="b-w3ltxt text-capitalize mt-md-2" style="font-size: 24px;font-family: 'B612 Mono', monospace;"><b>VOUS N'ÊTES PAS ENCORE INSCRIT ?</b></h4>
										<p class="w3ls_pvt-title my-3" style="font-size: 19px;font-family: 'B612 Mono', monospace;">Veuillez créer un compte étudiant  <a href="EtudiantRegister" class="btn btn-banner my-3" style="font-size: 14px;font-family: 'B612 Mono', monospace;">Cliquer ici</a> </p>
										
									</div>
								</div>
							</li>
						</ul>
	
					</div>
					<!-- //banner slider-->
				</div>
				<div class="col-lg-5 col-md-8 px-lg-3 px-0">
					<div class="banner-form-w3 ml-lg-5">
						<div class="padding">
							<!-- banner form -->
							<form:form modelAttribute="login" action="ActionLogin" method="post">
								<h5 class="mb-3" style="text-align: center;font-size: 14px;font-family: 'B612 Mono', monospace;"><b>S'identifier</b></h5>
								<div class="form-style-w3ls">
									<form:input path="username"  placeholder="Nom d'utlisateur" name="name" type="text"  style="text-align: center;font-size: 14px;font-family: 'B612 Mono', monospace;"/>
									<div class="help-block with-errors"><form:errors path="username"/></div>
									
									<form:input path="password" placeholder="Mot de passe " name="number" type="password" style="text-align: center;font-size: 14px;font-family: 'B612 Mono', monospace;"/>
				                    <div class="help-block with-errors"><form:errors path="password"/></div>
				                    
									<!--<input placeholder="Password" name="password" type="password" required=""> -->
									<form:button Class="btn" style="text-align: center;font-size: 14px;font-family: 'B612 Mono', monospace;">Login </form:button>
								</div>
							 </form:form>
							<!-- //banner form -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- //banner -->

${js}

</body>
</html>