package labb_1;

import java.util.Random;

public class Outside extends Location {

    //Kommentar: Snyggt!
    private static final String[] weather ={
	"sunny.",
	"rainy.",
	"cloudy."
    };
	
    Random random = new Random();

    //TODO: Komplettering: Denna klass har redan en visited variabel i
    //och med att basklassen har en visited variabel. Det kostar
    //därmed onödigt mycket minne att ha två variabler av samma typ
    //och med exakt samma namn.

	
    public Outside(String name, String shortDescription, String longDescription, boolean visited, boolean unlocked) {
	super(name, shortDescription, longDescription, visited, unlocked);
    }

    //Kommentar: Snyggt!
    @Override
    public boolean canDig() {
	return true;
    }
	

    //TODO: Komplettering: Var konsekventa med användandet av @Override FIXAT?

    @Override
    public void describeYourself() {
	
	String randomString = weather[random.nextInt(weather.length)];

	    //TODO: Komplettering: Använd basklassens
	    //'describeYourself()' istället för at tha en onödig
	    //getter för description. På så vis undviker ni också
	    //kodduplicering.
	//jag förstår inte riktigt vad du menar men har ändrat till protected så dessa getters/setters inte behövs
	
	if (visited) {
	    System.out.println(super.shortDescription + " The weather is " + randomString);
	}
	else {
			
	    System.out.println(super.longDescription + " The weather is " + randomString);
	    visited = true;
	}
    }
	
	

}
