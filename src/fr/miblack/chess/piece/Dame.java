package fr.miblack.chess.piece;
import java.util.*;
import fr.miblack.chess.Position;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.interfaceDeplacement.*;
import fr.miblack.chess.color.Couleur;

public class Dame extends Piece implements Diagonale,Ligne
{
	private Tour tour ;
	private Fou  fou  ;
	
	public Dame(Couleur color,Position pos,int valeur)
	{
		super(color,pos,valeur);
		tour=new Tour(color,pos,valeur);
		fou=new Fou(color,pos,valeur);
	}

	public LinkedList<Position> positionAccessible()
	{
		LinkedList<Position> myList=positionDiagonale() ;
		myList.addAll(positionLigne());
		return myList;
	}

	public LinkedList<Position> positionAccessibleChessboard(Echiquier chess)
	{
		LinkedList<Position> myList=tour.positionAccessibleChessboard(chess) ;
		myList.addAll(fou.positionAccessibleChessboard(chess));
		return myList;
	}

	public LinkedList<Position> whatCanIEat(Echiquier chess)
	{
		LinkedList<Position> myList=tour.whatCanIEat(chess) ;
		myList.addAll(fou.whatCanIEat(chess));
		return myList;
	}

	public LinkedList<Position> positionDiagonale()
	{
		LinkedList<Position> myList=fou.positionDiagonale() ;
		return myList;
	}

	public LinkedList<Position> positionLigne()
	{
		LinkedList<Position> myList=tour.positionLigne();
		return myList;
	}

	@Override
	public String toString()
	{
		if(this.color.getColor()==1)
			return "D";
//			return "♛";
		else
			return "d";
//			return "♕";
	}

	public String getNom()
	{
		return "D";
	}
}
