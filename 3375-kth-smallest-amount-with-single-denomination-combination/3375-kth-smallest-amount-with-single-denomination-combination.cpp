class Solution {
public:
    vector<long long> lcmVector;

    long long getCount(long long target) {
        long long count = 0;
        for(auto& lcm: lcmVector) count += target/lcm;
        return count;
    }

    long long findKthSmallest(vector<int>& coins, int k) {
        int n = coins.size();
        int allOnes = (1 << n) - 1;

        for(int mask = 1; mask <= allOnes; mask++) {
            long long currLCM = 1;
            for(int i = 0; i < n; i++) if(mask & (1 << i)) currLCM = lcm(currLCM, coins[i]);
            currLCM = (__builtin_popcount(mask) & 1? 1 : -1) * currLCM;
            lcmVector.push_back(currLCM);
        }

        long long l = 1, r = 1e11;
        while(l < r) {
            long long mid = l + (r-l)/2;
            long long count = getCount(mid);
            if(count < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    
};