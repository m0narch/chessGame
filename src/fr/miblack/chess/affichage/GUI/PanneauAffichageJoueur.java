package fr.miblack.chess.affichage.GUI;


import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.miblack.chess.Partie;
/**
 * @author mi-black
 *
 */
public class PanneauAffichageJoueur extends JPanel
{

	private static final long	serialVersionUID	= 407211498220803982L;
	private Partie	maPartie;
	JTextArea jtext=new JTextArea("...");

	/**
	 * @param maPartie
	 */
	public PanneauAffichageJoueur(Partie maPartie) 
	{
		this.setMaPartie( maPartie );
		this.add( jtext );
		jtext.setEditable( false );
	}

	/**
	 * @return
	 */
	public Partie getMaPartie()
	{
		return maPartie;
	}

	/**
	 * 
	 * @param maPartie
	 */
	public void setMaPartie( Partie maPartie )
	{
		this.maPartie = maPartie;
	}

	/**
	 * @return
	 */
	public JTextArea getJtext()
	{
		return jtext;
	}

	/**
	 * @param jtext
	 */
	public void setJtext( JTextArea jtext )
	{
		this.jtext = jtext;
	}
	/**
	 * param g
	 */
	@Override
	public void paintComponents( Graphics g )
	{
		jtext.setEditable( true );
		jtext.setText( "C'est au joueur " + maPartie.getPlayerEnCours().getType() + " "+ maPartie.getPlayerEnCours().toString() + " de jouer !" );
		jtext.setEditable( false );
	}
}
