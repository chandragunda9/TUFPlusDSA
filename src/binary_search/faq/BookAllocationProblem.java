package binary_search.faq;

public class BookAllocationProblem {
    public int findPages(int[] nums, int m) {
        int n=nums.length;
        if(n<m)
            return -1;

        int maxPages=Integer.MIN_VALUE;
        int sumPages=0;

        for(int i=0;i<n;i++){
            maxPages=Math.max(maxPages, nums[i]);
            sumPages+=nums[i];
        }

        int low=maxPages, high=sumPages;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canAllocate(nums, m, mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }


    boolean canAllocate(int[] nums, int m, int mid){
        int studentInd=1, pages=nums[0];
        for(int i=1;i<nums.length;i++){
            if(pages+nums[i]>mid){
                studentInd++;
                if(studentInd>m)
                    return false;
                pages=nums[i];
            }
            else{
                pages+=nums[i];
            }
        }
        return true;
    }
}
