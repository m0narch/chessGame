package fr.miblack.chess.piece;
import java.util.*;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;
import fr.miblack.chess.Position;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.color.Couleur;
public class Pion extends Piece
{

	public Pion(Couleur color,Position pos,int valeur)
	{
		super(color,pos,valeur);
	}

	public LinkedList<Position> positionAccessibleCouleur(int couleur)
	{
		LinkedList<Position> myList=new LinkedList<Position>() ;
		int mult=1;
		if(couleur==0)
		{
			mult=-1;
		}
		for(Position onePos : Position.listPosit()  )
		{
			if(onePos.getX()== getX() &&(onePos.getY()== (getY()+(1*mult))))
			{
				myList.add(onePos);
			}

		}
		if(this.asPlayed==0)
		{
			try
			{
			myList.add(Position.getPosition( getX(), getY()+(2*mult)));
			}
			catch(Exception e)
			{
			}
		}
		return myList;
	}

	public Piece promotion (String str)
	{
		if(str.equals( "F" ))
		{
			return new Fou(color, pos, asPlayed);
		}
		else if(str.equals( "C" ))
		{
			return new Cavalier(color, pos, asPlayed);
		}
		else if(str.equals( "T" ))
		{
			return new Tour(color, pos, asPlayed);
		}
		else if(str.equals( "D" ))
		{
			return new Dame(color, pos, asPlayed);
		}
		else 
		{
			return new Dame(color, pos, asPlayed);
		}
		
	}
	public LinkedList<Coup> getCoupPossible(Piece PieceDepart,Partie maPartie )
	{
		LinkedList<Position> myListOfPosAtteignable = this.positionAccessibleChessboard( maPartie.getMyChessboard() );
		LinkedList<Coup> listOfCoup=super.getCoupPossible( PieceDepart, maPartie );

			for(Position position : myListOfPosAtteignable  )
			{
				if(position.getY()==0  || position.getY()==7)
				{
					if(PieceDepart.whatCanIEat( maPartie.getMyChessboard() ).contains( position ))
					{		
						listOfCoup.add( new Coup(PieceDepart, position, true,"D") );
					}
					else
						listOfCoup.add( new Coup(PieceDepart, position, false,"D") );	
				}
			}
		return listOfCoup;
	}
	
	public  LinkedList<Position> positionAccessible()
	{
		LinkedList<Position> myList=positionAccessibleCouleur(color.getColor());
		return myList;
	}

	public LinkedList<Position> positionAccessibleChessboard(Echiquier chess)
	{
		LinkedList<Position> myList=positionAccessible() ;
		int mult=1;
		if(this.color.getColor()==0)
		{
			mult=-1;
		}
		if(this.getPlayed()==0)
		{
			if(estValide( getY()+(1*mult) ))
			{
				if(chess.getPiecePosition( getX(), (getY()+((1)*mult)) )!=null)
				{
					if(estValide( getY()+(2*mult) ))
					{
						myList.remove(Position.getPosition( getX(), getY()+(2*mult)));
					}
				}
			}
		}
		for(Position onePos :positionAccessible())
		{
			if((chess.getPiecePosition(onePos)!=null)) 
			{
				myList.remove(onePos);
			}
		}
		myList.addAll(whatCanIEat(chess));
		return myList;
	}

	public LinkedList<Position> whatCanIEat(Echiquier chess)
	{
		LinkedList<Position> myList=new LinkedList<Position>() ;
		Couleur maCouleur=this.getColor();
		int mult=1;
		if(maCouleur.getColor()==0)
		{
			mult=-1;
		}
		if((this.getX()+1)<=7)
		{
			if(estValide( this.getY()+(1*mult) ))
			{
				if(chess.getPiecePosition(this.getX()+1,this.getY()+(1*mult))!=null)
				{
					if(!verifColor(chess,this.getX()+1,this.getY()+(1*mult)) )
					{
						if(!(chess.getPiecePosition(this.getX()+1,this.getY()+(1*mult) ) instanceof Roi))
							myList.add(Position.getPosition(this.getX()+1,this.getY()+(1*mult)));
					}
				}
			}
		}
		if((this.getX()-1)>=0)
		{
			if(estValide( this.getY()+(1*mult) ))
			{
				if(chess.getPiecePosition(this.getX()-1,this.getY()+(1*mult))!=null)
				{
					if(!verifColor(chess,this.getX()-1,this.getY()+(1*mult)))
					{
						if(!(chess.getPiecePosition(this.getX()-1,this.getY()+(1*mult) ) instanceof Roi))
							myList.add(Position.getPosition(this.getX()-1,this.getY()+(1*mult)));
					}
				}
			}
		}
		return myList;
	}

	public boolean metEnEchec(Echiquier chess)
	{
		boolean check=false;
		Couleur maCouleur=this.getColor();
		int mult=1;
		if(maCouleur.getColor()==0)
		{
			mult=-1;
		}
		if((this.getX()+1)<=7)
		{
			if(estValide( this.getY()+(1*mult) ))
			{
				if(chess.getPiecePosition(this.getX()+1,this.getY()+(1*mult))!=null)
				{
					if(!verifColor(chess,this.getX()+1,this.getY()+(1*mult)) )
					{
						if((chess.getPiecePosition(this.getX()+1,this.getY()+(1*mult) ) instanceof Roi))
							check=true;
					}
				}
			}
		}
		if((this.getX()-1)>=0)
		{
			if(estValide( this.getY()+(1*mult) ))
			{
				if(chess.getPiecePosition(this.getX()-1,this.getY()+(1*mult))!=null)
				{
					if(!verifColor(chess,this.getX()-1,this.getY()+(1*mult)))
					{
						if((chess.getPiecePosition(this.getX()-1,this.getY()+(1*mult) ) instanceof Roi))
							check=true;
					}
				}
			}
		}
		return check;
	}
	
	@Override
	public String toString()
	{
		if(this.color.getColor()==1)
			return "P";
		//return "♟";
		else
			return "p";
		//return "♙";
	}

	public String getNom()
	{
		return "";
	}
	public Piece clone() 
	{
		Pion maPiece =new Pion(this.getColor(),this.getPos(),this.getValeur());
		return maPiece;
	}

	
}
