import copy

def Combination(idx, r, ans):
    global N

    if r==N//2:
        combs.append(ans)
        return
    if idx==N:
        return

    Combination(idx+1, r, copy.deepcopy(ans))
    ans.append(idx)
    Combination(idx+1, r+1, copy.deepcopy(ans))


T = int(input())

for tc in range(1, T+1):
    N = int(input())

    arr = [i for i in range(0, N)]
    synergy = []
    for r in range(0, N):
        synergy.append(list(map(int, input().split())))

    combs = []
    Combination(0, 0, [])

    ansList = []
    for x in range(0, len(combs)//2):
        
        tot = 0
        for i in combs[x]:
            for j in combs[x]:
                tot += synergy[i][j]

        for i in combs[-1 -x]:
            for j in combs[-1 -x]:
                tot -= synergy[i][j]

        ansList.append(abs(tot))

    print(f'#{tc} {min(ansList)}')
