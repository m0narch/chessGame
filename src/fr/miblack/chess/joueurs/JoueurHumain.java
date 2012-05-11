package fr.miblack.chess.joueurs;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Jouer;
import fr.miblack.chess.Partie;
import fr.miblack.chess.GUI.Interface;
import fr.miblack.chess.GUI.Textuelle;
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
		Interface monInterface=a.getMyInterface();
		Coup m;
		do
		{
			m=saisirCoup(monInterface);
		}while((a.seraEnEchec(m.getPosDepart(),m.getPosArrivee())));
	
		if(monInterface instanceof Textuelle)
			((Textuelle)monInterface).getMaPartie().addMove( m );
		return m;
	}
	
	public Coup saisirCoup(Interface monInterface)
	{
		Coup coup = null;
		try
		{
			if(monInterface instanceof Textuelle)
				coup=((Textuelle)monInterface).saisirCoup(this, ((Textuelle) monInterface).getMyChessboard()  );
		}
		catch(NullPointerException e)
		{
			System.err.println("Coup invalide");
		}
		return	coup;
	}
}
