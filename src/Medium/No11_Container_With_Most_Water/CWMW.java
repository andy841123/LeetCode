package Medium.No11_Container_With_Most_Water;

public class CWMW {
    public static void main(String[] args) {
        // int[] height = {1,8,6,2,5,4,8,3,7};
        // int[] height = {1,1};
        // int[] height = {4,3,2,1,4};
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }

    static int maxArea(int[] height){
        int max_area = 0, left = 0, right = height.length - 1;
        while(left <= right){
            int h = Math.min(height[left], height[right]);
            int l = right - left;
            max_area = Math.max(h * l, max_area);

            /*  讓比較小的一邊去做搜尋  */

            if(height[right] > height[left]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return max_area;
    }
}
