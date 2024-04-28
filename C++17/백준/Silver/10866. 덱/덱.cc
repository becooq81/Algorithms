#include<deque>
#include<iostream>
using namespace std;
int main(){
        deque<int> storage;
        int N;
        string command;
        int val;
        string temp;
        cin>>N;

        for (int i = 0; i < N; i++) {
            int a; cin>>command;
            if (command=="push_front") {
                cin>>a;
                storage.push_front(a);
            }
            else if (command=="push_back") {
                cin>>a;
                storage.push_back(a);
            }
            else if (command=="pop_front") {
                if (storage.empty()){
                    cout<<-1<<"\n";
                }
                else {
                    cout<<storage.front()<<"\n";
                    storage.pop_front();
                }
            }
            else if (command=="pop_back") {
                if (storage.empty()){
                    cout<<-1<<"\n";
                }
                else {
                    cout<<storage.back()<<"\n";
                    storage.pop_back();
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


