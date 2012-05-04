package fr.miblack.chess;
public class Joueur implements Jouer
{
	private String name;

	public Joueur(String p1) {
		this.name=p1;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public Coup moveAPiece(Partie g)
	{
		Coup m=new Coup();
		return m;
	}



}
