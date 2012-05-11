package fr.miblack.chess;
import java.util.*;

import fr.miblack.chess.Position;
import fr.miblack.chess.piece.*;
public class Echiquier
{


	private LinkedList<Piece> pieceList = new LinkedList<Piece>();
	private Piece piecePourTest;
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
	 * Deplacer la piece un coup,
	 * @param pieceDepart posArrivee
	 * @return
	 */
	public boolean realiserCoup(Piece pieceDepart ,Position posArrivee)
	{
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

	public boolean deplacerPiecePourTest(Position posDepart,Position posArrivee)
	{
		Piece pieceD=null;
		boolean prise=false;
		pieceD=this.getPiecePosition(posDepart);
		piecePourTest=this.getPiecePosition(posArrivee);
		if(piecePourTest!=null)
		{
			 prise=true;
			 pieceList.remove(piecePourTest);
		}
		pieceD.setPos( posArrivee );
		pieceList.remove(pieceD );
		pieceList.add(pieceD );
		return prise;
	}
	
	public void annulerDeplacerPiecePourTest(Position posDepart,Position posArrivee,boolean isPrise)
	{
		Piece pieceD=null;
		pieceD=this.getPiecePosition(posArrivee);
		pieceList.remove(pieceD );
		pieceD.setPos( posDepart );
		if(isPrise)
		{
			piecePourTest.setPos(posArrivee);
			pieceList.add(piecePourTest );
		}
		piecePourTest=null;
		pieceList.add(pieceD );
	}
	//TODO verif !!!!
	public boolean realiserCoup(Coup myCoup)
	{
		Piece pieceD=null;
		Position posA=null;
		piecePourTest=null;

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
							pieceD.setPlayed();
							pieceD.setPos( posA );
							pieceList.remove(piece );
							pieceList.add(pieceD );
							break;
						}
					}
					return true;
				}
			}
			else
				return false;
	
		return false;
	}
	
	//TODO Penser au roque
	public Coup moveRoque(boolean little)
	{
		Coup m=null;
		if(little)
		{
			return m;
		}
		else
		{
			return m;
		}
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

