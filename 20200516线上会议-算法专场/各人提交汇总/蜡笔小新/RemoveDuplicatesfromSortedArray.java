public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int curVal;
        int prevVal = nums[0];
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            curVal = nums[i];
            if(curVal!=prevVal){
                cnt++;
            }
            prevVal = curVal;

            nums[cnt-1]=curVal;
        }

        return cnt;
    }
}
