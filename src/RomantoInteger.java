import java.util.*;




public class RomantoInteger {
	public static int Solution(String s){
		Map<Character,Integer> CharValue=new HashMap<Character, Integer>();
		CharValue.put('I', 1);
		CharValue.put('V', 5);
		CharValue.put('X', 10);
		CharValue.put('L', 50);
		CharValue.put('C', 100);
		CharValue.put('D', 500);
		CharValue.put('M', 1000);
		int result=0;
		for (int i = 0; i < s.length(); i++) {
			char Mychar=s.charAt(i);
			if (i+1<s.length()&&CharValue.get(Mychar)<CharValue.get(s.charAt(i+1))) {
				result-=CharValue.get(Mychar);
			}else{
				result+=CharValue.get(Mychar);
			}
		}
		return result;
	}
}
