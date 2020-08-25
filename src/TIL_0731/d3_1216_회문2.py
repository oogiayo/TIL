def palVer(r0, c0, length):
    idx = 0
    while idx < length//2:
        if puzzle[r0+idx][c0]!=puzzle[length-1+r0-idx][c0]:
            return False
        idx += 1
    return True

def palHor(r0, c0, length):
    idx = 0
    while idx < length//2:
        if puzzle[r0][c0+idx]!=puzzle[r0][length-1+c0-idx]:
            return False
        idx += 1
    return True

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
                    if palVer(r0, c0, length)==True:
                        ans = length
                        breaker = True
                        break
                if (length-1+c0)<100:
                    if palHor(r0, c0, length)==True:
                        ans = length
                        breaker = True
                        break

            if breaker:
                break

        if breaker:
            break
        length -= 1
    
    print(f'#{tc} {ans}')
    

