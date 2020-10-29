def change(nums, idx):
    global ans
    if idx == N:
        if nums > ans:
            ans = nums
        return

    for i in range(0, M):
        for j in range(i, M):
            if i==j:
                continue
            else:
                num_i = nums%(10**(i+1))//(10**i)
                num_j = nums%(10**(j+1))//(10**j)
                new_nums = nums - num_i*(10**i) - num_j*(10**j) + num_i*(10**j) + num_j*(10**i)
                if not numList[idx+1][new_nums//10]:
                    numList[idx+1][new_nums//10] = True
                    change(new_nums, idx+1)


T = int(input())
for tc in range(1, T+1):
    nums, N = map(int, input().split())
    M = len(str(nums))
    numList = [[False for _ in range(0, 10**(M-1))] for _ in range(0, N+1)]
    numList[0][nums//10] = True

    ans = 0
    change(nums, 0)
    print(f'#{tc} {ans}')