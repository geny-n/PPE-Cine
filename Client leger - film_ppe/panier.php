<?php
        $panier = $unControleur -> selectWhereAll($_SESSION['email']);
        if(isset($panier)) {
			require_once ("vue/vue_panier.php");
		}	
        //$_POST -> c'est le tableau des données du formulaire
    
?>




