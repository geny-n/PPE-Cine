package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.print.attribute.standard.NumberOfDocuments;
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
import controleur.Tableau;
import controleur.Contact;

public class VueContact extends JFrame implements ActionListener {
	private JButton btRetour = new JButton("Retour au Menu");
	
	//panel de saisi d'un salari�
	private JPanel panelAjout = new JPanel();
	private JTextField txtEmail = new JTextField();
	private JComboBox<String> cbxTypeDemande = new JComboBox<String>();
	private JTextField txtDescription = new JTextField();
	private int idcontact;
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrement = new JButton("Enregistrer");
	
	//panel d'affichage des films
	private JPanel panelLister = new JPanel();
	private JTable uneTable;
	private JScrollPane uneScroll;
	private Tableau unTableau ;
	
	//rechercher par mot cl�
	private JTextField txtMot = new JTextField();
	private JButton btFilter = new JButton("Filtrer");
	
	public VueContact() {
		this.setTitle("Connexion des commentaires au cinéma");
		this.setBounds(200, 200, 1200, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color (128, 128, 128));
		this.setLayout(null);
		
		this.btRetour.setBounds(1000, 520, 130, 20);
		this.add(this.btRetour);
		this.btRetour.addActionListener(this);
		
		//construction du Panel Ajout 
		this.panelAjout.setBounds(20, 100, 300, 300);
		this.panelAjout.setBackground(new Color(128,128,128));
		this.panelAjout.setLayout(new GridLayout(4, 2));
		
		this.panelAjout.add(new JLabel("Email :"));
		this.panelAjout.add(this.txtEmail);
		this.panelAjout.add(new JLabel("Type de demande :"));
		this.panelAjout.add(this.cbxTypeDemande);
		this.panelAjout.add(new JLabel("Description :"));
		this.panelAjout.add(this.txtDescription);
		
		this.panelAjout.add(this.btAnnuler);
		this.panelAjout.add(this.btEnregistrement);
		this.add(this.panelAjout);
		
		//rendre les boutons cliquables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrement.addActionListener(this);
		
		//installation du panel lister
		this.panelLister.setBounds(370, 60, 800, 360);
		this.panelLister.setBackground(new Color(128,128,128));
		this.panelLister.setLayout(null);
		
		String entetes [] = {"Id Contact","Email","Type de demande","Description"};		
		//instanciation de la classe tableau avec les entetes et les donn�es
		this.unTableau =new Tableau(entetes, this.remplirDonnees(""));
		
		//instanciation de la JTable avec le Tableau construit
		this.uneTable = new JTable(this.unTableau);
		
		//je met ma table dans ma scroll 
		this.uneScroll = new JScrollPane(this.uneTable);
		this.uneScroll.setBounds(0, 0, 800, 800);
		this.panelLister.add(this.uneScroll);
		
		this.add(this.panelLister);
		
		//remplir combobox de statut et type
		this.cbxTypeDemande.addItem("Bug technique");
		this.cbxTypeDemande.addItem("Erreur de séance");
		this.cbxTypeDemande.addItem("Suggerer une amélioration");
		this.cbxTypeDemande.addItem("Signaler un abus");
		
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
					int retour = JOptionPane.showConfirmDialog(null, "Confirmez la suppresion","Suppression", JOptionPane.YES_NO_OPTION);
					if (retour == 0) {						
						//on r�cup�re l'ID du salari� a supp
						int idcontact = Integer.parseInt(unTableau.getValueAt(ligne,0).toString());
						
						//on supprime dans la BDD via le modele
						Main.deleteContact(idcontact);
						
						//suppression de la ligne de l'affichage
						unTableau.supprimerLigne(ligne);
					}
				}else if (e.getClickCount()==1) {
					int ligne = uneTable.getSelectedRow();
					txtEmail.setText(unTableau.getValueAt(ligne,1).toString());
					// pas de modif pour le prochainement
					txtDescription.setText(unTableau.getValueAt(ligne,3).toString());
					btEnregistrement.setText("Modifier");
				}
			}
		});
		
		//placement zone de recherche 
		this.txtMot.setBounds(400, 30, 140, 20);
		this.add(this.txtMot);
		this.btFilter.setBounds(580, 30, 100, 20);
		this.add(this.btFilter);
		this.btFilter.addActionListener(this);
		
		this.setVisible(true);
	}
	
	public Object [][] remplirDonnees (String mot){
		//cette m�thode transforme l'ArrayList des contacts en une matrice
		ArrayList<Contact> lesContacts = Main.selectAllContact(mot);
		Object [][] matrice = new Object [lesContacts.size()][4];
		int i = 0;
		for (Contact unContact : lesContacts) {
			matrice [i][0] = unContact.getIdcontact();
			matrice [i][1] = unContact.getEmail();
			matrice [i][2] = unContact.getTypedemande();
			matrice [i][3] = unContact.getDescription();
			i ++ ;
		}
		return matrice ;
	} 
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btRetour) {
			this.dispose(); // je detruit la vue actuelle
			// et je rend visible la vue connexion avec son menu
			Main.rendreVisible(true);
		}else if (e.getSource() == this.btAnnuler){
			this.viderChamps ();
		}else if (e.getSource() == this.btEnregistrement && e.getActionCommand().equals("Enregistrer")) {
			String email = this.txtEmail.getText();
			String typedemande = this.cbxTypeDemande.getSelectedItem().toString();
			String description = this.txtDescription.getText();
			
			//instanciation du film 
			Contact unContact = new Contact (email, typedemande, description);
			
			//insertion dans la base de donn�es
			Main.insertContact(unContact);
			
			//recuperation de k'ID film affecte par le SGBD
			unContact = Main.selectWhereContact(typedemande);
			
			//actualiser l'affichage 
			Object[] ligne = {unContact.getIdcontact(),email, typedemande, description};
			this.unTableau.ajouterLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Insertion réussie dans la base de données");
			this.viderChamps();
		}else if (e.getSource() == this.btEnregistrement && e.getActionCommand().equals("Modifier")) {
			String email = this.txtEmail.getText();
			String typedemande = this.cbxTypeDemande.getSelectedItem().toString();
			String description = this.txtDescription.getText();
			
			//recuperer l'ID du film
			 int numero = this.uneTable.getSelectedRow();
			 int idContact = Integer.parseInt(this.unTableau.getValueAt(numero, 0).toString());
			Contact unContactId = Main.selectWhereContact(idContact);
			
			//instanciation du film 
			Contact unContact = new Contact(unContactId.getIdcontact(), email, typedemande, description);

			//mise a jour dans la base de donn�es
			Main.updateContact(unContact);
			
			 
			
			//actualiser l'affichage 
			Object[] ligne = {unContactId.getIdcontact(),email, typedemande, description};
			this.unTableau.modifierLigne(numero, ligne);
			
			JOptionPane.showMessageDialog(this, "Modification réussie dans la base de données");
			this.viderChamps();
			this.btEnregistrement.setText("Enregistrer");
		}else if (e.getSource() == this.btFilter) {
			String mot = this.txtMot.getText();
			this.unTableau.setDonnees(this.remplirDonnees(mot));
		}
		
	}
	
	public void viderChamps () {
		this.txtEmail.setText("");
		this.txtDescription.setText("");

		this.btEnregistrement.setText("Enregistrer");
	}
}

