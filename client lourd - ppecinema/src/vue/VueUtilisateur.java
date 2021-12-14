package vue;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Utilisateur;
import controleur.Tableau;

public class VueUtilisateur extends JFrame implements ActionListener {
	
	private JButton btRetour = new JButton("Retour au menu");
	
	private JPanel panelAjout = new JPanel();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
    private JPasswordField txtConfirmation = new JPasswordField();
	private JTextField txtPost = new JTextField();
	private int idduutilisateur;
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	//panel d'affichage des salari�s
	private JPanel panelLister = new JPanel();
	private JTable uneTable;
	private JScrollPane uneScroll;
	private Tableau unTableau;
	
	//rechercher par mot 
	private JTextField txtMot = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");
	
	public VueUtilisateur () {
		this.setTitle("Gestion des Utilisateurs");
		this.setBounds(200, 200, 1200, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color (128, 128, 128));
		this.setLayout(null);
		
		this.btRetour.setBounds(1000, 520, 130, 20);
		this.add(this.btRetour);
		this.btRetour.addActionListener(this);
		
		//construction du Panel Ajout 
		
		this.panelAjout.setBounds(20, 30, 300, 500);
		this.panelAjout.setBackground(new Color(128,128,128));
		this.panelAjout.setLayout(new GridLayout(7,2));
		
		/*changement format text*/
		/*Font font = new Font("TimesRoman", Font.PLAIN, 20) ;
		JLabel l = new JLabel("Nom Pilote : ");
		l.setFont(font);
		this.panelAjout.add(l);	
		this.txtNom.setFont(font);
		this.panelAjout.add(this.txtNom);*/

		this.panelAjout.add(new JLabel("Nom utilisateur : "));
		this.panelAjout.add(this.txtNom);
		this.panelAjout.add(new JLabel("Prenom utilisateur : "));
		this.panelAjout.add(this.txtPrenom);
		this.panelAjout.add(new JLabel("email : "));
		this.panelAjout.add(this.txtEmail);
		this.panelAjout.add(new JLabel("mdp : "));
		this.panelAjout.add(this.txtMdp);
		this.panelAjout.add(new JLabel("confirmation : "));
		this.panelAjout.add(this.txtConfirmation);
		this.panelAjout.add(new JLabel("post : "));
		this.panelAjout.add(this.txtPost);   
		
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
		
		String entetes [] = {"Id Utilisateur", "Nom", "Prenom", "Email", "Mdp", "Confirmation", "Post"};
		
		//instanciation de la classe tableau avec les entetes et les donnees
		this.unTableau = new Tableau (entetes, this.remplirDonnees(""));
	
		//instanciation de la JTable avec le tableau construit 
		this.uneTable = new JTable(this.unTableau);
		
		//je mets ma table dans ma scroll
		this.uneScroll = new JScrollPane(this.uneTable);
		this.uneScroll.setBounds(0, 0, 800, 800);
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
						//on recupere l'id du salarie a supprimer
						int idutilisateur = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString());
						//on supprime dans la bdd via le modele
						Main.deleteUtilisateur(idutilisateur);
						//suppression de la ligne de l'affichage 
						unTableau.supprimerLigne(ligne);
					}
				}else if (e.getClickCount() == 1) {
					int ligne = uneTable.getSelectedRow();
					idduutilisateur = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString());
					txtNom.setText(unTableau.getValueAt(ligne, 1).toString());
					txtPrenom.setText(unTableau.getValueAt(ligne, 2).toString());
					txtEmail.setText(unTableau.getValueAt(ligne, 3).toString());
					txtMdp.setText(unTableau.getValueAt(ligne, 4).toString());
					txtConfirmation.setText(unTableau.getValueAt(ligne, 5).toString());
					txtPost.setText(unTableau.getValueAt(ligne, 6).toString());
					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		//placement zone de recherche
		this.txtMot.setBounds(400, 30, 140, 20);
		this.add(this.txtMot);
		this.btFiltrer.setBounds(580, 30, 100, 20);
		this.add(this.btFiltrer);
		this.btFiltrer.addActionListener(this);
		
		this.setVisible(true);
	}

	public Object [][] remplirDonnees (String mot){
		//cette m�thode transforme l'ArrayList des salaries
		//en une matrice 
		
		ArrayList<Utilisateur> lesUtilisateurs = Main.selectAllUtilisateur(mot);
		Object [][] matrice = new Object[lesUtilisateurs.size()][7];
		int i = 0;
		for (Utilisateur unUtilisateur : lesUtilisateurs)
		{
			matrice [i][0] = unUtilisateur.getIdutilisateur();
			matrice [i][1] = unUtilisateur.getNom();
			matrice [i][2] = unUtilisateur.getPrenom();
			matrice [i][3] = unUtilisateur.getEmail();
			matrice [i][4] = unUtilisateur.getMdp();
			matrice [i][5] = unUtilisateur.getConfirmation();
			matrice [i][6] = unUtilisateur.getPoste();			
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
			String nom = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String email = this.txtEmail.getText();
            String mdp = new String (this.txtMdp.getPassword());
			String confirmation = new String (this.txtConfirmation.getPassword());
			String post = this.txtPost.getText();			
			
			//Instanciation du salarie 
			Utilisateur unUtilisateur = new Utilisateur (nom, prenom, email, mdp, confirmation, post);
			
			//insertion dans la bdd
			Main.insertUtilisateur(unUtilisateur);
			
			//recuperation de l'ID salarie affecte par le SGBD
			unUtilisateur = Main.selectWhereUtilisateur(email, mdp);
			
			//actualiser l'affichage 
			Object [] ligne = {unUtilisateur.getIdutilisateur(), nom, prenom, email, mdp, confirmation, post};
			this.unTableau.ajouterLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Insertion reussie dans la Base de donnees");
			this.viderChamps();
		}else if (e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier")) {
			String nom = this.txtNom.getText();
			String prenom = this.txtPrenom.getText();
			String email = this.txtEmail.getText();
            String mdp = new String (this.txtMdp.getPassword());
			String confirmation = new String (this.txtConfirmation.getPassword());
			String post = this.txtPost.getText();
			
			//recup�rer l'id du salari�
			//Pilote unPiloteId = Main.selectWherePilote(email, mdp);
			
			//Instanciation du salarie 
			Utilisateur unUtilisateur = new Utilisateur(idduutilisateur, nom, prenom, email, mdp, confirmation, post);
			
			//maj dans la bdd
			Main.updateUtilisateur(unUtilisateur);
			
			//recuperer numero de ligne
			int numero = this.uneTable.getSelectedRow();
			
			//actualiser l'affichage 
			Object [] ligne = {idduutilisateur, nom, prenom, email, mdp, confirmation, post};
			this.unTableau.modifierLigne(numero, ligne);
			
			JOptionPane.showMessageDialog(this, "Modification reussie dans la Base de donnees");
			this.viderChamps();
			this.btEnregistrer.setText("Enregistrer");

		}else if (e.getSource() == this.btFiltrer) {
			String mot = this.txtMot.getText();
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		
	}
	
	public void viderChamps() {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtConfirmation.setText("");
		this.txtPost.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
}
