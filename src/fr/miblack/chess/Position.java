
package fr.miblack.chess;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import fr.miblack.chess.color.Couleur;

public class Position
{

	private static LinkedList<Position>	listPos	= new LinkedList<Position>();

	private int							x;
	private int							y;

	public Position( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	public int getColor()
	{
		if ( ((x + y) % 2) == 1 )
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setX( int x )
	{
		if(x>=0 && x<8)
			this.x = x;
	}

	public void setY( int a)
	{
		if(a>=0 && a<8)
		this.y = a;
	}

	public boolean equals( Position pos )
	{
		return ((this.getX() == pos.getX()) && (this.getY() == pos.getY()));
	}

	public String toString()
	{
		if ( getColor() == 1 )
		{
			return Couleur.ANSI_WHITE + ".";
		}
		else
		{
			return Couleur.ANSI_RED + ".";
		}
	}

	public static Position getPosition( int x, int y )
	{
		Position a;
		if ( valValide( x ) && valValide( y ) )
		{
			try
			{
				for ( Position myPos : listPos )
				{
					if ( (myPos.getX() == x) && (myPos.getY() == y) )
						return myPos;
				}	
			}catch(ConcurrentModificationException e)
			{
				e.getStackTrace();
			}

			a = new Position( x, y );
			listPos.add( a );
			return a;
		}
		throw new RuntimeException( x + ", " + y + " : coordonnees  invalide" );
	}

	public static boolean valValide( int a )
	{
		if ( (a >= 0) && (a < 8) )
		{
			return true;
		}
		return false;
	}

	public static int instanceOfPos()
	{
		return listPos.size();
	}

	public String toStringPos()
	{
		return "" + (char) (this.x + 97) + (this.y + 1);
	}

	/**
	 * 
	 * @param pos
	 * @return la position equivalante a la chaine passee
	 */
	public static Position stringToPos( String pos )
	{
		int x = 0;
		int y = 0;
		if ( pos.charAt( 0 ) >= 'a' && pos.charAt( 0 ) <= 'h' )
		{
			x = pos.charAt( 0 ) - 97;
			if ( pos.charAt( 1 ) >= '1' && pos.charAt( 1 ) <= '8' )
			{
				y = (int) pos.charAt( 1 ) - '1';
				return Position.getPosition( x, y );
			}
		}
		throw new RuntimeException( pos + " Position invalide" );
	}

	public static LinkedList<Position> listPosit()
	{
		return listPos;
	}

	public Position clone()
	{
		return new Position( this.x, this.y );
	}
}
