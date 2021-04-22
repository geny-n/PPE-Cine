<html>
		<style>
		table,th,td
		{
			border: 2px solid black;
			font-family: monospace;
			font-size: 120%;
			padding: 0.25cm;

		}
		/*
		body{
				background-image: url("images/show.jpg");
				-moz-background-size: cover;
				-webkit-background-size: cover;
				 background-size:100% 110vh;
				background-position: top center !important;
				background-repeat: no-repeat !important;
				background-attachment: fixed;
			
			}
		button 
		{
			display: block;
			margin: 0 auto;
			width: 20%;
			height: 40px;
			border: none;
			background-color: #222;
			font-family: arial;
			font-size: 16px;
		    color: #fff;
 			cursor: pointer;
		}	*/
	</style>

	<body style="background-color: powderblue; font-family: monospace; margin: 0; padding: 0;">
		
		<?php
			$i = 0;
			$j = 0;
			   
			/*recuperer les seances pour le film selectionne*/
			
			echo '<br><br><table style="margin-left: 28%; margin-right: 10%; background-color:#808080; color:white;">
					<tr>
						<td align="middle"><u><b>Numéro de séance</b></u></td>
				  		<td align="middle"><u><b>Jour</b></u></td>
						<td align="middle"><u><b>Heure</b></u></td>
					</tr>';
			//remplissage du tableau
			$resultats = $unControleur -> selectSeance ($idfilm);
			foreach ($resultats as $row)
			{
				/*recupere les id_seance et les affiche en incrementant i*/
				$idseance[$i] = $row['id_seance'];
				$i = $i +1;				
				echo  '<tr>
							<td align="middle">'.$i.'</td> 
							<td >'.$row['date_jour'].'</td>
							<td >'.$row['date_heure'].'</td>
					  </tr>';
			}

			echo '</table><br><br><br>';
		?>
	
	<form action="index.php?page=10&idfilm=<?php echo $unFilm['idfilm']?>" method="post">
              <div align="middle" style="background-color:#808080; color:white;font-size: 170%;">
                <label>Choisissez votre numéro de séance :</label>
				<?php
				while( $j < $i ){ //tant qu'il y a des séances ajout du numero correspodant avec un bouton
				echo $j+1;
				?>
				<input type="radio" name="choix" value="<?php echo $idseance[$j] ?>">
				<?php
				$j = $j + 1;
				}
				?>  
			  </div><br><br>
              <input style="margin-left: 48%;align="middle"; type="submit" value="Envoyer" ><br><br>
    </form>

	</body>
</html>


