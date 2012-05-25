
package fr.miblack.chess.joueurs;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;
import fr.miblack.chess.affichage.Interface;
import fr.miblack.chess.color.Couleur;

/**
 * @author mi-black
 */
public class JoueurHumain extends JoueurAbstract
{

	/**
	 * @param p1
	 * @param a la couleur
	 * @param monInterface
	 */
	public JoueurHumain( String p1, Couleur a, Interface monInterface ) 
	{
		super( p1, a, monInterface );
		type = "Humain";
	}
	 
	public String getName()
	{
		return this.name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public Coup jouerCoup( Partie a )
	{
		Coup m = getMyInterface().jouerCoup( a );
		return m;
	}

}
