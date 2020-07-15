from queue import Queue

M, N, H = map(int, input().split())
dr = [-1,1,0,0]
dc = [0,0,-1,1]
dz = [-1,1]

box = [[[0 for z in range(H)] for c in range(M)] for r in range(N)]
q = Queue()
ans = -2
cnt = 0
for z in range(0,H):
    for r in range(0,N):
        l = list(map(int, input().split()))
        for c in range(0,M):
            box[r][c][z] = l[c]
            if l[c]!=0:
                cnt += 1
            if l[c]==1:
                q.put([r, c, z, 0]) # r, c, z, days

if cnt==N*M*H:
    ans=0
else:
    while q.qsize()!=0:
        r, c, z, days = q.get()
        if cnt==N*M*H:
            ans = days+1
            break
        for k in range(0,4):
            nr = r + dr[k]
            nc = c + dc[k]
            if N>nr>=0 and M>nc>=0 and box[nr][nc][z]==0:
                box[nr][nc][z] = 1
                q.put([nr, nc, z, days+1])
                cnt += 1
        for k in range(0,2):
            nz = z + dz[k]
            if N>r>=0 and M>c>=0 and H>nz>=0 and box[r][c][nz]==0:
                box[r][c][nz] = 1
                q.put([r, c, nz, days+1])
                cnt += 1

    if cnt<N*M*H:
        ans = -1

print(ans)
