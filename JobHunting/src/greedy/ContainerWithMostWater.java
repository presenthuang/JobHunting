package greedy;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while(l < r){
            int min = Math.min(height[l], height[r]);
            if(min*(r-l) > max){
                max = min*(r-l);
            }
            if(height[l] < height[r]){
                int lh = height[l];
                while(l < r && height[l] <= lh){
                    l++;
                }
            }else{
                int rh = height[r];
                while(l < r && height[r] <= rh){
                    r--;
                }
            }
        }
        return max;
    }
}
