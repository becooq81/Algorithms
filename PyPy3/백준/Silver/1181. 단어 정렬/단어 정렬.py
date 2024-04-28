import sys

def merge(arr, l, m, r):
    n1 = m - l + 1
    n2 = r - m

    L = [0] * n1
    R = [0] * n2

    for i in range(n1):
        L[i] = arr[l+i]
    for j in range(n2):
        R[j] = arr[m + 1 + j]
    
    i = 0
    j = 0
    k = l

    while i < n1 and j < n2:
        if len(L[i]) < len(R[j]):
            arr[k] = L[i]
            i += 1
        elif len(L[i]) > len(R[j]):
            arr[k] = R[j]
            j += 1
        else:
            length = min(len(L[i]), len(R[j]))
            for idx in range(length):
                if L[i][idx] < R[j][idx]:
                    arr[k] = L[i]
                    i += 1
                    break
                elif L[i][idx] > R[j][idx]:
                    arr[k] = R[j]
                    j += 1
                    break
                
        k += 1
    
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1
    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1
    

def mergeSort(arr, l, r):
    if l < r:
        m = l + (r-l)//2
        mergeSort(arr, l, m)
        mergeSort(arr, m +1, r)
        merge(arr, l, m, r)

n = int(sys.stdin.readline())
words = []
for _ in range(n):
    word = input()
    if word not in words:
        words.append(word)

mergeSort(words, 0, len(words)-1)
for word in words:
    print(word)