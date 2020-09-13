T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = []
    for r in range(0, N):
        arr.extend(list(map(int, input().split())))

    print(f'#{tc}')
    for i in range(0, N):
        for j in range(1, N+1):
            print(arr[N*N-N*j+i], end='')
        print(' ', end='')
    
        for j in range(1, N+1):
            print(arr[N*N-j-N*i], end='')
        print(' ', end='')
        
        for j in range(1, N+1):
            print(arr[j*N-1-i], end='')
        print()
 