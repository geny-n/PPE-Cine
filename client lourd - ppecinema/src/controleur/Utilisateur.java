package controleur;

public class Utilisateur {
	private int idutilisateur;
	private String nom, prenom, email, mdp, confirmation, poste;
	
	public Utilisateur(int idutilisateur, String nom, String prenom, String email, String mdp, String confirmation, String poste) {
		super();
		this.idutilisateur = idutilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.confirmation = confirmation;
		this.poste = poste;
	}

	public Utilisateur(String nom, String prenom, String email, String mdp, String confirmation, String poste) {
		super();
		this.idutilisateur = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.confirmation = confirmation;
		this.poste = poste;
	}
	
	public Utilisateur() {
		super();
		this.idutilisateur = 0;
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.mdp = "";
		this.confirmation = "";
		this.poste = "";
	}
	
	//GETTERS and SETTERS

	public int getIdutilisateur() {
		return idutilisateur;
	}

	public void setIdutilisateur(int idutilisateur) {
		this.idutilisateur = idutilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
}
