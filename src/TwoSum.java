import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class with my solutions for the two-sum problem here: https://leetcode.com/problems/two-sum/
public class TwoSum
{
   static void run() {
      int target = 6;
      int[] nums = new int[]{3, 4, 5, 2, 6};

      int[] indexes = TwoSum.twoSum(nums, target);
      System.out.print(String.format("%d and %d sum to %d", nums[indexes[0]], nums[indexes[1]], target));

      int[] indexesRevised = TwoSum.twoSumRevised(nums, target);
      System.out.print(String.format("\n%d and %d sum to %d", nums[indexesRevised[0]], nums[indexesRevised[1]], target));
   }

   // My initial approach, including comments I used to think out loud
   static int[] twoSum(int[] nums, int target) {
      Map<Integer, List<Integer>> indexMap = new HashMap<>();

      // Iterate through the 'nums' array
      // If key not present, add it along with a new List including the current index
      // If key present already, push the new index to the List
      for (int i=0; i<nums.length; i++) {
         int currentValue = nums[i];
         if (!indexMap.containsKey(currentValue)) {
            List<Integer> indexList = new ArrayList<>();
            indexList.add(i);
            indexMap.put(currentValue, indexList);
         } else {
            indexMap.get(currentValue).add(i);
         }
      }

      // Iterate through the original list of values and look for (target - value) in the map
      // if the map contains (target - value) as a key, then:
      // if num == (target - value), then it's a hit iff there are 2 indices in the list
      // if so, return both (this is the unique solution since we can assume a single solution)
      // otherwise, return the index of the current value and the index associated with (target - value)
      for (int i = 0; i<nums.length; i++) {
         int currentValue = nums[i];
         int complementValue = target - currentValue;

         if(indexMap.containsKey(complementValue)) {
            List<Integer> complimentIndexList= indexMap.get(complementValue);
            if (currentValue == complementValue) {
               if (complimentIndexList.size() > 1) {
                  return new int[]{complimentIndexList.get(0), complimentIndexList.get(1)};
               }
            } else {
               return new int[]{i, complimentIndexList.get(0)};
            }
         }
      }
      // should never get here
      throw new InvalidParameterException("No two-sum answer found");
   }

   // Improved solution based on the solutions provided by LeetCode
   static int[] twoSumRevised(int[] nums, int target) {
      Map<Integer, Integer> indexMap = new HashMap<>();

      for (int i=0; i<nums.length; i++) {
         int currentValue = nums[i];
         if (indexMap.containsKey(target - currentValue)) {
            return new int[]{indexMap.get(target - currentValue), i};
         }
         indexMap.put(nums[i], i);
      }
      throw new IllegalArgumentException();
   }
}
