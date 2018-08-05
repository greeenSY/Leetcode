package WiggleSortII;

public class Solution {
	private int partition(int[] a, int low, int high) {
		int key = a[low];
		while (low < high) {
			while (low < high && a[high] >= key)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= key)
				low++;
			a[high] = a[low];
		}
		a[low] = key;
		return low;
	}

	private int quickSelect(int[] a, int low, int high, int k) {

		if (low == high)
			return a[low];
		int keyPos = partition(a, low, high);

		int num = keyPos - low + 1;
		if (num == k)
			return a[keyPos];
		else if (k < num)
			return quickSelect(a, low, keyPos - 1, k);
		else
			return quickSelect(a, keyPos + 1, high, k - num);

	}

	private int mapIndex(int i, int n){
		return (1+2*i) % (n|1);
	}

	private void swap(int[] nums, int a, int b){
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}

	public void wiggleSort(int[] nums) {
		int n = nums.length;
		int mid = quickSelect(nums, 0 ,n-1, n / 2 + 1);
		// 3-way-partition-to-wiggly in O(n) time with O(1) space.
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
			if (nums[mapIndex(i, n)] > mid)
				swap(nums, mapIndex(left++, n), mapIndex(i++, n));
			else if (nums[mapIndex(i, n)] < mid)
				swap(nums, mapIndex(i, n), mapIndex(right--, n));
			else
				i++;
		}

	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = {1, 5, 1, 1, 6, 4};
		solution.wiggleSort(array);
		for(int i : array){
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println();

		int[] array2 = {1, 3, 2, 2, 3, 1};
		solution.wiggleSort(array2);
		for(int i : array2){
			System.out.print(i);
			System.out.print(",");
		}
		System.out.println();

	}

}
