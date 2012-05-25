
package fr.miblack.chess.affichage;

import java.awt.Color;
import java.util.ConcurrentModificationException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.miblack.chess.affichage.GUI.Fenetre;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.Coup;
import fr.miblack.chess.Echiquier;
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
	
	public Graphique(Partie partie) 
	{
		maPartie=partie;
	}
 
	
	
	public void jouerPartie()
	{
		Coup monCoup;
		boolean termine=false;
		while (!getMaPartie().isDraw()) 
		{
			try 
			{
				for ( JoueurAbstract p : this.getMaPartie().getListOfPlayer() )
				{
					maFenetre.getTxt().setText( "" );
					maFenetre.getTxt().append(maPartie.listOfAvailableMove( p ).toString());
					maFenetre.getPanneauAffichage().getJtext().setEditable( true );
					maFenetre.getPanneauAffichage().getJtext().setBackground( new Color( 238,238,238 ) );
					maFenetre.getPanneauAffichage().getJtext().setText( "C'est au joueur " + maPartie.getPlayerEnCours().getType() + " "+ maPartie.getPlayerEnCours().toString() + " de jouer !" );
					maFenetre.getPanneauAffichage().getJtext().setEditable( false );
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
							termine=true;
							//System.exit( 0);
							break;
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
							termine=true;
							break;
						}
					}
					monCoup = p.jouerCoup( this.getMaPartie() );
					maFenetre.getMsg().append(monCoup.toString()+"\n");

					this.getMaPartie().realiserCoup( monCoup );
					if ( getMaPartie().promotionPossible(  ) )
					{
						getMyChessboard().realiserPromotion( monCoup );
					}
					this.getMaPartie().setPlayerEnCours();
				}
			
			}catch(ConcurrentModificationException e)
			{
				e.getStackTrace();
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
			if(termine)
			{
				break;
			}
		}
	}

	public Partie getMaPartie()
	{
		return maPartie;
	}

	public void setMaPartie( Partie maPartie )
	{
		this.maPartie = maPartie;
	}

	public  Coup jouerCoup( Partie g )
	{
		JoueurAbstract p = g.getPlayerEnCours();
		Coup m;
		boolean mauvaisChoix = false;
		do
		{
			if ( mauvaisChoix )
			{
				Thread t2 = new Thread(new Runnable(){
					@SuppressWarnings( "static-access" )
					public void run()
					{
						JOptionPane jop2 = new JOptionPane();
						jop2.showMessageDialog(null, "Mauvais choix !", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				});
				t2.run();
			}
				m = this.saisirCoup( p, this.getMyChessboard() );

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
	
	public   Coup saisirCoup( JoueurAbstract p, Echiquier chess )
	{
		String strCoup = null;
		Coup monCoup = null;
		boolean trouve = false;

		while (trouve == false)
		{
			try
			{
				while(maFenetre.getChaine() == null)
				{
					Thread.sleep( 100 );
				}
				strCoup=maFenetre.getChaine();

			} catch (InterruptedException monExecption)
			{
				monExecption.printStackTrace();
			}
			try
			{
					maFenetre.setChaine( null );
					monCoup = Coup.parseStringToCoupCompl( strCoup, maPartie,p );
			} catch (RuntimeException e)
			{
				continue;
			}
			for ( Coup c : maPartie.listOfAvailableMove( p ) )
			{
				if ( monCoup.equals( c ) )
				{
					trouve = true;
					break;
				}
			}
		}
		return monCoup;
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
	
	@Override
	public Graphique clone()  
	{
		return new Graphique(maPartie.clone());
	}
 
}
