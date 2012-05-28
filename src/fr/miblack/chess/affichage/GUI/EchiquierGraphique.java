package fr.miblack.chess.affichage.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import fr.miblack.chess.Partie;


/**
 * @author mi-black
 */
public class EchiquierGraphique extends JPanel
{
	private static final long	serialVersionUID	= 1L;
	HashMap<String,Image> laHashMap =new HashMap<String,Image> ();
	Partie maPartie;
	Image fond = null;

	/**
	 * @param maPartie
	 */
	public EchiquierGraphique(Partie maPartie) 
	{
		this.maPartie=maPartie;
		try
		{
			fond = ImageIO.read(getClass().getResource("../ressources/fond.png"));
		} catch (IOException monExecption)
		{
			monExecption.printStackTrace();
		}
		try
		{
			laHashMap.put( "P", ImageIO.read(getClass().getResource("../ressources/P.gif" )));
			laHashMap.put( "p", ImageIO.read(getClass().getResource("../ressources/p.gif" )));
			laHashMap.put( "C", ImageIO.read(getClass().getResource("../ressources/C.gif" )));
			laHashMap.put( "c", ImageIO.read(getClass().getResource("../ressources/c.gif" )));
			laHashMap.put( "R", ImageIO.read(getClass().getResource("../ressources/R.gif" )));
			laHashMap.put( "r", ImageIO.read(getClass().getResource("../ressources/r.gif" )));
			laHashMap.put( "T", ImageIO.read(getClass().getResource("../ressources/T.gif" )));
			laHashMap.put( "t", ImageIO.read(getClass().getResource("../ressources/t.gif" )));
			laHashMap.put( "F", ImageIO.read(getClass().getResource("../ressources/F.gif" )));
			laHashMap.put( "f", ImageIO.read(getClass().getResource("../ressources/f.gif" )));
			laHashMap.put( "D", ImageIO.read(getClass().getResource("../ressources/D.gif" )));
			laHashMap.put( "d", ImageIO.read(getClass().getResource("../ressources/d.gif" )));
			
		}
		catch (IOException monExecption)
		{
			monExecption.printStackTrace();
		}
	
	}
	
	/**
	 * @param g 
	 */
    public void paintComponent(Graphics g)
    {
    	Image imgN = null;
    	Image imgB = null;
    	String chaine = null;
    	try
		{
			imgN = ImageIO.read(getClass().getResource("../ressources/caseN.png"));
			imgB = ImageIO.read(getClass().getResource("../ressources/caseB.png"));
		} catch (IOException monExecption)
		{
			monExecption.printStackTrace();
		}
    	try
    	{
        	g.drawImage( fond, 0,0,this );

			Thread.sleep( 200 );

    		for ( int j = 7 ; j >= 0 ; j-- )
			{
    			for ( int i = 0 ; i <8 ; i++ )
   	    		{		
    				if( (i+j) %2 ==0)
    				{
    					g.drawImage( imgN, 120+50*i,120+50*j,this );
	            	}
	            	else
	            	{
	                	g.drawImage( imgB, 120+50*i,120+50*j,this );
	            	}
	            		if(maPartie.getMyChessboard().getPiecePosition( i, j )!=null)//50+x*50, 50+7*50-y*50
	                		g.drawImage( laHashMap.get( maPartie.getMyChessboard().getPiecePosition(i, j).toString() ), 120+50*i, 120+j*50,this );
	            }
    			//chaine = new String();
				//chaine += (char)(7-j+'1');
        	}
    		for(int x = 0; x < 8; x++)
			{
				chaine = new String();
				chaine +=  (char)(x+'a');
				g.drawString(chaine, 140+x*50, 115);//on paint l'indice de coordonnee
				chaine = new String();
				chaine += (char)(x+'1');
				g.drawString(chaine, 110, 150+50*x);//on paint l'indice de coordonne

			}
    	}
    	catch(ConcurrentModificationException e)
    	{
    		e.getStackTrace();
    	} catch (InterruptedException monExecption)
		{
			monExecption.printStackTrace();
		}
    }
 
	
}
