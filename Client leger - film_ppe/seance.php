<body style="background-color: powderblue; font-family: monospace; margin: 0; padding: 0;">
		
		
			<?php
				
				if(isset($_GET['idfilm'])){
					$idfilm = $_GET['idfilm'];
					$unFilm = $unControleur -> selectWhereFilm($idfilm);
					echo '<div>
					<h3 align="middle"><span>'.$unFilm['TITRE'].'</span></h3>
				</div>

				';
				
					require_once ("vue/vue_insert_seance.php");
				}
			?>
				
</body>

