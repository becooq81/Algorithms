while True:
    n = int(input())
    if n == -1:
        break
    
    sum = 0
    ans = f"{n} = 1"
    for i in range(1,n):
        if (n % i == 0):
            sum += i
            if (i != 1):
                ans += " + " + str(i)
    if sum == n:
        print(ans)
    else:
        print(f"{n} is NOT perfect.")