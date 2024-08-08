import java.util.*;
import java.io.*;

public class Main {
    private static final String LT = "<", GT = ">", COMMA = ",", WHITESPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        CircularLinkedList ll = new CircularLinkedList();
        for (int i = 1; i <= N; i++) {
            ll.add(new Node(i));
        }

        LinkedList<Integer> ans = new LinkedList<>();
        while (!ll.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                ll.next();
            }
            ans.add(ll.remove());
        }

        sb.append(LT);
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i == ans.size() - 1) {
                sb.append(GT);
                break;
            }
            sb.append(COMMA).append(WHITESPACE);
        }
        System.out.append(sb);
    }

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static class CircularLinkedList {
        Node head;
        Node tail;
        int size;
        Node cursor;

        CircularLinkedList() {
            this.size = 0;
        }

        boolean isEmpty() {
            return this.size == 0;
        }

        void add(Node newNode) {
            if (size == 0) {
                this.head = newNode;
                this.tail = newNode;
                this.cursor = newNode;
                this.head.next = tail;
                this.tail.next = head;
                this.head.prev = tail;
                this.tail.next = head;
            } else if (size == 1) {
                this.head.next = newNode;
                newNode.prev = this.head;
                newNode.next = this.head;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                newNode.next = this.head;
                this.tail = newNode;
            }
            this.size++;
        }

        int next() {
            this.cursor = this.cursor.next;
            return this.cursor.data;
        }

        int remove() {
            if (this.cursor.data == this.head.data) {
                this.head = this.head.next;
                this.head.prev = this.tail;
                this.tail.next = this.head;
            } else if (this.cursor.data == this.tail.data) {
                this.tail = this.tail.prev;
                this.tail.next = this.head;
                this.head.prev = this.tail;
            }

            // System.out.printf("Cursor now: %d\n", this.cursor.data);

            this.cursor.prev.next = this.cursor.next;
            this.cursor.next.prev = this.cursor.prev;
            this.size--;

            int data = this.cursor.data;
            this.cursor = this.cursor.next;
            return data;
        }
    }
}