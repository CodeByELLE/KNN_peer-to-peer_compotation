package knngraph;	

	import java.io.File;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.HashMap;
	import java.util.Map;
	
	
	
public  class EvalMetric {
			public  static double[] getPrecisionRecall(Map<Integer , Double> Bbrute,Map<Integer , Double> B) {
			double Recal,Precesion;	
			int truePositive=0,trueNegative=0,falsePositive=0,falseNegative=0;
			
			for (Integer key : Bbrute.keySet()) {
				//check if the the B contains the the Brute node
				  if (B.containsKey(key)) {truePositive++; }  
				  else {falseNegative++;}
			    
			}
			for (Integer key : B.keySet()) {
				  if (!Bbrute.containsKey(key)) falsePositive++;   
			}
			//calculate the Recal
			Recal=(double)truePositive/(truePositive+falseNegative);
			
			//calculate the precision
			Precesion=(double)truePositive/(truePositive+falsePositive);
			double[] results= {Recal,Precesion};
			return results;
	}
		
			
			}


