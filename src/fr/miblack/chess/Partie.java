
package fr.miblack.chess;

import fr.miblack.chess.Echiquier;
import fr.miblack.chess.GUI.Interface;
import fr.miblack.chess.GUI.Textuelle;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.joueurs.JoueurHumain;
import fr.miblack.chess.piece.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Partie
{

	private LinkedList<Coup>			listOfMove			= new LinkedList<Coup>();

	private LinkedList<Coup>			listOfMoveCancelled	= new LinkedList<Coup>();
	private LinkedList<JoueurAbstract>	listOfPlayer		= new LinkedList<JoueurAbstract>();

	private JoueurAbstract				playerEnCours;
	private int							cpt_sans_prise		= 0;
	private int							cptSansMvmtPion		= 0;
	private Echiquier					myChessboard		= new Echiquier();

	public Partie( JoueurAbstract player1, JoueurAbstract player2 ) 
	{
		listOfPlayer.add( player2 );
		listOfPlayer.addFirst( player1 );
		letsPlay( player1 );
	}

	public Echiquier getMyChessboard()
	{
		return myChessboard;
	}

	public Coup annulerDernierCoup()
	{
		Coup last = listOfMove.getLast();
		listOfMoveCancelled.add( listOfMove.getLast() );
		last.getPieceDepart().setPos( last.getPosDepart() );
		return listOfMove.removeLast();
	}

	public Coup rejouerDernierCoup()
	{
		listOfMove.add( listOfMoveCancelled.getLast() );
		return listOfMoveCancelled.removeLast();
	}

	public boolean estPat( JoueurAbstract p )
	{
		boolean stalemate = false;
		LinkedList<Piece> listeDePiece = new LinkedList<Piece>();
		for ( Piece onePiece : this.myChessboard.getPieceList() )
		{
			if ( onePiece.getColor().equals( p.getColor() ) )
			{
				listeDePiece.add( onePiece );
			}
		}

		if ( !estEnEchec( p ) )
		{
			try
			{
				for ( Piece onePiece : listeDePiece )
				{
					LinkedList<Position> listPos = onePiece.positionAccessibleChessboard( getMyChessboard() );
					for ( Position posA : listPos )
					{
						stalemate = seraEnEchec( onePiece.getPos().clone(),posA.clone() );
						if ( stalemate == false )
						{
							return stalemate;
						}
					}
				}
			} catch (ConcurrentModificationException e)
			{

			}
		}
		return stalemate;
	}

	public boolean estEnEchec( Position laPos )
	{
		boolean check = false;
		Piece maPiece = this.getMyChessboard().getPiecePosition( laPos );
		if ( maPiece != null )
		{
			LinkedList<Position> listPos = maPiece.positionAccessibleChessboard( getMyChessboard() );
			for ( Position onePos : listPos )
			{
				if ( this.getMyChessboard().getPiecePosition( onePos ) != null )
				{
					if ( this.getMyChessboard().getPiecePosition( onePos ) instanceof Roi )
					{
						check = true;
					}
				}
			}
		}
		return check;
	}

	@SuppressWarnings( "null" )
	public boolean seraEnEchec( Position laPosD, Position laPosA )
	{
		boolean prise = this.getMyChessboard().deplacerPiecePourTest( laPosD,
				laPosA );
		boolean check = false;

		Piece roiPiece = null;

		LinkedList<Piece> maListeDePiece = this.getMyChessboard().getPieceList();
		for ( Piece laPiece : maListeDePiece )
		{
			if ( laPiece instanceof Roi&& (getPlayerEnCours().getColor().equals( laPiece.getColor() )) )
			{
				roiPiece = laPiece;
			}
		}
		for ( Piece onePiece : maListeDePiece )
		{
			if ( !getPlayerEnCours().getColor().equals( onePiece.getColor() ) )
			{
				if ( onePiece.positionAccessibleChessboard( this.myChessboard ).contains( roiPiece.getPos() ) )
				{
					check = true;
				}
				if ( onePiece instanceof Pion )
				{
					check = check|| ((Pion) onePiece).metEnEchec( this.myChessboard );
				}
			}
		}
		this.getMyChessboard().annulerDeplacerPiecePourTest( laPosD, laPosA,prise );
		return check;
	}

	public boolean roquePossible(Echiquier chess,boolean petitRoque )
	{
		Couleur color=getPlayerEnCours().getColor();
		int xRoi;
		int yRoi;
		int xTour;
		int yTour;
		if(color.getColor()==0)
		{
			xRoi=4;
			yRoi=0;
			if(petitRoque)
			{
				xTour=7;
				yTour=0;
			}
			else
			{
				xTour=0;
				yTour=0;
			}
		}
		else
		{
			xRoi=4;
			yRoi=7;
			if(petitRoque)
			{
				xTour=7;
				yTour=7;
			}
			else
			{
				xTour=0;
				yTour=7;
			}
		}
		Position Roi=Position.getPosition( xRoi, yRoi );
		Position Tour=Position.getPosition( xTour, yTour );
		Piece pieceRoi=chess.getPiecePosition( Roi );
		Piece pieceTour=chess.getPiecePosition( Tour );
		if(pieceRoi !=null && pieceRoi.getPlayed()==0)
		{
			if(pieceTour !=null && pieceTour.getPlayed()==0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public boolean promotionPossible( Echiquier chess )
	{
		boolean possible = false;
		int col = 0;
		for ( Piece unePiece : chess.getPieceList() )
		{
			if ( unePiece.getColor().getColor() == 1 )
			{
				col = 7;
			}
			else
			{
				col = 0;
			}
			if ( unePiece instanceof Pion )
			{
				if ( unePiece.getY() == col )
				{
					possible = true;
				}
			}
		}
		return possible;
	}

	public void realiserCoup( Coup m )
	{
		if ( m.isEstPrise() )
		{
			this.setCpt_sans_prise();
		}
		else
			this.upCpt_sans_prise();
		if(m.getPieceDepart().toString().equalsIgnoreCase( "P" ))
			this.setCptSansMvmtPion();
		else
			this.upCptSansMvmtPion();

		this.getMyChessboard().realiserCoup( m );
		addMove( m );
	}

	// Le null Supress n'est pas obligatoire car un joueur à TOUJOURS un roi
	@SuppressWarnings( "null" )
	public boolean estEnEchec( JoueurAbstract p )
	{
		boolean check = false;
		Piece roiPiece = null;
		for ( Piece onePiece : this.myChessboard.getPieceList() )
		{
			if ( p.getColor().equals( onePiece.getColor() )&& onePiece instanceof Roi )
			{
				roiPiece = onePiece;
			}
		}
		for ( Piece onePiece : this.myChessboard.getPieceList() )
		{
			if ( !(onePiece instanceof Roi) )
			{
				if ( !p.getColor().equals( onePiece.getColor() ) )
				{
					if ( onePiece.positionAccessibleChessboard(this.myChessboard ).contains( roiPiece.getPos() ) )
					{
						check = true;
					}
					if ( onePiece instanceof Pion )
					{
						check = check || ((Pion) onePiece) .metEnEchec( this.myChessboard );
					}
				}
			}
		}
		return check;
	}

	public boolean estEchecEtMat( Position laPos )
	{
		boolean mat = false;

		if ( estEnEchec( laPos ) )
		{
			for ( Position onePos : getMyChessboard().getPiecePosition( laPos ).positionAccessibleChessboard( getMyChessboard() ) )
			{
				if ( estEnEchec( onePos ) )
				{
					mat = true;
				}
				else
				{
					mat = false;
				}
			}
			return mat;
		}
		return mat;
	}

	@SuppressWarnings( "null" )
	public boolean estEchecEtMat( JoueurAbstract p )
	{
		Piece roiPiece = null;
		boolean mat = false;
		// 1boolean prise=false;
		LinkedList<Piece> listeDePiece = this.myChessboard.getPieceList();
		for ( Piece onePiece : listeDePiece )
		{
			if ( p.getColor().equals( onePiece.getColor() )	&& onePiece instanceof Roi )
			{
				roiPiece = onePiece;
			}
		}
		LinkedList<Position> posKingAccess = roiPiece.positionAccessibleChessboard( getMyChessboard() );
		for ( Position posA : posKingAccess )
		{
			mat = seraEnEchec( roiPiece.getPos().clone(), posA );
			if ( mat == false )
			{
				return mat;
			}
		}
		try
		{
			for ( Piece onePiece : listeDePiece )
			{
				LinkedList<Position> listPos = onePiece.positionAccessibleChessboard( getMyChessboard() );
				for ( Position posA : listPos )
				{
					mat = seraEnEchec( onePiece.getPos().clone(), posA.clone() );
					if ( mat == false )
					{
						return mat;
					}
				}
			}
		} catch (ConcurrentModificationException e)
		{

		}

		return mat;
	}

	public boolean isDraw()
	{
		boolean draw = (cptSansMvmtPion > 50 || cpt_sans_prise > 50);
		return draw;
	}

	public void saveGame( String pathOfFile )
	{
		  try 
		  {
              String chaine=null;
			  FileWriter fstream =new FileWriter( pathOfFile );
			  BufferedWriter out =new BufferedWriter( fstream );
			  chaine=new String("[White \""+getJoueur( 0 )+"\"]\n");
			  out.write( chaine );
			  chaine=new String("[Black \""+getJoueur( 1 )+"\"]\n");
			  out.write( chaine );
			  out.write( miseEnFormeListCoup());
			  out.close();
		  }
		  catch(Exception e) { System.err.println("Error: "+ e.getMessage()); }
		 
	}

	public void loadGame( String pathOfFile ,Interface monInterface )
	{
		String j1="";
		String j2="";
		boolean fin=false;
		String lecture="";
		Coup coup=null;
		JoueurAbstract pJ1= new JoueurHumain("", new Couleur(0),monInterface);
		JoueurAbstract pJ2= new JoueurHumain("", new Couleur(1),monInterface);
		if(!listOfMove.isEmpty())
			this.listOfMove.remove();
		if(!myChessboard.getPieceList().isEmpty())
			myChessboard.getPieceList().remove();
		if(!listOfPlayer.isEmpty())
			listOfPlayer.remove();
		
		try
		{
			InputStream ips=new FileInputStream( pathOfFile );
			InputStreamReader ipsr=new InputStreamReader( ips );
			BufferedReader bis =new BufferedReader(ipsr);
			try
			{
				j1=bis.readLine().substring( 8 );
				j1=j1.substring( 0, j1.indexOf( "\"" ) );
				j2=bis.readLine().substring( 8 );
				j2=j2.substring( 0, j2.indexOf( "\"" ) );
				pJ1.setName(j1 );
				pJ2.setName(j2);
				listOfPlayer.add( pJ2 );
				listOfPlayer.addFirst( pJ1 );
				this.letsPlay( pJ1 );
			} 
			catch (IOException e)
			{
				System.out.println("Erreur de chargement");
				fin=true;
			}
			while(fin==false)
			{
				try
				{
					lecture=bis.readLine();
					if(lecture!=null)
					{
						coup=Coup.parseStringToCoupCompl( lecture, this );
					}
					else
					{
						fin=true;
						break;
					}
					if(this.seraEnEchec( coup.getPosDepart().clone(), coup.getPosArrivee().clone() ) )
					{
						throw new Exception("Le coup est erroné");
					}
					this.myChessboard.realiserCoup( coup );
					this.listOfMove.add( coup );
					this.setPlayerEnCours();
				}
				catch(Exception e)
				{
					 e.printStackTrace();
				}
			}
			try
			{
				bis.close();
				System.out.println("Partie bien chargée !");
			}
			catch (Exception e)
			{
				System.out.println("Echec de fermeture");
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		if(monInterface instanceof Textuelle)
		{
			((Textuelle)monInterface).AfficherEchiquier();
			System.out.println( ((Textuelle)monInterface).getMaPartie().listOfAvailableMove( getPlayerEnCours() ) );
			System.out.println( "C'est au joueur " + getPlayerEnCours().getType() + " "+ getPlayerEnCours().toString() + " de jouer !" );
		}
	}

	public LinkedList<Coup> listOfAvailableMove( JoueurAbstract p )
	{
		LinkedList<Coup> listCoup = new LinkedList<Coup>();
		for ( Piece onePiece : myChessboard.getPieceList() )
		{
			if ( onePiece.getColor().equals( p.getColor() ) )
			{
				listCoup.addAll( onePiece.getCoupPossible( onePiece, this ) );
			}
		}
		return listCoup;
	}

	public void initPositions()
	{
		/*************************** White piece ***********************************/
		/*************************** Black piece ***********************************/

		this.myChessboard.addKing( new Roi( new Couleur( 0 ), Position.getPosition( 4, 7 ), 0 ) );
		this.myChessboard.addKing( new Roi( new Couleur( 1 ), Position.getPosition( 4, 0 ), 0 ) );

		this.myChessboard.addQueen( new Dame( new Couleur( 0 ), Position.getPosition( 3, 7 ), 10 ) );
		this.myChessboard.addQueen( new Dame( new Couleur( 1 ), Position.getPosition( 3, 0 ), 10 ) );

		this.myChessboard.addRook( new Tour( new Couleur( 1 ), Position.getPosition( 0, 0 ), 5 ) );
		this.myChessboard.addRook( new Tour( new Couleur( 1 ), Position.getPosition( 7, 0 ), 5 ) );

		this.myChessboard.addRook( new Tour( new Couleur( 0 ), Position.getPosition( 0, 7 ), 5 ) );
		this.myChessboard.addRook( new Tour( new Couleur( 0 ), Position.getPosition( 7, 7 ), 5 ) );

		this.myChessboard.addBishop( new Fou( new Couleur( 1 ), Position.getPosition( 2, 0 ), 3 ) );
		this.myChessboard.addBishop( new Fou( new Couleur( 1 ), Position.getPosition( 5, 0 ), 3 ) );

		this.myChessboard.addBishop( new Fou( new Couleur( 0 ), Position.getPosition( 2, 7 ), 3 ) );
		this.myChessboard.addBishop( new Fou( new Couleur( 0 ), Position.getPosition( 5, 7 ), 3 ) );

		this.myChessboard.addKnight( new Cavalier( new Couleur( 1 ), Position.getPosition( 1, 0 ), 3 ) );
		this.myChessboard.addKnight( new Cavalier( new Couleur( 1 ), Position.getPosition( 6, 0 ), 3 ) );

		this.myChessboard.addKnight( new Cavalier( new Couleur( 0 ), Position.getPosition( 1, 7 ), 3 ) );
		this.myChessboard.addKnight( new Cavalier( new Couleur( 0 ), Position.getPosition( 6, 7 ), 3 ) );

		this.myChessboard.addPawn( new Pion( new Couleur( 1 ), Position.getPosition( 0, 1 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 1 ), Position.getPosition( 1, 1 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 1 ), Position.getPosition( 2, 1 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 1 ), Position.getPosition( 3, 1 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 1 ), Position.getPosition( 4, 1 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 1 ), Position.getPosition( 5, 1 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 1 ), Position.getPosition( 6, 1 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 1 ), Position.getPosition( 7, 1 ), 1 ) );

		this.myChessboard.addPawn( new Pion( new Couleur( 0 ), Position.getPosition( 0, 6 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 0 ), Position.getPosition( 1, 6 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 0 ), Position.getPosition( 2, 6 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 0 ), Position.getPosition( 3, 6 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 0 ), Position.getPosition( 4, 6 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 0 ), Position.getPosition( 5, 6 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 0 ), Position.getPosition( 6, 6 ), 1 ) );
		this.myChessboard.addPawn( new Pion( new Couleur( 0 ), Position.getPosition( 7, 6 ), 1 ) );
	}

	public void letsPlay( JoueurAbstract joueur1 )
	{
		initPositions();
		this.playerEnCours = joueur1;
	}

	public boolean addMove( Coup e )
	{
		return listOfMove.add( e );
	}

	/**
	 * @return the listOfMoveCancelled
	 */
	public LinkedList<Coup> getListOfMoveCancelled()
	{
		return listOfMoveCancelled;
	}

	public JoueurAbstract getJoueur( int i )
	{
		return this.listOfPlayer.get( i );
	}

	/**
	 * @param listOfMoveCancelled
	 *            the listOfMoveCancelled to set
	 */
	public void setListOfMoveCancelled( LinkedList<Coup> listOfMoveCancelled )
	{
		this.listOfMoveCancelled = listOfMoveCancelled;
	}

	public String miseEnFormeListCoup()
	{
		String msg="";
		Coup coup;
		Iterator<Coup> iterator=listOfMove.iterator();
		while(iterator.hasNext())
		{	
			coup=iterator.next();
			msg+=coup;
			msg+="\n"; 
		}
		return msg;
	}
	
	public int getCpt_sans_prise()
	{
		return cpt_sans_prise;
	}

	public void upCpt_sans_prise()
	{
		this.cpt_sans_prise++;
	}

	public void setCpt_sans_prise()
	{
		this.cpt_sans_prise = 0;
	}

	public void downCpt_sans_prise()
	{
		this.cpt_sans_prise--;
	}
	
	public void setCptSansMvmtPion()
	{
		this.cptSansMvmtPion=0;
	}
	
	public void upCptSansMvmtPion()
	{
		this.cptSansMvmtPion++;
	}

	public JoueurAbstract getPlayerEnCours()
	{
		return playerEnCours;
	}

	public void setPlayerEnCours()
	{
		if ( playerEnCours.equals( listOfPlayer.getFirst() ) )
		{
			this.playerEnCours = listOfPlayer.getLast();
		}
		else
			this.playerEnCours = listOfPlayer.getFirst();
	}

	public LinkedList<JoueurAbstract> getListOfPlayer()
	{
		return listOfPlayer;
	}

	public LinkedList<Coup> getListOfMove()
	{
		return listOfMove;
	}

}
