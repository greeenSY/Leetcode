package FirstMissingPositive;

public class Solution {

	/*
class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        int i = 0;
        while (i < n)
        {
            if (A[i] != (i+1) && A[i] >= 1 && A[i] <= n && A[A[i]-1] != A[i])
                swap(A[i], A[A[i]-1]);
            else
                i++;
        }
        for (i = 0; i < n; ++i)
            if (A[i] != (i+1))
                return i+1;
        return n+1;
    }
};
	 */
	public static int firstMissingPositive(int[] nums) {
		if(nums==null)
			return 1;
		int len = nums.length;
		int []r = new int[len+1];
		for(int i=0; i <= len; i++)
			r[i]=1;
		for(int i=0; i < len; i++){
			if(nums[i] <= 0)
				continue;
			else if(nums[i] <= len)
				r[nums[i]] = 0;
		}
		for(int i=1; i <= len; i++)
			if(r[i]==1)
				return i;
		return len+1;
        
    }
	public static void main(String[] args) {
		int []a= {1,3,2,-1};
		System.out.println(firstMissingPositive(a));

	}

}
