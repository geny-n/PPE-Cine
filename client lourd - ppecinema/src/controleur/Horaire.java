package controleur;

public class Horaire {
    private int id_seance;
    private String date_jour, date_heure;
    private int idfilm, capacite;
    
    public Horaire(int id_seance, String date_jour, String date_heure, int idfilm, int capacite) {
        this.id_seance = id_seance;
        this.date_jour = date_jour;
        this.date_heure = date_heure;
        this.idfilm = idfilm;
        this.capacite = capacite;
    }

    public Horaire(String date_jour, String date_heure, int idfilm, int capacite) {
        this.id_seance = 0;
        this.date_jour = date_jour;
        this.date_heure = date_heure;
        this.idfilm = idfilm;
        this.capacite = capacite;
    }

    public Horaire() {
        this.id_seance = 0;
        this.date_jour = "";
        this.date_heure = "";
        this.idfilm = 0;
        this.capacite = 0;
    }

    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public String getDate_jour() {
        return date_jour;
    }

    public void setDate_jour(String date_jour) {
        this.date_jour = date_jour;
    }

    public String getDate_heure() {
        return date_heure;
    }

    public void setDate_heure(String date_heure) {
        this.date_heure = date_heure;
    }

    public int getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(int idfilm) {
        this.idfilm = idfilm;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    
}
