<?php

    require_once ("vue/vue_insert_inscription.php");
    if ((isset($_POST["nom"]) and $_POST["nom"]=="") or
        (isset($_POST["email"]) and $_POST["email"]=="") or
        (isset($_POST["tel"]) and $_POST["tel"]=="") or
        (isset($_POST["adresse"]) and $_POST["adresse"]=="") ){

       		echo "<b><font color = 'red'>Veuillez remplir tous les champs obligatoires</font></b>";
    }else{
    	if (isset($_POST["nom"])){
        	$unControleur -> insertInscription($_POST);
            echo '<script language="Javascript">
                    <!--
                    document.location.replace("index.php?page=13");
                    -->
                    </script>';
    	}
        //$_POST -> c'est le tableau des données du formulaire
    }
?>
