package knngraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

public class knngraph {
	
	// Create The BRUTE FORCE
	 public static double[][] getMatrix(ArrayList<node> dataset) {
		 double[][] matrix = new double[dataset.size()][dataset.size()];	 
		 for(int i=0;i<dataset.size();i++){
				for(int j=0;j<dataset.size();j++){
					matrix[i][j] = distance.Euclidean(dataset.get(i).contenu,dataset.get(j).contenu);
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
	 public static int find(double[] array, double value) {
		 int a = 0;
		    for(int i=0; i<array.length; i++) {
		    	if(array[i] == value){
		    		a = i;}
		   										}
		   return a;
		        }
		
	 public static ArrayList<node> bruteB(double[][] sortmatrix,double[][] matrix, ArrayList<node> dataset,int K) {
		 for (int i = 0; i < sortmatrix.length; i++) {
			 for (int j = 1; j <= K; j++) {
			    	// Save indices of neighbors & Find the indice 
			    	(dataset.get(i).bruteB).put(find(matrix[i], sortmatrix[i][j]), sortmatrix[i][j]);
			    }
			}
		 return dataset;}
	 
	 
	public static void main(String[] args) {

		ArrayList<node> dataset=new ArrayList<node>();
		
		double[] a= {1,2,3,4,5,6};
		double[] b= {7,8,9,10,11,12};
		double[] c= {13,14,15,16,17,19};
		double[] d= {20,21,22,23,24,25};
		double[] e= {26,27,28,29,30,31};
		
		System.out.println(distance.Euclidean(a, b));
		
		dataset.add(new node(a));
		dataset.add(new node(b));
		dataset.add(new node(c));
		dataset.add(new node(d));
		dataset.add(new node(e));
		
		// Get Similarity matrix
		double[][]  matrix = getMatrix(dataset);
		
		// Show the Similarity matrix
		System.out.println("\n\nThe Similarity matrix :");
		showMatrix(matrix);
		
		 // New matrix for sort it		
		double[][] sortmatrix = new double[dataset.size()][dataset.size()];
		for(int i=0; i<sortmatrix.length; i++)
			  for(int j=0; j<sortmatrix[i].length; j++)
				  sortmatrix[i][j]=matrix[i][j];
		
		// Sort Matrix
		System.out.println("\n\nThe Similarity matrix sorted:");
		sortmatrix = sortMatrix(sortmatrix);
		 
		// show Matrix
		showMatrix(sortmatrix);
		
		// Select K Neighbors
		 int K = 3;

		 dataset = bruteB(sortmatrix,matrix,dataset,K);

		 
		 //Show BruteB
		 System.out.println();
		 for(int i=0;i<dataset.size();i++)
			{
				System.out.println("BruteB for the "+i+" element is "+dataset.get(i).bruteB);
			}
		 
		 
		for(int i=0;i<dataset.size();i++)
		{
			dataset.get(i).b=dataset.get(i).generate_sample(dataset,2,i);
			//System.out.println("the B for the "+i+" element is "+dataset.get(i).b);
		}
		
		
		
		int c1=0;
		do
		{c1=0;
			for(int i=0;i<dataset.size();i++){
				dataset.get(i).r=dataset.get(i).generate_reverse(dataset.get(i).b,dataset,i);
				//System.out.println("the R for the "+i+" element is "+dataset.get(i).r);
				}
			
			for(int i=0;i<dataset.size();i++){
				dataset.get(i).unionBR=dataset.get(i).generate_union(dataset.get(i).b,dataset.get(i).r);
				//System.out.println("the BuR for the "+i+" element is "+dataset.get(i).unionBR);
				}
			
			for(int i=0;i<dataset.size();i++){
				ArrayList<Integer> temp1=dataset.get(i).unionBR;
				for(int u1=0;u1<temp1.size();u1++){
					//System.out.println(temp1.get(u1));
					ArrayList<Integer> temp2=dataset.get(temp1.get(u1)).unionBR;
					for(int u2=0;u2<temp2.size();u2++){
						//System.out.print(temp2.get(u2)+" ");
						ArrayList<Double> a1= dataset.get(temp2.get(u2)).contenu;
						ArrayList<Double> b1=dataset.get(i).contenu;
						//System.out.println("The distance between "+temp2.get(u2)+" and "+i+" is: "+ distance.Euclidean(a1,b1));
					}
					System.out.println("");
				}
			}
			
			}while(c1!=0);
	}
	
	 public static int randomNumberInRange(int min, int max) {
	        Random random = new Random();
	        return random.nextInt((max - min) + 1) + min;
	    }

}

 