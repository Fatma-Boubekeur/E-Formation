<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!doctype html>
<html>

<head>
	<title>Inscription Etudiant </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Student Registration Form Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"
	/>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>

	<!-- css -->
	<link href="<c:url value='resources/CSS_JS/Etudiant_Register/css/bootstrap.css'/>" rel="stylesheet" media="all">
	<link href="<c:url value='resources/CSS_JS/Etudiant_Register/css/style.css'/>" rel="stylesheet">
	<!-- /css -->
</head>

<body>

	<div class="content-agileits">
		<h1 class="title">FORMULAIRE D'INSCRIPTION Étudiant</h1>
		<div class="left">
		
<form:form modelAttribute="Etudiant" method="post" action="RegisterAction"  data-toggle="validator" onsubmit="myFunction()">	
               <div class="form-group">
					<form:label path="login" for="login" class="control-label">Nom d'utilisateur:</form:label>
					<form:input path="login" type="text" class="form-control" id="login" placeholder="nom d'utilisateur"  maxlength= "20"/>
					<div class="help-block with-errors"><form:errors path="login"/></div>
				</div>
    
               <div class="form-group">
					<form:label path="password" class="control-label">Mot de passe</form:label>
					<form:input path="password"  type="password" class="form-control" id="password" placeholder="mot de passe" maxlength= "20" />
					<div class="help-block with-errors"><form:errors path="password"/> ${mdp_confirm_error} </div>
				</div>
				
				<div class="form-group">
					<form:label path="confirm_password" class="control-label">Confirmer mot de passe</form:label>
					<form:input path="confirm_password"  type="password" class="form-control" id="confirm_password" placeholder="Confirmer mot de passe" maxlength= "20" />
					<div class="help-block with-errors"><form:errors path="confirm_password"/>${mdp_confirm_error}</div>
				</div>
	
				<div class="form-group">
					<form:label path="Nom" for="Nom" class="control-label">Nom:</form:label>
					<form:input path="Nom" type="text" class="form-control" id="Nom" placeholder="nom"  />
					<div class="help-block with-errors"><form:errors path="Nom"/></div>
				</div>
				
				
				<div class="form-group">
					<form:label path="prenom" for="Prénom" class="control-label">Prénom:</form:label>
					<form:input path="prenom" type="text" class="form-control" id="Prénom" placeholder="prénom" data-error="Veuillez entrer votre prénom" />
					<div class="help-block with-errors"><form:errors path="prenom"/></div>
				</div>
				
				
				<div class="form-group">
					<form:label path="email" for="Émail" class="control-label">Émail:</form:label>
					<form:input path="email"  type="email" class="form-control" id="Émail" placeholder="émail" data-error="Adresse email non valide" />
					<div class="help-block with-errors"><form:errors path="email"/></div>
				</div>
				
				
				<div class="form-group">
					<form:label path="filiere" for="Fillière" class="control-label">Filière:</form:label>
					<form:input path="filiere" type="text" class="form-control" id="Fillière" placeholder="fillière" data-error="Veuillez entrer votre fillière" />
					<div class="help-block with-errors"><form:errors path="filiere"/></div>
				</div>
				
				
				<div class="form-group">
					<form:label path="specialite" for="Spécialité" class="control-label">Spécialité:</form:label>
					<form:input path="specialite" type="text" class="form-control" id="Spécialité" placeholder="spécialité" data-error="Veuillez entrer votre spécialité" />
					<div class="help-block with-errors"><form:errors path="specialite"></form:errors></div>
				</div>
				
				
				<div class="form-group">
					<form:label path="niveau" for="Niveau" class="control-label">Niveau:</form:label>
					<form:input path="niveau"  type="text" class="form-control" id="Niveau" placeholder="niveau" data-error="Veuillez entrer votre Niveau"/>
					<div class="help-block with-errors"><form:errors path="niveau"></form:errors></div>
				</div>
				

				<div class="form-group">
					<form:button type="submit" class="btn btn-lg">Valider</form:button>
				</div>
				
				
 </form:form>

		</div>
		<div class="right"></div>
		<div class="clear"></div>
	</div>
	
	<!-- js -->
	<script src="<c:url value="resources/CSS_JS/Etudiant_Register/js/jquery-2.1.4.min.js"/>"></script>
	<!-- //js -->
	<script src="<c:url value="resources/CSS_JS/Etudiant_Register/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="resources/CSS_JS/Etudiant_Register/js/validator.min.js"/>"></script>
	<!-- /js files -->
	
${js}

</body>

</html>