package fr.miblack.chess.affichage.GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import fr.miblack.chess.Partie;
import fr.miblack.chess.affichage.Graphique;
/**
 * @author mi-black
 *
 */
public class Fenetre extends JFrame
{
 	private static final long	serialVersionUID	= 2097605447320723308L;
	private JTextArea zoneSaisie=new JTextArea(1, 8);
	Partie maPartie;
	private JPanel monPanel=new JPanel( new BorderLayout() );
	private JPanel sud=new JPanel(new BorderLayout());
	private JPanel est=new JPanel(new BorderLayout());
	private JPanel nord=new JPanel(new BorderLayout());
	private JPanel ouest=new JPanel(new BorderLayout());
	private JButton boutonSend; 
	private PanneauAffichageJoueur panneauAffichage;
	private JMenuBar jmenu=new JMenuBar();
	private JMenuItem save=new JMenuItem("Sauvegarder");
	private JMenuItem load=new JMenuItem("Charger");
	/**
	 * le texte de la liste des coups
	 */
	public static JTextArea msg;
	/**
	 * le texte de  la liste des coups jouables
     */
	public static JTextArea txt;

	private TextPanel listeCoup=new TextPanel();
	private TextPanel2 listeCoupJouable=new TextPanel2();
	JMenuItem tips = new JMenuItem("Astuces");

	private EchiquierGraphique monEchiquier;
	private String chaine;

/**
 * @param maPartie
 */
	public Fenetre(Partie maPartie)
	{
		this.maPartie=maPartie;
		monEchiquier=new EchiquierGraphique(maPartie);
		initialiserFenetre();
	}


	/**
	 * Cette fonction initialise la fenetre pour la rendre utilisable , ajout 
	 * des Listeners & des Panels
	 * @author mi-black
	 */
	public void	initialiserFenetre()
	{
		setTitle("chessGame");
		setSize(800, 600);

		boutonSend= new JButton( "Envoyer" );
		boutonSend.addActionListener( new BoutonListener() );
		monPanel.setBackground( new Color( 125, 125, 125 ) );
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nord.setSize( 20, 400 );
		panneauAffichage=new PanneauAffichageJoueur(this.maPartie);
		nord.add(panneauAffichage ,BorderLayout.CENTER );
		save.addActionListener( new SauvegarderPartie() );
		jmenu.add( save );	
		load.addActionListener( new ChargerPartie() );
		jmenu.add( load );
		tips.addActionListener( new AfficherAstuce() );
		jmenu.add( tips );

		nord.add(jmenu ,BorderLayout.WEST );
		est.add( listeCoup );
		ouest.add( listeCoupJouable );
		listeCoup.setFocusable( false );
		listeCoupJouable.setFocusable( false );

		setResizable(false);
		zoneSaisie.addKeyListener( new ClavierListener() );
		sud.add(boutonSend,BorderLayout.EAST );
		sud.add(zoneSaisie,BorderLayout.WEST );
		zoneSaisie.setFocusable( true );
		monPanel.add( est,BorderLayout.EAST  );
		monPanel.add( ouest,BorderLayout.WEST  );
		monPanel.add( nord ,BorderLayout.NORTH);
		monPanel.add(monEchiquier,BorderLayout.CENTER);
		monPanel.add( sud ,BorderLayout.SOUTH);
		setContentPane( monPanel );
		setVisible(true);
		zoneSaisie.requestFocus();
	}


/**
 * @return
 */
	public EchiquierGraphique getMonEchiquier()
	{
		return monEchiquier;
	}
/**
 * @param monEchiquier
 */
	public void setMonEchiquier( EchiquierGraphique monEchiquier )
	{
		this.monEchiquier = monEchiquier;
	}
/**
 * @return
 */
	public JTextArea getZoneSaisie()
	{
		return zoneSaisie;
	}
/**
 * @param zoneSaisie
 */
	public void setZoneSaisie( JTextArea zoneSaisie )
	{
		this.zoneSaisie = zoneSaisie;
	}
/**
 * @return
 */
	public Partie getMaPartie()
	{
		return maPartie;
	}
/**
 * @param maPartie
 */
	public void setMaPartie( Partie maPartie )
	{
		this.maPartie = maPartie;
	}
/**
 * @return
 */
	public JPanel getMonPanel()
	{
		return monPanel;
	}
/**
 * @param monPanel
 */
	public void setMonPanel( JPanel monPanel )
	{
		this.monPanel = monPanel;
	}
/**
 * @return
 */
	public JPanel getSud()
	{
		return sud;
	}
/**
 * @param sud
 */
	public void setSud( JPanel sud )
	{
		this.sud = sud;
	}
/**
 * @return
 */
	public JButton getBoutonSend()
	{
		return boutonSend;
	}
/**
 * @param boutonSend
 */
	public void setBoutonSend( JButton boutonSend )
	{
		this.boutonSend = boutonSend;
	}

	/**
	 * @return
	 */
	public String getChaine()
	{
		return chaine;
	}

	/**
	 * @param chaine
	 */
	public void setChaine( String chaine )
	{
		this.chaine = chaine;
	}

	/**
	 * @return
	 */
	public JPanel getNord()
	{
		return nord;
	}

	/**
	 * @return
	 */
	public PanneauAffichageJoueur getPanneauAffichage()
	{
		return panneauAffichage;
	}

	/**
	 * @param panneauAffichage
	 */
	public void setPanneauAffichage( PanneauAffichageJoueur panneauAffichage )
	{
		this.panneauAffichage = panneauAffichage;
	}

	/**
	 * @param nord
	 */
	public void setNord( JPanel nord )
	{
		this.nord = nord;
	}

	/**
	 * @return
	 */
	public JPanel getEst()
	{
		return est;
	}

	/**
	 * @param est
	 */
	public void setEst( JPanel est )
	{
		this.est = est;
	}


/**
 * @return
 */
	public JMenuItem getSave()
	{
		return save;
	}

	/**
	 * @param save
	 */
	public void setSave( JMenuItem save )
	{
		this.save = save;
	}

	/**
	 * @return
	 */
	public JTextArea getMsg()
	{
		return msg;
	}

	/**
	 * @param msg
	 */
	@SuppressWarnings( "static-access" )
	public void setMsg( JTextArea msg )
	{
		this.msg = msg;
	}

	/**
	 * @return
	 */
	public JTextArea getTxt()
	{
		return txt;
	}

	/**
	 * @param msg
	 */
	@SuppressWarnings( "static-access" )
	public void setTxt( JTextArea msg )
	{
		this.txt = msg;
	}
	
	/**
	 * @return
	 */
	public Fenetre clone()
	{
		//return null;
		return new Fenetre(this.maPartie.clone());
	}

	/**
	 * @return
	 */
	public JPanel getOuest()
	{
		return ouest;
	}

/**
 * @param ouest
 */
	public void setOuest( JPanel ouest )
	{
		this.ouest = ouest;
	}
	/**
	 * @return
	 */
	public TextPanel2 getListeCoupJouable()
	{
		return listeCoupJouable;
	}

	/**
	 * @param listeCoupJouable
	 */
	public void setListeCoupJouable( TextPanel2 listeCoupJouable )
	{
		this.listeCoupJouable = listeCoupJouable;
	}

	/**
	 * Le Listeners de boutonSend , implemente les actions claviers & l'appui sur le bouton à la souris
	 * @author mi-black
	 */
	class BoutonListener implements ActionListener,KeyListener
	{ 
		public void actionPerformed(ActionEvent e) 
		{
			setChaine(getZoneSaisie().getText());
			getZoneSaisie().setText ("");
		}


		@Override
		public void keyPressed( KeyEvent e )
		{
			if(isFocused())
			{
				if(e.getKeyCode()==10)
				{
					setChaine(getZoneSaisie().getText());
					getZoneSaisie().setText ("");
				}
			}

		}

		@Override
		public void keyReleased( KeyEvent e )
		{
			if(e.getKeyCode()==10)
				getZoneSaisie().setText( "" );
		}

		@Override
		public void keyTyped( KeyEvent e )
		{
			if(e.getKeyCode()==10)
				getZoneSaisie().setText( "" );
		}

	}


	/**
	 * Le Listeners de zoneSaisie , implemente les actions claviers 
	 * @author mi-black
	 */
	class ClavierListener implements KeyListener
	{
		public void keyPressed(KeyEvent event) 
		{
			if(event.getKeyCode()==10)
			{
				setChaine(getZoneSaisie().getText());
				getZoneSaisie().setText( "" );
			}
		}

		public void keyReleased(KeyEvent event) 
		{
			if(event.getKeyCode()==10)
				getZoneSaisie().setText( "" );
		}


		public void keyTyped(KeyEvent event) 
		{
			if(event.getKeyCode()==10)
				getZoneSaisie().setText( "" );
		}
	}  

	/**
	 * Le Listeners du bouton de Chargement ,implemente l'appui sur le bouton à la souris et donc propose un chargement via un popup
	 * @author mi-black
	 */
	class ChargerPartie implements ActionListener
	{
		@Override
		public void actionPerformed( ActionEvent e )
		{     		
			Thread t2 = new Thread(new Runnable(){
				@SuppressWarnings( "static-access" )
				public void run(){
					JOptionPane jop2 = new JOptionPane();
					jop2.showMessageDialog(null, " Attention ! Cette opération est a vos riques et périls , le chargement n'est pas 100% fonctionnel", "Chargement : prévention", JOptionPane.WARNING_MESSAGE);
				}
			});
			t2.run();
			String nom_svg = JOptionPane.showInputDialog(null, "Entrez le nom du fichier à charger", "Chargement Partie", JOptionPane.QUESTION_MESSAGE);

			if(nom_svg == null)
			{
				return;
			}
			if(maPartie != null)
			{
				maPartie.loadGame(nom_svg, ((Graphique )maPartie.getPlayerEnCours().getMyInterface()).clone());
				getMonPanel().repaint();
			}
		}
	}

	/**
	 * Le Panel definissant la zone de liste des coups joués
	 * @author mi-black
	 */
	class TextPanel extends JPanel {
		private static final long serialVersionUID = 6836268484606084938L;

		public TextPanel() {
			super();

			// bordure..
			setBorder(BorderFactory.createLineBorder(Color.gray));

			msg = new JTextArea(34, 5);
			msg.setLineWrap(true);
			msg.setBackground( new Color( 238,238,238 ) );
			msg.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(msg);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			msg.setEditable(false);
			add(scrollPane);
		}

	}
	
	/**
	 * Le Panel definissant la zone de liste des coups jouables
	 * @author mi-black
	 */
	class TextPanel2 extends JPanel {
		private static final long serialVersionUID = 6836268484606084938L;

		public TextPanel2() {
			super();
			// bordure..
			setBorder(BorderFactory.createLineBorder(Color.gray));
			
			txt = new JTextArea(34, 10);
			txt.setBackground( new Color( 238,238,238 ) );
			txt.setLineWrap(true);
			txt.setWrapStyleWord(true);
			JScrollPane scrollPane = new JScrollPane(txt);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			txt.setEditable(false);
			add(scrollPane);
		}
	}
	/**
	 * Le Listeners du bouton de Sauvegarde ,l'appui sur le bouton à la souris et donc propose une sauvegarde via un popup
	 * @author mi-black
	 */
	class SauvegarderPartie implements ActionListener
	{
		@Override
		public void actionPerformed( ActionEvent e )
		{     		
			String nom_svg = JOptionPane.showInputDialog(null, "Entrez le nom du fichier de sauvegarde", "Sauvegarder Partie", JOptionPane.QUESTION_MESSAGE);

			if(nom_svg == null)
			{
				return;
			}
			if(maPartie != null)
			{
				maPartie.saveGame(nom_svg);
			}
		}
	}
	
	/**
	 * Le Listeners du bouton d'astuce ,implemente l'appui sur le bouton à la souris et donc propose une série d'astuce
	 * @author mi-black
	 */
	class AfficherAstuce implements ActionListener
	{    
		int x = 1;

		@Override
		public void actionPerformed( ActionEvent e )
		{           
			int y = 1;
			x=y;
			if (e.getSource() == tips) {
				String[] choix1 = {  "Ok", "Suivant >>"};
				int reponse = 0;
				do {
					reponse = JOptionPane.showOptionDialog(null,
							astuce(),
							"Astuce n°" + x,
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							choix1,
							choix1[0]);

					if (reponse == 1)
						x++;
				} while (reponse != 0 && x<=14);
			}
		}
		/**
		 * @return la chaine correspondant a l'astuce en cours
		 */
		public String astuce() {

			switch (x) {


				case 1:
					return "Programmation & Conception Graphique par John Lebouteiller aka Mi-black \nDistribués sous license BSD.";
				case 2:
					return "Le Pion :\nLe pion ne se déplace que vers le camp ennemi.\nMouvements :\n"
					+ "⬚  ⬚  ⬚  ⬚  ⬚\n"
					+ "⬚  ⬚  ⬚  ⬚  ⬚\n"
					+ "⬚  ⬚  ⬓  ⬚  ⬚\n"
					+ "⬚  ⬚  ■  ⬚  ⬚\n"
					+ "⬚  ⬚  ♟  ⬚  ⬚\n"
					+ "Le pion peut avancer d'une case supplémentaire pour son 1er mouvement.\n"
					+ "Le pion prend uniquement en diagonale .";
				case 3:
					return "Le Cavalier :\nMouvements :\n"
					+ "⬚  ■  ⬚  ■  ⬚\n"
					+ "■  ⬚  ⬚  ⬚  ■\n"
					+ "⬚  ⬚  ♞  ⬚  ⬚\n"
					+ "■  ⬚  ⬚  ⬚  ■\n"
					+ "⬚  ■  ⬚  ■  ⬚\n";
				case 4:
					return "Le Fou :\nMouvements :\n"
					+ "■  ⬚  ⬚  ⬚  ■\n"
					+ "⬚  ■  ⬚  ■  ⬚\n"
					+ "⬚  ⬚  ♝  ⬚  ⬚\n"
					+ "⬚  ■  ⬚  ■  ⬚\n"
					+ "■  ⬚  ⬚  ⬚  ■\n";
				case 5:
					return "La Tour:\nMouvements :\n"
					+ "⬚  ⬚  ■  ⬚  ⬚\n"
					+ "⬚  ⬚  ■  ⬚  ⬚\n"
					+ "■  ■  ♜  ■  ■\n"
					+ "⬚  ⬚  ■  ⬚  ⬚\n"
					+ "⬚  ⬚  ■  ⬚  ⬚\n";
				case 6:
					return "La Dame :\nMouvements :\n"
					+ "■  ⬚  ■  ⬚  ■\n"
					+ "⬚  ■  ■  ■  ⬚\n"
					+ "■  ■  ♛  ■  ■\n"
					+ "⬚  ■  ■  ■  ⬚\n"
					+ "■  ⬚  ■  ⬚  ■\n";
				case 7:
					return "Le ROI :\nMouvements :\n"
					+ "⬚  ⬚  ⬚  ⬚  ⬚\n"
					+ "⬚  ■  ■  ■  ⬚\n"
					+ "⬚  ■  ♚  ■  ⬚\n"
					+ "⬚  ■  ■  ■  ⬚\n"
					+ "⬚  ⬚  ⬚  ⬚  ⬚\n";

				case 8:
					return "Le roque permet de déplacer 2 pièces\n (Roi+Tour) en un seul coup !";
				case 9:
					return "Vous ne pouvez pas passer votre tour aux échecs,\n une pièce doit obligatoirement être déplacée.\nDans le cas contraire cela entraînne une perte de la partie";
				case 10:
					return "One does not simply beat BIG BLUE";
				case 11:
					return "Une partie peut être déclarée nulle dans les cas suivants :\n"
					+ "◉ Accord mutuel entre les deux joueurs.\n"
					+ "◉ 3e répétition d'un même coup.\n"
					+ "◉ 50 coups sans prise.\n"
					+ "◉ Impossibilité de mater (manque de pièces en général).\n"
					+ "◉ Lors d'un pat.\n";

				case 12:
					return "Le saviez-vous ? Seize échiquier comporte 16*8*8 = 16*64 cases !";
				case 13:
					return "La promotion d'un pion arrivé en haut (ou en bas)\n de l'échiquier est obligatoire.\nElle peut se faire en\n"
					+ "◉ Reine - ♛ ♕\n"
					+ "◉ Tour - ♜ ♖\n"
					+ "◉ Fou - ♝ ♗\n"
					+ "◉ Cavalier - ♞ ♘\n";

				default:
					x = 0;
					return "Vous avez lu toutes les astuces !\nSuccès débloqué : <L'Astuce est avec moi !>";
			}
		}
	}
}
