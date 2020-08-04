T = 10

for tc in range(1, T+1):
    N = int(input())
    boxList = list(map(int, input().split()))

    for i in range(0, N):
        boxList.sort()
        boxList[99] -= 1
        boxList[0] += 1
    
    boxList.sort()
    
    print(f'#{tc} {boxList[99]-boxList[0]}')

