def permutation(ans, idx):
    if len(ansList)==1:
            return
    if idx==len(ans):
        word = ''
        for i in range(0, N-2):
            if ans[i][1]==ans[i+1][0]:
                word += ans[i][0]
            else:
                return
        word += ans[N-2]
        ansList.append(word)
        return
    for i in range(0, N-1):
        if visited[i]==False:
            visited[i]=True
            ans[idx] = binary[i]
            permutation(ans, idx+1)
            visited[i] = False

T = int(input())
for tc in range(1, T+1):
    A, B, C, D = map(int, input().split())
    N = (A+B+C+D) + 1
    visited = [False]*(N-1)
    binary = ['00']*A + ['01']*B + ['10']*C + ['11']*D
    ansList = []
    permutation(['']*(N-1), 0)
    if len(ansList)==0:
        print(f'#{tc} impossible')
    else:
        print(f'#{tc} {ansList[0]}')