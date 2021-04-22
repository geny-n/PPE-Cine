<?php
	//connexion avec le sgbd extraction injection exploitation
class Modele {
	private $pdo ;

	public function __construct(){
		$this -> pdo = null;
		try{ //mettre le code qui peut poser un probleme
			$this -> pdo = new PDO("mysql:host=localhost;dbname=ppecinema","root","", array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));

		}

		catch(PDOException $exp){ //le code qui résoud le problème
			echo "Impossible de se connecter au serveur Mysql / ppecinema";
			echo $exp -> getMessage();
		}
	}
	
	public function insertReservation($tab){
		if($this -> pdo != null){
			$requete = "INSERT into reservation VALUES (null, :nom, :prenom, :email, :confirmation, :tarifPlein, :tarifReduit, :tarifEnfant, :tarifScolaire, :idfilm, :id_seance);";
			
			$donnees = array (":nom" => $tab["nom"],
							  ":prenom" => $tab["prenom"],
							  ":email" => $tab["email"],
							  ":confirmation" => $tab["confirmation"],
							  ":tarifPlein" => $tab["tarifPlein"],
							  ":tarifReduit" => $tab["tarifReduit"],
							  ":tarifEnfant" => $tab ["tarifEnfant"],
							  ":tarifScolaire" => $tab ["tarifScolaire"],
							  ":idfilm" => $tab ["idfilm"],
							  ":id_seance" => $tab ["id_seance"]);
			$insert = $this -> pdo -> prepare ($requete);
			$insert -> execute ($donnees);

			//gestion des messages des TRIGGERS
			$errorInfo = $insert -> errorInfo();
			if ($errorInfo[0] != 0){
				echo "<b><font color = 'red'>" . $errorInfo [0] . " # " . $errorInfo [2] . "</font></b>";
				return $errorInfo[0];
			}else{
				return 0;
			}

		}else{
			return null;
		}
	}

	public function insertPaiement($tab){
		if($this -> pdo != null){
			$cartemois = substr($tab["date_carte"],-2,2);
			$carteannee = substr($tab["date_carte"],0,4);
			$requete = "INSERT into paiement VALUES (null, :type, :nom, :email, :carte, :mois, :annee, :code);";
			$donnees = array (":type" => $tab["type"],
							  ":nom" => $tab["nom"],
							  ":email" => $tab["email"],
							  ":carte" => $tab["carte"],
							  ":mois" => $cartemois,
							  ":annee" => $carteannee,
							  ":code" => $tab["code"]);
			
			$insert = $this -> pdo -> prepare ($requete);
			$insert -> execute ($donnees);
			
			//gestion des messages des TRIGGERS
			$errorInfo = $insert -> errorInfo();
			if ($errorInfo[0] != 0){
				echo "<b><font color = 'red'>" . $errorInfo [0] . " # " . $errorInfo [2] . "</font></b>";
			}

		}else{
			return null;
		}
	}

	public function insertInscription($tab){
		if($this -> pdo != null){
			$requete = "INSERT into inscription VALUES (null, :prenom, :nom, :email, :tel, :adresse, :animation, :structure);";
			$donnees = array (":prenom" => $tab["prenom"],
							  ":nom" => $tab["nom"],
							  ":email" => $tab["email"],
							  ":tel" => $tab["tel"],
							  ":adresse" => $tab["adresse"],
							  ":animation" => $tab["animation"],
							  ":structure" => $tab ["structure"]);
			$insert = $this -> pdo -> prepare ($requete);
			$insert -> execute ($donnees);
		}else{
			return null;
		}
	}

	public function insertSeance($tab){
		if($this -> pdo != null){
			$requete = "INSERT into calendrier VALUES (null, :date_jour, :date_heure, :idfilm);";
			$donnees = array (":date_jour" => $tab["date_jour"],
							  ":date_heure" => $tab["date_heure"],
							  ":idfilm" => $tab["idfilm"]);
			$insert = $this -> pdo -> prepare ($requete);
			$insert -> execute ($donnees);
		}else{
			return null;
		}
	}

	public function selectSeance ($idfilm) {
		if($this -> pdo != null){
			$requete ="SELECT id_seance,date_jour,date_heure,idfilm from calendrier where idfilm = :idfilm;";
			$donnees = array (":idfilm" => $idfilm);
			$select = $this -> pdo -> prepare ($requete);
			$select -> execute ($donnees);
			return $select -> fetchAll();
		}else{
			return null;
		}
		
	}

	public function insertContact($tab){
		if($this -> pdo != null){
			$requete = "INSERT into contact VALUES (null, :email, :typedemande, :description);";
			$donnees = array (":email" => $tab["email"],
							  ":typedemande" => $tab["typedemande"],
							  ":description" => $tab["description"]);
			$insert = $this -> pdo -> prepare ($requete);
			$insert -> execute ($donnees);
		}else{
			return null;
		}
	}

	public function verifConnexion ($tab){
		if($this -> pdo != null){
			$requete = "SELECT * FROM utilisateur WHERE email = :email AND mdp = :mdp;";
			$donnees = array (":email" => $tab['email'],
							  ":mdp" => $tab['mdp']);
			$select = $this -> pdo -> prepare ($requete);
			$select -> execute ($donnees);
			$unUser = $select -> fetch();
			return $unUser;
		}else{
			return null;
		}
	}

	public function insertAdhesion($tab){
		if($this -> pdo != null){
			$requete = "INSERT into utilisateur VALUES (null, :nom, :prenom, :email, :mdp, :confirmation, :poste);";
			$donnees = array (":nom" => $tab["nom"],
							  ":prenom" => $tab["prenom"],
							  ":email" => $tab["email"],
							  ":mdp" => $tab["mdp"],
							  ":confirmation" => $tab["confirmation"],
							  ":poste" => $tab["poste"]);
			$insert = $this -> pdo -> prepare ($requete);
			$insert -> execute ($donnees);

			//gestion des messages error
			$errorInfo = $insert -> errorInfo();
			if ($errorInfo[0] != 0){
				echo "<b><font color = 'red'>" . $errorInfo [0] . " # " . $errorInfo [2] . "</font></b>";
				return $errorInfo[0];
			}else{
				return 0;
			}

		}else{
			return null;
		}
	}


	public function selectWhereAll ($var){
			if($this -> pdo != null){
				$requete = "SELECT * from panier where email = :email ;";
				$donnees = array (":email" => $var);
				$select = $this -> pdo -> prepare ($requete);
				$select -> execute($donnees);
				return $select -> fetchAll(); // retour un seul resultat
			}else{
				return null;
			}
	}

	public function selectAllFilms ($proche){
			if($this -> pdo != null){
				$requete = "SELECT * from film where prochainement = :proche;";
				$donnees = array (":proche" => $proche);
				$select = $this -> pdo -> prepare ($requete);
				$select -> execute($donnees);
				return $select -> fetchAll(); // retour un seul resultat
			}else{
				return null;
			}
	}

	public function selectWhereFilm ($idfilm){
			if($this -> pdo != null){
				$requete = "SELECT * from film where idfilm = :idfilm;";
				$donnees = array (":idfilm" => $idfilm);
				$select = $this -> pdo -> prepare ($requete);
				$select -> execute($donnees);
				return $select -> fetch(); // retour un seul resultat
			}else{
				return null;
			}
	}

	public function selectPlaceDispo ($idseance) {
		if($this -> pdo != null){
			$requete ="SELECT capacite from calendrier where id_seance = :idseance;";
			$donnees = array (":idseance" => $idseance);
			$select = $this -> pdo -> prepare ($requete);
			$select -> execute ($donnees);
			return $select -> fetchAll();
		}else{
			return null;
		}
		
	}

	public function selectReservation ($idseance) {
		if($this -> pdo != null){
			$requete ="SELECT idreservation from reservation where id_seance = :idseance;";
			$donnees = array (":idseance" => $idseance);
			$select = $this -> pdo -> prepare ($requete);
			$select -> execute ($donnees);
			return $select -> fetchAll();
		}else{
			return null;
		}
		
	}
	
	public function selectSiege ($idreservation) {
		if($this -> pdo != null){
			$requete ="SELECT tarifPlein,tarifReduit,tarifEnfant,tarifScolaire from reservation where idreservation = :idreservation;";
			$donnees = array (":idreservation" => $idreservation);
			$select = $this -> pdo -> prepare ($requete);
			$select -> execute ($donnees);
			return $select -> fetchAll();
		}else{
			return null;
		}
		
	}

}
?>