N, M = map(int, input().split())

ldb = []
ans = []
cnt = 0
for i in range(0, N+M):
    ldb.append(input())
ldb.sort()

for i in range(0, N+M-1):
    if ldb[i]==ldb[i+1]:
        cnt += 1
        ans.append(ldb[i])

print(cnt)
for i in ans:
    print(i)