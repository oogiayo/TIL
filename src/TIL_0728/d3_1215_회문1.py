dr = [1,0]
dc = [0,1]

T = 10
for tc in range(1, T+1):
    N = int(input())
    
    puzzle = [['' for c in range(8)] for r in range(8)]
    for r in range(0, 8):
        line = input()
        for c in range(0, 8):
            puzzle[r][c] = line[c]

    tot = 0
    for r0 in range(0, 8):
        for c0 in range(0, 8):
            # 우방향, 하방향 탐색
            for k in range(0, 2):
                word = puzzle[r0][c0]
                # N칸 탐색
                while len(word)<N:
                    nr = r0 + dr[k]*len(word)
                    nc = c0 + dc[k]*len(word)
                    if 0<=nr<8 and 0<=nc<8:
                        word += puzzle[nr][nc]
                    else:
                        break
                if len(word)==N:
                    # 팰린드롬 판별
                    while True:
                        if len(word)<2:
                            tot += 1
                            break
                        if word[0]==word[-1]:
                            word = word[1:-1]
                        else:
                            break

    print(f'#{tc} {tot}')                    
                    


