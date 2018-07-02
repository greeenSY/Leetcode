package KthLargestElementInAnArray;

public class Solution {

	public static int split(int[] nums, int low, int high) {
		int mid=nums[low];
		while(low<high){
			while(low < high && nums[high] >= mid){
				high--;
			}
			if(low < high){
				nums[low++] = nums[high];
			}
			while(low < high && nums[low] <= mid){
				low++;
			}
			if(low < high){
				nums[high--] = nums[low];
			}
		}
		nums[low] = mid;
		return low;
    }
	
	public static int findKthLargest(int[] nums, int k) {
		int n = nums.length;
		int begin = 0,end = n-1,mid=0;
		mid = split(nums,begin,end);
		while(true){
			if(mid == end+1-k){
				return nums[mid];
			}else if(mid < end+1-k){
				begin = mid+1;
				mid = split(nums,begin,end);
			}else if(mid > end+1-k){
				k = k-(end+1-mid);
				end = mid-1;
				mid = split(nums,begin,end);
			}
		}
    }
	public static void main(String[] args) {
		int[] a= {7,6,5,4,3,2,1};
		System.out.println(findKthLargest(a,5));

	}

}
