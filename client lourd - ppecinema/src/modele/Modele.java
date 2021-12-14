package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Contact;
import controleur.Film;
import controleur.Horaire;
import controleur.Utilisateur;

public class Modele {
//private static BDD uneBdd = new BDD ("172.20.95.194","ppecinema","geny","geny");
private static BDD uneBdd = new BDD ("localhost", "ppecinema", "root","");
	/******Gestion des utilisateurs *******/
	public static void insertUtilisateur (Utilisateur unUtilisateur) {
		String requete = "insert into utilisateur values (null, '" + unUtilisateur.getNom()
		+"' , '" + unUtilisateur.getPrenom() + "','" + unUtilisateur.getEmail()
		+"','" + unUtilisateur.getMdp() +"','" + unUtilisateur.getConfirmation() 
		+"', '" + unUtilisateur.getPoste() + "'); ";
		
		Modele.executer(requete);
	}
	
	public static void deleteUtilisateur (int idutilisateur) {
		String requete = "delete from utilisateur where idutilisateur =" +idutilisateur+";";
		Modele.executer(requete);
	}
	
	public static void updateUtilisateur (Utilisateur unUtilisateur) {
		String requete = "update utilisateur set nom = '" + unUtilisateur.getNom()
		+"' , prenom ='" + unUtilisateur.getPrenom() + "', email ='" + unUtilisateur.getEmail()
		+"', mdp = '" + unUtilisateur.getMdp() + "', confirmation = '" + unUtilisateur.getConfirmation() 
		+"', poste = '" + unUtilisateur.getPoste() 
		+ "' where idutilisateur = " + unUtilisateur.getIdutilisateur() + ";";
		Modele.executer(requete);
	}
	
	public static void executer (String requete) {
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
	}
	
	public static Utilisateur selectWhereUtilisateur (int idutilisateur) {
		String requete = "select * from utilisateur where idutilisateur = "+idutilisateur +";";
		Utilisateur unUtilisateur = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unUtilisateur = new Utilisateur ( 
						unRes.getInt("idutilisateur"), unRes.getString("nom"), unRes.getString("prenom"),
						unRes.getString("email"), unRes.getString("mdp"), unRes.getString("confirmation"),
						unRes.getString("poste")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return unUtilisateur;
	}
	
	//surchage de la methode selectWhereSalarie avec different arguments
	public static Utilisateur selectWhereUtilisateur (String email, String mdp) {
		String requete = "select * from utilisateur where email = '"+email +"' and mdp = '" +mdp+ "' ;";
		Utilisateur unUtilisateur = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unUtilisateur = new Utilisateur ( 
						unRes.getInt("idutilisateur"), unRes.getString("nom"), unRes.getString("prenom"),
						unRes.getString("email"), unRes.getString("mdp"), unRes.getString("confirmation"),
						unRes.getString("poste")
						);								
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return unUtilisateur;
	}
	
	
	
	public static ArrayList<Utilisateur> selectAllUtilisateur (String mot) {
		String requete = ""; 
		if (mot.equals("")) {
			requete = "select * from utilisateur ;";
		}else {
			requete = "select * from utilisateur where nom like '%" +mot+"%' or prenom like '%" 
					+mot+ "%' or poste like '%" +mot+ "%' ;" ;
		}
		ArrayList<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Utilisateur unUtilisateur = new Utilisateur ( 
						desRes.getInt("idutilisateur"), desRes.getString("nom"), desRes.getString("prenom"),
						desRes.getString("email"), desRes.getString("mdp"), desRes.getString("confirmation"),
						desRes.getString("poste")
						);
				lesUtilisateurs.add(unUtilisateur);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return lesUtilisateurs;
	}
	
	
	/******Gestion des films *******/
	public static void insertFilm (Film unFilm) {
		String requete = "insert into film values (null, '" + unFilm.getVisa()
		+"' , '" + unFilm.getNomcompagnie() + "','" + unFilm.getCodegenre()
		+"','" + unFilm.getTitre() +"','" + unFilm.getDuree() 
		+"', '" + unFilm.getVersion() +"','" + unFilm.getDatelimite() 
		+"', '" + unFilm.getURL() + "','" + unFilm.getDatesortie()
		+"', '" + unFilm.getSynopsis() + "','" + unFilm.getAvec()
		+ "','" + unFilm.getProchainement()
		+ "'); ";
		
		Modele.executer(requete);
	}
	
	public static void deleteFilm (int idfilm) {
		String requete = "delete from film where idfilm =" +idfilm+";";
		Modele.executer(requete);
	}
	
	public static void updateFilm (Film unFilm) {
		String requete = "update film set visa = '" + unFilm.getVisa()
		+"' , nomcompagnie ='" + unFilm.getNomcompagnie() + "', codegenre ='" + unFilm.getCodegenre()
		+"', titre = '" + unFilm.getTitre() + "', duree = '" + unFilm.getDuree()
		+"', version = '" + unFilm.getVersion() +"', datelimite = '" + unFilm.getDatelimite()
		+"', URL = '" + unFilm.getURL() +"', dateSortie = '" + unFilm.getDatesortie()
		+"', avec = '" + unFilm.getAvec() +"', synopsis = '" + unFilm.getSynopsis() 
		+"', prochainement = '" + unFilm.getProchainement()
		+ "' where idfilm = " + unFilm.getIdfilm() + ";";
		Modele.executer(requete);
	}	
	
	public static Film selectWhereFilm (int idfilm) {
		String requete = "select * from film where idfilm = "+idfilm +";";
		Film unFilm = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unFilm = new Film ( 
						unRes.getInt("idfilm"), unRes.getString("visa"), unRes.getString("nomcompagnie"),
						unRes.getString("codegenre"), unRes.getString("titre"), unRes.getString("duree"),
						unRes.getString("version"), unRes.getString("datelimite"), unRes.getString("URL"),
						unRes.getString("dateSortie"), unRes.getString("avec"), unRes.getString("synopsis"),unRes.getString("prochainement")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return unFilm;
	}
	
	//surchage de la methode selectWhereFilm avec different arguments
	public static Film selectWhereFilm (String titre, String version) {
		String requete = "select * from film where titre = '"+titre +"' and version = '" +version+ "' ;";
		Film unFilm = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unFilm = new Film ( 
					unRes.getInt("idfilm"), unRes.getString("visa"), unRes.getString("nomcompagnie"),
					unRes.getString("codegenre"), unRes.getString("titre"), unRes.getString("duree"),
					unRes.getString("version"), unRes.getString("datelimite"), unRes.getString("URL"),
					unRes.getString("dateSortie"), unRes.getString("avec"), unRes.getString("synopsis"),unRes.getString("prochainement")
						);								
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return unFilm;
	}
	
	
	
	public static ArrayList<Film> selectAllFilm (String mot) {
		String requete = ""; 
		if (mot.equals("")) {
			requete = "select * from film ;";
		}else {
			requete = "select * from film where titre like '%" +mot+"%' or version like '%" 
					+mot+ "%' ;" ;
		}
		ArrayList<Film> lesFilms = new ArrayList<Film>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Film unFilm = new Film ( 
					desRes.getInt("idfilm"), desRes.getString("visa"), desRes.getString("nomcompagnie"),
					desRes.getString("codegenre"), desRes.getString("titre"), desRes.getString("duree"),
					desRes.getString("version"), desRes.getString("datelimite"), desRes.getString("URL"),
					desRes.getString("dateSortie"), desRes.getString("avec"), desRes.getString("synopsis"),
					desRes.getString("prochainement")
				);
				lesFilms.add(unFilm);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return lesFilms;
	}
	
	
	/******Gestion des commentaires *******/
	public static void insertContact (Contact unContact) {
		String requete = "insert into contact values (null, '" + unContact.getEmail()
		+"' , '" + unContact.getTypedemande() + "','" + unContact.getDescription()
		+ "'); ";
		
		Modele.executer(requete);
	}
	
	public static void deleteContact (int idcontact) {
		String requete = "delete from contact where idcontact =" +idcontact+";";
		Modele.executer(requete);
	}
	
	public static void updateContact (Contact unContact) {
		String requete = "update contact set email = '" + unContact.getEmail()
		+"' , typedemande ='" + unContact.getTypedemande() + "', description ='" + unContact.getDescription()
		+ "' where idcontact = " + unContact.getIdcontact() + ";";
		Modele.executer(requete);
	}	
	
	public static Contact selectWhereContact (int idcontact) {
		String requete = "select * from contact where idcontact = "+idcontact +";";
		Contact unContact = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unContact = new Contact ( 
						unRes.getInt("idcontact"), unRes.getString("email"), unRes.getString("typedemande"),
						unRes.getString("description")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return unContact;
	}
	
	//surchage de la methode selectWhereContact avec different arguments
	public static Contact selectWhereContact (String typedemande) {
		String requete = "select * from contact where typedemande = '"+typedemande +"' ;";
		Contact unContact = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unContact = new Contact ( 
						unRes.getInt("idcontact"), unRes.getString("email"), unRes.getString("typedemande"),
						unRes.getString("description")
						);								
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return unContact;
	}
	
	
	
	public static ArrayList<Contact> selectAllContact (String mot) {
		String requete = ""; 
		if (mot.equals("")) {
			requete = "select * from contact ;";
		}else {
			requete = "select * from contact where typedemande like '%" +mot+"%' ;" ;
		}
		ArrayList<Contact> lesContacts = new ArrayList<Contact>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Contact unContact = new Contact ( 
						desRes.getInt("idcontact"), desRes.getString("email"), desRes.getString("typedemande"),
						desRes.getString("description")
						);
				lesContacts.add(unContact);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return lesContacts;
	}
	
	
	/******Gestion des horaires *******/

	public static void insertHoraire (Horaire unHoraire) {
		String requete = "insert into calendrier values (null, '" + unHoraire.getDate_jour() +
		"','" + unHoraire.getDate_heure() +
		"','" + unHoraire.getIdfilm()+
		"','" + unHoraire.getCapacite()+
		"'); ";
		Modele.executer(requete);
	}

	public static void deleteHoraire (int id_seance) {
		String requete = "delete from calendrier where id_seance =" +id_seance+";";
		Modele.executer(requete);
	}

	public static void updateHoraire (Horaire unHoraire) {
		String requete = "update calendrier set date_jour = '" + unHoraire.getDate_jour() +
		"', date_heure ='" + unHoraire.getDate_heure() +
		"', idfilm ='" + unHoraire.getIdfilm()+
		"', capacite ='" + unHoraire.getCapacite()+
		"' where id_seance =" + unHoraire.getId_seance()+ "; ";
		Modele.executer(requete);
	}

	public static Horaire selectWhereHoraire (int id_seance) {
			
		String requete = "select * from calendrier where id_seance = "+id_seance +";";
		Horaire unHoraire = null;
		try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unRes = unStat.executeQuery(requete);
		if (unRes.next()){
			unHoraire = new Horaire (
					unRes.getInt("id_seance"), unRes.getString("date_jour"), unRes.getString("date_heure"),
					unRes.getInt("idfilm"), unRes.getInt("capacite"));
		}
		unStat.close();
		uneBdd.seDeconnecter();
		}catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
			return unHoraire;
	}

	//surcharge de la m�thode selectWhereSalarie avec different arguments 
	public static Horaire selectWhereHoraire (String date_jour, String date_heure) {
			
		String requete = "select * from calendrier where date_jour = '"+date_jour +"' and date_heure ='"+date_heure+"' ;";
		Horaire unHoraire = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()){
				unHoraire = new Horaire (
					unRes.getInt("id_seance"), unRes.getString("date_jour"), unRes.getString("date_heure"),
					unRes.getInt("idfilm"), unRes.getInt("capacite"));
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return unHoraire;
	}
	public static ArrayList<Horaire> selectAllHoraires (String mot) {
			
		String requete ="";
		if (mot.equals("")) {
			requete ="select * from calendrier ;" ;
		}else {
			requete = "select * from calendrier where date_jour like '%" + mot +
				"%' or date_heure like '%" + mot + "%' ;";
		}
		ArrayList<Horaire> lesHoraires = new ArrayList<Horaire>();
		try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet desRes = unStat.executeQuery(requete);
		while (desRes.next()){
			Horaire unHoraire = new Horaire(
				desRes.getInt("id_seance"), desRes.getString("date_jour"), desRes.getString("date_heure"),
				desRes.getInt("idfilm"), desRes.getInt("capacite"));
			lesHoraires.add(unHoraire);
		}
		unStat.close();
		uneBdd.seDeconnecter();
	}catch (SQLException exp) {
		System.out.println("Erreur d'execution de la requete :" + requete);
	}
		return lesHoraires;
}




	/*public static void insertHoraire (Horaire unHoraire) {
		String requete = "insert into calendrier values (null, '" + unHoraire.getDate_jour()
		+"' , '" + unHoraire.getDate_heure() + "','" + unHoraire.getIdfilm()+ "','" + unHoraire.getCapacite()
		+ "'); ";
		
		Modele.executer(requete);
	}
	
	public static void deleteHoraire (int id_seance) {
		String requete = "delete from calendrier where id_seance =" +id_seance+";";
		Modele.executer(requete);
	}
	
	public static void updateHoraire (Horaire unHoraire) {
		String requete = "update calendrier set date_jour = '" + unHoraire.getDate_jour()
		+"' , date_heure ='" + unHoraire.getDate_heure()  + "', idfilm ='" + unHoraire.getIdfilm()+ "' , capacite ='" + unHoraire.getCapacite()
		+ "' where id_seance = " + unHoraire.getId_seance() + ";";
		Modele.executer(requete);
	}	
	
	public static Horaire selectWhereHoraire (int id_seance) {
		String requete = "select * from calendrier where id_seance = "+id_seance +";";
		Horaire unHoraire = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unHoraire = new Horaire ( 
						unRes.getInt("id_seance"), unRes.getString("date_jour"), unRes.getString("date_heure"),
						unRes.getInt("idfilm"), unRes.getInt("capacite")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete :" + requete);
		}
		return unHoraire;
	}
	
	//surchage de la methode selectWhereHoraire avec different arguments
	public static Horaire selectWhereHoraire (String idfilm) {
		String requete = "select * from calendrier where idfilm = '"+idfilm +"' ;";
		Horaire unHoraire = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unHoraire = new Horaire ( 
						unRes.getInt("id_seance"), unRes.getString("date_jour"), unRes.getString("date_heure"),
						unRes.getInt("idfilm"), unRes.getInt("capacite")
						);								
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete :" + requete);
		}
		return unHoraire;
	}
	
	
	
	public static ArrayList<Horaire> selectAllHoraire (String mot) {
		String requete = ""; 
		if (mot.equals("")) {
			requete = "select * from calendrier ;";
		}else {
			requete = "select * from calendrier where idfilm like '%" +mot+"%' ;" ;
		}
		ArrayList<Horaire> lesHoraires = new ArrayList<Horaire>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Horaire unHoraire = new Horaire ( 
						desRes.getInt("id_seance"), desRes.getString("date_jour"), desRes.getString("date_heure"),
						desRes.getInt("idfilm"), desRes.getInt("capacite")
						);
				lesHoraires.add(unHoraire);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requete :" + requete);
		}
		return lesHoraires;
	}*/



	
}
