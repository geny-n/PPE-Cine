<center><h3>Contactez-nous</h3></center><hr><br>
<form method = "post" action="" id="contact_form">
	<table border = "0">
	<tr>
		<table border = "0">
		<tr>
			<td>
			<h4>Email : </h4>
			<input type="text"  name="email" value ="">
		    </td>
		</tr>

		<tr>
			<td><br><h4><span>Type de demande :</h4></span>
				<SELECT name="typedemande" size="1">
				    <OPTION>Bug technique
                    <OPTION>Erreur de séance
                    <OPTION>Suggérer une amélioration
                    <OPTION>Signaler un abus
				</select></td>
		</tr>

		<tr>
			
			<td><br><h4><span>Description : *</h4></span>
			<textarea name="description" rows="10" cols="50"></textarea></td>
			
		</tr>
		</table>
	</tr>
	<tr>
		<br>
		<div class="wrapper">
			<!--<input class="bouton" type = "submit" name="Valider" value="Valider">-->
                
                <a href="#" class="link2" onclick="document.getElementById('contact_form').submit();">
                    <span><span>Valider</span></span>
                </a>
        </div>
        <br>

		</table>
	</tr>
	<tr>
		<p> * Champs Obligatoires </p>
	</tr>
	</table>
</form>

