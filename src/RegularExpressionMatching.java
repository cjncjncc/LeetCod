import java.util.*;
public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		int jump=0;
		int replaced=0;
		Map<Integer,int[]> retro=new HashMap<Integer,int[]>();
		Map<Integer,Character> ReplaceC=new HashMap<Integer,Character>();
		String remaindString=p;
		int begin=0;
		while(remaindString.indexOf("*")>0){
			int place=remaindString.indexOf("*")+begin-1;
			ReplaceC.put(place,p.charAt(place));
			if(place+2<p.length()){
				remaindString=p.substring(place+2,p.length());
			}else{
				remaindString="";
			}
			p=p.substring(0,place)+p.substring(place+1,p.length());
			begin=place+1;
		}
		System.out.println(p);
		if(s.length()>0&&p.length()==0){
			return false;
		}
		for(int i=0;i<s.length();i++){
				if(s.charAt(i)!=p.charAt(i+jump-replaced)){
					if(p.charAt(i+jump-replaced)=='.'){
						
					}else if(p.charAt(i+jump-replaced)=='*'){
						if(ReplaceC.get(i+jump-replaced)==s.charAt(i)){
							int info[]=new int[3];
							info[0]=jump;
							info[1]=replaced;
							info[2]=i;
							retro.put(retro.size()+1, info);
							jump++;
						}else if(ReplaceC.get(i+jump-replaced)=='.'){
							int info[]=new int[2];
							info[0]=jump;
							info[1]=replaced;
							info[2]=i;
							retro.put(retro.size()+1, info);
							jump++;
						}else if(retro.size()>0){
							int info[]=retro.get(retro.size());
							jump=info[0];
							replaced=info[1]+1;
							i=info[2];
							retro.remove(retro.size());
						}else{
							return false;
						}
					}else if(retro.size()>0){
						int info[]=retro.get(retro.size());
						jump=info[0];
						replaced=info[1]+1;
						i=info[2];
						retro.remove(retro.size());
					}else{
						return false;
					}
			}else if(i==s.length()&&i+jump-replaced==p.length()){
				return true;
			}
			
		}
		return false;
      }
}
