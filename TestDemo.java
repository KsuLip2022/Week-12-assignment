import java.util.Random;
import com.google.common.annotations.VisibleForTesting;


public class TestDemo {
	public int addPositive(int a, int b) {
		
			if ( a > 0 &&  b > 0) {
				return a + b;
//			throw new IllegalArgumentException ("Both parameters must be positive!");
		} else {
//		return a + b;	
		throw new IllegalArgumentException ("Both parameters must be positive!");
	}
	}
	  @VisibleForTesting
	 	int getRandomInt() {
		 Random random = new Random();
		  return random.nextInt(10) + 1;
		 
	}
		
	    @VisibleForTesting
	    int randomNumberSquared() {
		 int a = getRandomInt();	 
		  return a*a;		
	 }
	  
	
	 
	
	
	
	
	
}


