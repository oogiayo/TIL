import sys
sys.stdin = open("input.txt", "r")


def chg(line):
    temp = ''
    for i in line:
        if i.isdigit():
            t = ord(i) - ord('0') 
        else:
            t = ord(i) - ord('A') + 10

        # t = int(i, 16)
        res = ''
        while t > 0:
            res = str(t%2) + res
            t //= 2
        while len(res) < 4:
            res = '0' + res
        temp += res     
    return temp


info = [[[None for _ in range(0, 5)] for _ in range(0, 5)] for _ in range(0, 5)]
info[2][1][1] = 0
info[2][2][1] = 1
info[1][2][2] = 2
info[4][1][1] = 3
info[1][3][2] = 4
info[2][3][1] = 5
info[1][1][4] = 6
info[3][1][2] = 7
info[2][1][3] = 8
info[1][1][2] = 9


T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    codes = ['' for _ in range(0, N)]
    ans = 0

    for r in range(0, N):
        line = input()
        codes[r] = chg(line)

    for r in range(1, N):

        col = len(codes[r])-1
        while col >= 0:
            if codes[r][col]=='1' and codes[r-1][col]=='0':
                code = ''
                for i in range(0, 8):
                    d = 0
                    while codes[r][col]=='1':
                        col -= 1
                        d += 1
                    c = 0
                    while codes[r][col]=='0':
                        col -= 1
                        c += 1
                    b = 0
                    while codes[r][col]=='1':
                        col -= 1
                        b += 1
                    
                    depth = min(b, c, d)
                    b //= depth
                    c //= depth
                    d //= depth

                    if info[b][c][d] != None:
                        code = str(info[b][c][d]) + code        
                    
                    col -= (7 - b - c - d)*depth
                    
                score = 0
                sumCode = 0
                for j in range(0, 8):
                    sumCode += int(code[j])
                    if j%2:
                        score += int(code[j])
                    else:
                        score += int(code[j])*3

                if score%10==0:
                    ans += sumCode
                
                continue

            else:
                col -= 1
            
    print(f'#{tc} {ans}')