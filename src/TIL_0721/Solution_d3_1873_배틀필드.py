# Solution_d3_1873_배틀필드
from collections import deque
global fld, q

tank = ['<', '>', '^', 'v']
movement = ['L', 'R', 'U', 'D']
dr = [0,0,-1,1]
dc = [-1,1,0,0]
T = int(input())
q = deque()  # (r, c, direc)

def attack(r, c, direc):
    q.appendleft([r, c, direc])
    k = tank.index(direc)
    while len(q)!=0:
        p_r, p_c, p_direc = q.popleft()
        nr = p_r + dr[k]
        nc = p_c + dc[k]
        if(0<=nr<H and 0<=nc<W):
            if(fld[nr][nc]=='.' or fld[nr][nc]=='-'):
                q.appendleft([nr, nc, p_direc])
            if(fld[nr][nc]=='#'):
                break
            if(fld[nr][nc]=='*'):
                fld[nr][nc]='.'


def go(r, c, direc, key_go):
    direc_int = movement.index(key_go)
    direc_turn = tank[direc_int]  
    k = tank.index(direc_turn)
    nr = r + dr[k]
    nc = c + dc[k]
    if(0<=nr<H and 0<=nc<W):
        if(fld[nr][nc]=='.'):
            fld[nr][nc] = direc_turn
            fld[r][c] = '.'
            return [nr, nc, direc_turn]
        else:
            fld[r][c] = direc_turn
            return [r, c, direc_turn]


for tc in range(1, T+1):
    H, W = map(int, input().split())
    fld = [['' for c in range(W)] for r in range(H)]
    for r in range(0, H):
        str_r = input()
        for c in range(0, W):
            fld[r][c] = str_r[c:c+1]

            if fld[r][c] in tank:
                play_cond = [r, c, fld[r][c]]

    N_command = int(input())
    commands = input()

    for play in commands:
        if play=='S':
            attack(play_cond[0], play_cond[1], play_cond[2])
        else:
            play_cond = go(play_cond[0], play_cond[1], play_cond[2], play)

    print(f'#{tc} ', end='')
    for r in range(0, H):
        for c in range(0, W):
            print(fld[r][c], end='')
        print()

