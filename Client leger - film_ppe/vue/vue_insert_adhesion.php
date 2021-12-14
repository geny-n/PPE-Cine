<center><h3>Inscription</h3></center><hr><br>
<form method = "post" action="" id="adhesion_form">
	<table border = "0">
        <tr>
            <table border = "0">
                <tr>
                    <td width="110">Nom : </td>
                    <td><input type="text"  name="nom" value =""></td>
                </tr>

                <tr>
                    <td width="110">Prenom : </td>
                    <td><input type="text"  name="prenom" value =""></td>
                </tr>
                
                <tr>
                    <td width="110">Email : * </td>
                    <td><input type="text"  name="email" value =""></td>
                </tr>

                <tr>
                    <td width="110">MDP : * </td>
                    <td><input type="password"  name="mdp" value =""></td>
                </tr>

                <tr>
                    <td width="150">Confirmation : * </td>
                    <td><input type="password"  name="confirmation" value =""></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="hidden"  name="poste" value ="Client"></td>
                </tr>
        
            </table>
        </tr>
        <tr>
            <br>
            <div class="wrapper">
                <!--<input class="bouton" type = "submit" name="Valider" value="Valider">-->
                    
                    <a href="#" class="link2" onclick="document.getElementById('adhesion_form').submit();">
                        <span><span>Valider</span></span>
                    </a>
            </div>
            <br>           
        </tr>
        <p> * Champs Obligatoires </p>
        <br><br><br><br><br>
	</table>
</form>

