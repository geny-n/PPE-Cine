<?php

    require_once ("vue/vue_insert_adhesion.php");
    if (isset($_POST["email"])){
        if ($_POST['mdp']==""){
            echo "<b><font color = 'red'>Veuillez remplir tous les champs obligatoires</font></b>";
        }else{
			$value = $unControleur -> insertAdhesion($_POST);
        	if ($value == 0){
          		echo '<script language="Javascript">
           		<!--
           		document.location.replace("index.php?page=0");
            	-->
           		</script>';

        } 
           
       }
        //$_POST -> c'est le tableau des données du formulaire
    }
?>