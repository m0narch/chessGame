package fr.miblack.chess.com.jtuto.gui;

import java.util.HashMap;
import java.util.ArrayList;

import fr.miblack.chess.com.jtuto.gui.PanneauJeu.Dessinable;
public class HashMapList extends HashMap<String , Dessinable>{
	  
	private static final long serialVersionUID = 1L;
	private ArrayList<Dessinable> lesDessinablesOrdonnes = new ArrayList<Dessinable>(); 
	private ArrayList<String> lesClefsOrdonnes = new ArrayList<String>();
	
	public Dessinable put( String key , Dessinable value )
	{
		
	   if ( ! containsKey( key )) // On a pas la cle
	   {
	     lesDessinablesOrdonnes.add( value );
	     lesClefsOrdonnes.add( key );
	   } // On a la cle
	   else
	   {
	   	int indexKey = lesClefsOrdonnes.indexOf( key );
	   	lesDessinablesOrdonnes.set( indexKey , value );
	   }
		
		return super.put( key , value );  
	}
	
	
	public void clear()
	{
		this.removeAll( );
	}
	public void removeAll()
	{
		super.clear( );
		lesDessinablesOrdonnes.clear( );
	}
	public Dessinable remove( String key )
	{
		Dessinable d = super.get( key );
		if ( d != null ) 
		{ 
			int indexKey = lesClefsOrdonnes.indexOf( key );
			lesClefsOrdonnes.remove( indexKey );
			lesDessinablesOrdonnes.remove(  indexKey  );
		}
		return super.remove( key );
	}
	
	public ArrayList<Dessinable> lesDessinables()
	{
		return lesDessinablesOrdonnes;
	}
}
