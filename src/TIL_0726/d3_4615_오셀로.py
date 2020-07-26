# 상하좌우, 대각선12
dr = [-1,1,0,0, -1,-1,1,1]
dc = [0,0,-1,1, -1,1,-1,1]

T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())
    board = [[0 for c in range(0, N)] for r in range(0, N)]
    # 백돌 = 2
    board[N//2-1][N//2-1] = 2
    board[N//2][N//2] = 2
    # 흑돌 = 1
    board[N//2-1][N//2] = 1
    board[N//2][N//2-1] = 1

    for i in range(0, M):
        c, r, player = map(int, input().split())
        r0 = r-1
        c0 = c-1        
        board[r0][c0] = player

        for k in range(0, 8):
            nr = r0 + dr[k]
            nc = c0 + dc[k]
            # 상대편 돌이 탐색될 경우
            if 0<=nr<N and 0<=nc<N and player==2 and board[nr][nc]==1:
                eat = 0
                while True:
                    if 0<=nr<N and 0<=nc<N and board[nr][nc]==1:
                        nr += dr[k]
                        nc += dc[k]
                        continue
                    # 자기편 돌로 감싸진 것을 확인한 순간
                    elif 0<=nr<N and 0<=nc<N and board[nr][nc]==2:
                        eat += 1
                        break
                    else:
                        break

                while eat:
                    nr -= dr[k]
                    nc -= dc[k]
                    # 자기편 돌로 바꾼다(상대 돌을 먹는다).
                    if 0<=nr<N and 0<=nc<N and board[nr][nc]==1:
                        board[nr][nc] = 2
                        continue
                    else:
                        break

            if 0<=nr<N and 0<=nc<N and player==1 and board[nr][nc]==2:
                eat = 0
                while True:
                    if 0<=nr<N and 0<=nc<N and board[nr][nc]==2:
                        nr += dr[k]
                        nc += dc[k]
                        continue
                    # 자기편 돌로 감싸진 것을 확인한 순간
                    elif 0<=nr<N and 0<=nc<N and board[nr][nc]==1:
                        eat += 1
                        break
                    else:
                        break

                while eat:
                    nr -= dr[k]
                    nc -= dc[k]
                    # 자기편 돌로 바꾼다(상대 돌을 먹는다).
                    if 0<=nr<N and 0<=nc<N and board[nr][nc]==2:
                        board[nr][nc] = 1
                        continue
                    else:
                        break

    # 게임이 끝나고 바둑알을 센다
    white = 0
    black = 0
    for r in range(0, N):
        for c in range(0, N):
            if board[r][c]==2:
                white += 1
            elif board[r][c]==1:
                black += 1

    print(f'#{tc} {black} {white}')