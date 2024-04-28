#include<iostream>
#include<vector>
#include<algorithm>
#include <cstdlib>


using namespace std;

int main() {
    int n, l;
    vector<int> liquids;
    cin >> n;
    for (int i = 0; i < n; i ++) {
        cin >> l;
        liquids.push_back(l);
    }

    sort(liquids.begin(), liquids.end());
    int ans0, ans1, tmp, start = 0, end = n-1, sum = 2000000000;

    while (start < end) {
        tmp = liquids[start] + liquids[end];

        if (abs(tmp) < sum) {
            sum = abs(tmp);
            ans0 = liquids[start];
            ans1 = liquids[end];
            if (sum == 0) break;
        }
        if (tmp < 0) start ++;
        else end --;
    }


    cout << ans0 << " " << ans1 << endl;
}