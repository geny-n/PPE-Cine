<?php
    require_once ("Modele/modele.film.php");


    class Controleur 
    {
        private $unModele;
        public function __construct(){
            //instanciation de la classe Modele
            $this -> unModele = new Modele();
        }

        public function insertReservation($tab){
            //controler les données
            //si tout est ok on insere
            return $this -> unModele -> insertReservation($tab);
        }

         public function insertPaiement($tab){
            //controler les données
            //si tout est ok on insere
            $this -> unModele -> insertPaiement($tab);
        }


        public function insertInscription($tab){
            //controler les données
            //si tout est ok on insere
            $this -> unModele -> insertInscription($tab);
        }

        public function insertSeance($tab){
            //controler les données
            //si tout est ok on insere
            $this -> unModele -> insertSeance($tab);
        }

        public function selectSeance ($idfilm) {
            return $this -> unModele -> selectSeance($idfilm);
        }

        public function insertContact($tab){
            //controler les données
            //si tout est ok on insere
            $this -> unModele -> insertContact($tab);
        }

        public function verifConnexion($tab){
            return $this -> unModele -> verifConnexion($tab);
        }

        public function insertAdhesion($tab){
            //controler les données
            //si tout est ok on insere
            return $this -> unModele -> insertAdhesion($tab);
        }

        public function selectWhereAll ($var){
            return $this -> unModele -> selectWhereAll ($var);
        }

        public function selectAllFilms ($proche){
            return $this -> unModele -> selectAllFilms ($proche);
        }

        public function selectWhereFilm ($idfilm){
            return $this -> unModele -> selectWhereFilm ($idfilm);
        }

        public function selectPlaceDispo ($idseance){
            return $this -> unModele -> selectPlaceDispo ($idseance);
        }
        
        public function selectReservation ($idseance){
            return $this -> unModele -> selectReservation ($idseance);
        }

        public function selectSiege ($idreservation){
            return $this -> unModele -> selectSiege ($idreservation);
        }

        /*se connecter a la bdd*/
    }

    
?>
