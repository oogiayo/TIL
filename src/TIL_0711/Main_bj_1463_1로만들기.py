def dp(x):
    for i in range(2, x+1):
        m[i] = m[i-1]+1
        if i%2 == 0 and m[i] > m[i//2]+1:
            m[i] = m[i//2]+1
        if i%3 == 0 and m[i] > m[i//3]+1:
            m[i] = m[i//3]+1
    print(m[x])

m = [0]*1000001 # memoization
x = int(input())
dp(x)