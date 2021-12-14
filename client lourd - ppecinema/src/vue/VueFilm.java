package vue;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import controleur.Main;
import controleur.Film;
import controleur.Tableau;

public class VueFilm extends JFrame implements ActionListener {
	
	private JButton btRetour = new JButton("Retour au menu");

	private JPanel panelAjout = new JPanel();
	private JTextField txtVisa = new JTextField();
	private JTextField txtNomCompagnie = new JTextField();
	private JTextField txtCodeGenre = new JTextField();
	private JTextField txtTitre = new JTextField();
	private JTextField txtDuree = new JTextField();
	private JTextField txtVersion = new JTextField();
	private JTextField txtDateLimite = new JTextField();
	private JTextField txtURL = new JTextField();
	private JTextField txtDateSortie = new JTextField();
	private JTextField txtAvec = new JTextField();
	private JTextField txtSynopsis = new JTextField();
	private JComboBox<String> cbxProchainenement = new JComboBox<String>();
	private int idfilm;

	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	//panel d'affichage des salariés
	private JPanel panelLister = new JPanel();
	private JTable uneTable;
	private JScrollPane uneScroll;
	private Tableau unTableau;
	
	//rechercher par mot 
	private JTextField txtMot = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueFilm() {
		
		this.setTitle("Gestion des Films");
		this.setBounds(200, 200, 1200, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color (128, 128, 128));
		this.setLayout(null);
		
		this.btRetour.setBounds(1000, 520, 130, 20);
		this.add(this.btRetour);
		this.btRetour.addActionListener(this);
		
		//construction du Panel Ajout 
		this.panelAjout.setBounds(50, 50, 300, 500);
		this.panelAjout.setBackground(new Color (128,128,128));
		this.panelAjout.setLayout(new GridLayout(14,2));
		
		this.panelAjout.add(new JLabel("Visa : "));
		this.panelAjout.add(this.txtVisa);
		this.panelAjout.add(new JLabel("Nom Compagnie : "));
		this.panelAjout.add(this.txtNomCompagnie);
		this.panelAjout.add(new JLabel("Code Genre : "));
		this.panelAjout.add(this.txtCodeGenre);
		this.panelAjout.add(new JLabel("Titre : "));
		this.panelAjout.add(this.txtTitre);
		this.panelAjout.add(new JLabel("Duree : "));
		this.panelAjout.add(this.txtDuree);
		this.panelAjout.add(new JLabel("Version : "));
		this.panelAjout.add(this.txtVersion);
		this.panelAjout.add(new JLabel("Date Limites : "));
		this.panelAjout.add(this.txtDateLimite);
		this.panelAjout.add(new JLabel("URL : "));
		this.panelAjout.add(this.txtURL);
		this.panelAjout.add(new JLabel("Date sortie : "));
		this.panelAjout.add(this.txtDateSortie);
		this.panelAjout.add(new JLabel("Avec : "));
		this.panelAjout.add(this.txtAvec);
		this.panelAjout.add(new JLabel("Synopsis : "));
		this.panelAjout.add(this.txtSynopsis);
		this.panelAjout.add(new JLabel("Prochainement : "));
		this.panelAjout.add(this.cbxProchainenement);
		
		this.panelAjout.add(this.btAnnuler);
		this.panelAjout.add(this.btEnregistrer);
		this.add(this.panelAjout);
		
		//rendre les boutons cliquables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		// ajout du panel lister 
		this.panelLister.setBounds(370, 60, 800, 360);
		this.panelLister.setBackground(new Color(128,128,128));
		this.panelLister.setLayout(null);
		
		String entetes [] = {"Id fIlm", "Visa", "Nom Compagnie", "Code Genre", "Titre", "Duree", "Version", 
								"Date Limite", "URL", "Date Sortie", "Avec", "synopsis", "Prochainement"};
		
		//instanciation de la classe tableau avec les entetes et les donnees
		this.unTableau = new Tableau (entetes, this.remplirDonnees(""));
	
		//instanciation de la JTable avec le tableau construit 
		this.uneTable = new JTable(this.unTableau);
		
		//je mets ma table dans ma scroll
		this.uneScroll = new JScrollPane(this.uneTable);
		this.uneScroll.setBounds(20, 20, 780, 200);
		this.panelLister.add(this.uneScroll);
		this.add(this.panelLister);

		//remplir combobox des statut et type
		this.cbxProchainenement.addItem("0");
		this.cbxProchainenement.addItem("1");
		
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
					if (retour == 0) {					
						//on recupere l'id du salarie a supprimer
						idfilm = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString());
						//on supprime dans la bdd via le modele
						Main.deleteFilm(idfilm);
						//suppression de la ligne de l'affichage 
						unTableau.supprimerLigne(ligne);
					}
				}else if (e.getClickCount() == 1) {
					int ligne = uneTable.getSelectedRow();
					idfilm = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString());
					txtVisa.setText(unTableau.getValueAt(ligne, 1).toString());
					txtNomCompagnie.setText(unTableau.getValueAt(ligne, 2).toString());
					txtCodeGenre.setText(unTableau.getValueAt(ligne, 3).toString());
					txtTitre.setText(unTableau.getValueAt(ligne, 4).toString());
					txtDuree.setText(unTableau.getValueAt(ligne, 5).toString());
					txtVersion.setText(unTableau.getValueAt(ligne, 6).toString());
					txtDateLimite.setText(unTableau.getValueAt(ligne, 7).toString());
					txtURL.setText(unTableau.getValueAt(ligne, 8).toString());
					txtDateSortie.setText(unTableau.getValueAt(ligne, 9).toString());
					txtAvec.setText(unTableau.getValueAt(ligne, 10).toString());
					txtSynopsis.setText(unTableau.getValueAt(ligne, 11).toString());
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
		//cette méthode transforme l'ArrayList des salaries
		//en une matrice 
		
		ArrayList<Film> lesFilms = Main.selectAllFilm(mot);
		Object [][] matrice = new Object[lesFilms.size()][14];
		int i =0;
		for (Film unFilm : lesFilms)
		{
			matrice [i][0] = unFilm.getIdfilm();
			matrice [i][1] = unFilm.getVisa();
			matrice [i][2] = unFilm.getNomcompagnie();
			matrice [i][3] = unFilm.getCodegenre();
			matrice [i][4] = unFilm.getTitre();
			matrice [i][5] = unFilm.getDuree();
			matrice [i][6] = unFilm.getVersion();
			matrice [i][7] = unFilm.getDatelimite();
			matrice [i][8] = unFilm.getURL();
			matrice [i][9] = unFilm.getDatesortie();
			matrice [i][10] = unFilm.getAvec();
			matrice [i][11] = unFilm.getSynopsis();
			matrice [i][12] = unFilm.getProchainement();			
			
			i++;
		}
		return matrice;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btRetour ) {
			this.dispose();//je detruis la vue actuelle
			//et je rends visible la vue connexion avec son menu
			Main.rendreVisible(true);
		}else if (e.getSource() == this.btAnnuler) {
			this.viderChamps ();
		}else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")) {
			String visa = this.txtVisa.getText();
			String nomcompagnie = this.txtNomCompagnie.getText();
			String codegenre = this.txtCodeGenre.getText();
            String titre = this.txtTitre.getText();
			String duree = this.txtDuree.getText();
			String version = this.txtVersion.getText();
			String datelimite = this.txtDateLimite.getText();
			String URL = this.txtURL.getText();
            String datesortie = this.txtDateSortie.getText();
			String avec = this.txtAvec.getText();
			String synopsis = this.txtSynopsis.getText();
			String prochainement = this.cbxProchainenement.getSelectedItem().toString();          
			
			//Instanciation du salarie 
			Film unFilm = new Film (visa, nomcompagnie, codegenre, titre, duree, version, datelimite,
										URL, datesortie, avec, synopsis, prochainement);
			
			//insertion dans la bdd
			Main.insertFilm(unFilm);
			
			//recuperation de l'ID salarie affecte par le SGBD
			unFilm = Main.selectWhereFilm(titre, version);
			
			//actualiser l'affichage 
			Object [] ligne = {unFilm.getIdfilm(), visa, nomcompagnie, codegenre, titre, duree, version, datelimite,
				URL, datesortie, avec, synopsis, prochainement};
			this.unTableau.ajouterLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Insertion réussie dans la Base de données");
			this.viderChamps();
		}else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier")) {
			String visa = this.txtVisa.getText();
			String nomcompagnie = this.txtNomCompagnie.getText();
			String codegenre = this.txtCodeGenre.getText();
            String titre = this.txtTitre.getText();
			String duree = this.txtDuree.getText();
			String version = this.txtVersion.getText();
			String datelimite = this.txtDateLimite.getText();
			String URL = this.txtURL.getText();
            String datesortie = this.txtDateSortie.getText();
			String avec = this.txtAvec.getText();
			String synopsis = this.txtSynopsis.getText();
			String prochainement = this.cbxProchainenement.getSelectedItem().toString();
			
			//recupérer l'id du salarié
			//Avion unAvionId = Main.selectWhereAvion(designation, typeavion);
			
			//Instanciation du salarie 
			Film unFilm = new Film (idfilm, visa, nomcompagnie, codegenre, titre, duree, version, datelimite,
			URL, datesortie, avec, synopsis, prochainement);
			
			//maj dans la bdd
			Main.updateFilm(unFilm);
			
			//recuperer numero de ligne
			int numero = this.uneTable.getSelectedRow();
			
			//actualiser l'affichage 
			Object [] ligne = {idfilm, visa, nomcompagnie, codegenre, titre, duree, version, datelimite,
				URL, datesortie, avec, synopsis, prochainement};
			this.unTableau.modifierLigne(numero, ligne);
			
			JOptionPane.showMessageDialog(this, "Modification réussie dans la Base de données");
			this.viderChamps();
			this.btEnregistrer.setText("Enregistrer");
		}else if (e.getSource() == this.btFiltrer) {
			String mot = this.txtMot.getText();
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		
	}
	
	public void viderChamps() {
		this.txtVisa.setText("");
		this.txtNomCompagnie.setText("");
		this.txtCodeGenre.setText("");
		this.txtTitre.setText("");
		this.txtDuree.setText("");
		this.txtVersion.setText("");
		this.txtDateLimite.setText("");
		this.txtURL.setText("");
		this.txtDateSortie.setText("");
		this.txtAvec.setText("");
		this.txtSynopsis.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
}
