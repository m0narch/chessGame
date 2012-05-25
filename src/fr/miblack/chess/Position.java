
package fr.miblack.chess;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import fr.miblack.chess.color.Couleur;

/**
 * Une position est consitué d'un x et d'un y
 * @author mi-black
 */
public class Position
{

	private static LinkedList<Position>	listPos	= new LinkedList<Position>();

	private int							x;
	private int							y;

	/**
	 * @param x
	 * @param y
	 */
	public Position( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return la couleur d'une position (0 ou 1)
	 */
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

	/**
	 * @return
	 */
	public int getX()
	{
		return this.x;
	}
	/**
	 * @return
	 */
	public int getY()
	{
		return this.y;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX( int x )
	{
		if(x>=0 && x<8)
			this.x = x;
	}

	/**
	 * @param y
	 */
	public void setY( int y)
	{
		if(y>=0 && y<8)
		this.y = y;
	}

	/**
	 * @param pos
	 * @return
	 */
	public boolean equals( Position pos )
	{
		return ((this.getX() == pos.getX()) && (this.getY() == pos.getY()));
	}

	/**
	 * @return
	 */
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

	/**
	 * Fly weight
	 * @param x
	 * @param y
	 * @return new Pos OU pos déjà existante
	 */
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

	/**
	 * @param a
	 * @return a>=0 && a<8
	 */
	public static boolean valValide( int a )
	{
		if ( (a >= 0) && (a < 8) )
		{
			return true;
		}
		return false;
	}

	/**
	 * @return chaine , 00 => a1
	 */
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

	/**
	 * @return la liste des positions
	 */
	public static LinkedList<Position> listPosit()
	{
		return listPos;
	}
	
	/**
	 * @return 
	 */
	public Position clone()
	{
		return new Position( this.x, this.y );
	}
}
