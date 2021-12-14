 <script type="text/javascript">
    function refresh_libelle(selectObject){  
        var libelle=document.getElementById('nom_ins'); 
        var selected=document.getElementById('structure'); 
        libelle.innerHTML= selectObject + ' : *';

        if (selectObject != ''){
        	document.getElementById('prenom').style.display='none';
        }else {
        	document.getElementById('prenom').style.display='table-row';
        }   
    }    
</script> 
<center><h3>Autres réservations</h3></center><hr><br>
<form method = "post" action="" id="inscription_form">
	<table border = "0" >
	<tr>
		<table border = "0">
		<tr>
			<td width="180">Nom <span id="nom_ins"> : * </span> </td>
			<td><input type="text"  name="nom"
				id="ecole_nom_ins" 
				value="<?php if(isset($_POST['nom'])){echo $_POST['nom'];}?>"/>
				<span class="nom-color" id="nom_ins"> </span></td>
		</tr>

		<tr id="prenom">
			<td width="180">Prénom : </td>
			<td><input type="text"  name="prenom" value="<?php if(isset($_POST['prenom'])){echo $_POST['prenom'];}?>"></td>
		</tr>

		<tr>
			<td width="180">Email : * </td>
			<td><input type="text"  name="email" value="<?php if(isset($_POST['email'])){echo $_POST['email'];}?>"></td>
		</tr>

		<tr>
			<td width="180">Téléphone : * </td>
			<td><input type="text"  name="tel" value="<?php if(isset($_POST['tel'])){echo $_POST['tel'];}?>"></td>
		</tr>

		<tr>
			<td>Adresse : * </td>
			<td><input type="text"  name="adresse" value="<?php if(isset($_POST['adresse'])){echo $_POST['adresse'];}?>"></td>
		</tr>

		<tr>
			<td width="180">Animations :</td>
				<td><SELECT name="animation" size="1">
				    <OPTION>Nous les Gosses</OPTION>
                    <OPTION>Bambin(e)s</OPTION>
                    <OPTION>Séniors</OPTION>
                    <OPTION>Visite Cinéma</OPTION>
				</select></td>
		</tr>

		<tr>
			<td width="180">Structure :</td>
				<td><SELECT name="structure" size="1" onchange="refresh_libelle(this.value);">
				    <OPTION value="" selected>Particuliers</OPTION>
                    <OPTION value="de l'Ecole">Scolaires</OPTION>
                    <OPTION value="du Centre">Centre de loisirs</OPTION>
                    <OPTION value="de l'Association">Association</OPTION>
				</select></td>
		</tr>

		</table>

	</tr>
	<tr>
		<br>
		<div class="wrapper">
			<!--<input class="bouton" type = "submit" name="Valider" value="Valider">-->
                
                <a href="#" class="link2" onclick="document.getElementById('inscription_form').submit();">
                    <span><span>Valider</span></span>
                </a>
        </div>
        <br>
        <tr>
        <p> * Champs Obligatoires </p>
    </tr>
        <br>
        <hr width="100%" color="black">
            <p> Le 25 mai 2018 entre en vigueur la nouvelle loi européenne : le
                    Règlement Général sur la Protection des Données personnelles (RGPD) :<br>
                    En soumettant ce formulaire, j'accepte que mes informations soient utilisées exclusivement dans le cadre de ma demande et de la relation commerciale &eacutethique et personnalisée qui pourrait en découler si je le souhaite.
            </p>

		</table>
	</tr>
	</table>
</form>
