package fr.miblack.chess;
import java.util.*;

import fr.miblack.chess.Position;
import fr.miblack.chess.piece.*;
public class Echiquier
{


	private LinkedList<Piece> pieceList = new LinkedList<Piece>();



	public Piece getPiecePosition(Position pos)
	{
		for(Piece onePiece :this.pieceList)
		{
			if(onePiece.getPos().equals(pos))
			{
				return onePiece;
			}
		}
		return null;
	}

	public Piece getPiecePosition(int x,int y)
	{
		for(Piece onePiece :this.pieceList)
		{
			if(onePiece.getPos().equals(getPosition(x,y)))
			{
				return onePiece;
			}
		}
		return null;
	}

	/**
	 * Effectuer un coup,
	 * @param pieceDepart posArrivee
	 * @return
	 */
	public boolean realiserCoup(Piece pieceDepart ,Position posArrivee)
	{
		//TODO Pouvoir effectuer un coup
		if(pieceList.contains( pieceDepart))
		{
			pieceList.remove(this.getPiecePosition( posArrivee ) );
			for(Piece piece : pieceList)
			{
				if(piece.equals( pieceDepart ))
				{
					pieceDepart.setPos( posArrivee );
					pieceList.remove(piece );
					pieceList.add(pieceDepart );
					break;
				}
			}
			pieceDepart.setPlayed();
			return true;
		}
		else
			return false;
	}

	public boolean realiserCoup(Coup myCoup)
	{
		//TODO Pouvoir effectuer un coup complet
		Piece pieceD=null;
		Position posA=null;
		try
		{
			pieceD=myCoup.getPieceDepart();
			posA= myCoup.getPosArrivee();
			myCoup.setPiecePrise( this.getPiecePosition( posA ) );
			if(pieceList.contains( pieceD ))
			{
				if(pieceD.positionAccessibleChessboard( this ).contains( posA ))
				{
					pieceList.remove(this.getPiecePosition( posA ) );
					for(Piece piece : pieceList)
					{
						if(piece.equals( pieceD ))
						{
							pieceD.setPos( posA );
							pieceList.remove(piece );
							pieceList.add(pieceD );
							break;
						}
					}
					pieceD.setPlayed();
					return true;
				}
			}
			else
				return false;
		}
		catch(RuntimeException e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Coup moveRoque(boolean little)
	{
		Coup m=null;// = new Coup();
		if(little)
		{
			return m;
		}
		else
		{
			return m;
		}
	}

	public Object clone() 
	{
		return pieceList.clone();
	}

	public boolean contains(Object o) 
	{
		return pieceList.contains(o);
	}

	public boolean equals(Object arg0) 
	{
		return pieceList.equals(arg0);
	}

	public Piece get(int index) 
	{
		return pieceList.get(index);
	}

	public Piece getFirst() 
	{
		return pieceList.getFirst();
	}

	public Piece getLast() 
	{
		return pieceList.getLast();
	}

	public boolean remove(Object arg0) 
	{
		return pieceList.remove(arg0);
	}

	public int size() 
	{
		return pieceList.size();
	}

	public boolean addPawn(Pion pawn) 
	{
		return pieceList.add(pawn);
	}
	public boolean addRook(Tour rook) 
	{
		return pieceList.add(rook);
	}

	public boolean addBishop(Fou bishop) 
	{
		return pieceList.add(bishop);
	}
	public boolean addKing(Roi king) 
	{
		return pieceList.add(king);
	}
	public boolean addKnight(Cavalier knight) 
	{
		return pieceList.add(knight);
	}
	public boolean addQueen(Dame queen) 
	{
		return pieceList.add(queen);
	}

	public  Position getPosition(int x,int y)
	{
		return Position.getPosition(x, y);
	}

	public LinkedList<Piece> getPieceList()
	{
		return pieceList;
	}
}

