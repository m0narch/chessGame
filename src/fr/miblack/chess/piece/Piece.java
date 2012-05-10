package fr.miblack.chess.piece;
import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;
import fr.miblack.chess.Position;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.Echiquier;
import java.util.*;
public abstract class Piece implements Cloneable
{
	/*  List of unicode char : BLACK : ♟ ♞ ♝ ♜ ♛ ♚ WHITE : ♙ ♘ ♗ ♖ ♕ ♔ **/
	protected Couleur color;
	protected Position pos;
	protected int valeur;
	protected int asPlayed=0;



	public Piece(Couleur color,Position pos,int valeur)
	{
		this.color=color;
		this.pos=pos;
		this.valeur=valeur;
	}

	public Couleur getColor()
	{
		return this.color;
	}

	public void setColor(int color)
	{
		this.color.setColor(color);
	}

	public int getPlayed()
	{
		return this.asPlayed;
	}

	public void setPlayed()
	{
		this.asPlayed++;
	}
	public void unSetPlayed()
	{
		this.asPlayed--;
	}
	
	public void setPos(Position pos)
	{
		if(pos !=null)
		{
			this.pos.setX(pos.getX());
			this.pos.setY(pos.getY());	
		}
		else
		{
			this.pos= null ;
		}
		
	}

	public Position getPos()
	{
		return 	this.pos;
	}

	public int getValeur()
	{
		return this.valeur;
	}


	/**
	 * @return List of position where one piece can be going
	 */
	public abstract LinkedList<Position> positionAccessible();
	/**
	 * @return List of position where one piece can be going with restriction of the chessboard
	 */
	public abstract LinkedList<Position> positionAccessibleChessboard(Echiquier chess);
	public abstract LinkedList<Position> whatCanIEat(Echiquier chess);
	public int getY()
	{
		return this.getPos().getY();
	}
	public int getX()
	{
		return this.getPos().getX();
	}
	public boolean estValide(int x)
	{
		return Position.valValide( x );
	}
	
	public boolean verifColor(Echiquier chess,Position onePos)
	{
		if(chess.getPiecePosition( onePos )==null)
		{
			return true;
		}
		else
			return (this.getColor().getColor() == chess.getPiecePosition(onePos).getColor().getColor());
	}
	public boolean verifColor(Echiquier chess,int x, int y)
	{
		return this.getColor().equals(chess.getPiecePosition(x,y).getColor());
	}

	public String getNom()
	{
		return "";
	}
	
	public LinkedList<Coup> getCoupPossible(Piece PieceDepart,Partie maPartie )
	{
		LinkedList<Position> myListOfPosAtteignable = PieceDepart.positionAccessibleChessboard( maPartie.getMyChessboard() );
		LinkedList<Coup> listOfCoup=new LinkedList<Coup>();

		for(Position position : myListOfPosAtteignable  )
		{
			if(!maPartie.estEnEchec( position ))
			{
				if(!(maPartie.getMyChessboard().getPiecePosition( position ) instanceof Roi))
				{
					if(PieceDepart.whatCanIEat( maPartie.getMyChessboard() ).contains( position ))
					{		
						listOfCoup.add( new Coup(PieceDepart, position, true) );
					}
					else
						listOfCoup.add( new Coup(PieceDepart, position, false) );	
				}	
			}
		}
		return listOfCoup;
	}

	public boolean equals(Piece autre)
	{
		return (this.pos.equals( autre.getPos() ) && color.equals( autre.getColor() ) && (this.valeur==autre.getValeur()));
	}


}


