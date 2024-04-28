#include<cmath>
#include<iostream>
#include<vector>
using namespace std;

int N, answer=2000;
int S[20][20]={};
bool visited[20]={};

void comb(int index, int count) {
    vector<int> start;
    vector<int> link;
    int s = 0, l = 0;
    if (count == N/2) {
        for (int i = 0; i < N; i++) {
            if (visited[i] == true) {
                start.push_back(i);
            }
            else {
                link.push_back(i);
            }
        }
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < N/2; j ++) {
                s += S[start[i]][start[j]];
                l += S[link[i]][link[j]];
            }
        }
        if (abs(s - l) < answer)
            answer = abs(s - l);
        return;
    }
    for (int i = index; i < N; i ++) {
        if (visited[i])
            continue;
        else {
            visited[i] = true;
            comb(i, count+1);
            visited[i] = false;
        }
    }
}


int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> S[i][j];
        }
    }
    comb(0, 0);
    cout << answer << endl;
}

