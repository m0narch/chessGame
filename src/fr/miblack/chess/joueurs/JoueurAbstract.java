package fr.miblack.chess.joueurs;


import fr.miblack.chess.color.Couleur;

public  class JoueurAbstract 
{
	protected String name;
	protected Couleur color;
	
	public Couleur getColor()
	{
		return this.color;
	}
	public JoueurAbstract(String p1,Couleur a) 
	{
		this.name=p1;
		this.color=a;
	}
	@Override
	public String toString()
	{
		return this.name;
	}

	public boolean equals(JoueurAbstract joueur)
	{
		return ( joueur.name.equals( this.name )&&joueur.color.equals( this.color ));
	}
	
}
