
package fr.miblack.chess.piece;

import java.util.*;

import fr.miblack.chess.Position;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.interfaceDeplacement.Ligne;
import fr.miblack.chess.color.Couleur;

public class Tour extends Piece implements Ligne
{

	public Tour( Couleur color, Position pos, int valeur ) {
		super( color, pos, valeur );
	}

	public LinkedList<Position> positionAccessible()
	{
		LinkedList<Position> myList = positionLigne();

		return myList;
	}

	public LinkedList<Position> positionLigne()
	{
		LinkedList<Position> myList = new LinkedList<Position>();
		for ( int i = 0 ; i < 8 ; i++ )
		{
			for ( int j = 0 ; j < 8 ; j++ )
			{
				if ( (i == this.getX()) && j != this.getY() )
				{
					myList.add( Position.getPosition( i, j ) );
					continue;
				}
				if ( (j == this.getY()) && i != this.getX() )
				{
					myList.add( Position.getPosition( i, j ) );
					continue;
				}
			}
		}
		return myList;
	}

	public LinkedList<Position> positionAccessibleChessboard( Echiquier chess )
	{
		LinkedList<Position> myList = new LinkedList<Position>();

		myList.addAll( this.positionAccessibleHoriz( -1, chess ) );
		myList.addAll( this.positionAccessibleHoriz( 1, chess ) );
		myList.addAll( this.positionAccessibleVert( -1, chess ) );
		myList.addAll( this.positionAccessibleVert( 1, chess ) );
		return myList;
	}

	public LinkedList<Position> positionAccessibleHoriz( int a, Echiquier chess )
	{
		LinkedList<Position> myList = new LinkedList<Position>();
		int x = getX();
		int y = getY();
		if ( a > 0 )// apres la piece
		{
			for ( x = getX() + a ; x < 8 ; x = x + a )
			{
				if ( estValide( x ) )
				{
					if ( chess.getPiecePosition( x, y ) != null )
					{
						if ( !verifColor( chess, x, y ) )
						{
							myList.add( Position.getPosition( x, y ) );
						}
						break;
					}
					else
					{
						myList.add( Position.getPosition( x, y ) );
					}
				}
			}
		}
		else
		// Avant
		{
			for ( x = getX() + a ; x >= 0 ; x = x + a )
			{
				if ( estValide( x ) )
				{
					if ( chess.getPiecePosition( x, y ) != null )
					{
						if ( !verifColor( chess, x, y ) )
						{
							myList.add( Position.getPosition( x, y ) );
						}
						break;
					}
					else
					{
						myList.add( Position.getPosition( x, y ) );
					}
				}
			}
		}
		return myList;
	}

	public LinkedList<Position> positionAccessibleVert( int a, Echiquier chess )
	{
		LinkedList<Position> myList = new LinkedList<Position>();
		int y = getY();
		int x = getX();
		if ( a > 0 )// Apres la piece
		{
			for ( y = getY() + a ; y < 8 ; y = y + a )
			{
				if ( estValide( y ) )
				{
					if ( chess.getPiecePosition( x, y ) != null )
					{
						if ( !verifColor( chess, x, y ) )
						{
							myList.add( Position.getPosition( x, y ) );
						}
						break;
					}
					else
					{
						myList.add( Position.getPosition( x, y ) );
					}
				}
			}
		}
		else
		// avant
		{
			for ( y = getY() + a ; y >= 0 ; y = y + a )
			{
				if ( estValide( y ) )
				{
					if ( chess.getPiecePosition( x, y ) != null )
					{
						if ( !verifColor( chess, x, y ) )
						{
							myList.add( Position.getPosition( x, y ) );
						}
						break;
					}
					else
					{
						myList.add( Position.getPosition( x, y ) );
					}
				}
			}
		}
		return myList;
	}

	public LinkedList<Position> whatCanIEat( Echiquier chess )
	{
		LinkedList<Position> myList = positionAccessibleChessboard( chess );
		for ( Position onePos : positionAccessibleChessboard( chess ) )
		{
			if ( chess.getPiecePosition( onePos ) == null )
			{
				myList.remove( onePos );
			}

		}
		return myList;
	}

	@Override
	public String toString()
	{
		if ( this.color.getColor() == 1 )
			return "T";
		else
			return "t";
	}

	public String getNom()
	{
		return "T";
	}

	public Piece clone()
	{
		Tour maPiece = new Tour( this.getColor(), this.getPos(),
				this.getValeur() );
		return maPiece;
	}
}
