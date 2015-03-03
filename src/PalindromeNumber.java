
public class PalindromeNumber {
	 public static boolean isPalindrome(int x) {
		 if(x<0){
			 return false;
		 }
		String y=Integer.toString(Math.abs(x));
		if(y.length()<2){
			return true;
		}else{
			if(y.length()%2==0){
				int mid1=y.length()/2;
				int mid2=mid1-1;
				for(int i=0;i<mid1;i++){
					if(y.charAt(mid2-i)!=y.charAt(mid1+i)){
						return false;
					}
				}
				return true;
			}else{
				int mid=y.length()/2;
				for(int i=1;i<=mid;i++){
					if(y.charAt(mid-i)!=y.charAt(mid+i)){
						return false;
					}
				}
				return true;
			}
		}
	 }
}
