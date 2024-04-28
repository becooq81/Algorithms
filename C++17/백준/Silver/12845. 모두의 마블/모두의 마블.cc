#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
    int n, l;
    vector<int> levels;
    cin >> n;
    for (int i = 0; i < n; i ++) {
        cin >> l;
        levels.push_back(l);
    }

    std::sort(levels.begin(), levels.end(), greater<int>());

    int gold = 0;
    for (int i = 0; i < n-1; i ++) {
        gold += levels[i];
        gold += levels[i+1];
        if (levels[i] > levels[i+1]) {
            levels[i+1] = levels[i];
        }
    }
    cout << gold << endl;
}