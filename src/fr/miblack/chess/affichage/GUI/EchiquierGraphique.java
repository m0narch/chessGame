package fr.miblack.chess.affichage.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.miblack.chess.Partie;



public class EchiquierGraphique extends JPanel
{
	private static final long	serialVersionUID	= 1L;
	HashMap<String,Image> laHashMap =new HashMap<String,Image> ();
	Partie maPartie;
	public EchiquierGraphique(Partie maPartie) 
	{
		this.maPartie=maPartie;
		try
		{
			laHashMap.put( "P", ImageIO.read(new File("src/images/P.gif" )));
			laHashMap.put( "p", ImageIO.read(new File("src/images/p.gif" )));
			laHashMap.put( "C", ImageIO.read(new File("src/images/C.gif" )));
			laHashMap.put( "c", ImageIO.read(new File("src/images/c.gif" )));
			laHashMap.put( "R", ImageIO.read(new File("src/images/R.gif" )));
			laHashMap.put( "r", ImageIO.read(new File("src/images/r.gif" )));
			laHashMap.put( "T", ImageIO.read(new File("src/images/T.gif" )));
			laHashMap.put( "t", ImageIO.read(new File("src/images/t.gif" )));
			laHashMap.put( "F", ImageIO.read(new File("src/images/F.gif" )));
			laHashMap.put( "f", ImageIO.read(new File("src/images/f.gif" )));
			laHashMap.put( "D", ImageIO.read(new File("src/images/D.gif" )));
			laHashMap.put( "d", ImageIO.read(new File("src/images/d.gif" )));
		} catch (IOException monExecption)
		{
			monExecption.printStackTrace();
		}
	
	}
	
    public void paintComponent(Graphics g)
    {
    	Image imgN = null;
    	Image imgB = null;
    	try
		{
			imgN = ImageIO.read(new File("src/images/caseN.png"));
			imgB = ImageIO.read(new File("src/images/caseB.png"));
		} catch (IOException monExecption)
		{
			monExecption.printStackTrace();
		}
    	try
    	{
    		for(int i=0;i<8;i++)
    		{
    			for(int j=0;j<8;j++)
    			{
    				if((i+j)%2!=0)
    				{
    					g.drawImage( imgN, 120+50*i,120+50*j,this );
	            	}
	            	else
	            	{
	                	g.drawImage( imgB, 120+50*i,120+50*j,this );
	            	}
	            	
	            		if(maPartie.getMyChessboard().getPiecePosition( 7-i, 7-j )!=null)
	                		g.drawImage( laHashMap.get( maPartie.getMyChessboard().getPiecePosition(7-i, 7-j).toString() ), 120+50*i,120+50*j,this );
	            	}
        	}
    	}
    	catch(ConcurrentModificationException e)
    	{
    		e.getStackTrace();
    	}
    }

	public HashMap<String,Image> getLaHashMap()
	{
		return laHashMap;
	}

	public void setLaHashMap( HashMap<String,Image> laHashMap )
	{
		this.laHashMap = laHashMap;
	}   
	
}
