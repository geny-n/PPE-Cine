package controleur;

public class Film {
	private int idfilm;
	private String visa, nomcompagnie, codegenre, titre, duree, 
                    version, datelimite, URL, datesortie, avec, synopsis, prochainement;

    public Film(int idfilm, String visa, String nomcompagnie, String codegenre, String titre, String duree,
            String version, String datelimite, String URL, String datesortie, String avec, String synopsis,
            String prochainement) {
        this.idfilm = idfilm;
        this.visa = visa;
        this.nomcompagnie = nomcompagnie;
        this.codegenre = codegenre;
        this.titre = titre;
        this.duree = duree;
        this.version = version;
        this.datelimite = datelimite;
        this.URL = URL;
        this.datesortie = datesortie;
        this.avec = avec;
        this.synopsis = synopsis;
        this.prochainement = prochainement;
    }

    public Film(String visa, String nomcompagnie, String codegenre, String titre, String duree,
            String version, String datelimite, String URL, String datesortie, String avec, String synopsis,
            String prochainement) {
        this.idfilm = 0;
        this.visa = visa;
        this.nomcompagnie = nomcompagnie;
        this.codegenre = codegenre;
        this.titre = titre;
        this.duree = duree;
        this.version = version;
        this.datelimite = datelimite;
        this.URL = URL;
        this.datesortie = datesortie;
        this.avec = avec;
        this.synopsis = synopsis;
        this.prochainement = prochainement;
    }

    public Film() {
        this.idfilm = 0;
        this.visa = "";
        this.nomcompagnie = "";
        this.codegenre = "";
        this.titre = "";
        this.duree = "";
        this.version = "";
        this.datelimite = "";
        this.URL = "";
        this.datesortie = "";
        this.avec = "";
        this.synopsis = "";
        this.prochainement = "";
    }

    public int getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(int idfilm) {
        this.idfilm = idfilm;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public String getNomcompagnie() {
        return nomcompagnie;
    }

    public void setNomcompagnie(String nomcompagnie) {
        this.nomcompagnie = nomcompagnie;
    }

    public String getCodegenre() {
        return codegenre;
    }

    public void setCodegenre(String codegenre) {
        this.codegenre = codegenre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(String datelimite) {
        this.datelimite = datelimite;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(String datesortie) {
        this.datesortie = datesortie;
    }

    public String getAvec() {
        return avec;
    }

    public void setAvec(String avec) {
        this.avec = avec;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getProchainement() {
        return prochainement;
    }

    public void setProchainement(String prochainement) {
        this.prochainement = prochainement;
    }

    
    

                    
}
