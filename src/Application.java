import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * 1. Make a CarSale class to represent the sale of a car. The class should represent the car name
(model), the list price, the discount in percent, and the final cost (calculated from the list price after
the discount is applied). To keep your code shorter, you can have getter but not setter methods for
each of those properties. Also put in a useful toString method. Make a few instances and print them
out.
Note: if you dont understand @Override, just skip it for now. In the next lecture, we will explain it
more and see a situation where using it is critical. Also, remember that once you have instance variables,
Eclipse can create the getters, setters (not needed here), and constructor for you. Use the
Source menu to tell Eclipse to insert this code.
2. Make a PaperclipSale class to represent the sale of a set of boxes of certain types of paper clips.
The class should represent the color of the clips, the per-box price, the number of those boxes being
sold, and the final cost. Also put in a useful toString method. Make a few instances and print them
out.
3. Make a static method called cheapest that, given an array of mixed CarSale and PaperclipSale
objects, will return the item with the lowest cost. (Return null if given an empty array. Dont worry
about the possibility that the array might have two entries with the same cost.) Where is the best
place to put this method? Test the method.
Question to ponder: why was it important that your classes had meaningful toString methods?
4. Make a static method called totalCost that, given an array of mixed CarSale and PaperclipSale
objects, will return the total cost of all elements in the array. (Return 0 if given an empty array.) Test
the method.
5. Make a Coin enum with instances named HEADS and TAILS.
6. Make a static flip method that returns Coin.HEADS and Coin.TAILS with equal probability. Where
is the best place to put this method? Make a test case where you call flip multiple times and print
out the result each time.
*
 */
public class Application {
   	public enum Coin {
   	    HEADS,
   	    TAILS
   	}

	public static void main(String[] args) {
		
         //1)
		CarSale car1 = new CarSale("Fiat", 10000, 5);
		System.out.println( car1.toString() + "\n");
		
		CarSale [] carSaleArray = new CarSale [] { new CarSale("Fiat", 10000, 5), new CarSale("Skoda", 15000, 6), 
				new CarSale("Honda", 20000, 2)};
		
		//2)
        PaperclipSale paperclip1 = new PaperclipSale("Red", 5, 5000);
        System.out.println( paperclip1.toString()+ "\n");
        
        PaperclipSale [] paperclipSaleArray = new PaperclipSale [] {new PaperclipSale("Red", 5, 5000), new PaperclipSale("Blue", 5, 1000),
        		new PaperclipSale("Black", 5, 2000)};
        
       //3)
	   Object [] mixedArray = new Object [carSaleArray.length + paperclipSaleArray.length];

		System.arraycopy(carSaleArray,0,mixedArray,0,carSaleArray.length);
		System.arraycopy(paperclipSaleArray,0,mixedArray,carSaleArray.length,paperclipSaleArray.length);

	   if(cheapest(mixedArray) != null ) {
		   System.out.println( "The item with the lowest cost:\n" + cheapest(mixedArray));
	   }
	   //4)
	   	System.out.println("\nTotal cost:" + totalCost( mixedArray));
		System.out.println("\nTotal cost(J8):" + totalCostJ8( mixedArray));
	   	//5) && 6)
	   	System.out.println();
	   	for(int i = 0 ; i < 10; i++) {
			System.out.println("Flip " + i + " " + flipCoin());
		}
	}
	
	private static Object cheapest( Object [] objArray) {
		
		if(objArray.length > 0 && !checkForCarsClipsNull( objArray)) {
			int index = 0;
			float cheapestPrice = getObjectPrice( objArray[0]);	
			for( int i = 1; i < objArray.length; i++) {
				if( getObjectPrice(objArray[i]) < cheapestPrice){
					cheapestPrice = getObjectPrice(objArray[i]);
					index = i;
				}
			}
			return objArray[index];
		}
		return null;
	}
private static float totalCostJ8( Object [] objArray) {
		
		if(objArray.length > 0 && !checkForCarsClipsNull( objArray)) {		
			List<Object> objList = new ArrayList<>(Arrays.asList(objArray));
			
			float carTotal = (float) objList.stream().filter( o -> o.getClass().equals(CarSale.class)).mapToDouble( o -> ((CarSale)o).finalCost()).sum();
			float PaperclipsTotal = (float) objList.stream().filter( o -> o.getClass().equals(PaperclipSale.class)).mapToDouble( o -> ((PaperclipSale)o).finalCost()).sum();
			
			return (carTotal + PaperclipsTotal);
		}
		return 0;
	}
	private static float totalCost(Object [] objArray) {
		float totalCost = 0;
		if(objArray.length > 0 && !checkForCarsClipsNull( objArray)) {
			for( Object obj: objArray)
			{
				totalCost+= getObjectPrice(obj);
			}
		}
		return totalCost;
	}
	private static float getObjectPrice( Object obj) {	
			if( obj.getClass().equals(PaperclipSale.class)) {
				return ((PaperclipSale) obj).finalCost();
			}
			return ((CarSale) obj).finalCost();
	}
	private static boolean checkForCarsClipsNull(Object [] objArray) {
		
		if( objArray.length != 0) {
			
			for( Object obj : objArray) {
				if(obj == null ||  ( !obj.getClass().equals(CarSale.class) || !obj.getClass().equals( PaperclipSale.class))){				
					return false;
				}
			}
			return true;
		}
		return false;
		
	}
	private static Coin flipCoin() {
		
		Random rnd = new Random();
		boolean  head = rnd.nextBoolean();
		if( head) {
			return Coin.HEADS;
			}
		return Coin.TAILS;	
	}

}
