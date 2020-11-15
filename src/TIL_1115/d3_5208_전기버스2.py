def drive(idx, remain, num):
    global ans
    if num >= ans:
        return
    if idx == N-1:
        if num < ans:
            ans = num
        return

    if remain > 1 or (remain==1 and batteries[idx+1]):
        drive(idx+1, remain-1, num)
    if batteries[idx]:
        drive(idx+1, batteries[idx]-1, num+1)


T = int(input())
for tc in range(1, T+1):
    line = list(map(int, input().split()))
    N = line[0]
    batteries = line[1:] + [1]
    ans = N
    drive(0, batteries[0], 0)
    print(f'#{tc} {ans}')