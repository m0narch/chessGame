package fr.miblack.chess.piece;
import java.util.*;
import fr.miblack.chess.Position;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.color.Couleur;
public class Cavalier extends Piece
{
	public Cavalier(Couleur color,Position pos,int valeur)
	{
		super(color,pos,valeur);
	}

	public  LinkedList<Position> positionAccessible()
	{
		LinkedList<Position> myList=new LinkedList<Position>() ;
		int xx=0;
		int yy=0;
		int delta=0;
		for (xx=this.getPos().getX() -2; xx <= getX()+2;++xx)
		{
			if(xx== getX())
				continue;
			delta=Math.abs(xx-getX());
			if(delta==2)
			{
				delta=1;
			}
			else
			{
				delta=2;
			}
			for(yy= getY()-delta;yy<= getY()+delta;yy=yy+delta)
			{
				if(yy== getY())
				{
					continue;
				}
				if(!(estValide(yy)&&estValide(xx)))
					continue;
				myList.add(Position.getPosition(xx,yy));
			}
		}
		return myList;
	}

	public LinkedList<Position> positionAccessibleChessboard(Echiquier chess)
	{
		LinkedList<Position> myList=positionAccessible() ;
		
		for(Position onePos:positionAccessible())
		{
			if(chess.getPiecePosition(onePos)!=null)
			{
				if(verifColor(chess,onePos))
				{
					myList.remove(onePos);
				}
			}
		}
		return myList;
	}

	public LinkedList<Position> whatCanIEat(Echiquier chess)
	{
		LinkedList<Position> myList=positionAccessibleChessboard(chess) ;
		
		for(Position onePos:positionAccessibleChessboard(chess))
		{
			if(chess.getPiecePosition(onePos)==null)
			{
				myList.remove(onePos);
			}

		}
		return myList;
	}

	@Override
	public String toString()
	{
		if(this.color.getColor()==1)
			//return "♞";
			return "C";
		else
			return "c";
		//return "♘";
	}

	public String getNom()
	{
		return "C";
	}
	
	public Piece clone() 
	{
		Cavalier maPiece =new Cavalier(this.getColor(),this.getPos(),this.getValeur());
		return maPiece;
	}
}
