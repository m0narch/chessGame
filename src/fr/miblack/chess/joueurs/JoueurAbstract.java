
package fr.miblack.chess.joueurs;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Jouer;
import fr.miblack.chess.Partie;
import fr.miblack.chess.affichage.Interface;
import fr.miblack.chess.color.Couleur;

public abstract class JoueurAbstract implements Jouer
{
	protected String	name;
	protected Couleur	color;
	protected Interface	monInterface;
	protected String	type;

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType( String type )
	{
		this.type = type;
	}

	public Couleur getColor()
	{
		return this.color;
	}

	public JoueurAbstract( String p1, Couleur a, Interface monInterface ) 
	{
		this.name = p1;
		this.color = a;
		this.monInterface = monInterface;
	}
	public JoueurAbstract( String p1 ,Couleur a  ) 
	{
		this.name = p1;
		this.color = a;
	}

	@Override
	public String toString()
	{
		return this.name;
	}

	public boolean equals( JoueurAbstract joueur )
	{
		return (joueur.name.equals( this.name ) && joueur.color
				.equals( this.color ));
	}

	@Override
	public abstract Coup jouerCoup( Partie g );

	public Interface getMyInterface()
	{
		return monInterface;
	}

	public void setMyInterface( Interface myInterface )
	{
		this.monInterface = myInterface;
	}

}
