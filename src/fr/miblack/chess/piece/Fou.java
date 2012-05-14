
package fr.miblack.chess.piece;

import java.util.*;

import fr.miblack.chess.Position;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.interfaceDeplacement.Diagonale;

public class Fou extends Piece implements Diagonale
{
	public Fou( Couleur color, Position pos, int valeur ) {
		super( color, pos, valeur );
	}

	public LinkedList<Position> positionAccessible()
	{
		LinkedList<Position> myList = positionDiagonale();
		return myList;
	}

	public LinkedList<Position> positionDiagonale()
	{
		LinkedList<Position> myList = new LinkedList<Position>();
		int delta;
		int xx = 0;
		int yy = 0;
		for ( xx = 0 ; xx < 8 ; ++xx )
		{
			delta = getX() - xx;
			if ( xx != getX() )
			{
				yy = getY() + delta;
				if ( (yy >= 1) && (yy < 7) )
				{
					myList.add( Position.getPosition( xx, yy ) );
				}
				yy = getY() - delta;
				if ( (yy >= 1) && (yy < 7) )
				{
					myList.add( Position.getPosition( xx, yy ) );
				}
			}
		}
		return myList;
	}

	public LinkedList<Position> positionAccessibleChessboard( Echiquier chess )
	{
		LinkedList<Position> myList = new LinkedList<Position>();
		myList.addAll( diagonaleDrt( -1, chess ) );
		myList.addAll( diagonaleDrt( 1, chess ) );
		myList.addAll( diagonaleGch( -1, chess ) );
		myList.addAll( diagonaleGch( 1, chess ) );
		return myList;
	}

	public LinkedList<Position> diagonaleDrt( int a, Echiquier chess )
	{
		LinkedList<Position> myList = new LinkedList<Position>();
		int x = getX();
		int y = getY();
		int i = 0;
		for ( x = getX() + 1 ; x < 8 ; x = x + 1 )
		{
			i = i + a;
			if ( estValide( x ) )
			{
				if ( estValide( y + i ) )
				{
					if ( chess.getPiecePosition( x, y + i ) != null )
					{
						if ( !verifColor( chess, x, y + i ) )
						{
							myList.add( Position.getPosition( x, y + i ) );
						}
						break;
					}
					else
					{
						myList.add( Position.getPosition( x, y + i ) );
					}
				}
			}
		}
		return myList;
	}

	public LinkedList<Position> diagonaleGch( int a, Echiquier chess )
	{
		LinkedList<Position> myList = new LinkedList<Position>();
		int x = getX();
		int y = getY();
		int i = 0;
		for ( x = getX() - 1 ; x >= 0 ; x = x - 1 )
		{
			i = i + a;
			if ( estValide( x ) )
			{
				if ( estValide( y + i ) )
				{
					if ( chess.getPiecePosition( x, y + i ) != null )
					{
						if ( !verifColor( chess, x, y + i ) )
						{
							myList.add( Position.getPosition( x, y + i ) );
						}
						break;
					}
					else
					{
						myList.add( Position.getPosition( x, y + i ) );
					}
				}
			}
		}
		return myList;
	}

	public LinkedList<Position> whatCanIEat( Echiquier chess )
	{
		LinkedList<Position> myList = positionAccessibleChessboard( chess );
		for ( Position onePos : this.positionAccessibleChessboard( chess ) )
		{
			if ( chess.getPiecePosition( onePos ) == null )
			{
				myList.remove( onePos );
				continue;
			}

		}
		return myList;
	}

	@Override
	public String toString()
	{
		if ( this.color.getColor() == 1 )
			return "F";
		// return "♝";
		else
			return "f";
		// return "♗";
	}

	public String getNom()
	{
		return "F";
	}

	public Piece clone()
	{
		Fou maPiece = new Fou( this.getColor(), this.getPos(), this.getValeur() );
		return maPiece;
	}

}
