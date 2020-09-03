T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())

    nums = list(map(int, input().split()))
    
    for i in range(0, M):
        nums.append(nums.pop(0))
    
    first = nums.pop(0)

    print(f'#{tc} {first}')
