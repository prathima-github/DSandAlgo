package amazo;

import java.util.Arrays;

public class ReorderLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(log1,log2) -> {
            String[] split1 = log1.split(" ",2);
            String[] split2 = log2.split(" ",2);
            
            boolean flag1 = Character.isDigit(split1[1].charAt(0));
            boolean flag2 = Character.isDigit(split2[1].charAt(0));
            if(!flag1 && !flag2){
                int i = split1[1].compareTo(split2[1]);
                if(i!=0) return i;
                    return split1[0].compareTo(split2[0]);
                
                
            }  
            
            return flag1 ? (flag2 ? 0 : 1) : -1;
           
        });
        return logs;
        
    }

}
