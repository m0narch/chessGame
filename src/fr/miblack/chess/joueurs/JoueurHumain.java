package fr.miblack.chess.joueurs;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Jouer;
import fr.miblack.chess.Partie;
import fr.miblack.chess.color.Couleur;


public class JoueurHumain extends JoueurAbstract implements Jouer
{

	public JoueurHumain(String p1,Couleur a) 
	{
		super(p1,a);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public Coup jouerCoup(Partie a)
	{
		Coup m = null;//=new Coup(p,a);
		return m;
	}
}
