 package labb_1;

//TODO: Komplettering: Det finns just nu ingen vettign anledning till
//att had enna klass dåd en endast kallar på basklassens
//konstruktor. Ni måste implementera någon specifik funktionalitet som
//motiverar att detta är en separat klass. FIXAT

public class Room extends Location{
	
	String room;
	
	public Room(String name, String shortDescription, String longDescription, boolean visited,  boolean unlocked, String room) {
		super(name, shortDescription, longDescription, visited, unlocked);
		this.room = room;
		
	}
	
	public void describeYourself() {
		
		if (visited) {
		    System.out.println(shortDescription + " This is a " + room);
		}
		else {
		    System.out.println(longDescription + " This is a " + room);
		    visited = true;
		}
	    }
	
	
} 
