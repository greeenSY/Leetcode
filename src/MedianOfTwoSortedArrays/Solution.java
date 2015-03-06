package MedianOfTwoSortedArrays;

public class Solution {

	private static int[] merge(int[] a, int[] b,int m,int n) {
		int[] re = new int[m+n];
		int i=0,j=0,t=0;
		while(i<m && j<n){
			if(a[i]<b[j]){
				re[t++] = a[i++];
			}
			else{
				re[t++] = b[j++];
			}
		}
		if(i==m){
			while(j<n)
				re[t++] = b[j++];
		} else if(j==n){
			while(i<m)
				re[t++] = a[i++];
		}
			
		return re;
	}
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int[] C = merge(A,B,m,n);
		if((m+n) % 2 == 0)
			return ((double)C[(m+n)/2] + (double)C[(m+n)/2 - 1]) / 2;
		else
			return (double)C[(m+n)/2];
        
    }
	
	public static void main(String[] args) {
		int[] A = {20,21,23};
		int[] B = {24,25,29,32,33};
		System.out.println(findMedianSortedArrays(A,B));
 	}

}
