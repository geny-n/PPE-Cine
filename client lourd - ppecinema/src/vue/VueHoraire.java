package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.net.http.HttpRequest;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Horaire;
import controleur.Film;
import controleur.Main;
//import controleur.Salarie;
//import controleur.Pilote;
//import jdk.javadoc.internal.doclets.formats.html.markup.Table;
import controleur.Tableau;

public class VueHoraire extends JFrame implements ActionListener{
    private JButton btRetour = new JButton("Retour au menu");
    
    //declaration du pannel d'ajout
    private JPanel panelAjout = new JPanel();
    private JTextField txtDateJour = new JTextField();
    private JTextField txtDateHeure = new JTextField();
    private JComboBox<String> cbxFilm = new JComboBox<String>();
	private JTextField txtCapacite = new JTextField();
    private JButton btAnnuler= new JButton("Annuler");
    private JButton btEnregistrer = new JButton("Enregistrer");
	private int iddeseance;//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	
	//pael lister : gestion du tableau des �v�nements 
	private JTable uneTable;
	private Tableau unTableau;
	private JScrollPane uneScroll;
	private JPanel panelLister = new JPanel();
	
	//rechercher par mot cle
		private JTextField txtMot = new JTextField();
		private JButton btFiltrer = new JButton("Filtrer");
    
    public VueHoraire() {
		this.setTitle("Gestion des Horaires");
		this.setBounds(200, 200, 1200, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color (128, 128, 128));
		this.setLayout(null);
        		
		this.btRetour.setBounds(1000, 520, 130, 20);
		this.add(this.btRetour);
        this.btRetour.addActionListener(this);
        
        //construction du panel ajout
		this.panelAjout.setBounds(20, 100, 300, 300);
		this.panelAjout.setBackground(new Color(128,128,128));
		this.panelAjout.setLayout(new GridLayout(5, 2));		
		
		this.panelAjout.add(new JLabel("Jour : "));
		this.panelAjout.add(this.txtDateJour);
		this.panelAjout.add(new JLabel("Heure : "));
		this.panelAjout.add(this.txtDateHeure);
		this.panelAjout.add(new JLabel("Film : "));
		this.panelAjout.add(this.cbxFilm);
		this.panelAjout.add(new JLabel("Capacite : "));
		this.panelAjout.add(this.txtCapacite);
		
		this.panelAjout.add(this.btAnnuler);
		this.panelAjout.add(this.btEnregistrer);
		this.add(this.panelAjout);
		
		//remplir le CBX Avion 
		this.remplirCBXFilm();

		//rendre les deux boutons cliquables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
        
        
     // installation du panel lister 
			this.panelLister.setBounds(370, 60, 800, 360);
			this.panelLister.setBackground(new Color(128,128,128));
			this.panelLister.setLayout(null);
     		
     		String entetes [] = {"Id seance", "Date_jour", "Date_heure", "Film", "Capacite"};
     		
     		//instanciation de la classe tableau avec les entetes et les donnees
     		this.unTableau = new Tableau (entetes, this.remplirDonnees(""));
     	
     		//instanciation de la JTable avec le tableau construit 
     		this.uneTable = new JTable(this.unTableau);
     		
     		//je mets ma table dans ma scroll
     		this.uneScroll = new JScrollPane(this.uneTable);
     		this.uneScroll.setBounds(20, 20, 780, 200);
     		this.panelLister.add(this.uneScroll);
     		
     		this.add(this.panelLister);		    		
     		
     		this.uneTable.addMouseListener(new MouseListener() {
		
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() >= 2) {
						int ligne = uneTable.getSelectedRow();
						int retour = JOptionPane.showConfirmDialog(null, "Confirmez la suppression", "Suppression", JOptionPane.YES_NO_OPTION);
						if (retour ==0) {					
							//on recupere l'id de l'a�roport � supprimer
							int id_seance = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString());
							//on supprime dans la bdd via le modele
							Main.deleteHoraire(id_seance);
							//suppression de la ligne de l'affichage 
							unTableau.supprimerLigne(ligne);
						}
						
					} else if (e.getClickCount() == 1) {
						int ligne = uneTable.getSelectedRow();
						iddeseance = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString());//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
						txtDateJour.setText(unTableau.getValueAt(ligne, 1).toString());
						txtDateHeure.setText(unTableau.getValueAt(ligne, 2).toString());
						txtCapacite.setText(unTableau.getValueAt(ligne, 4).toString());
						
						//pas de modif pour mle combo staut et type et idsalarie
						btEnregistrer.setText("Modifier");
					}
					
				}
     		});
     		
     		
     		//placement zone de recherche
    		this.txtMot.setBounds(200, 10, 130, 25);
    		this.add(this.txtMot);
    		this.btFiltrer.setBounds(370, 10, 130, 25);
    		this.add(this.btFiltrer);
    		this.btFiltrer.addActionListener(this);
    		
    		this.setVisible(true);
        
	}   
    
    public Object [][] remplirDonnees (String mot){
		//cette methode transforme l'ArrayList des �v�nements
		//en une matrice 
		
		ArrayList<Horaire> lesHoraires= Main.selectAllHoraires(mot);
		Object [][] matrice = new Object[lesHoraires.size()][5];
		int i =0;
		for (Horaire unHoraire : lesHoraires)
		{
			matrice [i][0] = unHoraire.getId_seance();
			matrice [i][1] = unHoraire.getDate_jour();
			matrice [i][2] = unHoraire.getDate_heure();
			matrice [i][3] = unHoraire.getIdfilm();
			matrice [i][4] = unHoraire.getCapacite();
			i++;
		}
		return matrice;
    }
	
	public void remplirCBXFilm () {
		// cette methode remplit le select (combp) des avions
		ArrayList<Film> lesFilms = Main.selectAllFilm("");
		this.cbxFilm.removeAllItems();
		for (Film unFilm : lesFilms) {
			this.cbxFilm.addItem(unFilm.getIdfilm()+	" - " + unFilm.getTitre()+" - " + unFilm.getVersion());
		}
 	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btRetour) {
            this.dispose();
            Main.rendreVisible(true);
        } else if (e.getSource() == this.btAnnuler) {
        	this.viderChamps ();
        } else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")) {
			String date_jour = this.txtDateJour.getText();
			String date_heure = this.txtDateHeure.getText();
			String chaine = this.cbxFilm.getSelectedItem().toString();
			String tab [] = chaine.split(" - ");
			int idfilm = Integer.parseInt(tab [0]);
			int capacite = Integer.parseInt(this.txtCapacite.getText());

			//Instanciation de l'a�roport
			Horaire unHoraire = new Horaire(date_jour, date_heure, idfilm, capacite);
			
			//insertion dans la bdd
			Main.insertHoraire(unHoraire);

			//recuperation de l'ID a�roport affecte par le SGBD			
			unHoraire = Main.selectWhereHoraire(date_jour, date_heure);
			
			//actualiser l'affichage 
			Object ligne [] = {unHoraire.getId_seance(), date_jour, date_heure, idfilm, capacite};
				this.unTableau.ajouterLigne(ligne);				
				JOptionPane.showMessageDialog(this, "insertion reussie de l'Horaire");
				this.viderChamps();
        }else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier")) {
        	String date_jour = this.txtDateJour.getText();
			String date_heure = this.txtDateHeure.getText();
			String chaine = this.cbxFilm.getSelectedItem().toString();
			String tab [] = chaine.split(" - ");
			int idfilm = Integer.parseInt(tab [0]);
			int capacite = Integer.parseInt(this.txtCapacite.getText());
			
			//recuperer l'id de l'a�roport		
			//Aeroport unAeroportID = Main.selectWhereAeroport(idAeroport);
			
			//Instanciation de l'a�roport
			Horaire unHoraire = new Horaire (iddeseance, date_jour, date_heure, idfilm, capacite);	
			
			//maj dans la bdd			
			Main.updateHoraire(unHoraire);		
			
			//recuperer numero ligne			
			int numero = this.uneTable.getSelectedRow();		
			
			//actualiser l'affichage
			Object [] ligne = {iddeseance, date_jour, date_heure, idfilm, capacite};
			this.unTableau.modifierLigne(numero, ligne);
			
			JOptionPane.showMessageDialog(this, "Modification reussie dans la Base de données");
			this.viderChamps();
			this.btEnregistrer.setText("Enregistrer");
		}else if (e.getSource() == this.btFiltrer) {
			String mot = this.txtMot.getText();
			this.unTableau.setDonnees(this.remplirDonnees(mot));
        }
    }
    
    
    public void viderChamps () {
    	this.txtDateJour.setText("");
    	this.txtDateHeure.setText("");
    	this.txtCapacite.setText("");
    }
    
  
}
