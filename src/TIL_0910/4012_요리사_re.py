import copy

def Combination(idx, r, ans):
    global N, case
    
    if len(combs) >= case//2 or idx-r > N//2:
        return
    if r==N//2:
        combs.append(ans)
        return

    Combination(idx+1, r, ans)
    Combination(idx+1, r+1, copy.deepcopy(ans) + [idx])


T = int(input())

for tc in range(1, T+1):
    N = int(input())

    synergy = []
    case = 1
    for r in range(0, N):
        if r < N//2:
            case *= (N-r)
        else:
            case //= (N-r)
        synergy.append(list(map(int, input().split())))

    combs = []
    Combination(0, 0, [])

    ansList = []
    for x in range(0, len(combs)):
        
        tot = 0
        arr = [_ for _ in range(0, N)]

        for i in combs[x]:
            arr[i] = None
            for j in combs[x]:
                tot += synergy[i][j]

        for i in arr:
            for j in arr:
                if i!=None and j!=None:        
                    tot -= synergy[i][j]

        ansList.append(abs(tot))

    print(f'#{tc} {min(ansList)}')
