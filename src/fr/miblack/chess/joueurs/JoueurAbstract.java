
package fr.miblack.chess.joueurs;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Jouer;
import fr.miblack.chess.Partie;
import fr.miblack.chess.affichage.Interface;
import fr.miblack.chess.color.Couleur;
/**
 * @author mi-black
 *
 */
public abstract class JoueurAbstract implements Jouer
{
	/**
	 * le nom
	 */
	protected String	name;
	/**
	 * la couleur
	 */
	protected Couleur	color;
	/**
	 * l'interface utilisé
	 */
	protected Interface	monInterface;
	/**
	 * le type
	 */
	protected String	type;
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 */
	public void setName( String name )
	{
		this.name = name;
	}
/**
 * @return
 */
	public String getType()
	{
		return type;
	}
/**
 * 
 * @param type
 */
	public void setType( String type )
	{
		this.type = type;
	}
/**
 * 
 * @return
 */
	public Couleur getColor()
	{
		return this.color;
	}
/**
 * @param p1
 * @param a couleur
 * @param monInterface
 */
	public JoueurAbstract( String p1, Couleur a, Interface monInterface ) 
	{
		this.name = p1;
		this.color = a;
		this.monInterface = monInterface;
	}
	/**
	 * @param p1
	 * @param a  couleur
	 */
	public JoueurAbstract( String p1 ,Couleur a  ) 
	{
		this.name = p1;
		this.color = a;
	}
/**
 * @return
 */
	@Override
	public String toString()
	{
		return this.name;
	}
	/**
	 * @return
	 */
	public boolean equals( JoueurAbstract joueur )
	{
		return (joueur.name.equals( this.name ) && joueur.color
				.equals( this.color ));
	}

	@Override
	public abstract Coup jouerCoup( Partie g );
	/**
	 * @return
	 */
	public Interface getMyInterface()
	{
		return monInterface;
	}
	/**
	 * @return
	 */
	public void setMyInterface( Interface myInterface )
	{
		this.monInterface = myInterface;
	}

}
