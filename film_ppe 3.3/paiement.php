<?php
    require_once ("vue/vue_insert_paiement.php");
    if (isset($_POST["nom"])){
        if ($_POST['carte']=="" or $_POST['code']==""){
            echo "<b><font color = 'red'>Veuillez remplir tous les champs obligatoires</font></b>";
        }else{
            if (isset($_POST["conditions"]) && $_POST["conditions"] == "1"){
                $unControleur -> insertPaiement($_POST);
                echo '<script language="Javascript">
                    <!--
                    document.location.replace("index.php?page=15");
                    -->
                    </script>';
            }else{
                echo "<b><font color = 'red'>Veuillez accepter les conditions générales</font></b> ";
            }
        }
    }
?>
