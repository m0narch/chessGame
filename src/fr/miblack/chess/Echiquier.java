
package fr.miblack.chess;

import java.util.*;

import fr.miblack.chess.Position;
import fr.miblack.chess.piece.*;

public class Echiquier
{

	private LinkedList<Piece>	pieceList	= new LinkedList<Piece>();
	private Piece				piecePourTest;

	public Piece getPiecePosition( Position pos )
	{
		for ( Piece onePiece : this.pieceList )
		{
			if ( onePiece.getPos().equals( pos ) )
			{
				return onePiece;
			}
		}
		return null;
	}

	public Piece getPiecePosition( int x, int y )
	{
		for ( Piece onePiece : this.pieceList )
		{
			if ( onePiece.getPos().equals( getPosition( x, y ) ) )
			{
				return onePiece;
			}
		}
		return null;
	}

	/**
	 * Deplacer la piece un coup,
	 * 
	 * @param pieceDepart
	 *            posArrivee
	 * @return
	 */
	public boolean realiserCoup( Piece pieceDepart, Position posArrivee )
	{
		if ( pieceList.contains( pieceDepart ) )
		{
			pieceList.remove( this.getPiecePosition( posArrivee ) );
			for ( Piece piece : pieceList )
			{
				if ( piece.equals( pieceDepart ) )
				{
					pieceDepart.setPos( posArrivee );
					pieceList.remove( piece );
					pieceList.add( pieceDepart );
					break;
				}
			}
			pieceDepart.setPlayed();
			return true;
		}
		else
			return false;
	}

	public boolean deplacerPiecePourTest( Position posDepart,
			Position posArrivee )
	{
		Piece pieceD = null;
		boolean prise = false;
		pieceD = this.getPiecePosition( posDepart );
		piecePourTest = this.getPiecePosition( posArrivee );
		if ( piecePourTest != null )
		{
			prise = true;
			pieceList.remove( piecePourTest );
		}
		pieceD.setPos( posArrivee );
		pieceList.remove( pieceD );
		pieceList.add( pieceD );
		return prise;
	}

	public void annulerDeplacerPiecePourTest( Position posDepart,Position posArrivee, boolean isPrise )
	{
		Piece pieceD = null;
		pieceD = this.getPiecePosition( posArrivee );
		pieceList.remove( pieceD );
		pieceD.setPos( posDepart );
		if ( isPrise )
		{
			piecePourTest.setPos( posArrivee );
			pieceList.add( piecePourTest );
		}
		piecePourTest = null;
		pieceList.add( pieceD );
	}

	@SuppressWarnings( "null" )
	public boolean realiserCoup( Coup myCoup )
	{
		
		Piece pieceD = null;
		Position posA = null;
		piecePourTest = null;
		Piece roi=null;
		Piece tour=null;
		try
		{
			pieceD = myCoup.getPieceDepart();
			posA = myCoup.getPosArrivee();
			myCoup.setPiecePrise( this.getPiecePosition( posA ) );
		}
		catch (NullPointerException e)
		{
			
		}
		if(myCoup.getRoque()==false)
		{
			if ( pieceList.contains( pieceD ) )
			{
				if ( pieceD.positionAccessibleChessboard( this ).contains( posA ) )
				{
					pieceList.remove( this.getPiecePosition( posA ) );
					for ( Piece piece : pieceList )
					{
						if ( piece.equals( pieceD ) )
						{
							pieceD.setPlayed();
							pieceD.setPos( posA );
							pieceList.remove( piece );
							pieceList.add( pieceD );
							break;
						}
					}
					return true;
				}
			}
			else
				return false;	
		}
		else
		{
			if(myCoup.estPetitRoque)
			{
				if(myCoup.getCouleur().getColor()==1)//blanc
				{
					roi=this.getPiecePosition(4,0);
					tour=this.getPiecePosition( 7, 0 );
					roi.setPos(6,0);
					tour.setPos( 5, 0 );
				}
				else
				{
					roi=this.getPiecePosition(4,7);
					tour=this.getPiecePosition( 7, 7 );
					roi.setPos(6,7);
					tour.setPos( 5, 7 );
				}
			}
			else
			{
				if(myCoup.getCouleur().getColor()==1)//blanc
				{
					roi=this.getPiecePosition(4,0);
					tour=this.getPiecePosition( 0, 0 );
					roi.setPos(2,0);
					tour.setPos( 3, 0 );
				}
				else
				{
					roi=this.getPiecePosition(4,7);
					tour=this.getPiecePosition( 0, 7 );
					roi.setPos(2,7);
					tour.setPos( 3, 7 );
				}
			}
		}
		

		return false;
	}

	public boolean realiserPromotion( Coup myCoup )
	{
		Piece pieceD = null;
		Piece pieceApres = null;
		pieceD = myCoup.getPieceDepart();
		if ( pieceD instanceof Pion )
			pieceApres = ((Pion) pieceD).promotion( myCoup.getPromotion() );
		pieceList.remove( pieceD );
		pieceList.add( pieceApres );
		return true;
	}


	public int size()
	{
		return pieceList.size();
	}

	public boolean addPawn( Pion pawn )
	{
		return pieceList.add( pawn );
	}

	public boolean addRook( Tour rook )
	{
		return pieceList.add( rook );
	}

	public boolean addBishop( Fou bishop )
	{
		return pieceList.add( bishop );
	}

	public boolean addKing( Roi king )
	{
		return pieceList.add( king );
	}

	public boolean addKnight( Cavalier knight )
	{
		return pieceList.add( knight );
	}

	public boolean addQueen( Dame queen )
	{
		return pieceList.add( queen );
	}

	public Position getPosition( int x, int y )
	{
		return Position.getPosition( x, y );
	}

	public LinkedList<Piece> getPieceList()
	{
		return pieceList;
	}
}
