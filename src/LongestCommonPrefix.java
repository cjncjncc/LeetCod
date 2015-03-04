
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length==0){
    		return "";
    	}
    	int CommonPrelength=0;
    	for (int i = 0; i < strs[0].length(); i++) {
			char testChar=strs[0].charAt(i);
			boolean AlltheSame=true;
			for(int j=1;j<strs.length;j++){
				if (strs[j].length()>i&&strs[j].charAt(i)==testChar) {
					
				}else{
					AlltheSame=false;
				}
			}
			if (AlltheSame) {
				CommonPrelength=i+1;
			}else{
				break;
			}
		}
    	String ret=strs[0].substring(0,CommonPrelength);
        return ret;
    }
}
