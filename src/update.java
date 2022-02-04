package knngraph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class update {

	
	
	public static int  updateNN(Map<Integer , Double> B ,int j,double d) {
		double maxValueInMap=(Collections.max(B.values()));
		
		if (d>=maxValueInMap) {
			return 0;
		}
		else {
		int Element=0;
        for (Entry<Integer, Double> entry : B.entrySet()) {
            if (entry.getValue()==maxValueInMap) {
            	Element=entry.getKey();
              }
              
            }
   
        B.remove(Element);
  	  	B.put(j, d);
        return 1;  
        }
		}
	public static void main(String rags[]) {
		Map<Integer,Double> temp = new HashMap<>();
		temp.put(1, 46.6);
		temp.put(2, 50.1);
		temp.put(6, 10.9);
		temp.put(3, 20.0);
		temp.put(4, 2.45);
		temp.put(5, 46.6);
		
		for (Integer key: temp.keySet()) {
		    //System.out.print("key : " + key+" ");
		    System.out.print(" " + temp.get(key)+" ");
		}
		System.out.println("\n after upfate");
		update.updateNN(temp,10,1.3);
	
		for (Integer key: temp.keySet()) {
		  // System.out.print("key : " + key+" ");
		    
		    System.out.print(" " + temp.get(key)+" ");
		}
		/**/
		
	}
        
	
	
	
}
