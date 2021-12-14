<?php
    require_once ("vue/vue_insert_contact.php");
    if (isset($_POST["email"])){
        if ($_POST['description']==""){
            echo "<b><font color = 'red'>Veuillez remplir tous les champs obligatoires</font></b>";
        }else{
            $unControleur -> insertContact($_POST);
        }
        //$_POST -> c'est le tableau des données du formulaire
    }
?>

