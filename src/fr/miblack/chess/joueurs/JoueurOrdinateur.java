
package fr.miblack.chess.joueurs;

import java.util.LinkedList;
import java.util.Random;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;
import fr.miblack.chess.affichage.Interface;
import fr.miblack.chess.color.Couleur;

public class JoueurOrdinateur extends JoueurAbstract
{

	private int	niveau;

	public JoueurOrdinateur( String p1, Couleur a, Interface monInterface ) 
	{
		super( p1, a, monInterface );
		type = "Ordinateur";
	}

	public JoueurOrdinateur( String p1, Couleur a, Interface monInterface,int niveau ) 
	{
		super( p1, a, monInterface );
		this.niveau = niveau;
		type = "Ordinateur";
	}

	public String getName()
	{
		return this.name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	/**
	 * permet a une machine de jouer un coup , ici seulement le niveau 1 est implementee
	 * @return le coup a jouer
	 */
	public Coup jouerCoup( Partie a )
	{
		Coup m;
		boolean mauvaisChoix = false;
		do
		{
			m = selectionCoupAleatoire( a );
			if(m.getRoque()==false)
			{
				if ( a.seraEnEchec( m.getPosDepart().clone(), m.getPosArrivee().clone() ) )
				{
					mauvaisChoix = true;
				}
				else
					mauvaisChoix = false;
			}
			else
				mauvaisChoix = false;

			
		} while (mauvaisChoix);
		return m;
	}

	/**
	 * IA de niveau 1 , selection aleatoire
	 * @param a , la partie
	 * @return un coup aleatoire parmis la liste de coup jouable
	 */
	public Coup selectionCoupAleatoire( Partie a )
	{
		LinkedList<Coup> listOfTheRandom = a.listOfAvailableMove( this );
		if ( !a.listOfAvailableMove( this ).isEmpty() )
		{
			Random rand = new Random();
			int size = a.listOfAvailableMove( this ).size();
			if ( size <= 0 )
			{
				size = 1;
			}
			int var = rand.nextInt( size );
			return listOfTheRandom.get( var );
		}
		throw new RuntimeException( "Plus de coups possible !" );
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
