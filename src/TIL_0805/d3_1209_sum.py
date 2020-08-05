T = 10
for tc in range(1, T+1):
    tc = int(input())
    arr = [[] for r in range(0, 100)]
    max_sum = 0
    for r in range(0, 100):
        row = list(map(int, input().split()))
        sum_r = sum(row)
        if sum_r > max_sum:
            max_sum = sum_r
        arr[r] = row

    sum_d1 = 0
    sum_d2 = 0
    for c in range(0, 100):
        sum_c = 0
        for r in range(0, 100):
            sum_c += arr[r][c]
        if sum_c > max_sum:
            max_sum = sum_c
        
        if r==c:
            sum_d1 += arr[r][c]
        if r==99-c:
            sum_d2 += arr[r][c]
    max_sum = max(max_sum, sum_d1, sum_d2)
    print(f'#{tc} {max_sum}')