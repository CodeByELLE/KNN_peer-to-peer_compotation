package knngraph;

import java.util.ArrayList;
import java.util.Arrays;

public class bruteforce {

	 // Create The BRUTE FORCE
	 public static double[][] getMatrix(ArrayList<node> dataset) {
		 double[][] matrix = new double[dataset.size()][dataset.size()];	 
		 for(int i=0;i<dataset.size();i++){
				for(int j=0;j<dataset.size();j++){
					matrix[i][j] = knngraph.dist.driver(dataset.get(i).contenu,dataset.get(j).contenu);
					//System.out.println(i+" : "+distance.Euclidean(dataset.get(i).contenu,dataset.get(j).contenu));
				//System.out.println(i+" : "+dataset.get(i).contenu);
				}}
	        return matrix;
	        		}
	 
	 // show the Matrix
	 public static void showMatrix(double[][] sortmatrix) {

	 for (int i = 0; i < sortmatrix.length; i++) {
		    for (int j = 0; j < sortmatrix[i].length; j++) {
		        System.out.print(sortmatrix[i][j] + "\t");
		    }
		    System.out.println();
		}
	 
	 }
	 
	 //sort the Matrix
	 public static double[][] sortMatrix(double[][] sortmatrix) {
	 for (int i = 0; i < sortmatrix.length; i++) {
		  Arrays.sort(sortmatrix[i]);
		}
	 System.out.println("");
	 return sortmatrix;
	 }
	// Find Indice of neighbor
	 public static int[] find(double[] array, double value) {
		 int a = 0;
		 
		 for(int i=0; i<array.length; i++) {
		    	if(array[i] == value){
		    		a++;}}
		  int[] q = new int[a] ;
		  a = 0;
		 for(int i=0; i<array.length; i++) {
			    if(array[i] == value){
			    		q[a] = i;a++;}
		   										}
		   return q;
		        }
		
	 public static ArrayList<node> bruteB(double[][] sortmatrix,double[][] matrix, ArrayList<node> dataset,int K) {
		 for (int i = 0; i < sortmatrix.length; i++) {
			 int j =1;
			 while (j <= K) {
				 int[] q = find(matrix[i], sortmatrix[i][j]);
				 if (q.length == 1){
			    	(dataset.get(i).bruteB).put(find(matrix[i], sortmatrix[i][j])[0], sortmatrix[i][j]);
			    	j = j +1;
			    }
				 else{
					 for(int r = 0; r < q.length; r++) {
						 if(j <= K){
							 (dataset.get(i).bruteB).put(find(matrix[i], sortmatrix[i][j])[r], sortmatrix[i][j]);
							 j = j +1;}
					 									}
				 	}
				 			}
			 											}
		 
		 return dataset;}
	
}
