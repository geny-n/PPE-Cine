 <script type="text/javascript">
    function refresh_total(parametre){  
        var tarif=document.getElementById(parametre); 
        var Nb=document.getElementById('nb_' + parametre); 
        var prix=document.getElementById('prix_' + parametre);
        prix.style.color='red';  
        prix.innerHTML=tarif.innerHTML * Nb.value;
    }    

</script> 


<center><h3>Réservation</h3></center><hr><br>

<form method = "post" action="" id="reserv_form">
	<table border = "0">
	<tr>
		<table border = "0">
            <input type="hidden"  name="idfilm" value ="<?php if(isset($_GET['idfilm'])){echo $_GET['idfilm'];}?>">
            <input type="hidden"  name="id_seance" value = "<?php if(isset($_POST['choix'])){echo $_POST['choix'];}?>">
            <tr>
            <td width="100">Nom : * </td>
            <td><input type="text"  name="nom" value="<?php if(isset($_POST['nom'])){echo $_POST['nom'];}?>"></td>
            </tr>
		
			<tr>
			<td>Prenom : </td>
			<td><input type="text"  name="prenom" value="<?php if(isset($_POST['prenom'])){echo $_POST['prenom'];}?>"></td>
			</tr>
		
		
			<tr>
			<td>Email : * </td>
			<td><input type="text" name="email" value="<?php if(isset($_POST['email'])){echo $_POST['email'];}?>"></td>
			</tr>
		

			<tr>
			<td>Confirmer :</td>
			<td><input type="text"  name="confirmation"></td>
			</tr>
		</table>
	</tr>
	<tr>

        <div>
                 <?php 
                $var=0;
                $i=0;$j=0;
                $NbrTotal=0;
                $capacite=0;
                if(isset($_POST['choix'])){$var = $_POST['choix'];}
                else{$var = $_SESSION['var'];};  
                //$_SESSION : rendre la capacité disponible partout dans la session
                $_SESSION['var'] = $var;
                $resultats = $unControleur -> selectPlaceDispo ($var);
                    foreach ($resultats as $row)
                    { 
                        /*recupere la capacité de la salle*/
                        $capacite= $row['capacite'];
                        echo $capacite;
                    }
                
                //recuperer les idreservation pour la séance selectionner
                $resultats = $unControleur -> selectReservation ($var);
                    foreach ($resultats as $row)
                    {   
                        /*recupere les reservations*/
                        $Reservation[$i]= $row['idreservation'];
                        echo $Reservation[$i];
                        $i=$i+1;
                    }

                for ($j=0; $j<$i; $j++){
                $resultats = $unControleur -> selectSiege ($Reservation[$j]);
                foreach ($resultats as $row)
                    {   
                        /*recupere les nbr de sieges*/
                        echo $NbrTotal;
                        // calcule du nbr de tarif = place reservé pour chauque reservation deja faite
                        $NbrTotal= $NbrTotal + $row['tarifPlein']+$row['tarifReduit']+$row['tarifEnfant']+$row['tarifScolaire'];
                        echo $NbrTotal;
                        }    
                    }
                    //capacité restante encore disponible 
                    $capacite = $capacite - $NbrTotal;
                    ?>
         </div>

        <div class="un-tarif">
                <p>TARIF PLEIN : <span class="tarif-color" id="tarif_plein">6.50 </span> &euro;<br>
                    <input name="tarifPlein" 
                    id="nb_tarif_plein" onchange="refresh_total('tarif_plein');" class="place-nb vide" type="number" value="0" min="0"
                    max="30" step="1" />&nbsp;:&nbsp;<span class="tarif-color" id="prix_tarif_plein">0 </span> &euro;
                </p>
        </div>

        <div class="un-tarif">
                <p>TARIF REDUIT* : <span class="tarif-color" id="tarif_reduit">4.50 </span> &euro;<br>
                    <input name="tarifReduit" 
                    id="nb_tarif_reduit" onchange="refresh_total('tarif_reduit');" class="place-nb vide" type="number" value="0" min="0" 
                    max="30" step="1" />&nbsp;:&nbsp;<span class="tarif-color" id="prix_tarif_reduit">0 </span> &euro;
                </p>
        </div>

        <div class="un-tarif">
                <p>TARIF ENFANT* : <span class="tarif-color" id="tarif_enfant">3.50 </span> &euro;<br>
                    <input name="tarifEnfant" 
                    id="nb_tarif_enfant" onchange="refresh_total('tarif_enfant');" class="place-nb vide" type="number" value="0" min="0" 
                    max="30" step="1" /> &nbsp;:&nbsp;<span class="tarif-color" id="prix_tarif_enfant">0 </span> &euro;
                </p>
        </div>

        <div class="un-tarif">
                <p>TARIF SCOLAIRE : <span class="tarif-color" id="tarif_scolaire">3.00 </span>&euro;<br>
                    <input name="tarifScolaire" 
                    id="nb_tarif_scolaire" onchange="refresh_total('tarif_scolaire');total_place('tarif_reduit','tarif_enfant','tarif_scolaire')" class="place-nb vide" type="number" value="0" min="0" 
                    max="30" step="1" /> &nbsp;:&nbsp;<span class="tarif-color" id="prix_tarif_scolaire">0 </span> &euro;
                </p>
        </div>

        <p style="color:darkgrey; font-size:17px;">Nbr places disponibles : <span id="total" style="color:darkgrey;"><?php echo $capacite;?></span>  

       <div class="wrapper">
                <a href="index.php?page=0" class="link2">
                    <span><span>Retour</span></span>
                </a>
                <a href="#" class="link2" onclick="document.getElementById('reserv_form').submit();"> 
                <span><span>Suivant</span></span>
                </a>
        </div>
     </tr>
     
     <tr>
              <p> * Champs Obligatoires </p>
    </tr>
    </table>
    
</form>

<script type="text/javascript">
     
     function alertOnSiege(param){
        if (param < 1){
            alert("VOUS NE POUVEZ PLUS AJOUTER DE SIEGE. IL N'Y EN A PLUS DE DISPONIBLE !!");
        }
     }
     function addition() {
          result = 0;
          for (j=0; j<array.length; j++) {
                    result = parseFloat(result) + parseFloat(array[j].value);
          }
          total.innerHTML = <?php echo $capacite;?> - result;
          alertOnSiege(<?php echo $capacite;?> - result);
          }
          array = document.getElementsByClassName('place-nb vide') ;
     for (j=0; j<array.length; j++) { array[j].addEventListener("click", addition);
          }
</script>

