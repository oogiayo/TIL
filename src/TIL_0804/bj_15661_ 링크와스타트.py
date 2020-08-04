def subSet(ans, idx):
    if idx==len(ans):
        SL = []
        SS = []
        for i in range(0, idx):
            if ans[i]=='L':
                SL.append(i)
            else:
                SS.append(i)
        sum_L = 0
        for i in SL:
            for j in SL:
                sum_L += arr[i][j]
        sum_S = 0
        for i in SS:
            for j in SS:
                sum_S += arr[i][j]
        dif.append(abs(sum_L-sum_S))
        return
    ans[idx] = 'S'
    subSet(ans, idx+1)
    ans[idx] = 'L'
    subSet(ans, idx+1)

N = int(input())

arr = [[] for r in range(0, N)]
for r in range(0, N):
    arr[r] = list(map(int, input().split()))

dif = []
subSet(['L' for i in range(0, N)], 0)
print(min(dif))