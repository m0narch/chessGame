
package fr.miblack.chess;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.piece.Piece;
import fr.miblack.chess.piece.Roi;

public class Coup
{
	static String maRegex= "^([FDRCT]?)([a-h][1-8])([-x])([a-h][1-8])(=?)([FDCT]?)[#+!?]*$";
	static String maRegexRoque="^(O-O-O|O-O)?";
	protected static Pattern  myRegexComp = Pattern.compile(maRegex );
	protected static Pattern  myRegexRoque = Pattern.compile(maRegexRoque );
	protected Piece		pieceDepart;
	protected Position	posDepart;
	protected Position	posArrivee;
	protected boolean		estPrise;
	protected Piece		PiecePrise;
	protected String		promotion;
	protected boolean estPetitRoque ;
	protected boolean estRoque ;
	protected Couleur couleur;
	


	public Coup(boolean petitRoque,Couleur couleur)
	{	
		this.estRoque=true;
		this.couleur=couleur;
		//TODO realiser coup pour le roque !
		this.estPetitRoque=petitRoque;
	}

	public Coup( Piece pieceDepart, Position posArrivee ) {
		this.setPieceDepart( pieceDepart );
		this.estRoque=false;
		this.setPosDepart( pieceDepart.getPos().clone() );
		this.setPosArrivee( posArrivee );
	}

	public Coup( Piece pieceDepart, Position posArrivee, boolean prise,
			String promotion ) {
		this.setPieceDepart( pieceDepart );
		this.estRoque=false;
		this.setPosDepart( pieceDepart.getPos().clone() );
		this.setPosArrivee( posArrivee );
		this.setEstPrise( prise );
		this.setPromotion( promotion );
	}

	public Coup( Piece pieceDepart, Position posArrivee, boolean prise ) {
		this.setPieceDepart( pieceDepart );
		this.setPosDepart( pieceDepart.getPos().clone() );
		this.setPosArrivee( posArrivee );
		this.setEstPrise( prise );
		this.estRoque=false;
	}

	/**
	 * @return the pieceDepart
	 */
	public Piece getPieceDepart()
	{
		return pieceDepart;
	}

	public boolean getRoque()
	{
		return this.estRoque;
	}
	/**
	 * @param pieceDepart
	 *            the pieceDepart to set
	 */
	public void setPieceDepart( Piece piece )
	{
		this.pieceDepart = piece;
	}

	/**
	 * @return the posArrivee
	 */
	public Position getPosArrivee()
	{
		return posArrivee;
	}

	/**
	 * @param posArrivee
	 *            the posArrivee to set
	 */
	public void setPosArrivee( Position posArrivee )
	{
		if ( Position.valValide( posArrivee.getX() )
				&& Position.valValide( posArrivee.getY() ) )
			this.posArrivee = posArrivee;
		else
			throw new RuntimeException( posArrivee.getX() + ", "+ posArrivee.getY() + " : coordonnées  invalide" );
	}

	/**
	 * @return the posDepart
	 */
	public Position getPosDepart()
	{
		return posDepart;
	}

	/**
	 * @param posDepart
	 *            the posDepart to set
	 */
	public void setPosDepart( Position posDepart )
	{
		if ( Position.valValide( posDepart.getX() )&& Position.valValide( posDepart.getY() ) )
			this.posDepart = posDepart;
		else
			throw new RuntimeException( posDepart.getX() + ", "+ posDepart.getY() + " : coordonnées  invalide" );
	}

	public String toString()
	{
		if(estRoque==false)
		{
			if ( isEstPrise() )
			{
				return "" + pieceDepart.getNom() + posDepart.toStringPos() + "x"+ posArrivee.toStringPos();
			}
			else
				return "" + pieceDepart.getNom() + posDepart.toStringPos() + "-"+ posArrivee.toStringPos();
		}
		else
		{
			if(estPetitRoque)
				return "O-O";
			else
				return "O-O-O";
		}
	}

	public boolean metEnEchec( JoueurAbstract p, Echiquier chess )
	{
		boolean echec = false;
		Piece maPiece = pieceDepart;
		if ( maPiece != null )
		{
			LinkedList<Position> listPos = maPiece.positionAccessibleChessboard( chess );
			for ( Position onePos : listPos )
			{
				if ( chess.getPiecePosition( onePos ) != null )
				{
					if ( chess.getPiecePosition( onePos ) instanceof Roi )
					{
						echec = true;
					}
				}
			}
		}
		return echec;
	}

	public static Coup parseStringToCoupCompl(String myString, Partie party,JoueurAbstract p )
	{
		Matcher matcher = myRegexComp.matcher( myString );
		Matcher matcherRoque = myRegexRoque.matcher( myString );
		Piece pieceD;
		boolean prise;
		String promotion;
		Position posA;
 
		if(matcherRoque.matches())
		{
			if(matcherRoque.group(1).equals( "O-O" ))
			{
				return new Coup(true,p.getColor());
			}
			else
			{
				return new Coup(false,p.getColor());
			}
		}
			if ( matcher.matches() )
			{
				pieceD = party.getMyChessboard().getPiecePosition(Position.stringToPos( matcher.group( 2 ) ) );
				posA = Position.stringToPos( matcher.group( 4 ) );
				prise = matcher.group( 3 ).equals( "x" );
				promotion = matcher.group( 6 );
				if ( matcher.group( 5 ).equals( "=" ) && !promotion.isEmpty() )
					return new Coup( pieceD, posA, prise, promotion );
				return new Coup( pieceD, posA, prise );
			}	
		throw new RuntimeException( "coup invalide" );
	}

	public boolean isEstPrise()
	{
		return estPrise;
	}

	public void setEstPrise( boolean estPrise )
	{
		this.estPrise = estPrise;
	}

	public boolean equals( Coup autre )
	{
		boolean equals;
		if(this.estRoque)
		{
			equals=(autre.estPetitRoque==this.estPetitRoque);
		}
		else
		{
			equals=(pieceDepart.equals( autre.pieceDepart )&& posArrivee.equals( autre.posArrivee ) && pieceDepart.getPos().equals( autre.posDepart ));
		}
		return equals;
	}

	public Piece getPiecePrise()
	{
		return PiecePrise;
	}

	public void setPiecePrise( Piece piecePrise )
	{
		PiecePrise = piecePrise;
	}

	public String getPromotion()
	{
		return promotion;
	}

	public void setPromotion( String promotion )
	{
		this.promotion = promotion;
	}
	public Couleur getCouleur()
	{
		return couleur;
	}

	public void setCouleur( Couleur couleur )
	{
		this.couleur = couleur;
	}
}
