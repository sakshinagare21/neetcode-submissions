class Solution {
    public boolean isPossible(int[] piles, int k, int h){
        long count=0;
        for(int i=0;i<piles.length;i++){
            count+=(piles[i] + k - 1) / k;
        }

        return count<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        //my answer will be from 1 to maximum number of piles present in array

        int maxi=piles[0];

        for(int x:piles){
            maxi=Math.max(x,maxi);
        }

        int low=1;
        int high=maxi;

        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
