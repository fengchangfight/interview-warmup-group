import java.util.Arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        boolean[] calculatedMax = new boolean[nums.length];
        boolean[] calculatedMin = new boolean[nums.length];
        Arrays.fill(calculatedMax, false);
        Arrays.fill(calculatedMin, false);

        int globalMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int v = dpmax(nums, i, dpMax, dpMin, calculatedMax, calculatedMin);
            globalMax = Math.max(globalMax, v);
        }

        return globalMax;
    }

    private int dpmax(int[] nums, int i, int[] dpMax, int[] dpMin, boolean[] calculatedMax, boolean[] calculatedMin){
        if(calculatedMax[i]){
            return dpMax[i];
        }

        if(i==0){
            dpMax[i]=nums[i];
            calculatedMax[i]=true;
            return nums[i];
        }
        if(nums[i]>0){
            // 正数
            int val =  Math.max(nums[i], nums[i]*dpmax(nums, i-1, dpMax, dpMin, calculatedMax, calculatedMin));
            calculatedMax[i]=true;
            dpMax[i]=val;
            return val;
        }else if(nums[i]==0){
            // 0
            dpMax[i]=0;
            calculatedMax[i]=true;
            return 0;
        }else{
            //负数
            int val = Math.max(nums[i], nums[i]*dpmin(nums, i-1, dpMax, dpMin, calculatedMax, calculatedMin));
            dpMax[i]=val;
            calculatedMax[i]=true;
            return val;
        }
    }

    private int dpmin(int[] nums, int i, int[] dpMax, int[] dpMin, boolean[] calculatedMax, boolean[] calculatedMin){
        if(calculatedMin[i]){
            return dpMin[i];
        }
        if(i==0){
            dpMin[i]=nums[i];
            calculatedMin[i]=true;
            return nums[i];
        }

        if(nums[i]>0){
            // 正数
            int val = Math.min(nums[i], nums[i]*dpmin(nums, i-1, dpMax, dpMin, calculatedMax, calculatedMin));
            dpMin[i]=val;
            calculatedMin[i]=true;
            return val;
        }else if(nums[i]==0){
            // 0
            dpMin[i]=0;
            calculatedMin[i]=true;
            return 0;
        }else{
            //负数
            int val = Math.min(nums[i], nums[i]*dpmax(nums, i-1, dpMax, dpMin, calculatedMax, calculatedMin));
            dpMin[i]=val;
            calculatedMin[i]=true;
            return val;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3};

        MaximumProductSubarray demo = new MaximumProductSubarray();
        int ret = demo.maxProduct(nums);

        System.out.println(ret);
    }
}
