
package fr.miblack.chess.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;
import fr.miblack.chess.joueurs.JoueurAbstract;

public class Graphique extends Interface
{
	private Partie		maPartie;
	private JFrame		maFrame;
	private JPanel		monJpanel;
	private JMenuBar	monJMenu;

	
	public Graphique( JoueurAbstract player1, JoueurAbstract player2 ) 
	{
		this.setMaPartie( new Partie( player1, player2 ) );
	}

	public Graphique() 
	{
		this.setMaFrame( creationDeFenetre() );
		this.setMaPartie( new Partie( player1, player2 ) );
	}

	/**
	 * 
	 * Initialise la fenetre de base
	 * @return laFrame crée
	 */
	public JFrame creationDeFenetre()
	{
		JFrame laFrame = new JFrame( "chessGame" );
		JPanel leJpanel = new JPanel( new BorderLayout() );
		this.monJMenu = new JMenuBar();
		JMenu menuPartie = new JMenu( "Partie" );
		JMenu menuHelp = new JMenu( "Help" );
		JMenu menuUnJoueur = new JMenu( "Un Joueur" );
		menuPartie.add( menuUnJoueur );
		monJMenu.add( menuPartie );
		monJMenu.add( menuHelp );
		laFrame.setBounds( 200, 100, 800, 600 );
		laFrame.setResizable( false );
		laFrame.add( monJMenu, BorderLayout.NORTH );
		leJpanel.setBackground( new Color( 123, 123, 123 ) );
		this.setMonJpanel( leJpanel );
		laFrame.add( leJpanel, BorderLayout.CENTER );
		laFrame.setVisible( true );
		laFrame.repaint();
		return laFrame;
	}

	public void jouerPartie()
	{
		
	}
	public Partie getMaPartie()
	{
		return maPartie;
	}

	public void afficherEchiquier()
	{
//		Echiquier myChessboard = maPartie.getMyChessboard();
	}

	public void setMaPartie( Partie maPartie )
	{
		this.maPartie = maPartie;
	}

	@Override
	public Coup jouerCoup( Partie g )
	{
		// TODO JouerCoup Graphique ... après !
		return null;
	}

	public JFrame getMaFrame()
	{
		return maFrame;
	}

	public void setMaFrame( JFrame maFrame )
	{
		this.maFrame = maFrame;
	}

	public JPanel getMonJpanel()
	{
		return monJpanel;
	}

	public void setMonJpanel( JPanel monJpanel )
	{
		this.monJpanel = monJpanel;
	}

	public JMenuBar getMonJMenu()
	{
		return monJMenu;
	}

	public void setMonJMenu( JMenuBar monJMenu )
	{
		this.monJMenu = monJMenu;
	}
}
