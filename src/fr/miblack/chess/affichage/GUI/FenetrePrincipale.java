package fr.miblack.chess.affichage.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class FenetrePrincipale extends JFrame implements ActionListener
{
	

	public FenetrePrincipale() 
	{
		super();
		creationDeFenetre();
	}
	public void creationDeFenetre()
	{
		JPanel leJpanel = new JPanel( new BorderLayout() );
		JMenuBar monJMenu = new JMenuBar();
		JMenu menuPartie = new JMenu( "Partie" );
		JMenu menuHelp = new JMenu( "Help" );
		JMenu menuUnJoueur = new JMenu( "Un Joueur" );
		menuPartie.add( menuUnJoueur );
		monJMenu.add( menuPartie );
		monJMenu.add( menuHelp );
		setSize(800, 600 );
		setLocationRelativeTo(null);
		setResizable( false );
		add( monJMenu, BorderLayout.NORTH );
		leJpanel.setBackground( new Color( 123, 123, 123 ) );
		add( leJpanel, BorderLayout.CENTER );
		setVisible( true );
	}
	@Override
	public void actionPerformed( ActionEvent e )
	{
		// TODO Auto-generated method stub
	}

	
	
	
	
	public void quitter ()
	{
		System.exit ( 0 ) ;
	}

}
