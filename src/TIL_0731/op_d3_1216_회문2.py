def palVer(r1, r2, c):
    if r2==r1+1 or r2==r1:
        return True
    else:
        if puzzle[r1][c] == puzzle[r2][c]:
            return palVer(r1+1, r2-1, c)
        else:
            return False

def palHor(r, c1, c2):
    if c2==c1+1 or c2==c1:
        return True
    else:
        if puzzle[r][c1] == puzzle[r][c2]:
            return palHor(r, c1+1, c2-1)
        else:
            return False

T = 10

for tc in range(1, T+1):
    tc = int(input())

    puzzle = [[] for r in range(0, 100)]
    for r in range(0, 100):
        row = input()
        for c in range(0, 100):
            puzzle[r].append(row[c])

    ans = 0
    length = 100
    breaker = False
    while True:
        for r0 in range(0, 100):
            for c0 in range(0, 100):
                if (length-1+r0)<100:
                    if palVer(r0, length-1+r0, c0)==True:
                        ans = length
                        breaker = True
                        break
                if (length-1+c0)<100:
                    if palHor(r, c0, length-1+c0)==True:
                        ans = length
                        breaker = True
                        break

            if breaker:
                break

        if breaker:
            break
        length -= 1
    
    print(f'#{tc} {ans}')
    

