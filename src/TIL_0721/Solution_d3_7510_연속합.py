T = int(input())

for tc in range(1, T+1):
    N = int(input())
    cnt = 1
    for i in range(1, N//2+1):
        next = i
        n = N-i
        while n>0:
            next += 1
            n -= next
        if n==0:
            cnt += 1        
    print(f'#{tc} {cnt}') 