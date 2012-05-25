
package fr.miblack.chess;

import java.util.*;

import fr.miblack.chess.Position;
import fr.miblack.chess.piece.*;


/**
 * Un echiquier est composé d'une liste de piece et d'une piece bidon (pour les test de déplacement
 * 
 * @author mi-black
 */
public class Echiquier
{

	private LinkedList<Piece>	pieceList	= new LinkedList<Piece>();
	private Piece				piecePourTest;

	
	/**
	 * @param pos
	 * @return la piece a la position donnee , null si la position est vide
	 */
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

	/**
	 * Retourne la piece positionné a telle coordonnée x & y
	 * @param x
	 * @param y
	 * @return la piece a la position donnee , null si la position est vide
	 */
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
	 * @param posArrivee
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

	/**
	 * Deplace une piece sans faire de test
	 * 
	 * @param posDepart
	 * @param posArrivee
	 * @return s'il y  a une prise de piece
	 */
	public boolean deplacerPiecePourTest( Position posDepart,Position posArrivee )
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

	/**
	 * @param posDepart
	 * @param posArrivee
	 * @param isPrise 
	 */
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

	/**
	 * Realise un déplacement 
	 * @param myCoup 
	 * @return 
	 */
	@SuppressWarnings( "null" )
	public boolean realiserCoup( Coup myCoup )
	{
		
		Piece pieceD = null;
		Position posA = null;
		piecePourTest = null;
		
		try
		{
			pieceD = myCoup.getPieceDepart();
			posA = myCoup.getPosArrivee();
			myCoup.setPiecePrise( this.getPiecePosition( posA ) );
		}
		catch (NullPointerException e)
		{
			e.getStackTrace();
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
			realiserRoque(myCoup);
		}
		return false;
	}

	/**
	 * Realise le roque (deplace les pieces)
	 * @param myCoup (le coup joue)
	 */
	public void realiserRoque(Coup myCoup)
	{
		Piece roi=null;
		Piece tour=null;
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
	
	/**
	 * Realise la promotion (change la piece)
	 * @param myCoup
	 */
	
	public void realiserPromotion( Coup myCoup )
	{
		Piece pieceD = null;
		Piece pieceApres = null;
		pieceD = myCoup.getPieceDepart();
		if ( pieceD instanceof Pion )
			pieceApres = ((Pion) pieceD).promotion( myCoup.getPromotion() );
		pieceList.remove( pieceD );
		pieceList.add( pieceApres );
	}

	/**
	 * @return pieceList.size()
	 */
	public int size()
	{
		return pieceList.size();
	}
	
	/**
	 * @param pawn
	 * @return add un pion a la LinkedList de piece
	 */
	public boolean addPawn( Pion pawn )
	{
		return pieceList.add( pawn );
	}
	
	/**
	 * @param rook
	 * @return add une tour a la LinkedList de piece
	 */
	public boolean addRook( Tour rook )
	{
		return pieceList.add( rook );
	}
	
	/**
	 * 
	 * @param bishop
	 * @return add un fou a la LinkedList de piece
	 */
	public boolean addBishop( Fou bishop )
	{
		return pieceList.add( bishop );
	}

	/**
	 * @param king
	 * @return add un roi a la LinkedList de piece
	 */
	public boolean addKing( Roi king )
	{
		return pieceList.add( king );
	}
	
	/**
	 * @param knight
	 * @return add un cavalier a la LinkedList de piece
	 */
	public boolean addKnight( Cavalier knight )
	{
		return pieceList.add( knight );
	}

	/**
	 * @param queen
	 * @return add une dame a la LinkedList de piece
	 */
	public boolean addQueen( Dame queen )
	{
		return pieceList.add( queen );
	}

	/**
	 * Le fly-weight de position
	 * @param x
	 * @param y
	 * @return Position.getPosition( x, y )
	 */
	public Position getPosition( int x, int y )
	{
		return Position.getPosition( x, y );
	}

	/**
	 * @return get la liste de piece
	 */
	public LinkedList<Piece> getPieceList()
	{
		return pieceList;
	}
}
