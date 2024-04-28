#include <map>
#include <iostream>
#include <iterator>
using namespace std;

int N, M, ans;
string s;


int main() {
    cin >> N;
    cin >> M;
    ans = 0;
    map <string, bool> m;
    for (int i = 0; i < N; i++) {
        cin >> s;
        m[s] = true;
    }
    for (int j = 0; j < M; j ++) {
        cin >> s;
        if (m[s]) ans++;
    }
    cout << ans << '\n';
}

