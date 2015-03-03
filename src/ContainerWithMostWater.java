
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if(height.length<2){
        	return 0;
        }
        
        int[][] result = new int[height.length][height.length];
        for(int i=0;i<height.length;i++){
        	for (int j = 0; j < height.length; j++) {
        		result[i][j]=0;
			}
        	
        }
        for (int i = 1; i < height.length; i++) {
			for (int begin = 0; begin < result.length-i; begin++) {
				int ThisWater=i*Math.min(height[begin], height[begin+i]);
				if(ThisWater>result[begin][begin+i-1]&&ThisWater>result[begin+1][begin+i]){
					result[begin][begin+i]=ThisWater;
				}else if (result[begin][begin+i-1]>result[begin+1][begin+i]) {
					result[begin][begin+i]=result[begin][begin+i-1];
				}else{
					result[begin][begin+i]=result[begin+1][begin+i];
				}
			}
		}
        return result[0][height.length-1];
    }
}
