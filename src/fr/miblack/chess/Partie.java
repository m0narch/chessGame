
package fr.miblack.chess;

import fr.miblack.chess.Echiquier;
import fr.miblack.chess.affichage.Interface;
import fr.miblack.chess.affichage.Textuelle;
import fr.miblack.chess.affichage.GUI.Fenetre;
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

/** 
 * @author mi-black
 * Une partie est définie par ...
 * listOfMove :une liste de coup 
 * listOfPlayer : une liste de joueurs
 * playerEnCours : le joueur qui possède la main
 * cpt_sans_prise : le nbre de coup sans 1 prise de piece
 * cptSansMvmtPion : le nbre de coup dans déplacer un pion
 * myChessboard : l'echiquier sur lequel se base la partie
 */
public class Partie
{

	private LinkedList<Coup>			listOfMove			= new LinkedList<Coup>();

	private LinkedList<JoueurAbstract>	listOfPlayer		= new LinkedList<JoueurAbstract>();

	private JoueurAbstract				playerEnCours;
	private int							cpt_sans_prise		= 0;
	private int							cptSansMvmtPion		= 0;
	private Echiquier					myChessboard		= new Echiquier();
	
	/**
	 * Constructeur de partie
	 * @param player1
	 * @param player2
	 */
	public Partie( JoueurAbstract player1, JoueurAbstract player2 ) 
	{
		listOfPlayer.add( player2 );
		listOfPlayer.addFirst( player1 );
		letsPlay( player1 );
	}

	/**
	 * @return
	 */
	public Partie clone()
	{
		Partie maPartie= new Partie( listOfPlayer.getFirst(), listOfPlayer.getLast() );
		maPartie.setListOfMove( listOfMove );
		return maPartie;
	}
	/**
	 * @return myChessboard
	 */
	public Echiquier getMyChessboard()
	{
		return myChessboard;
	}

	/**
	 * @param p un joueur
	 * @return p est pat ?
	 */
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
				e.getStackTrace();
			}
		}
		return stalemate;
	}

	/**
	 * 
	 * @param laPos la pos ou se de placer 
	 * @return si on est en Echecs à laPos
	 */
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
	
	/**
	 * @param listOfMove
	 */
	public void setListOfMove( LinkedList<Coup> listOfMove )
	{
		this.listOfMove = listOfMove;
	}
	/**
	 * Verifie si l'on est en echec si l'on bouge une piece d'une posD à une posA
	 * @param laPosD
	 * @param laPosA
	 * @return si posD se libere et que la piece va en posA , y aura echec ?
	 */
	@SuppressWarnings( "null" )
	public boolean seraEnEchec( Position laPosD, Position laPosA )
	{
		boolean prise = this.getMyChessboard().deplacerPiecePourTest( laPosD,laPosA );
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
				try
				{
					if ( onePiece.positionAccessibleChessboard( this.myChessboard ).contains( roiPiece.getPos() ) )
					{
						check = true;
					}	
				}
				catch(NullPointerException e)
				{
					e.getStackTrace();
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

	/**
	 * @return la position du Roi du joueur courant
	 */
	public Position getPosRoi( )
	{
		setPlayerEnCours();
		Couleur color=getPlayerEnCours().getColor();
		int xRoi=4;
		int yRoi=0;
		if(color.getColor()==0)
		{
			xRoi=4;
			yRoi=0;
		}
		else
		{
			xRoi=4;
			yRoi=7;
		}
		setPlayerEnCours();
		return Position.getPosition( xRoi, yRoi );
	}

	/**
	 * @param petitRoque
	 * @return la position de la tour du joueur courant concernée par le roque
	 */
	public  Position getPosTour( boolean petitRoque)
	{
		setPlayerEnCours();
		Couleur color=getPlayerEnCours().getColor();
		int xTour=0;
		int yTour=0;
		if(color.getColor()==0)
		{
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

		setPlayerEnCours();
		return Position.getPosition( xTour, yTour );
	}
	
	/**
	 * @param chess : l'echiquier
	 * @param Roi	la position du roi
	 * @param petitRoque
	 * @return Si le trajet est possible entre le roi et le petit(ou grand) roque
	 */
	public boolean trajetLibre(Echiquier chess,Position Roi,boolean petitRoque)
	{
		int x1=Roi.getX()-1;
		int x2=Roi.getX()-2;
		int j1=Roi.getX()+1;
		int j2=Roi.getX()+2;
		if(!petitRoque)
		{
			if(Position.valValide( x1 ) && Position.valValide( x2 ))
			{
				if(chess.getPiecePosition( Position.getPosition( x1 , Roi.getY() ) )==null)
				{
					if(chess.getPiecePosition( Position.getPosition(x2 ,  Roi.getY() ) )==null)
					{
							return true;
					}	
				}
			}
			else
				return false;
		}
		else
		{
			if(Position.valValide( j1 )&& Position.valValide( j2 ) )
			{
				if(chess.getPiecePosition( Position.getPosition( j1 ,  Roi.getY() ) )==null)
				{
					if(chess.getPiecePosition( Position.getPosition( j2 ,  Roi.getY() ) )==null)
					{
						return true;
					}
				}
			}	
		}
		return false;
	}
	
	/**
	 * @param chess l'echiquier
	 * @return Le petit roque est possible ?
	 */
	public boolean petitRoquePossible(Echiquier chess  )
	{
		boolean check=false;
		
		Position Roi=getPosRoi(  );
		Position Tour=getPosTour(true);
		Piece pieceRoi=chess.getPiecePosition( Roi );
		Piece pieceTour=chess.getPiecePosition( Tour );
		if(pieceRoi !=null && pieceRoi.getPlayed()==0)
		{
			if(pieceTour !=null && pieceTour.getPlayed()==0)
			{
				if(trajetLibre( chess, Roi,  true ))
				{
					check=check|| estEnEchec( Roi.clone() );
					check=check||seraEnEchec( Roi.clone(),Position.getPosition( Roi.getX()-1,  Roi.getY() ) );
					check=check||seraEnEchec( Roi.clone(),Position.getPosition( Roi.getX()-2,  Roi.getY() ) );
					return !check;
				}
				return false;
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
	
	/**
	 * @param chess : l'echiquier
	 * @return	Le grand roque est possible ?
	 */
	public boolean grandRoquePossible(Echiquier chess )
	{
		boolean check=false;
		Position Roi=getPosRoi();
		Position Tour=getPosTour(false);
		Piece pieceRoi=chess.getPiecePosition( Roi );
		Piece pieceTour=chess.getPiecePosition( Tour );
		
		if((pieceRoi !=null) && (pieceRoi.getPlayed()==0))
		{
			if((pieceTour !=null)&& (pieceTour.getPlayed()==0))
			{
				if(trajetLibre( chess, Roi,  false ))
				{
					check=check || estEnEchec( Roi.clone() );
					check=check || seraEnEchec( Roi.clone(),Position.getPosition( Roi.getX()+1,  Roi.getY() ) );
					check=check || seraEnEchec( Roi.clone(),Position.getPosition( Roi.getX()+2,  Roi.getY() ) );
					check=check || seraEnEchec( Tour.clone(),Roi.clone() );
					return !check;
				}
				return false;

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
	
	
	/**
	 * Verifie si une promotion est possible 
	 * @author mi-black
 	 * @return
	 */
	public boolean promotionPossible(  )
	{
		boolean possible = false;
		int col = 0;
		for ( Piece unePiece : myChessboard.getPieceList() )
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

	/**
	 * augmente les compteurs de partie nulle puis réalise un coup sur 
	 * l'échiquier et ajoute enfin le coup à la liste des coups
	 * @param m le coup à réaliser
	 */
	public void realiserCoup( Coup m )
	{
		if ( m.isEstPrise() )
		{
			this.setCpt_sans_prise();
		}
		else
			this.upCpt_sans_prise();
		if(!m.estRoque)
		{
			if(m.getPieceDepart().toString().equalsIgnoreCase( "P" ))
				this.setCptSansMvmtPion();
			else
				this.upCptSansMvmtPion();
		}else
			this.upCptSansMvmtPion();

		this.getMyChessboard().realiserCoup( m );
		addMove( m );
	}
	
	
	/**
	 * Cette fonction vérifie si le roi de p est dans la liste de déplacement 
	 * d'une des pieces de l'adversaire
	 * @author mi-black
	 * @param p le joueur à vérifier
	 * @return si le joueur p est en Echecs
	 */
	@SuppressWarnings( "null" )	// Le null Supress n'est pas obligatoire car un joueur a TOUJOURS un roi
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
						try
						{
							check = check || ((Pion) onePiece) .metEnEchec( this.myChessboard );
						}
						catch (ConcurrentModificationException e)
						{
							e.getStackTrace();
						}
					}
				}
			}
		}
		return check;
	}

	/**
	 * @author mi-black
	 * Cette fonction vérifie pour chaque piece si son déplacement mettera le 
	 * joueur p en Echec , si c'est le cas pour tout les coups alors p est mat
	 * @param p le joueur à vérifier
	 * @return si le joueur p est réelement Echecs & mat
	 */
	public boolean estEchecEtMat( JoueurAbstract p )
	{
		Piece roiPiece =null;
		boolean mat = false;
		LinkedList<Piece> listeDePiece = this.myChessboard.getPieceList();
		LinkedList<Piece> mesPieces=new LinkedList<Piece>();
		for(Piece onePiece : listeDePiece)
		{
			if(p.getColor().equals( onePiece.getColor() ))
			{
				mesPieces.add( onePiece );
			}
		}
		for ( Piece onePiece : listeDePiece )
		{
			if ( p.getColor().equals( onePiece.getColor() )	&& onePiece instanceof Roi )
			{
				roiPiece = onePiece;
			}
		}
		@SuppressWarnings( "null" )// Juste pour le suppress warning car un roi sera TOUJOURS present
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
			for ( Piece onePiece : mesPieces )
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
			e.getStackTrace();
		}

		return mat;
	}

	/**
	 * Verifie s'il y a une partie nulle
	 * @author mi-black
	 * @return draw , une partie est considérée comme nulle si cptSansMvmtPion ou cpt_sans_prise sont >50
	 */
	public boolean isDraw()
	{
		boolean draw = (cptSansMvmtPion > 50 || cpt_sans_prise > 50);
		return draw;
	}
	
	
	/**
	 * Cette fonction permet donc d'enregistrer une partie dans un fichier texte
	 * @author mi-black
	 * @param pathOfFile Le fichier où sauvegarder
	 */
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

	/**
	 * Cette fonction permet de charger une partie , elle reprend une partie de zéro et effectue chaque coups un par un
	 * @author mi-black
	 * @param pathOfFile Le fichier à charger
	 * @param monInterface	L'interface à charger
	 */
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
						coup=Coup.parseStringToCoupCompl( lecture, this ,playerEnCours);
						if(Fenetre.msg!=null)
						{
							Fenetre.msg.append(coup.toString()+"\n");
						}
						
					}
					else
					{
						fin=true;
						break;
					}
					if(this.seraEnEchec( coup.getPosDepart().clone(), coup.getPosArrivee().clone() ) )
					{
						throw new Exception("Le coup est errone");
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
				System.out.println("Partie bien chargee !");
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
			((Textuelle)monInterface).afficherEchiquier();
			System.out.println( ((Textuelle)monInterface).getMaPartie().listOfAvailableMove( getPlayerEnCours() ) );
			System.out.println( "C'est au joueur " + getPlayerEnCours().getType() + " "+ getPlayerEnCours().toString() + " de jouer !" );
		}
	}
	
	
	
	 
	
	/**
	 * @author mi-black
	 * @param p le joueur dont on veux la liste
	 * @return Liste des coups possibles
	 */
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
		if(petitRoquePossible( myChessboard))
		{
			listCoup.addLast( new Coup(true,p.getColor()) );
		}
		if(grandRoquePossible( myChessboard))
		{
			listCoup.addLast( new Coup(false,p.getColor()) );
		}
		return listCoup;
	}

	/**
	 * Place chaque piece sur l'échiquier 
	 * @author mi-black
	 */
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

	/**
	 * initialise les positions puis affecte le joueurs au blanc
	 * @author mi-black
	 * @param joueur1 le joueur jouant les blancs
	 */
	public void letsPlay( JoueurAbstract joueur1 )
	{
		initPositions();
		this.playerEnCours = joueur1;
	}
	
	/**
	 * @param e un coup
	 * @return
	 */
	public boolean addMove( Coup e )
	{
		return listOfMove.add( e );
	}
 

	/**
	 * @param i 
	 * @return
	 */
	public JoueurAbstract getJoueur( int i )
	{
		return this.listOfPlayer.get( i );
	}

 

	/**
	 * met en forme la liste des coups joués pour posseder une syntaxe comme
	 * a2-a4
	 * a7-a5
	 * Ta1-a3
	 * @author mi-black
	 * @return la liste des coups avec une syntaxe correcte
	 */
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
	/**
	 * @return
	 */
	public int getCpt_sans_prise()
	{
		return cpt_sans_prise;
	}
	
	/**
	 * @return
	 */
	public void upCpt_sans_prise()
	{
		this.cpt_sans_prise++;
	}

	/**
	 * @return
	 */
	public void setCpt_sans_prise()
	{
		this.cpt_sans_prise = 0;
	}
	
	/**
	 * @return
	 */
	public void downCpt_sans_prise()
	{
		this.cpt_sans_prise--;
	}
	
	/**
	 * @return
	 */
	public void setCptSansMvmtPion()
	{
		this.cptSansMvmtPion=0;
	}
	/**
	 * @return
	 */
	public void upCptSansMvmtPion()
	{
		this.cptSansMvmtPion++;
	}
	
	/**
	 * @return
	 */
	public JoueurAbstract getPlayerEnCours()
	{
		return playerEnCours;
	}

	/**
	 * Change le joueur en cours
	 * @author mi-black
	 */
	public void setPlayerEnCours()
	{
		if ( playerEnCours.equals( listOfPlayer.getFirst() ) )
		{
			this.playerEnCours = listOfPlayer.getLast();
		}
		else
			this.playerEnCours = listOfPlayer.getFirst();
	}
	
	/**
	 * @return
	 */
	public LinkedList<JoueurAbstract> getListOfPlayer()
	{
		return listOfPlayer;
	}
	
	/**
	 * @return
	 */
	public LinkedList<Coup> getListOfMove()
	{
		return listOfMove;
	}

}
