package amazo;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(solution(new int[] {-1,1,-3}));
		//solution("1111010101111");
		//solution("011100");
		solution("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		}
	
	
	
	 public static int solution(String S) {
		 double d=0;
		 int l=0;
		 long l1 = 0;
		 int d1=0;
		 long d2=0;
		 try {
		  l1= Long.parseLong(S,2);
		  d1= (int) (l1);
		  
		 }catch(NumberFormatException e) {
			 for(int i=0;i<S.length();i++) {
				 if(S.charAt(i)=='1')
					  l = S.length()-1-i;
				 d2+=Math.pow(2, l);
				 
				 
			 }
			 d1=(int)d2;
		 }
		  
		 /*for(int i=0;i<S.length();i++) {
			 if(S.charAt(i)=='1')
				  l = S.length()-1-i;
			 d+=Math.pow(2, l);
			 
		 }*/
		 System.out.println((int)d1 + ".is the parsed string");
		// if((int)d>1000000) 
			// d = 1000000;
		 int count = 0;
		 while((int)d1!=0) {
			 if(d1%2==0)
				 d1=d1/2;
			 else
				 d1=d1-1;
			 count++;
		 }
		 System.out.println("Number of iters is "+ count);
		 return count;
		 
		 
		 
	 }
	
	   /* public static int solution(int[] A) {
	    	if(A==null || A.length==0)
	    		return 0;
	        // write your code in Java SE 8
	    	int value = Arrays.stream(A).reduce(1,(x,y)->x*y);
	    	if(value>0)
	    		return 1;
	    	else if(value<0)
	    		return -1;
	    	else return 0;  	
	    	
	    	
	    	
	        
	    }
	*/


}
