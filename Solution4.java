import java.util.Arrays;
class Solution4 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n =nums.length;
        int[] ans = new int[n];
        int totalSum=0;
        for (int num:nums){
            totalSum += num;
        }
        int leftSum=0;
        for(int i=0;i<n;i++){
            int rightSum=totalSum-leftSum-nums[i];
            ans[i] =nums[i]*i-leftSum+rightSum-nums[i]*(n-i-1);
            leftSum += nums[i];
        }
        return ans;
    }
    public static void main(String[] args){
        Solution4 s=new Solution4();
        int[] nums={2,3,5};
        System.out.println(Arrays.toString(s.getSumAbsoluteDifferences(nums)));
    }
}

