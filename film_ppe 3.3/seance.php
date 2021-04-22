<body style="background-color: powderblue; font-family: monospace; margin: 0; padding: 0;">
		
		
			<?php
				
				if(isset($_GET['idfilm'])){
					$idfilm = $_GET['idfilm'];
					$unFilm = $unControleur -> selectWhereFilm($idfilm);
					echo '<div>
					<h3 align="middle"><span>'.$unFilm['TITRE'].'</span></h3>
				</div>
				<h1 align="middle" style="font-size: 270%; color:white;"><b>Choisissez votre séance</b></h1>
				';
				
					require_once ("vue/vue_insert_seance.php");
				}
			?>
				
</body>

