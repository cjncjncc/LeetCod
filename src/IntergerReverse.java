import java.util.*;
public class IntergerReverse {
    public static int reverse(int x) {
    	boolean IsNegative;
    	Map<Integer,Integer> numberMap=new HashMap<Integer,Integer>();
    	int numberCount=0;
    	long ret=0;
    	if(x<0){
    		IsNegative=true;
    		ret=x;
    		ret=-ret;
    	}else{
    		IsNegative=false;
    		ret=x;
    	}
    	while(ret!=0){
    		numberCount++;
    		numberMap.put(numberCount,(int)(ret%10));
    		ret=ret/10;
    	}
    	ret=0;
    	for(int i=1;i<=numberCount;i++){
    		ret=ret*10+numberMap.get(i);
    	}
    	
    	if(IsNegative){
    		ret=-ret;
    		if(ret<Integer.MIN_VALUE){
    			x=0;
    		}else{
    			x=(int) ret;
    		}
    	}else{
    		if(ret>Integer.MAX_VALUE){
    			x=0;
    		}else{
    			x=(int) ret;
    		}
    	}
		return x;
    }
}
