def permutation(ans, idx):
    if idx==len(ans):
        print(ans)
    for i in range(0, 7):
        if visited[i]==True:
            ans[idx] = arr[i]
            permutation(ans, idx+1)
            visited[i] = False

T = int(input())

for tc in range(1, T+1):
    A, B, C, D = map(int, input().split())
    N = (A+B+C+D) + 1
    visited = [False]*7
    

