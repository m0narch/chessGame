
package fr.miblack.chess.piece;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;
import fr.miblack.chess.Position;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.Echiquier;
import java.util.*;
/**
 * @author mi-black
 */
public abstract class Piece implements Cloneable
{
	/**
	 * La couleur d'une piece
	 */
	protected Couleur	color;
	/**
	 * Sa positions
	 */
	protected Position	pos;
	/**
	 * Sa valeur (implémentation possible alpha-beta ?)
	 */
	protected int		valeur;
	/**
	 *	Combien de fois jouée 
	 */
	protected int		asPlayed	= 0;
	/**
	 * 
	 * @param color
	 * @param pos
	 * @param valeur
	 */
	public Piece( Couleur color, Position pos, int valeur ) {
		this.color = color;
		this.pos = pos;
		this.valeur = valeur;
	}
	/**
	 * 
	 * @return
	 */
	public Couleur getColor()
	{
		return this.color;
	}
	/**
	 * 
	 * @param color
	 */
	public void setColor( int color )
	{
		this.color.setColor( color );
	}
	/**
	 * 
	 * @return
	 */
	public int getPlayed()
	{
		return this.asPlayed;
	}
	
	/**
	 * Rien
	 */
	public void setPlayed()
	{
		this.asPlayed = asPlayed + 1;
	}
	
	/**
	 * Rien
	 */
	public void unSetPlayed()
	{
		this.asPlayed--;
	}
	
	/**
	 * 
	 * @param pos
	 */
	public void setPos( Position pos )
	{
		if ( pos != null )
		{
			this.pos.setX( pos.getX() );
			this.pos.setY( pos.getY() );
		}
		else
		{
			this.pos = null;
		}

	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setPos( int x,int y )
	{
		this.pos.setX(x );
		this.pos.setY(y );
	}
	/**
	 * 
	 * @return
	 */
	public Position getPos()
	{
		return this.pos;
	}
	/**
	 * 
	 * @return
	 */
	public int getValeur()
	{
		return this.valeur;
	}

	/**
	 * @return List of position where one piece can be going
	 */
	public abstract LinkedList<Position> positionAccessible();

	/**
	 * @return List of position where one piece can be going with restriction of
	 *         the chessboard
	 */
	public abstract LinkedList<Position> positionAccessibleChessboard(
			Echiquier chess );
	/**
	 * @param chess l'echiquier
	 * @return Liste des position capturables
	 */
	public abstract LinkedList<Position> whatCanIEat( Echiquier chess );

	/**
	 * @return
	 */
	public int getY()
	{
		return this.getPos().getY();
	}
	/**
	 * @return
	 */
	public int getX()
	{
		return this.getPos().getX();
	}

	/**
	 * @param x
	 * @return
	 */
	public boolean estValide( int x )
	{
		return Position.valValide( x );
	}

	/**
	 * @param chess
	 * @param onePos
	 * @return 
	 */
	public boolean verifColor( Echiquier chess, Position onePos )
	{
		if ( chess.getPiecePosition( onePos ) == null )
		{
			return true;
		}
		else
			return (this.getColor().getColor() == chess
			.getPiecePosition( onePos ).getColor().getColor());
	}

	/**
	 * @param chess
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean verifColor( Echiquier chess, int x, int y )
	{
		return this.getColor().equals(
				chess.getPiecePosition( x, y ).getColor() );
	}

	/**
	 * @return
	 */
	public String getNom()
	{
		return "";
	}
	/**
	 * @param PieceDepart
	 * @param maPartie
	 * @return
	 */
	public LinkedList<Coup> getCoupPossible( Piece PieceDepart, Partie maPartie )
	{
		LinkedList<Position> myListOfPosAtteignable = PieceDepart
				.positionAccessibleChessboard( maPartie.getMyChessboard() );
		LinkedList<Coup> listOfCoup = new LinkedList<Coup>();

		for ( Position position : myListOfPosAtteignable )
		{
			if ( !(maPartie.getMyChessboard().getPiecePosition( position ) instanceof Roi) )
			{
				if ( PieceDepart.whatCanIEat( maPartie.getMyChessboard() )
						.contains( position ) )
				{
					listOfCoup
					.add( new Coup( PieceDepart, position, true, "D" ) );
				}
				else
					listOfCoup
					.add( new Coup( PieceDepart, position, false, "D" ) );
			}
		}
		return listOfCoup;
	}

	/**
	 * @param autre
	 * @return
	 */
	public boolean equals( Piece autre )
	{
		return (this.pos.equals( autre.getPos() )
				&& color.equals( autre.getColor() ) && (this.valeur == autre
				.getValeur()));
	}

}
