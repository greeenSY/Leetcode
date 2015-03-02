package SearchInRotatedSortedArray;

public class Solution {

	public static int search(int[] A, int target) {
		int n = A.length;
		if(n <= 0)
			return -1;
		int i,result = -1;
		if(target > A[n-1]){
			i=0;
			while(i < n){
				if(A[i] == target){
					result = i;
					break;
				}else if(A[i] > target){
					break;
				}
				i++;
			}
		} else {
			i=n-1;
			while(i >= 0){
				if(A[i] == target){
					result = i;
					break;
				}else if(A[i] < target){
					break;
				}
				i--;
			}
		}
		return result;
        
    }
	public static void main(String[] args) {
		int A[] = {4,5,6,7,0,1,2};
		int target = 9;
		System.out.println(search(A,target));
	}

}
