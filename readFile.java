package knngraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
	public static ArrayList<node> read_file() throws FileNotFoundException {
		
		// read CSV file 
	String fileName = "jester.csv";
	File file = new File(fileName);
	ArrayList<node> A = new ArrayList<node>();
	
	int ii=0;
	int c=0;
	  Scanner inputStream = new Scanner(file);
	//put each line of the dataset into a node object 
	  while(inputStream.hasNext()){
	     String data = inputStream.next();
	     String[] spliteddata =  data.split(",");
	     double vect []= new double[spliteddata.length];
	     //System.out.print(spliteddata.length+" ");
	     ArrayList<Double> temp=new ArrayList<Double>();
	     for(int i=0; i<spliteddata.length;i++)
	     
	     {
	    	// System.out.println(spliteddata[i]);
	    	 temp.add(Double.parseDouble(spliteddata[i]));
	     
	     }
	     node datavect= new node(temp);
	     
	  // fill the A array with the node instances 
	     A.add(datavect);
	  }
	    	 
	  //System.out.println("Finish "+A.size());
	  
	     return A;
}
}
