package Q21;

/*
 * Given n non-negative integers representing an elevation 
 * map where the width of each bar is 1, compute how much water it can trap after raining.
 * 
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        int[] right = new int[height.length];
        int[] left = new int[height.length];
        
        left[0] = 0;
        int max = height[0];
        
        for(int i=1;i<height.length;i++) {
            left[i] = Math.max(max, height[i-1]);
            max =  left[i];
        }
        
        right[height.length-1] = 0;
        max = height[height.length-1];
        for(int i=height.length-2;i>=0;i--) {
            right[i] = Math.max(max, height[i+1]);
            max = right[i];
        }
        
        int ans = 0;
        for(int i=0;i<height.length;i++) {
            int minOfMax = Math.min(left[i], right[i]);
            if(minOfMax - height[i] > 0) ans += minOfMax - height[i];
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int[] heights = new int[] {4,2,0,3,2,5};

        System.out.println(trap(heights));
    }
}

/*
 * TC: O(n)
 * SC: O(n)
 */