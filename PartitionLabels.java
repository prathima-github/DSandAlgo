package amazo;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<Integer> partitionLabels(String S) {
	        int[] lastIndex = new int[26];
	        for(int i=0;i<S.length();i++)
	            lastIndex[S.charAt(i) - 'a'] = i;
	        
	        
	        int j=0;
	        int anchor = 0;
	        List<Integer> partitions = new ArrayList();
	        for(int i=0;i<S.length();i++){
	            j=Math.max(j,lastIndex[S.charAt(i)-'a']);
	            if(i==j){
	                partitions.add(i-anchor+1);
	                anchor = i+1;
	            }
	        }
	        return partitions;
	        
	    }

}
