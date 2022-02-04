package knngraph;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class distance {

	public static double Euclidean(double x[], double y[]) {
		  
		  double ds=0.0;
		  for(int n=0;n<x.length;n++)
		   ds += Math.pow(x[n]-y[n],2.0);
		  
		  ds=Math.sqrt(ds);
		  return  ds;  
		 }
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public static double Euclidean(ArrayList<Double> x, ArrayList<Double> y) {
		  
		  double ds=0.0;
		  for(int n=0;n<x.size();n++)
		   ds += Math.pow(x.get(n)-y.get(n),2.0);
		  
		  ds=Math.sqrt(ds);
		  DecimalFormat df = new DecimalFormat("0.00");      
		  return  round(ds,2);  
		 }


	public static double Manhattan(double x[], double y[]) {
		  
		  double ds=0.0;
		  for(int n=0;n<x.length;n++)
		   ds += Math.abs(x[n]-y[n]);   
		  return  ds;  
		 }
	
	public static double cosineSimilarity(double[] vectorA, double[] vectorB) {
	    double dotProduct = 0.0;
	    double normA = 0.0;
	    double normB = 0.0;
	    for (int i = 0; i < vectorA.length; i++) {
	        dotProduct += vectorA[i] * vectorB[i];
	        normA += Math.pow(vectorA[i], 2);
	        normB += Math.pow(vectorB[i], 2);
	    }   
	    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
	}
	
	public static double hamming(double[] source, double[] target) { 
		double distance=0; 
       
      if (source.length!= target.length) return distance; 
      for(int i=0;i<source.length;i++) { 
          if (source[i]!=target[i]) distance++; 
      } 
       
      return distance; 
  }

	public static String Euclidean(Object[] e1, Object[] e2) {
		// TODO Auto-generated method stub
		return null;
	} 
}
