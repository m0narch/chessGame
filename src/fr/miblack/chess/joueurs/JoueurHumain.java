package fr.miblack.chess.joueurs;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;
import fr.miblack.chess.GUI.Interface;
import fr.miblack.chess.color.Couleur;


public class JoueurHumain extends JoueurAbstract 
{

	public JoueurHumain(String p1,Couleur a,Interface monInterface) 
	{
		super(p1,a,monInterface);
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
		Coup m=	getMyInterface().jouerCoup( a );
		return m;
	}
	
	
}
