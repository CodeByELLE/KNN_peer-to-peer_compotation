package knngraph;

import java.awt.List;
import java.util.*; 
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class node
{
	//this to store the content of the dataset ( each row )
	 public ArrayList<Double> contenu =new ArrayList<Double>();
	 
	 //this to store the B (neighbors)
	 public HashMap<Integer, Double> b=new HashMap<Integer, Double>();
	 
	 
	 public ArrayList<Integer> r = new ArrayList<Integer>();
	 public ArrayList<Integer> unionBR= new ArrayList<Integer>();
	 
	 //this to store the real K neighbors
	 public HashMap<Integer, Double> bruteB=new HashMap<Integer, Double>();
	 
	 
	 //constuctor to initiate the node with an array
	 node(double[] t)
	 {
		 for(int i=0;i<t.length;i++)
		 {
			 contenu.add((double)t[i]);
			 
		 }
	 }
	 
	 node(ArrayList<Double> t)
	 {
		 for(int i=0;i<t.size();i++)
		 {
			 contenu.add((double)t.get(i));
			 
		 }
	 }
	 
	 
	 public HashMap<Integer, Double> generate_sample(ArrayList<node> v,int k,int h)
	 {
		 
		 ArrayList<Integer> ran_index=new ArrayList<Integer>();
		 int i=0;
		 while(i<k)
			 {
			 int r=knngraph.randomNumberInRange(0,v.size()-1);
			 if(!ran_index.contains(r) && r!=h)
			 {
				 ran_index.add(r);
				 i=i+1;
			 }
			 };
			 HashMap<Integer, Double> p= new HashMap<Integer, Double>();
		for(int j=0;j<k;j++)
		{
			p.put(ran_index.get(j), (double) 999);
		}
		 

		 return p;
	 }
	 
	 public ArrayList<Integer> generate_reverse(HashMap<Integer, Double> p,ArrayList<node> v,int h)
	 {
		 ArrayList<Integer> r=new ArrayList<Integer>();
		 
		 
		 for(int i=0;i<v.size();i++)
		 {
			 if(i!=h)
			 {
			 for (Integer key:v.get(i).b.keySet())
			 {
				 //System.out.println(i+" "+key);
				 if(key==h)
				 {
					r.add(i); 
					
				 }
			 }
			 
		 }}
		 
		 return r;
	 }
	 
	 public ArrayList<Integer> generate_union(HashMap<Integer,Double> p,ArrayList<Integer> r)
	 {
		 ArrayList<Integer> u=new ArrayList<Integer>();
		 
		 for (Integer key:p.keySet())
		 {
			 //System.out.println(i+" "+key);
			
				u.add(key); 
			 
		 }
		 
		 for(int i=0;i<r.size();i++)
		 {
			 u.add(r.get(i));
			 
		 }
		 
		 Set<Integer> set = new HashSet<Integer>(u);
		 ArrayList<Integer> u1 = new ArrayList<Integer>(set);
		 
		 return u1;
	 }
	 
	 public HashMap<Integer, Double> brute_force(ArrayList<node> v,int k,int h)
	 {
		 HashMap<Integer,Double> bb=new HashMap<Integer,Double>();
		 
		 for(int i=0;i<v.size();i++)
		 {
			 if(i!=h)
			 {
				 bb.put(i, knngraph.dist.driver(v.get(i).contenu,v.get(h).contenu));
			 }
				 
		 }
		 
		 
		 
		 return bb;
		 
	 }
	 
	 
	 
	 
	 
	 
}
 