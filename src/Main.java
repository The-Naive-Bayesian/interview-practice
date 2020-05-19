public class Main
{
   public static void main(String[] args) {
      int target = 6;
      int[] nums = new int[]{3, 4, 5, 2, 6};

      int[] indexes = TwoSum.twoSum(nums, target);
      System.out.print(String.format("%d and %d sum to %d", nums[indexes[0]], nums[indexes[1]], target));

      int[] indexesRevised = TwoSum.twoSumRevised(nums, target);
      System.out.print(String.format("\n%d and %d sum to %d", nums[indexesRevised[0]], nums[indexesRevised[1]], target));
   }
}
