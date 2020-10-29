def change(nums, idx):
    global ans
    if idx == N:
        if int(nums) > ans:
            ans = int(nums)
        return

    for i in range(0, len(nums)):
        for j in range(i, len(nums)):
            if i==j:
                continue
            else:
                new_nums = nums[0:i] + nums[j] + nums[i+1:j] + nums[i] + nums[j+1:]
                if not numList[idx+1][new_nums]:
                    numList[idx+1][new_nums] = True
                    change(new_nums, idx+1)


T = int(input())
for tc in range(1, T+1):
    nums, N = map(int, input().split())
    nums = str(nums)
    
    numSetList = [[] for _ in range(0, N)]
    numList = [[False for _ in range(0, 10**(M-1))] for _ in range(0, N+1)]

    ans = 0
    change(nums, 0)
    print(f'#{tc} {ans}')