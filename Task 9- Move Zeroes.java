import java.util.Arrays;  

class Solution9 {      
    public void moveZeroes(int[] nums) {          
        int insertPosition = 0;          
        
        // Shift non-zero values to the front
        for (int i = 0; i < nums.length; i++) {             
            if (nums[i] != 0) {                 
                nums[insertPosition++] = nums[i];             
            }         
        }          
        
        // Fill the remaining positions with zeros
        while (insertPosition < nums.length) {             
            nums[insertPosition++] = 0;         
        }     
    }      
    
    public static void main(String[] args) {         
        Solution9 s = new Solution9();         
        int[] nums = {0, 1, 0, 3, 12};          
        
        s.moveZeroes(nums);         
        System.out.println(Arrays.toString(nums)); // Output: [1, 3, 12, 0, 0]    
    } 
}
