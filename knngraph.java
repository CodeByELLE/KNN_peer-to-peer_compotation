package knngraph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class knngraph {
	public static distance dist = new distance();

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan1=new Scanner(System.in);
		
		//reading the K
		
		System.out.println("Enter K : The number of neighbors :");
		
		int k=scan1.nextInt();
		
				//calling the read file function
		ArrayList<node> dataset=readFile.read_file();
		
		for(int i=0;i<dataset.size();i++)
		{
			dataset.get(i).b=dataset.get(i).generate_sample(dataset,k,i);
			//System.out.println("the B for the "+i+" element is "+dataset.get(i).b);
		}
		
		
		
		int c1=0;
		int c2=0;
		
		
		
//System.out.println("\nOkay ..... Lets compare");
		
		// Get Similarity matrix
				double[][]  matrix = bruteforce.getMatrix(dataset);
				
				// Show the Similarity matrix
				//System.out.println("\n\nThe Similarity matrix :");
				//bruteforce.showMatrix(matrix);
				
				 // New matrix for sort it		
				double[][] sortmatrix = new double[dataset.size()][dataset.size()];
				for(int i=0; i<sortmatrix.length; i++)
					  for(int j=0; j<sortmatrix[i].length; j++)
						  sortmatrix[i][j]=matrix[i][j];
				
				// Sort Matrix
				//System.out.println("\n\nThe Similarity matrix sorted:");
				sortmatrix = bruteforce.sortMatrix(sortmatrix);
				 
				// show Matrix
				//bruteforce.showMatrix(sortmatrix);
				
				// Select K Neighbors
				


				 dataset = bruteforce.bruteB(sortmatrix,matrix,dataset,k);

				 
				 //Show BruteB
				 System.out.println();
				 for(int i=0;i<dataset.size();i++)
					{
						//System.out.println("BruteB for the "+i+" element is "+dataset.get(i).bruteB);
					}
		
		
		do
		{
			c2++;
			c1=0;
			
			for(int i=0;i<dataset.size();i++)
			{
				//generate the R
				dataset.get(i).r=dataset.get(i).generate_reverse(dataset.get(i).b,dataset,i);
				//System.out.println("the R for the "+i+" element is "+dataset.get(i).r);
			}
			
			for(int i=0;i<dataset.size();i++)
			{
				//Generate the R union B
				dataset.get(i).unionBR=dataset.get(i).generate_union(dataset.get(i).b,dataset.get(i).r);
				//System.out.println("the BuR for the "+i+" element is "+dataset.get(i).unionBR);
			}
			
			
			//iterate on the nodes of V
			for(int i=0;i<dataset.size();i++)
			{
				ArrayList<Integer> temp1=dataset.get(i).unionBR;
				
				//iterate on the each node of BuR[i] 
				for(int u1=0;u1<temp1.size();u1++)
				{
					
					//System.out.println(temp1.get(u1));
					ArrayList<Integer> temp2=dataset.get(temp1.get(u1)).unionBR;
					
					//iterate on the each node of BuR[u1] 
					for(int u2=0;u2<temp2.size();u2++)
					{
						//System.out.print(temp2.get(u2)+" ");
						
						if(temp2.get(u2)!=i)
						{
							
							//extract the content of the vectors u2 and i
						ArrayList<Double> a1= dataset.get(temp2.get(u2)).contenu;
						ArrayList<Double> b1=dataset.get(i).contenu;
						
						
						//calculate the distance between a1 and b1
						double l= dist.driver(a1,b1);
						//System.out.println("Compate "+i+" with "+temp2.get(u2)+" Distance : "+l);
						
						//call the update function and check if the c1 is increased or not 
						c1=c1+update.updateNN(dataset.get(i).b,temp2.get(u2),l);
						}
					}
					
				}
			}
				
		
			
			ArrayList<Double> recall=new ArrayList<Double>();
			 ArrayList<Double> precision=new ArrayList<Double>();
			 
			 
			 //run the scoring function and calculate the average of the scores
			 for(int i=0;i<dataset.size();i++)
			 {
				 recall.add(EvalMetric.getPrecisionRecall(dataset.get(i).bruteB, dataset.get(i).b)[0]);
				 precision.add(EvalMetric.getPrecisionRecall(dataset.get(i).bruteB, dataset.get(i).b)[1]);
			 }

			 
			 //System.out.println("Iter: "+c2+" Recall : "+mean_arraylist(recall)+" Precision : "+mean_arraylist(precision));
			
			System.out.println(c2+"\t Recall : "+String.format(" %.2f",mean_arraylist(recall))+ " Precision : "+String.format(" %.2f",mean_arraylist(precision)));
			
			
		}while(c1!=0);
		System.out.println("");
		for(int i=0;i<dataset.size();i++)
		{
			//dataset.get(i).b=dataset.get(i).generate_sample(dataset,3,i);
			System.out.println("B for the "+i+" node "+dataset.get(i).b);
			
			System.out.println("BruteForce for the "+i+" node "+dataset.get(i).bruteB);
			System.out.println("");
		}
		
					 
				 
	}
	
	
	
	//the random generator function used to generate random sample for the B initialization 
	
	 public static int randomNumberInRange(int min, int max) {
	        Random random = new Random();
	        return random.nextInt((max - min) + 1) + min;
	    }
	 
	 
	 
	 public static double mean_arraylist(ArrayList<Double> a)
	 {
		 double s=0;
		 
		 for (int i=0;i<a.size();i++)
		 {
			 s=s+a.get(i);
			 
		 }
		 
		 s=s/a.size();
		 return s;
	 }
	 
	 
	 public static void scores_eval(ArrayList<node> dataset) {
		 
		 
		 ArrayList<Double> recall=new ArrayList<Double>();
		 ArrayList<Double> precision=new ArrayList<Double>();
		 
		 for(int i=0;i<dataset.size();i++)
		 {
			 recall.add(EvalMetric.getPrecisionRecall(dataset.get(i).bruteB, dataset.get(i).b)[0]);
			 precision.add(EvalMetric.getPrecisionRecall(dataset.get(i).bruteB, dataset.get(i).b)[1]);
		 }

		 
		 System.out.println("\nRecall : "+mean_arraylist(recall)+" Precision : "+mean_arraylist(precision));
		 
		 
	 }

}

 