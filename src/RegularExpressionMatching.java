import java.awt.List;
import java.util.ArrayList;

import com.sun.media.jfxmedia.events.NewFrameEvent;


public class RegularExpressionMatching {
	class Node{
		public char mychar;
		public int length;
	}
	class Node2{
		public char mychar;
		public int Max;
		public int min;
	}
	 public boolean isMatch(String s, String p) {
		 	
		 	ArrayList<Node> sList=new ArrayList<Node>();
		 	ArrayList<Node2> pList=new ArrayList<Node2>();
		 	//把s读成List
		 	if (s.length()>0) {
				char sChar=s.charAt(0);
				int leng=1;
				for (int i = 1; i < s.length(); i++) {
					if(sChar==s.charAt(i)){
						leng++;
					}else {
						Node newNode=new Node();
						newNode.mychar=sChar;
						newNode.length=leng;
						sList.add(newNode);
						sChar=s.charAt(i);
						leng=1;
					}
					
				}
			}
		 	if (p.length()>0) {
				char pChar=p.charAt(0);
				int leng=1;
				boolean hasChange=false;
				for (int i = 1; i < s.length(); i++) {
					if(pChar==p.charAt(i)){
						leng++;
					}else {
						if(p.charAt(i)=='*'){
							hasChange=true;
							leng--;
						}else {
							Node2 newNode=new Node2();
							newNode.mychar=pChar;
							newNode.min=leng;
							if(hasChange){
								newNode.Max=-1;
							}else{
								newNode.Max=leng;
							}
							pList.add(newNode);
							pChar=s.charAt(i);
							leng=1;
							hasChange=false;
						}
						
					}
					
				}
				if(p.charAt(p.length()-1)=='*'){
					Node2 newNode=new Node2();
					newNode.mychar=pChar;
					newNode.min=leng;
					if(hasChange){
						newNode.Max=-1;
					}else{
						newNode.Max=leng;
					}
					pList.add(newNode);
				}
			}
		 	//两个录入完后开始对比
		 	
	        return true;
	    }
}
