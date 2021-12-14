<center><h3>Paiement</h3></center>
<hr><br>

<form method = "post" action="" id="paiement_form">
	<table border = "0">
	<tr>
		<table border = "0">
		<tr>
			<td>Type de carte : </td>
			<td><SELECT name="type" size="1">
					<OPTION>Visa
	                <OPTION>MasterCard
	                <OPTION>VisaElectron
            	</SELECT>
			</td>     
		</tr>

		<tr>
			<td width="180">Nom du titulaire : </td>
			<td><input type="text"  name="nom" value ="<?php ?>"></td>
		</tr>
		
		<tr>
			<td>Email : </td>
			<td><input type="text"  name="email" value ="<?php ?>"></td>
		</tr>

		<tr>
			<td>N° carte : *</td>
			<td><input type="number"  name="carte" value ="<?php ?>"></td>
		</tr>

		<tr>
			<td>Date d'expiration :</td>
				<td><input type="month" id="date_carte" name="date_carte" value="<?php echo date("Y-m"); ?>"></td>
			</td>
		</tr>
		 <tr>
			<td>Code securite : *</td>
			<td><input type="number"  name="code" value =""></td>
		</tr>
		</table>
	</tr>
	<tr>
		<br>
		<p>
		<INPUT type="checkbox" name="conditions" id="conditions" value="1" unchecked >&nbsp;&nbsp;Accepter les conditions générales
		</p>

		<div class="wrapper">

		    <a href="index.php?page=10" class="link2" >
		        <span><span>Retour</span></span>
		    </a>
		   
		    <a href="#" class="link2" onclick="document.getElementById('paiement_form').submit();">
		        <span><span>Valider</span></span>
		    </a>
		</div>

		</table>
	</tr>
	<tr>
		<p> * Champs Obligatoires </p>
	</tr>
	</table>
</form>

