T = int(input())
for tc in range(1, T+1):
    arr = [[] for r in range(0, 9)]
    ans = 1
    
    for r in range(0, 9):
        arr[r] = list(map(int, input().split()))
        if sum(arr[r])!=45:
            ans = 0

    if ans==1:
        for c in range(0, 9):
            sum_c = 0
            for r in range(0, 9):
                sum_c += arr[r][c]

                sum_square = 0
                if r%3==0 and c%3==0:
                    for x in range(0, 3):
                        for y in range(0, 3):
                            sum_square += arr[r+x][c+y]
                    if sum_square!=45:
                        ans = 0
                        break
            
            if sum_c!=45:
                ans = 0
                break

    print(f'#{tc} {ans}')