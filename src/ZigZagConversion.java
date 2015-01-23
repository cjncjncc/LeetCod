import java.util.*;
public class ZigZagConversion {
	  public static String convert(String s, int nRows) {
		 if(nRows>1){
		 int Seg;
		 int SegLength;
		 String ret="";
		 SegLength=nRows*2-2;
		 Seg=s.length()/SegLength;
		 Map<Integer,int[]> SameLevelNum=new HashMap<Integer,int[]>();
		 
		 for(int i=1;i<nRows+1;i++){
			 if(i!=1&&i!=nRows){
				 int []b=new int[2];
				 b[0]=i;
				 b[1]=2*nRows-i;
				 SameLevelNum.put(i, b);
			 }else{
				 int []a=new int[1];
				 a[0]=i;
				 SameLevelNum.put(i, a);
			 }
		 }
		 for(int i=1;i<=nRows;i++){
			 for(int j=0;j<Seg+1;j++){
				 int []Array=SameLevelNum.get(i);
				 for(int m:Array){
					 if(SegLength*j+m<s.length()+1){
						 ret+=s.charAt(SegLength*j+m-1);
					 }
				 }
			 }
		 }
		 return ret;		
		 }else{
			 return s;
		 }
	 }
}
