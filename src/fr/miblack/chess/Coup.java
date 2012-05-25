
package fr.miblack.chess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.piece.Piece;
import fr.miblack.chess.piece.Pion;

/**
 * Cette classe regroupe tout les composant d'un coup
 * @author mi-black
 */
public class Coup
{
	/**
	 * maRegex  est une Regex (Comprendre Expréssion régulière) qui permet de déterminer si un coup est complet ou non
	 */
	static String maRegex= "^([FDRCT]?)([a-h][1-8])([-x])([a-h][1-8])(=?)([FDCT]?)[#+!?]*$";
	
	
	/**
	 * maRegexRoque  est une Regex (Comprendre Expréssion régulière) qui permet de déterminer si un coup st un roque
	 */
	static String maRegexRoque="^(O-O-O|O-O)?";
	
	
	/**
	 * 	myRegexComp est un parttern (une sorte de moule) ou l'on insère une regex ici maRegex
	 */
	protected static Pattern  myRegexComp = Pattern.compile(maRegex );
	
	
	/**
	 * 	myRegexRoque est un parttern (une sorte de moule) ou l'on insère une regex ici maRegexRoque
	 */
	protected static Pattern  myRegexRoque = Pattern.compile(maRegexRoque );
	
	/**
	 *  La piece d'ou part le coup
	 */
	protected Piece		pieceDepart;
	
	/**
	 *  La position d'ou part le coup
	 */
	protected Position	posDepart;
	
	/**
	 *  La position d'arrivée du coup
	 */
	protected Position	posArrivee;
	
	/**
	 *  Le coup est une prise ?
	 */
	protected boolean		estPrise;
	
	/**
	 *  Dans le cas d'une prise , on stock la piece
	 */
	protected Piece		PiecePrise;
	
	/**
	 *  En quoi la piece est promus D F T ou C 
	 */
	protected String		promotion;
	
	/**
	 *  Le coup est un petit roque ?
	 */
	protected boolean estPetitRoque ;
	
	/**
	 *  Le coup est un roque ?
	 */
	protected boolean estRoque ;
	
	/**
	 *  Couleur du coup (utile pour le roque)
	 */
	protected Couleur couleur;
	


	/**
	 * Constructeur du roque
	 * @param petitRoque : un petit roque ?
	 * @param couleur  : la couleur du roque
	 */
	public Coup(boolean petitRoque,Couleur couleur)
	{	
		this.estRoque=true;
		this.couleur=couleur;
		this.estPetitRoque=petitRoque;
	}
	

	/**
	 * Constructeur avancé d'un coup , il gère la promotion et la prise 
	 * @param  pieceDepart
	 * @param posArrivee 
	 * @param prise
	 * @param promotion
	 */
	public Coup( Piece pieceDepart, Position posArrivee, boolean prise,
			String promotion ) {
		this.setPieceDepart( pieceDepart );
		this.estRoque=false;
		this.setPosDepart( pieceDepart.getPos().clone() );
		this.setPosArrivee( posArrivee );
		this.setEstPrise( prise );
		this.setPromotion( promotion );
	}
	
	/**
	 * Constructeur basique d'un coup avec possibilité de prise
	 */
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

	/**
	 *  Recupère si le coup est un roque
	 * @return estRoque ?
	 */
	public boolean getRoque()
	{
		return this.estRoque;
	}
	
	/**
	 * the pieceDepart to set
	 * @param piece
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
	 *  the posArrivee to set
	 */
	public void setPosArrivee( Position posArrivee )
	{
		if ( Position.valValide( posArrivee.getX() )
				&& Position.valValide( posArrivee.getY() ) )
			this.posArrivee = posArrivee;
		else
			throw new RuntimeException( posArrivee.getX() + ", "+ posArrivee.getY() + " : coordonnees  invalide" );
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
			throw new RuntimeException( posDepart.getX() + ", "+ posDepart.getY() + " : coordonnees  invalide" );
	}
	
	/**
	 * @return La chaine d'un coup , lisible par un homme
	 */
	public String toString()
	{
		if(estRoque==false)
		{
			if ( isEstPrise() )
			{
				if((pieceDepart instanceof Pion) &&(posArrivee.getY()==0 || posArrivee.getY()==7))
				{
					return "" + pieceDepart.getNom() + posDepart.toStringPos() + "x"+ posArrivee.toStringPos()+"="+promotion;
				}
				else
					return "" + pieceDepart.getNom() + posDepart.toStringPos() + "x"+ posArrivee.toStringPos();
			}
			else
				if((pieceDepart instanceof Pion) &&(posArrivee.getY()==0 || posArrivee.getY()==7))
				{
					return "" + pieceDepart.getNom() + posDepart.toStringPos() + "-"+ posArrivee.toStringPos()+"="+promotion;
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
	/*
	 * public boolean metEnEchec( JoueurAbstract p, Echiquier chess )
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
	 */
	
	/**
	 * 
	 * @param myString chaine style a2-a4
	 * @param party la partie 
	 * @param p	le joueur
	 * @return a new Coup avec tout comme il faut !
	 */
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
				else
					return new Coup( pieceD, posA, prise );
			}	
		throw new RuntimeException( "coup invalide" );
	}

	/**
	 * Le coup est une prise ?
	 * @return estPrise 
	 */
	public boolean isEstPrise()
	{
		return estPrise;
	}
	
	/**
	 * Set estPrise
	 */
	public void setEstPrise( boolean estPrise )
	{
		this.estPrise = estPrise;
	}
	
	/**
	 * test si deux coups sont identiques 
	 * @param autre un autre coup
	 * @return true si equals , false sinon
	 */
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

	/**
	 * La piece prise
	 * @return piecePrise
	 */
	
	public Piece getPiecePrise()
	{
		return PiecePrise;
	}
	
	/**
	 * Set piecePrise
	 */
	public void setPiecePrise( Piece piecePrise )
	{
		PiecePrise = piecePrise;
	}
	
	/**
	 * get Promotion
	 */
	public String getPromotion()
	{
		return promotion;
	}

	
	/**
	 * Set promotion
	 */
	public void setPromotion( String promotion )
	{
		this.promotion = promotion;
	}
	
	/**
	 * Get couleur
	 */
	public Couleur getCouleur()
	{
		return couleur;
	}
	
	/**
	 * Set couleur
	 */
	public void setCouleur( Couleur couleur )
	{
		this.couleur = couleur;
	}
}
