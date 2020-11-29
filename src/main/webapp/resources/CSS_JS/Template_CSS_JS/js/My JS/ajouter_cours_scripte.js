$(document).ready(function(){

$('input[class="form-control"]').focus(function(){
   $(this).removeAttr('style');  
});

$('textarea[class="form-control"]').focus(function(){
   $(this).removeAttr('style');  
});


$('#nom_cours').focus(function(){
   $('#message_cours').hide();
});
$('#description').focus(function(){
  $('#message_description').hide();
});

$('#btn_ajouter').click(function(){
valid=true;



if($('#nom_cours').val()==''){
   $('#nom_cours').css("border-color","#DA1900");
   $('#nom_cours').css("background-color","#F2DEDE");
   $('#message_cours').html('<span class="text-danger" style="font-size:16px;">Veuillez remplir ce  champs svp </span><br>');
   $('#message_cours').show();
  valid=false;
}


if($('#description').val()==''){
   $('#description').css("border-color","#DA1900");
   $('#description').css("background-color","#F2DEDE");
   $('#message_description').html('<span class="text-danger" style="font-size:16px;">Veuillez remplir ce  champs svp </span><br>');
   $('#message_description').show();
  valid=false;
}

if($('#ressource').val()==''){
   $('#ressource').css("border-color","#DA1900");
   $('#ressource').css("background-color","#F2DEDE");
   $('#message_ressources').html('<span class="text-danger" style="font-size:16px;">Veuillez choisir une ressource svp </span><br>');
   $('#message_ressources').show();
  valid=false;
}

$('#ressource').change(function(){
	  $('#message_ressources').hide();
      var ressource=$(this).val()
      var pattern = new RegExp(/\.(aif|cda|mid|midi|mp3|mpa|ogg|wav|wma|wpl|7z|arj|deb|pkg|rar|rpm|tar|gz|z|zip|bin|dmg|iso|toast|vcd|csv|dat|db|dbf|log|mdb|sav|sql|tar|xml|apk|bat|bin|cgi|com|exe|gadget|jar|py|wsf|fnt|fon|otf|ttf|ai|bmp|gif|ico|jpeg|jpg|png|ps|psd|svg|tif|tiff|asp|aspx|cer|cfm|cgi|pl|css|htm|html|js|jsp|part|php|py|rss|xhtml|key|odp|pps|ppt|pptx|c|class|cpp|cs|h|java|sh|swift|vb|ods|xlr|xls|xlsx|3g2|3gp|avi|flv|h264|m4v|mkv|mov|mp4|mpg|mpeg|rm|swf|vob|wmv|doc|docx|odt|pdf|rtf|tex|txt|wks|wps|wpd)$/i);
     if(pattern.test(ressource)==false){
     $('#message_ressources').html('<span class="text-danger" style="font-size:16px;"> Format non valide </span><br>');
     $('#message_ressources').show();
      valid=false;
     }
});



return valid && alert(" Cours ajouté avec succès ! ");

















});
});