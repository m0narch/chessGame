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
		boolean mauvaisChoix=false;
		Coup m;
	 	do
	 	{
			m =selectionCoupAleatoire(a);
			if(a.seraEnEchec(m.getPosDepart(),m.getPosArrivee()))
			{
				mauvaisChoix=true;
			}
			else
				mauvaisChoix=false;
		}while(mauvaisChoix );
		System.out.println(m);
		if(m.isEstPrise())
		{
			a.setCpt_sans_prise();
		}
		else
			a.upCpt_sans_prise();
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
			var=rand.nextInt(size);
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
