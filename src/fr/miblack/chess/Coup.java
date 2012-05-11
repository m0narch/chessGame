package fr.miblack.chess;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.piece.Piece;
import fr.miblack.chess.piece.Roi;

public class Coup
{
	private Piece pieceDepart;
	private Position posDepart;
	private Position posArrivee;
	private boolean estPrise;
	private Piece PiecePrise;
	
	public Coup(Piece pieceDepart,Position posArrivee )
	{
		 this.setPieceDepart( pieceDepart );
		 this.setPosDepart  ( pieceDepart.getPos().clone());
		 this.setPosArrivee ( posArrivee  );
	}
	
	public Coup(Piece pieceDepart,Position posArrivee,boolean prise)
	{
		 this.setPieceDepart( pieceDepart );
		 this.setPosDepart  ( pieceDepart.getPos().clone());
		 this.setPosArrivee ( posArrivee  );
		 this.setEstPrise	( prise );
	}
	
	/**
	 * @return the pieceDepart
	 */
	public Piece getPieceDepart()
	{
		return pieceDepart;
	}
	
	/**
	 * @param pieceDepart the pieceDepart to set
	 */
	public void setPieceDepart( Piece piece  )
	{
		this.pieceDepart = piece ;
	}

	/**
	 * @return the posArrivee
	 */
	public Position getPosArrivee()
	{
		return posArrivee;
	}
	
	/**
	 * @param posArrivee the posArrivee to set
	 */
	public void setPosArrivee( Position posArrivee )
	{
		if(Position.valValide(posArrivee.getX())&&Position.valValide(posArrivee.getY()))
			this.posArrivee = posArrivee;
		else
			throw new RuntimeException(posArrivee.getX() + ", " + posArrivee.getY() + " : coordonnées  invalide");
	}

	/**
	 * @return the posDepart
	 */
	public Position getPosDepart()
	{
		return posDepart;
	}

	/**
	 * @param posDepart the posDepart to set
	 */
	public void setPosDepart( Position posDepart )
	{
		if( Position.valValide(posDepart.getX()) && Position.valValide(posDepart.getY()) )
			this.posDepart = posDepart;
		else
			throw new RuntimeException(posDepart.getX() + ", " + posDepart.getY() + " : coordonnées  invalide");
	}
	
	public String toString()
	{
		if(isEstPrise())
		{
			return ""+pieceDepart.getNom()+posDepart.toStringPos()+"x"+posArrivee.toStringPos();
		}
		else
			return ""+pieceDepart.getNom()+posDepart.toStringPos()+"-"+posArrivee.toStringPos();
	}

	public boolean metEnEchec(JoueurAbstract p,Echiquier chess)
	{
		boolean echec=false;
		Piece maPiece=pieceDepart;
		if(maPiece!=null)
		{
			LinkedList<Position> listPos =maPiece.positionAccessibleChessboard( chess );
			for(Position onePos :listPos)
			{
				if(chess.getPiecePosition(onePos)!=null)
				{
					if(chess.getPiecePosition(onePos) instanceof Roi)
					{
						echec=true;
					}
				}
			}
		}
		return echec;
	}
		
	//TODO Réussir la regex du coup simplifié
	//TODO ... gérer the fuc***** prise en passant 
	public static Coup parseStringToCoupCompl(String myString,Partie party)
	{
		Pattern myRegexComp=Pattern.compile("^([FDRCT]?)([a-h][1-8])([-x])([a-h][1-8])[=]?([FDCT]?)[#+!?]*$");
		Matcher matcher= myRegexComp.matcher( myString );
		Piece pieceD;
		boolean prise;
		Position posA;
		if(matcher.find())
		{
			pieceD =party.getMyChessboard().getPiecePosition(Position.stringToPos(matcher.group(2)));
			posA=Position.stringToPos( matcher.group(4) );
			prise =matcher.group(3).equals("x");
			return new Coup(pieceD, posA , prise);
		}
		throw new RuntimeException("coup invalide");
	}
	
	public boolean isEstPrise()
	{
		return estPrise;
	}

	public void setEstPrise( boolean estPrise )
	{
		this.estPrise = estPrise;
	}

	public boolean equals(Coup autre)
	{
		return (pieceDepart.equals(autre.pieceDepart) && posArrivee.equals( autre.posArrivee )  && pieceDepart.getPos().equals( autre.posDepart ) );		
	}
	
	
	public Piece getPiecePrise()
	{
		return PiecePrise;
	}
	public void setPiecePrise( Piece piecePrise )
	{
		PiecePrise = piecePrise;
	}
	
}
