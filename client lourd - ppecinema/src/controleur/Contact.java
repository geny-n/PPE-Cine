package controleur;

public class Contact {

	private int idcontact;
	private String email, typedemande, description;
	
	public Contact(int idcontact, String email, String typedemande, String description) {
		super();
		this.idcontact = idcontact;
		this.email = email;
		this.typedemande = typedemande;
		this.description = description;
	}
	
	public Contact( String email, String typedemande, String description) {
		super();
		this.idcontact = 0;
		this.email = email;
		this.typedemande = typedemande;
		this.description = description;
	}
	
	public Contact() {
		super();
		this.idcontact = 0;
		this.email = "";
		this.typedemande = "";
		this.description = "";
	}
	
	//getters and setters

	public int getIdcontact() {
		return idcontact;
	}

	public void setIdcontact(int idcontact) {
		this.idcontact = idcontact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypedemande() {
		return typedemande;
	}

	public void setTypedemande(String typedemande) {
		this.typedemande = typedemande;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
