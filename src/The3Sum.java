import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.scenario.animation.shared.InfiniteClipEnvelope;


public class The3Sum {
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> ret=new ArrayList<List<Integer>>();
    	Arrays.sort(num);
    	//找到分界点
    	int neg=-1;
    	int pos=-1;
    	int count0=0;
    	for (int i = 0; i < num.length; i++) {
			if(num[i]==0){
				if (neg==-1) {
					neg=i-1;
				}
				count0++;
			}
			if(num[i]>0){
				if (neg==-1) {
					neg=i-1;
				}
				pos=i;
				break;
			}
		}
    	if (neg==-1||pos==-1) {
    		if(count0<3){
    			return ret;
    			
    		}else{
    			List<Integer> zeros=new ArrayList<Integer>();
    			zeros.add(0);
    			zeros.add(0);
    			zeros.add(0);
    			ret.add(zeros);
    			return ret;
    		}
    		
		}
    	int negs[]=new int[neg+1];
    	int poss[]=new int[num.length-pos];
    	for (int i = 0; i < negs.length; i++) {
			negs[i]=num[i];
		}
    	for (int i = pos; i < num.length; i++) {
			poss[i]=num[i];
		}
    	//两正数和
    	HashMap<int[], Integer> PosSum=new HashMap<int[], Integer>();
    	for (int i = 0; i < poss.length; i++) {
			for (int j = i+1; j < poss.length; j++) {
				int number[]={poss[i],poss[j]};
				PosSum.put(number, poss[i]+poss[j]);
			}
		}
    	//两负数和
    	HashMap<int[], Integer> negSum=new HashMap<int[], Integer>();
    	for (int i = 0; i < negs.length; i++) {
			for (int j = i+1; j < negs.length; j++) {
				int number[]={negs[i],negs[j]};
				negSum.put(number, negs[i]+negs[j]);
			}
		}
    	//有零那正数加负数
    	if (count0>0) {
			for (int i = 0; i < poss.length; i++) {
				for (int j = 0; j < negs.length; j++) {
					if (poss[i]==-negs[j]) {
						List<Integer> lists=new ArrayList<Integer>();
						lists.add(negs[j]);
						lists.add(0);
						lists.add(poss[i]);
						ret.add(lists);
					}
				}
			}
		}
    	return ret;
    }
}
