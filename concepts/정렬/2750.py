# https://www.geeksforgeeks.org/python-program-for-merge-sort/

def merge(arr, l, m, r):
    n1 = m - l + 1
    n2 = r - m

    L = [0] * n1
    R = [0] * n2

    # Copy data to temporary arrays
    for i in range(n1):
        L[i] = arr[l + i]
    
    for j in range(0, n2):
        R[j] = arr[m + 1 + j]
    
    # Merge temporary arrays back into arr
    i = 0       # initial index of first subarray
    j = 0       # initial index of second subarray
    k = l       # initial index of merged subarray

    # Compare first elements of each array and add to the full array whatever is smaller
    while i < n1 and j < n2:
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1
    
    # Copy remaining elements of L[]
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1
    
    # Do the same for R[]
    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1

def mergeSort(arr, l, r):
    if l < r:
        m = l + (r-l)//2

        mergeSort(arr, l, m)
        mergeSort(arr, m + 1, r)
        merge(arr, l, m, r)

n = int(input())
nums = []
for _ in range(n):
    nums.append(int(input()))
mergeSort(nums, 0, n-1)

for num in nums:
    print(num)