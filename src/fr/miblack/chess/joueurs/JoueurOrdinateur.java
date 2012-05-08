package fr.miblack.chess.joueurs;

import java.util.LinkedList;
import java.util.Random;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Jouer;
import fr.miblack.chess.Partie; 
import fr.miblack.chess.color.Couleur;


public class JoueurOrdinateur extends JoueurAbstract implements Jouer
{

	private int niveau;
	
	public JoueurOrdinateur(String p1,Couleur a) 
	{
		super(p1,a);
	}
	
	public JoueurOrdinateur(String p1,Couleur a,int niveau) 
	{
		super(p1,a);
		this.niveau=niveau;
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
		Coup m;
		do
		{
			m =selectionCoupAleatoire(a);
		}while(a.estEnEchec( m.getPosDepart() ));
		 
		return m;
	}
	
	public Coup selectionCoupAleatoire(Partie a) 
	{
		LinkedList<Coup> listOfTheRandom=a.listOfAvailableMove( this );
		if(!a.listOfAvailableMove(this).isEmpty())
		{
			Random rand = new Random();
			int size=a.listOfAvailableMove( this ).size();
			if(size<=0)
			{
				size=1;
			}

			int var =rand.nextInt(size);
			return listOfTheRandom.get( var );
		}
		throw new RuntimeException("Plus de coups possible !");
	}

	public int getNiveau()
	{
		return niveau;
	}

	public void setNiveau( int niveau )
	{
		this.niveau = niveau;
	}
}
