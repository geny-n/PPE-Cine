package controleur;

import java.util.ArrayList;

import modele.Modele;
import vue.VueContact;
import vue.VueConnexion;
import vue.VueFilm;
import vue.VueHoraire;
import vue.VueUtilisateur;

public class Main {
	private static VueConnexion uneConnexion;
	private static VueUtilisateur uneVueUtilisateur;
	private static VueFilm uneVueFilm;
	private static VueContact uneVueContact;
	private static VueHoraire uneVueHoraire;

	public static void main(String[] args) {
		uneConnexion = new VueConnexion();
	}
	
	public static void instancierVueUtilisateur () {
		uneVueUtilisateur = new VueUtilisateur();
	}
	
	public static void instancierVueFilm () {
		uneVueFilm = new VueFilm();
	}
	
	public static void instancierVueContact () {
		uneVueContact = new VueContact();
	}
	
	public static void instancierVueHoraire () {
		uneVueHoraire = new VueHoraire();
	}
	
	public static void rendreVisible (boolean action) {
		uneConnexion.setVisible(action);
	}
	
	/*****************Controleur de la table Utilisateur*****************/
	public static void insertUtilisateur (Utilisateur unUtilisateur) {
		Modele.insertUtilisateur(unUtilisateur);
	}

	public static void deleteUtilisateur (int idutilisateur){
		Modele.deleteUtilisateur(idutilisateur);
	}
	
	public static void updateUtilisateur (Utilisateur unUtilisateur) {
		Modele.updateUtilisateur(unUtilisateur);
	}
	
	public static Utilisateur selectWhereUtilisateur (int idutilisateur) {
		return Modele.selectWhereUtilisateur(idutilisateur);
	}
	
	public static Utilisateur selectWhereUtilisateur (String email, String mdp) {
		return Modele.selectWhereUtilisateur(email, mdp);
	}
	
	public static ArrayList<Utilisateur> selectAllUtilisateur (String mot) {
		return Modele.selectAllUtilisateur(mot);
	}
	
	/****************************************************************/
	
	/*****************Controleur de la table Film*****************/
	public static void insertFilm (Film unFilm) {
		Modele.insertFilm(unFilm);
	}

	public static void deleteFilm (int idfilm){
		Modele.deleteFilm(idfilm);
	}
	
	public static void updateFilm (Film unFilm) {
		Modele.updateFilm(unFilm);
	}
	
	public static Film selectWhereFilm (int idfilm) {
		return Modele.selectWhereFilm(idfilm);
	}
	
	public static Film selectWhereFilm (String titre, String version) {
		return Modele.selectWhereFilm(titre, version);
	}
	
	public static ArrayList<Film> selectAllFilm (String mot) {
		return Modele.selectAllFilm(mot);
	}
	
	/****************************************************************/
	
	/*****************Controleur de la table contact*****************/
	public static void insertContact (Contact unContact) {
		Modele.insertContact(unContact);
	}

	public static void deleteContact (int idcontact){
		Modele.deleteContact(idcontact);
	}
	
	public static void updateContact (Contact unContact) {
		Modele.updateContact(unContact);
	}
	
	public static Contact selectWhereContact (int idcontact) {
		return Modele.selectWhereContact(idcontact);
	}
	
	public static Contact selectWhereContact (String typedemande) {
		return Modele.selectWhereContact(typedemande);
	}
	
	public static ArrayList<Contact> selectAllContact (String mot) {
		return Modele.selectAllContact(mot);
	}
	
	/****************************************************************/
	
	/*****************Controleur de la table horaire*****************/
	public static void insertHoraire (Horaire unHoraire) {
		Modele.insertHoraire(unHoraire);
	}

	public static void deleteHoraire (int id_seance){
		Modele.deleteHoraire(id_seance);
	}
	
	public static void updateHoraire (Horaire unHoraire) {
		Modele.updateHoraire(unHoraire);
	}
	
	public static Horaire selectWhereHoraire (int id_seance) {
		return Modele.selectWhereHoraire(id_seance);
	}
	                                                                                                                                                
	public static Horaire selectWhereHoraire (String date_jour, String date_heure) {
		return Modele.selectWhereHoraire(date_jour, date_heure);
	}

	public static ArrayList<Horaire> selectAllHoraires (String mot) {
		return Modele.selectAllHoraires(mot);
	}
	
	/****************************************************************/
}
