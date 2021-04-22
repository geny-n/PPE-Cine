<?php
    require_once ("vue/vue_insert_reservation.php");
    if ((isset($_POST["email"]) and $_POST["email"]=="") or
        (isset($_POST["nom"]) and $_POST["nom"]=="") ){
       echo "<b><font color = 'red'>Veuillez remplir tous les champs obligatoires</font></b>";
    }else{
      if (isset($_POST["nom"])){
        $value = $unControleur -> insertReservation($_POST);
         
        if ($value == 0){
          echo '<script language="Javascript">
           <!--
           document.location.replace("index.php?page=11");
            -->
           </script>';

        } 
      }   		
    }
?>

