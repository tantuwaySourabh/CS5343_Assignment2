package Q2;

public class FindPeak {

    public static void main(String[] args){

        //driver code for passing input array
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println("Peak element index is : " + findPeakElement(arr));

    }
    public static int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int l, int r){

        if(l == r) return l;
        int mid = (l + r) / 2;

        if(nums[mid] > nums[mid + 1])
            return search(nums, l, mid);

        return search(nums, mid + 1, r);
    }
}