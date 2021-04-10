package arraysandstrings;
/**
 * 
 *Example 1:

Input: "42"
Output: 42

Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.

Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.

Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned. 
 * 
 * 

 *
 */
public class AtoI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("2147483646"));

	}
	   public static int myAtoi(String str) {
	        if(str==null ||str.length()==0) return 0;
	        int result = 0 ;
	        int i = 0;
	        boolean negNum = false;
	        
	        while(i<str.length() && str.charAt(i)==' ')
	            i++;
	        
	        if(i<str.length()&&str.charAt(i)=='-'){
	            negNum = true;
	            i++;
	        }else if(i<str.length()&&str.charAt(i)=='+'){
	           
	            i++;
	        }
	        
	        while(i<str.length() && str.charAt(i)-'0' >= 0 && str.charAt(i)-'0' <= 9){
	            
	            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && str.charAt(i)-'0'>Integer.MAX_VALUE%10))
	                return negNum ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	            result = result*10 + (str.charAt(i)-'0');
	            i++;
	        }
	        return negNum ?  result*(-1) : result;
	        
	    }

}
/**
 * Complexity Analysis

    Time Complexity: O(N)\mathcal{O}(N)O(N). Here, N is the length of string str. We perform only one iteration over string str.
    Space Complexity: O(1)\mathcal{O}(1)O(1) We use constant extra space for storing sign of the result.

 * 
 */
