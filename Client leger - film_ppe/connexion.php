<?php
    require_once ("vue/vue_connexion.php");
     if (isset($_POST["email"])){
        if ($_POST['mdp']==""){
        	echo "<b><font color = 'red'>Veuillez remplir tous les champs obligatoires</font></b>";
    	}else{
	    	//if (isset($_POST["seConnecter"])){
					$unUser = $unControleur -> verifConnexion($_POST);
					if (isset($unUser['idutilisateur'])){
						//création d'une session
						$_SESSION ['email'] = $unUser ['email'];
						$_SESSION ['mdp'] = $unUser ['mdp'];
						header("Location: index.php");
						//header("Location: vue/vue_information.php");
					}else{
						echo "<b><font color = 'red'>ERROR attention aux identifiants</font></b>";
					}
			//}

		}
	}
?>
