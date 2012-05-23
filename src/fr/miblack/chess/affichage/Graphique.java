
package fr.miblack.chess.affichage;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.miblack.chess.affichage.GUI.Fenetre;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;

public class Graphique extends Interface
{
	private Fenetre maFenetre=null ;
	private JPanel monPanel;
	private JOptionPane jop1 = new JOptionPane();
	
	public Graphique( String p1, String p2 ) 
	{
		menuLocal( p1, p2 );
		setMaFenetre( new Fenetre(getMaPartie()) );
		this.setMonPanel( (JPanel) maFenetre.getContentPane() );
	}

	public Graphique() 
	{
		menuPrincipal();
		setMaFenetre( new Fenetre(getMaPartie()) );
		this.setMonPanel( (JPanel) maFenetre.getContentPane() );
	}
	
	
	public void afficherEvenement(String event)
	{
		JDialog dialog = new JDialog();
		dialog.setSize(300, 200);//On lui donne une taille
		dialog.setTitle(event); 
		dialog.setLocationRelativeTo(null);
		dialog.add( new JLabel(event),BorderLayout.CENTER);
		dialog.setVisible(true);//On la rend visible
		
	}
	
	public void jouerPartie()
	{
		Coup monCoup;
		while (!getMaPartie().isDraw()) 
		{
			for ( JoueurAbstract p : this.getMaPartie().getListOfPlayer() )
			{
				this.maFenetre.getMonEchiquier().repaint();
				if ( getMaPartie().estEnEchec( p ) )
				{
					if ( getMaPartie().estEchecEtMat( p ) )
					{
						Thread t2 = new Thread(new Runnable(){
							@SuppressWarnings( "static-access" )
							public void run(){
								JOptionPane jop2 = new JOptionPane();
								jop2.showMessageDialog(null, "Le roi de "+ getMaPartie().getPlayerEnCours()+ " est echecs et mat !", "Fin de Partie", JOptionPane.WARNING_MESSAGE);
							}
						});
						t2.run();
						proposerSave(maPartie);
						System.exit( 0);
					}
 
				}
				else
				{
					if ( getMaPartie().estPat( p ) )
					{
						Thread t2 = new Thread(new Runnable(){
							@SuppressWarnings( "static-access" )
							public void run(){
								JOptionPane jop2 = new JOptionPane();
								jop2.showMessageDialog(null, "Le roi de "+ getMaPartie().getPlayerEnCours()+ " est pat !", "Fin de Partie", JOptionPane.WARNING_MESSAGE);
							}
						});
						t2.run();

						proposerSave(maPartie);
						System.exit( 0);
					}
				}
				System.out.println( this.getMaPartie().listOfAvailableMove( p ) );
				System.out.println( "C'est au joueur " + p.getType() + " "+ p.toString() + " de jouer !" );
				Thread t2 = new Thread(new Runnable(){
					public void run(){
				//		getMaFenetre().getZoneSaisie().getText();
					}
				});
				t2.run();
				monCoup = p.jouerCoup( this.getMaPartie() );

				this.getMaPartie().realiserCoup( monCoup );
				if ( getMaPartie().promotionPossible( getMyChessboard() ) )
				{
					getMyChessboard().realiserPromotion( monCoup );
				}
				this.getMaPartie().setPlayerEnCours();
			}
		}
		if ( getMaPartie().isDraw() )
		{
			Thread t2 = new Thread(new Runnable(){
				@SuppressWarnings( "static-access" )
				public void run(){
					JOptionPane jop2 = new JOptionPane();
					jop2.showMessageDialog(null, "Fin de partie , partie nulle", "Fin de Partie", JOptionPane.WARNING_MESSAGE);
				}
			});
			t2.run();

		}
		proposerSave(maPartie); 
	}

	
	
	private void proposerSave( Partie maPartie )
	{
		//TODO faire une popup proposant la save
	}

	public Partie getMaPartie()
	{
		return maPartie;
	}

	public void setMaPartie( Partie maPartie )
	{
		this.maPartie = maPartie;
	}

	public Coup jouerCoup( Partie g )
	{
		JoueurAbstract p = g.getPlayerEnCours();
		Coup m;
		boolean mauvaisChoix = false;
		do
		{
			if ( mauvaisChoix )
			{
				System.out.println( "Mauvais choix de coup" );
			}
			m = saisirCoup( p, this.getMyChessboard() );
			if(m.getRoque()==true)
			{
				break;
			}
			if ( g.seraEnEchec( m.getPosDepart().clone(), m.getPosArrivee().clone() ) )
			{
				mauvaisChoix = true;
			}
			else
				mauvaisChoix = false;
		} while (mauvaisChoix);

		return m;
	}

	public Fenetre getMaFenetre()
	{
		return maFenetre;
	}

	public void setMaFenetre( Fenetre maFenetre )
	{
		this.maFenetre = maFenetre;
	}

	public JPanel getMonPanel()
	{
		return monPanel;
	}

	public void setMonPanel( JPanel monPanel )
	{
		this.monPanel = monPanel;
	}

	public JOptionPane getJop1()
	{
		return jop1;
	}

	public void setJop1( JOptionPane jop1 )
	{
		this.jop1 = jop1;
	}
 
}
