<?php
    require_once ("vue/vue_insert_paiement.php");
    if (isset($_POST["nom"])){
        if ($_POST['carte']=="" || $_POST['code']==""){
            echo "<b><font color = 'red'>Veuillez remplir tous les champs obligatoires</font></b>";
        }else{
            if (isset($_POST["conditions"]) && $_POST["conditions"] == "1"){
               $retour = $unControleur -> insertPaiement($_POST);
                if ($retour != -1) {
                echo '<script language="Javascript">
                    <!--
                    document.location.replace("index.php?page=15");
                    -->
                    </script>';
                }
            }else{
                echo "<b><font color = 'red'>Veuillez accepter les conditions générales</font></b> ";
            }
        }
    }
?>
