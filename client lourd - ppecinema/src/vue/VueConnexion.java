package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Utilisateur;

public class VueConnexion extends JFrame implements ActionListener, KeyListener {
	//panel Connexion
		private JPanel panelCon = new JPanel();
		private JTextField txtEmail = new JTextField();
		private JPasswordField txtMdp = new JPasswordField();
		private JButton btAnnuler = new JButton("Annuler");
		private JButton btSeConnecter = new JButton("Se Connecter");
		
		//panel Menu
		private JPanel panelMenu = new JPanel();
		private JButton btUtilisateur = new JButton("Gerer les Utilisateurs");
		private JButton btFilm = new JButton("Gerer les Films");
		private JButton btComment = new JButton("Gerer les Commentaires");
		private JButton btHoraire = new JButton("Gerer les Horaires");
		private JButton btQuitter = new JButton("Quitter");
		
		public VueConnexion() {
			this.setTitle("Connexion a l'application Film");
			this.setBounds(200, 200, 700, 320);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.getContentPane().setBackground(new Color (128, 128, 128));
			this.setLayout(null);
			
			//insertion du logo
			ImageIcon uneImage = new ImageIcon("src/images/cinema.PNG");
			JLabel monLogo = new JLabel(uneImage);
			monLogo.setBounds(10, 20, 300, 250);
			this.add(monLogo);
			
			//insertion du pannel Connexion
			this.panelCon.setBounds(320, 50, 350, 200);
			this.panelCon.setBackground(new Color (128, 128, 128));
			this.panelCon.setLayout(new GridLayout(3, 2));
			
			this.panelCon.add(new JLabel("Email : "));
			this.panelCon.add(this.txtEmail);
			this.panelCon.add(new JLabel("MDP : "));
			this.panelCon.add(this.txtMdp);
			this.panelCon.add(this.btAnnuler);
			this.panelCon.add(this.btSeConnecter);
			
			//insertion du panel dans al fenetre
			this.add(this.panelCon);
			
			//rendre les boutons ecoutables
			this.btAnnuler.addActionListener(this);
			this.btSeConnecter.addActionListener(this);
			
			//rendre les TXT ecoutables sur frappe de touche
			this.txtEmail.addKeyListener(this);
			this.txtMdp.addKeyListener(this);
			
			//construction du panel 
			this.panelMenu.setBounds(320, 50, 350, 200);
			this.panelMenu.setBackground(new Color (128, 128, 128));
			this.panelMenu.setLayout(new GridLayout(5, 1));
			this.panelMenu.add(this.btUtilisateur);
			this.panelMenu.add(this.btFilm);
			this.panelMenu.add(this.btComment);
			this.panelMenu.add(this.btHoraire);
			this.panelMenu.add(this.btQuitter);
			this.panelMenu.setVisible(false);
			this.add(this.panelMenu);
			
			//rendre les boutons du panel Menu �coutable
			this.btUtilisateur.addActionListener(this);
			this.btFilm.addActionListener(this);
			this.btComment.addActionListener(this);
			this.btHoraire.addActionListener(this);
			this.btQuitter.addActionListener(this);
			
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.btAnnuler) {
				this.txtEmail.setText("");
				this.txtMdp.setText("");
			}else if (e.getSource() == this.btSeConnecter) {
				this.traitement();
			}else if (e.getSource() ==  this.btQuitter) {
				int retour = JOptionPane.showConfirmDialog(this, "voulez-vous quitter l'application ?", 
						"Quitter l'application", JOptionPane.YES_NO_OPTION);
				if (retour == 0) {
					this.txtEmail.setText("");
					this.txtMdp.setText("");
					this.panelCon.setVisible(true);
					this.panelMenu.setVisible(false);
				}
			}else if (e.getSource() == this.btUtilisateur) {
				//on cache la fenetre de connexion et on ouvre la fenetre des salri�s
				Main.rendreVisible(false);
				Main.instancierVueUtilisateur();
			}else if (e.getSource() == this.btFilm) {
				//on cache la fenetre de connexion et on ouvre la fenetre des salri�s
				Main.rendreVisible(false);
				Main.instancierVueFilm();
			}else if (e.getSource() == this.btComment) {
				//on cache la fenetre de connexion et on ouvre la fenetre des salri�s
				Main.rendreVisible(false);
				Main.instancierVueContact();
			}else if (e.getSource() == this.btHoraire) {
				//on cache la fenetre de connexion et on ouvre la fenetre des salri�s
				Main.rendreVisible(false);
				Main.instancierVueHoraire();
			}
		}

		public void traitement() {
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
			
			//on verifie dans la base de donn�es en passant par le controleur
			Utilisateur unUtilisateur = Main.selectWhereUtilisateur(email, mdp);
			if (unUtilisateur == null) {
				JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants !", "Erreur de connexion",
				JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "Bienvenue M/Mme "+ unUtilisateur.getNom() +"  " +unUtilisateur.getPrenom(),
						"Connexion réussite à Cinema", JOptionPane.INFORMATION_MESSAGE);
				this.panelCon.setVisible(false);
				this.panelMenu.setVisible(true);
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				this.traitement();
			}	
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
