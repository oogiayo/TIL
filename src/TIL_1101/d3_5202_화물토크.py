def go(endTime, cnt):
    global ans
    isLast = True
    for nextStart in range(endTime, 24):
        for endTime in endTimes[nextStart]:
            go(endTime, cnt+1)
            isLast = False
    if isLast:
        if cnt > ans:
            ans = cnt


T = int(input())

for tc in range(1, T+1):
    N = int(input())
    endTimes = [[] for _ in range(0, 24)]
    isUsed = [False for _ in range(0, 24)]
    for i in range(0, N):
        startTime, endTime = map(int, input().split())
        endTimes[startTime] += [endTime]

    ans = 0
    for startTime in range(0, 24):
        if endTimes[startTime]:
            for startTime in endTimes[startTime]:
                go(startTime, 1)

    print(f'#{tc} {ans}')