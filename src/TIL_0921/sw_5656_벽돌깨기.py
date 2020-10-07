from copy import deepcopy
from collections import deque

T = int(input())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def shot(mapp, cnt, remain):
    global ans

    # 주어진 횟수를 모두 사용할 경우 해당 시점에서의 남은 블럭 개수 파악
    if cnt==N:
        if remain < ans:
            ans = remain    
        return

    # x좌표 별로 모든 경우 체크
    for c in range(0, W):

        for r in range(0, H):
            if mapp[r][c]!=0:
                # 해당 블럭에서부터 연쇄폭발 시작
                mapp_after_shot, remain_after_shot = bomb(r, c, deepcopy(mapp), remain)

                # 남은 블럭이 0개일 경우 바로 답으로 체크
                if remain_after_shot == 0:
                    ans = 0
                    return

                # 공중에 있는 블럭을 아래로 떨어뜨림
                drop(mapp_after_shot)

                # 해당 상태에서 다시 x좌표별로 벽돌깨기 시작
                shot(mapp_after_shot, cnt+1, remain_after_shot)

                # 최상단 블럭을 부순 후에는 아래로 탐색하지 않음
                break


def bomb(r0, c0, mapp, remain):
    power = mapp[r0][c0]

    q = deque()
    q.append((r0, c0, power-1))
    while q:
        pr, pc, bonus = q.popleft()
        if mapp[pr][pc]!=0:
            remain -= 1
        mapp[pr][pc] = 0
        for k in range(0, 4):
            nr = pr + dr[k]
            nc = pc + dc[k]
            for i in range(0, bonus):
                if 0<=nr<H and 0<=nc<W:
                    q.append((nr, nc, mapp[nr][nc]-1))
                    nr += dr[k]
                    nc += dc[k]
                else:
                    break
    return mapp, remain


def drop(mapp):
    for c in range(0, W):
        q = deque()
        findSpace = False
        for r in range(H-1, -1, -1):
            if mapp[r][c]==0:
                findSpace = True
                continue
            if findSpace and mapp[r][c]!=0:
                q.append((r, c, mapp[r][c]))

        while q:
            pr, pc, num = q.popleft()
            nr = pr + 1
            nc = pc
            if 0<=nr<H and mapp[nr][nc]==0:
                mapp[nr][nc] = mapp[pr][pc]
                mapp[pr][pc] = 0
                q.append((nr, nc, mapp[nr][nc]))


for tc in range(1, T+1):
    N, W, H = map(int, input().split())
    # N 깨는 횟수 W 가로 H 높이
    
    blocks = 0

    mapp = [[0]*W for _ in range(0, H)]
    for r in range(0, H):
        line = list(map(int, input().split()))
        for c in range(0, W):
            mapp[r][c] = line[c]
            if mapp[r][c] != 0:
                blocks += 1

    ans = H*W
    shot(mapp, 0, blocks)

    print(f'#{tc} {ans}')
