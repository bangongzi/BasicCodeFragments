import java.util.Random;

/**
 * Created by per on 2018/1/27.
 */

public class Draft {
    public void quickSortNoReturn(int[] nums) {
        int len = nums.length;
        if(len <= 1) return;
        sortHelp(nums, 0, len - 1);
    }

    public void quickSortNormal(int[] nums, int left, int right) {
        if(nums == null || left>= right) return;
        int index = partitionSword(nums, left, right);
        quickSortNormal(nums, left, index - 1);
        quickSortNormal(nums, index + 1, right);
    }

    public int partitionSword(int[] nums, int left, int right) {
        if(left >= right) return left;
        Random random = new Random();
        int index = random.nextInt(right - left + 1) + left; // index is a random number in [left, right]
        swap(nums, index, right); // put the 'to be in-position' value in the right for a while
        int val = nums[right];
        int small = left - 1; // where the smaller number stay
        for(index = left; index < right; index++) {
            if(nums[index] < val) {
                ++small;
                if(small < index) {
                    swap(nums, small, index);
                }
            }
        }
        ++small;
        swap(nums, small, right);
        return small;
    }

    public void sortHelp(int[] nums, int start, int end) {
        if(start >= end) return;
        int val = nums[start];
        int i = start, j = end;
        while(i <= j) {
            if(nums[i] <= val) {
                i++;
            } else if(nums[j] >= val) {
                j--;
            } else {
                swap(nums, i, j);
            }
        }
        swap(nums, start, j);
        sortHelp(nums, start, j-1);
        sortHelp(nums, i, end);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {
        int[] nums = {2, 1, 3, 6, 12, 3, 7, 21, 7};
        // int[] nums = {2, 1};
        // int[] nums = {2};
        Draft test = new Draft();
        test.quickSortNormal(nums, 0, nums.length - 1);
        for(int i: nums) {
            System.out.println(i);
        }
    }
}
