package knngraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
	public static void main(String[] args) throws FileNotFoundException {
	String fileName = "jester.csv";
	File file = new File(fileName);
	ArrayList<node> A = new ArrayList<node>();
	
	int ii=0;
	  Scanner inputStream = new Scanner(file);
	  while(inputStream.hasNext()){
	     String data = inputStream.next();
	     String[] spliteddata =  data.split(",");
	     //double vect []= new double[spliteddata.length];
	     double vect []= new double[8];
	     
	     //System.out.print(spliteddata.length+" ");
	     //for(int i=0; i<spliteddata.length;i++)
	     for(int i=0; i<8;i++)
	    	 
	     {
	    	 //System.out.println(spliteddata[i]);
	    	  vect[i]= Double.parseDouble(spliteddata[i]);
	    	 node datavect= new node(vect);
	     A.add(datavect);
	     
	     }
	     
	     }
	  for(int i=0; i<8;i++){
	    	 System.out.println((A.get(i)).contenu);      }
	    	 
	  System.out.println("Finish");
	  
	     
}
}
