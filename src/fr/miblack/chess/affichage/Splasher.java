package fr.miblack.chess.affichage;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Permet de crée la window de "chargement"
 * @author Donateur de l'idée : Amateras
 *
 */
public class Splasher extends Window
{
	private static final long serialVersionUID = 100L;
	private boolean paintCalled = false;
	private static Splasher instance;
	private Image image;


	/**
	 * Constructeur 
	 * @param image
	 */
	private Splasher( Image image )
	{
		super( new Frame( ) );
		this.setImage( image );
		MediaTracker mt = new MediaTracker( this );
		mt.addImage( image, 0 );
		try
		{
			mt.waitForID( 0 );
		} catch ( InterruptedException ie )
		{
			ie.printStackTrace();
		}

		setSize( image.getWidth( null ), image.getHeight( null ) );
		Dimension d = Toolkit.getDefaultToolkit( ).getScreenSize( );
		setLocation( ( d.width - getWidth( ) ) / 2,
				( d.height - getHeight( ) ) / 2 );
	}

	/**
	 * Ouvre l'image dont le lien donné en params
	 * @param a 
	 */
	public static void splash( String a )
	{
		Image fond = null;
		try
		{
			fond = ImageIO.read(new File(a));
		} catch (IOException monExecption)
		{
			monExecption.printStackTrace();
		}
		splash(fond);
	}

	/**
	 * Affiche
	 * @param image
	 */
	public static void splash( Image image )
	{
		if ( instance == null && image != null )
		{
			instance = new Splasher( image );
			instance.setVisible( true );
			instance.toFront( );

			if ( !EventQueue.isDispatchThread( )
					&& Runtime.getRuntime( ).availableProcessors( ) == 1 )
				synchronized (instance)
				{
					while (!instance.paintCalled)
					{
						try
						{
							instance.wait( );
						} catch ( InterruptedException e )
						{
							e.printStackTrace();
						}
					}
				}
		}
	}

	/**
	 * efface après
	 */
	public static void disposeSplash()
	{
		instance.setVisible( false );
	}

	/**
	 * @param g
	 */
	public void update( Graphics g )
	{
		paint( g );
	}

	/**
	 * @param g
	 */
	public void paint( Graphics g )
	{
		g.drawImage( image, 0, 0, this );

		if ( !paintCalled )
		{
			paintCalled = true;
			synchronized (this)
			{
				notifyAll( );
			}
		}
	}

	/**
	 * @return
	 */
	public boolean isPaintCalled()
	{
		return paintCalled;
	}

	/**
	 * @param paintCalled
	 */
	public void setPaintCalled( boolean paintCalled )
	{
		this.paintCalled = paintCalled;
	}


	/**
	 * @return
	 */
	public Image getImage()
	{
		return image;
	}

	/**
	 * @param image
	 */
	public void setImage( Image image )
	{
		this.image = image;
	}
	/**
	 * @return
	 */
	public static Splasher getInstance()
	{
		return instance;
	}

	/**
	 * @param instance
	 */
	public static void setInstance( Splasher instance )
	{
		Splasher.instance = instance;
	}
}
