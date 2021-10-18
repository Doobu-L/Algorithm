//최소공배수 찾기

/**
Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.


Constraints:

2 <= nums.length <= 1000
1 <= nums[i] <= 1000

*/

class Solution {
    public int findGCD(int[] nums) {
        int max=0;
        int min=1000;
        int result=0;
        
        for(int num:nums){
            if(max<num)max=num;
            if(min>num)min=num;
        }
        
        for(int i=min;i>0;i--){
            if(max%i==0 && min%i==0){
                result=i;
                break;
            }
        }
        return result;
        
    }
}
