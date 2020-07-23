T = int(input())

def Subset(idx, ans):
    if idx==N:
        sum_i = 0
        for i in range(0, idx):
            if ans[i]==False:
                sum_i += A_list[i]
        global cnt
        if sum_i == K:
            cnt += 1
        return
    ans[idx] = True
    Subset(idx+1, ans)
    ans[idx] = False
    Subset(idx+1, ans)

for tc in range(1, T+1):
    N, K = map(int, input().split())
    A_list = list(map(int, input().split()))    # N
    cnt = 0
    Subset(0, [False for i in range(0, N)])
    print(f'#{tc} {cnt}')