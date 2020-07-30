from collections import deque

T = 10
for tc in range(1, T+1):
    N_codes = int(input())
    codes = list(map(int, input().split()))
    N_cmds = int(input())
    cmds = deque(input().split())

    start = N_codes
    while len(cmds):
        cmd = cmds.popleft()
        if cmd=='I':
            x = int(cmds.popleft())
            y = int(cmds.popleft())
            l_codes = codes[0:x+1]
            r_codes = codes[x+1:]
            for i in range(1, y+1):
                l_codes.append(int(cmds.popleft())) 
            codes = l_codes + r_codes
        elif cmd=='D':
            x = int(cmds.popleft())
            y = int(cmds.popleft())
            for i in range(1, y+1):
                del codes[x+1]
        elif cmd=='A':
            y = int(cmds.popleft())
            for i in range(1, y+1):
                s = int(cmds.popleft())
                codes.append(s)
    
    ans = ''
    for i in range(1, 11):
        ans += str(codes[i]) + ' '

    print(f'#{tc} {ans}')

