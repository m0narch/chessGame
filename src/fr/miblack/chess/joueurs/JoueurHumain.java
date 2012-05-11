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
		boolean mauvaisChoix=false;
		do
		{
			if(mauvaisChoix)
			{
				System.out.println("Mauvais choix de coup");
			}
			m=saisirCoup(monInterface);
			if(a.seraEnEchec(m.getPosDepart(),m.getPosArrivee()))
			{
				mauvaisChoix=true;
			}
			else
				mauvaisChoix=false;
		}while(mauvaisChoix);
	
		if(monInterface instanceof Textuelle)
			((Textuelle)monInterface).getMaPartie().addMove( m );
		
		if(m.isEstPrise())
		{
			a.setCpt_sans_prise();
		}
		else
			a.upCpt_sans_prise();
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
