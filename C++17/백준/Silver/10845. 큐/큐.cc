#include<queue>
#include<iostream>
using namespace std;
int main(){
    queue<int> storage;
    int N;
    string command;
    int val;
    string temp;
    cin>>N;

    for (int i = 0; i < N; i++) {
        int a; cin>>command;
        if (command=="push") {
            cin>>a;
            storage.push(a);
        }
        else if (command=="pop") {
            if (storage.empty()){
                cout<<-1<<"\n";
            }
            else {
                cout<<storage.front()<<"\n";
                storage.pop();
            }
        }
        else if (command=="size") {
            cout<<storage.size()<<"\n";
        }
        else if (command=="empty") {
            if (storage.empty()) {
                cout<<1<<"\n";
            }
            else {
                cout<<0<<"\n";
            }
        }
        else if (command=="front") {
            if (storage.empty()) {
                cout<<-1<<"\n";
            }
            else {
                cout<<storage.front()<<"\n";
            }
        }
        else if (command=="back") {
            if (storage.empty()) {
                cout<<-1<<"\n";
            }
            else {
                cout<<storage.back()<<"\n";
            }
        }

    }



}

