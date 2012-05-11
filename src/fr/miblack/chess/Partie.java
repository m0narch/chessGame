package fr.miblack.chess;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.GUI.Interface;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.piece.*;

import java.util.*;

public class Partie
{

	private LinkedList<Coup> listOfMove=new LinkedList<Coup>();

	private LinkedList<Coup> listOfMoveCancelled=new LinkedList<Coup>();
	private LinkedList<JoueurAbstract> listOfPlayer =new LinkedList<JoueurAbstract>();


	private JoueurAbstract playerEnCours;
	private int cpt_sans_prise=0;
	private int cptSansMvmtPion=0;
	private Echiquier myChessboard = new Echiquier();
	private Interface myInterface;


	public Partie(JoueurAbstract player1,JoueurAbstract player2,Interface myInterface)
	{
		listOfPlayer.add(player2);
		listOfPlayer.addFirst( player1 );
		this.myInterface=myInterface;
		letsPlay(player1);
	}

	public Echiquier getMyChessboard()
	{
		return myChessboard;
	}

	public Coup annulerDernierCoup()
	{
		Coup last=listOfMove.getLast();
		listOfMoveCancelled.add(listOfMove.getLast());
		last.getPieceDepart().setPos(last.getPosDepart());
		return listOfMove.removeLast();
	}

	public Coup rejouerDernierCoup()
	{
		listOfMove.add( listOfMoveCancelled.getLast() );
		return listOfMoveCancelled.removeLast();
	}
	
	public boolean estPat()
	{
		boolean stalemate=false;

		return stalemate;
	}

	public boolean estEnEchec(Position laPos)
	{
		boolean check=false;
		Piece maPiece=this.getMyChessboard().getPiecePosition(laPos );
		if(maPiece!=null)
		{
			LinkedList<Position> listPos =maPiece.positionAccessibleChessboard( getMyChessboard() );
			for(Position onePos :listPos)
			{
				if(this.getMyChessboard().getPiecePosition(onePos)!=null)
				{
					if(this.getMyChessboard().getPiecePosition(onePos) instanceof Roi)
					{
						check=true;
					}
				}
			}
		}
		return check;
	}
	
	@SuppressWarnings( "null" )
	public boolean seraEnEchec(Position laPosD,Position laPosA)
	{
		boolean prise=this.getMyChessboard().deplacerPiecePourTest(laPosD, laPosA);
		boolean check=false;
		
		Piece roiPiece = null;

		LinkedList<Piece> maListeDePiece=this.getMyChessboard().getPieceList();
		for(Piece laPiece :	maListeDePiece ) 
		{
			if(laPiece instanceof Roi && (getPlayerEnCours().getColor().equals(laPiece.getColor())))
			{
				roiPiece=laPiece;
			}
		}
		for(Piece onePiece : maListeDePiece)
		{
			if(!getPlayerEnCours().getColor().equals(onePiece.getColor()))
			{
				if(onePiece.positionAccessibleChessboard( this.myChessboard ).contains( roiPiece.getPos() ))
				{
					check=true;
				}
				if(onePiece instanceof Pion)
				{
					check=check || ((Pion )onePiece).metEnEchec(this.myChessboard);
				}
			}
		}
		this.getMyChessboard().annulerDeplacerPiecePourTest(laPosD, laPosA,prise);
		return check;
	}
	
	//Le null Supress n'est pas obligatoire car un joueur à TOUJOURS un roi
	@SuppressWarnings( "null" )
	public boolean estEnEchec(JoueurAbstract p)
	{
		boolean check=false;
		Piece roiPiece = null;
		for(Piece onePiece : this.myChessboard.getPieceList())
		{
			if(p.getColor().equals( onePiece.getColor() ) && onePiece instanceof Roi)
			{
				roiPiece=onePiece;
			}
		}
		for(Piece onePiece : this.myChessboard.getPieceList())
		{
			if(!(onePiece instanceof Roi))
			{
				if(!p.getColor().equals( onePiece.getColor() ))
				{
					if(onePiece.positionAccessibleChessboard( this.myChessboard ).contains( roiPiece.getPos() ))
					{
						check=true;
					}
					if(onePiece instanceof Pion)
					{
						check=check || ((Pion )onePiece).metEnEchec(this.myChessboard);
					}
				}
			}
		}
		return check;
	}
	
	public boolean estEchecEtMat(Position laPos)
	{
		boolean mat=false;
		
		if(estEnEchec(laPos))
		{	
			for(Position onePos : getMyChessboard().getPiecePosition( laPos ).positionAccessibleChessboard( getMyChessboard() ))
			{
				if(estEnEchec( onePos ))
				{
					mat=true;
				}
				else
				{
					mat=false;
				}
			}
			return mat;
		}
		return mat;
	}
	
	@SuppressWarnings( "null" )
	public boolean estEchecEtMat(JoueurAbstract p)
	{
		Piece roiPiece = null;
		boolean mat=false;
		//1boolean prise=false;
		for(Piece onePiece : this.myChessboard.getPieceList())
		{
			if(p.getColor().equals( onePiece.getColor() ) && onePiece instanceof Roi)
			{
				roiPiece=onePiece;
			}
		}
	//	System.out.println(roiPiece.getPos().toStringPos());
		LinkedList<Position> posKingAccess=roiPiece.positionAccessibleChessboard( getMyChessboard() );
		for(Position posA :posKingAccess)
		{
			mat=seraEnEchec(roiPiece.getPos().clone(),posA);
			if(mat==false)
			{
				return mat;
			}
			/*System.out.println("Avant "+roiPiece.getPos().toStringPos());
			prise=this.getMyChessboard().deplacerPiecePourTest(roiPiece.getPos(), posA.clone());
			System.out.println("Après "+roiPiece.getPos().toStringPos());
			for(Piece laPiece : this.getMyChessboard().getPieceList())
			{
				if(laPiece.getColor()!=p.getColor())
				{
					for(Position laPos : laPiece.positionAccessibleChessboard( getMyChessboard() ))
					{
						if(laPos.equals( posA ))
						{
							mat=true;
						}
						else
						{
							mat=false;
							System.out.println("Finalement pendant: "+roiPiece.getPos().toStringPos());
							this.getMyChessboard().annulerDeplacerPiecePourTest(posA, roiPiece.getPos(),prise);
							System.out.println("Finalement pendant après: "+roiPiece.getPos().toStringPos());
							return mat;
						}
					}
					if(laPiece instanceof Pion)
					{
						mat=mat || ((Pion )laPiece).metEnEchec(this.myChessboard);
					}
				}
			}
			System.out.println("Finalement avant: "+roiPiece.getPos().toStringPos());
			this.getMyChessboard().annulerDeplacerPiecePourTest(roiPiece.getPos().clone(), posA,prise);
			System.out.println("Finalement après: "+roiPiece.getPos().toStringPos());
*/
		}
		return mat;
	}

	public boolean isDraw()
	{
		boolean draw=(cptSansMvmtPion>50 || cpt_sans_prise>50);
		return draw;
	}

	public void saveGame(String pathOfFile)
	{
	/*	try
		{
			FileWriter fstream =new FileWriter( pathOfFile );
			BufferedWriter out =new BufferedWriter( fstream );
		//	out.write(  )
		}
		catch(Exception e)
		{
			System.err.println("Error: "+ e.getMessage());
		}
	*/	
	}

	public void loadGame(String pathOfFile)
	{

	}

	public LinkedList<Coup> listOfAvailableMove(JoueurAbstract p)
	{
		LinkedList<Coup> listCoup=new LinkedList<Coup>();
		for(Piece onePiece : myChessboard.getPieceList())
		{
			if(onePiece.getColor().equals( p.getColor()))
			{
				listCoup.addAll(onePiece.getCoupPossible( onePiece,this));
			}
		}
		//TODO ici juste les coups normaux sont géré
		return listCoup;
	}

	public void initPositions()
	{
		/***************************     White piece       ***********************************/
		/***************************     Black piece       ***********************************/

		this.myChessboard.addKing(new Roi(new Couleur(0),Position.getPosition(4,7),0));
		this.myChessboard.addKing(new Roi(new Couleur(1),Position.getPosition(4,0),0));

		this.myChessboard.addQueen(new Dame(new Couleur(0),Position.getPosition(3,7),10));
		this.myChessboard.addQueen(new Dame(new Couleur(1),Position.getPosition(3,0),10));

		this.myChessboard.addRook(new Tour(new Couleur(1),Position.getPosition(0,0),5));
		this.myChessboard.addRook(new Tour(new Couleur(1),Position.getPosition(7,0),5));

		this.myChessboard.addRook(new Tour(new Couleur(0),Position.getPosition(0,7),5));
		this.myChessboard.addRook(new Tour(new Couleur(0),Position.getPosition(7,7),5));
		
		this.myChessboard.addBishop(new Fou(new Couleur(1),Position.getPosition(2,0),3));
		this.myChessboard.addBishop(new Fou(new Couleur(1),Position.getPosition(5,0),3));

		this.myChessboard.addBishop(new Fou(new Couleur(0),Position.getPosition(2,7),3));
		this.myChessboard.addBishop(new Fou(new Couleur(0),Position.getPosition(5,7),3));

		this.myChessboard.addKnight(new Cavalier(new Couleur(1),Position.getPosition(1,0),3));
		this.myChessboard.addKnight(new Cavalier(new Couleur(1),Position.getPosition(6,0),3));
		
		this.myChessboard.addKnight(new Cavalier(new Couleur(0),Position.getPosition(1,7),3));
		this.myChessboard.addKnight(new Cavalier(new Couleur(0),Position.getPosition(6,7),3));
		
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(0,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(1,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(2,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(3,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(4,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(5,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(6,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(7,1),1));

		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(0,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(1,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(2,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(3,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(4,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(5,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(6,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(7,6),1));
	}

	public void letsPlay(JoueurAbstract joueur1)
	{
		initPositions();
		this.playerEnCours=joueur1;
	}

	public boolean  coupValide(Piece pieceD,Position posD,Piece pieceA,Position posA,int coupSpecial)
	{
		//TODO verifier si c'est un coup spé !
		//TODO ... OMG j'ai ça a faire aussi
		return false;
	}

	public boolean addMove(Coup e)
	{
		return listOfMove.add(e);
	}

	/**
	 * @return the listOfMoveCancelled
	 */
	public LinkedList<Coup> getListOfMoveCancelled()
	{
		return listOfMoveCancelled;
	}

	public JoueurAbstract getJoueur(int i)
	{
		return this.listOfPlayer.get( i );
	}

	/**
	 * @param listOfMoveCancelled the listOfMoveCancelled to set
	 */
	public void setListOfMoveCancelled( LinkedList<Coup> listOfMoveCancelled )
	{
		this.listOfMoveCancelled = listOfMoveCancelled;
	}
	
	public int getCpt_sans_prise()
	{
		return cpt_sans_prise;
	}

	public void upCpt_sans_prise( )
	{
		this.cpt_sans_prise++;
	}
	public void setCpt_sans_prise( )
	{
		this.cpt_sans_prise=0;
	}
	public void downCpt_sans_prise( )
	{
		this.cpt_sans_prise--;
	}

	public JoueurAbstract getPlayerEnCours()
	{
		return playerEnCours;
	}

	public void setPlayerEnCours()
	{
		if(playerEnCours.equals( listOfPlayer.getFirst() ))
		{
			this.playerEnCours=listOfPlayer.getLast();
		}
		else
			this.playerEnCours=listOfPlayer.getFirst();
	}
	public LinkedList<JoueurAbstract> getListOfPlayer()
	{
		return listOfPlayer;
	}

	public Interface getMyInterface()
	{
		return myInterface;
	}

	public void setMyInterface( Interface myInterface )
	{
		this.myInterface = myInterface;
	}
	
	public LinkedList<Coup> getListOfMove()
	{
		return listOfMove;
	}


	
}
	

