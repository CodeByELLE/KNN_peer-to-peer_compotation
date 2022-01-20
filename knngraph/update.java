package knngraph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class update {

	
	
	public static int  updateNN(Map<Integer , Double> B ,int j,double d) {
		double maxValueInMap=(Collections.max(B.values()));
		
		//check if the distance D is larger than all the neighbors of B then exist
		if (d>=maxValueInMap) {
			//System.out.println("Not Changed");
			return 0;
		}
		 //check if the B contains the the element key j , if it's smaller than it replace it
		else if(B.containsKey(j) )
		{
			if(B.get(j)<=d)
			{
				return 0;
			}
			//System.out.println(B.get(j));
			B.put(j, d);
			//System.out.println(B);
			
			return 1;
		}
		else
		{
		int Element=0;
        for (Entry<Integer, Double> entry : B.entrySet()) {
            if (entry.getValue()==maxValueInMap) {
            	Element=entry.getKey();
              }
              
            }
        
   
        B.remove(Element);
  	  	B.put(j, d);
  	  	
  	  //	System.out.println(B);
  	  //	System.out.println("Changed");
        return 1;  
        }
		}

        
	
	
	
}
