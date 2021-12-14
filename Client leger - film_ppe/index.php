<?php
if (!isset($_SESSION)) {
    session_start();
}
if (isset($_GET['page'])){
	$page = $_GET['page'];
}else{
	$page = 0;
}
if ($page == 100) {
	session_destroy();
}

require_once ("controleur/controleur.class.php");
	//instanciation du controleur
	$unControleur = new Controleur();
?>

<!DOCTYPE html PUBLIC >
<html>
<head>
<title>Cinéma Jacques Brel</title>
<meta http-equiv=" Content-Type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />

<!-- Mise en page des titres-->
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/cufon-replace.js" type="text/javascript"></script> 
<script src="js/Gill_Sans_400.font.js" type="text/javascript"></script>

<!-- Mise en page tableau panier -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body id="page1">

	<div class="tail-top">
		<div class="tail-bottom">
			<div id="main">
				<div id="header">
					<div class="row-1">
						<div class="fleft"><a href="index.php?page=0">Cinema <span>Jacques Brel</span></a></div>
						<ul>
							<li><a href="index.php?page=0"><img src="images/icon1-act.gif" alt="" /></a></li>
							<li><a href="index.php?page=12"><img src="images/icon2.gif" alt="" /></a></li>
									<?php
										if (isset($_SESSION['email'])){
											echo "<li><a href='index.php?page=15'><img src='images/panier.gif'/></a></li>";
											echo "<li><a href = 'index.php?page=100'>Déconnexion</a></li>";
										}else{
											echo "<li><a href = 'index.php?page=13'>Connexion</a></li>";
										}
									?> 
						</ul>
					</div>
					<div class="row-2">
						<ul>
							<li><a href="index.php?page=0" class="active">Accueil</a></li>
							<li><a href="index.php?page=1">Prochainement</a></li>
							<li><a href="index.php?page=2">Amis du cinéma</a></li>
							<li><a href="index.php?page=3">Tarifs</a></li>
							<!--<li><a href="index.php?page=4">description</a></li>-->
						</ul>
					</div>
				</div><br>
	<?php
		if (isset($_GET['page'])){
			$page = $_GET['page'];
		}else{
			$page = 0;
		}
		switch ($page){
			case 0 : require_once("accueil.php");
					 break;
			case 1 : require_once("prochainement.php");
					 break;
			case 2 : require_once("inscription.php");
					 break;
			case 3 : require_once("tarif.php");
					 break;
			case 4 : require_once("description/desc-SansUnBruit2.php");
					 break;
			case 7 : require_once("description/Desc-ReineDesNeignes2.php");
					 break;
			case 8 :if (isset($_SESSION['email'])){
						require_once("seance.php");
					}else{
						require_once("connexion.php");
					}
					 break;
			case 10 :require_once("reservation.php");
					 break;
			case 11 : require_once("paiement.php");
					 break;
			case 12 : require_once("contact.php");
					 break;
			case 13 : require_once("connexion.php");
					 break;
			case 14 : require_once("adhesion.php");
					 break;
			case 15 : require_once("panier.php");
					 break;
			case 100 : header("Location: index.php");
			         break;
		}
	?>

			</div>
			<div id="footer">
				<div class="left">
					<div class="right">
						<div class="inside">Contact : Cinéma Jacques Brel<br>
							1 place de l'Hôtel de Ville<br>
							95140 - Garges-lès-Gonesse<br>
							Tel : 01 34 53 32 26<br>
							cinemavilledegargesmavilledegarges.com</span><br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		Cufon.now();
	</script>
</body>

</html>