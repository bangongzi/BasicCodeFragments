package Algorithm;
import java.util.Random;

/**
 *  快速排序的思想是分而治之。每次排好一个位置，使这个元素左边的位置都不大于这个元素，使这个元素右边的元素都不小于这个元素。
 *  迭代的对这个位置的左边和右边进行排序，即可得到最终排序结果。时间复杂度O(nlog(n))，空间复杂度O(n)
 *  如果数组有序程度较高，用快排可能会有O(n^2)这样高时间复杂度风险。
 *  在这里我们采用随机打乱的方式避免，而实际上应用中，可预先判断有序程度，如果有序程度高，可结合堆排序进来(如Java Arrays.sort()中做法)。
 *  这里的partition函数是从左到右单个指针遍历，而非左右两个指针一起遍历。这么做方便记忆、手写代码，且似乎也没有丢失什么性能。
 */
public class QuickSort {
    // 按升序排序
    public static void sortSingle(int[] nums) {
        if (nums == null || nums.length == 0) return;

        sortSingle(nums, 0, nums.length - 1);
    }

    private static void sortSingle(int[] nums, int lo, int hi) {
        if (lo >= hi) return;

        int index = partitionSingle(nums, lo, hi);
        sortSingle(nums, lo, index - 1);
        sortSingle(nums, index + 1, hi);
    }

    private static int partitionSingle(int[] nums, int lo, int hi) {
        if(lo >= hi) return lo;

        Random random = new Random();
        int index = random.nextInt(hi - lo + 1) + lo;
        swap(nums, index, lo);

        int val = nums[lo];
        int smallIndex = lo; // where the smaller number stay

        // 把比给定元素小的，都放到左边
        for(index = lo + 1; index <= hi; index++) {
            if(nums[index] < val) {
                if(++smallIndex < index) {
                    swap(nums, smallIndex, index);
                }
            }
        }

        swap(nums, smallIndex, lo);
        return smallIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
