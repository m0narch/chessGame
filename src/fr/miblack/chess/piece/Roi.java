package fr.miblack.chess.piece;
import java.util.*;
import fr.miblack.chess.Position;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.color.Couleur;
public class Roi extends Piece
{

	public Roi(Couleur color,Position pos,int valeur)
	{
		super(color,pos,valeur);
	}

	public  LinkedList<Position> positionAccessible()
	{
		LinkedList<Position> myList=new LinkedList<Position>() ;
		for (int xx=( getX()-1); xx<=( getX()+1); ++xx)	/* parcours colonne*/
		{
			for (int yy=( getY()-1); yy<= ( getY()+1); ++yy)	/*parcours ligne*/
			{
				if ( !((xx== getX()) && (yy== getY())) &&estValide(xx) && estValide(yy))
				{
					myList.add(Position.getPosition(xx,yy));
				}
			}
		}
		return myList;
	}

	public LinkedList<Position> positionAccessibleChessboard(Echiquier chess)
	{
		LinkedList<Position> myList=positionAccessible() ;
		for(Position onePos:positionAccessible())
		{
			if(verifColor( chess, onePos ))
			{
				myList.remove(onePos);
			}
		}
		return myList;
	}

	public LinkedList<Position> whatCanIEat(Echiquier chess)
	{
		LinkedList<Position> myList=positionAccessibleChessboard(chess);
		for(Position onePos:positionAccessibleChessboard(chess))
		{
			if(chess.getPiecePosition( onePos )==null)
			{
				myList.remove(onePos);
			}
			else
			{
				if(chess.getPiecePosition( onePos ) instanceof Roi)
				{
					myList.remove(onePos);
				}
			}
		}
		return myList;
	}

	@Override
	public String toString()
	{
		if(this.color.getColor()==1)
			//return "♚";
			return "R";
		else
			return "r";
		//return "♔";
	}


	public String getNom()
	{
		return "R";
	}
}
