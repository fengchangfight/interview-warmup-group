
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // edge case: nums empty

        if(nums.length<1){
            return 0;
        }

        int currentSum = nums[0];
        int globalMaxSum = currentSum;

        for(int i=1;i<nums.length;i++){
            if(currentSum<0){
                currentSum = nums[i];
            }else{
                currentSum = nums[i]+currentSum;
            }

            if(currentSum>globalMaxSum){
                globalMaxSum = currentSum;
            }
        }

        return globalMaxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray demo = new MaximumSubarray();
        int ret = demo.maxSubArray(nums);

        System.out.println(ret);
    }
}
