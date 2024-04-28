#include<iostream>
#include<map>
#include<numeric>
#include<algorithm>
#define FASTIO cin.tie(0); ios::sync_with_stdio(false);

using namespace std;
using ll = long long int;

map<ll, int> mp;

int main(){
    FASTIO;

    int n ; cin >> n;
    for(int i = 0; i < n; i++) {
        ll a; cin >> a;
        mp[a]++;
    }


    ll mx = -1;
    ll ans = -1;

    for(auto e: mp) {
        if(mx < e.second) {
            mx = e.second;
            ans = e.first;
        }
    }

    cout << ans << endl;
}


