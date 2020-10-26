info = {'0001101': 0, '0011001': 1, '0010011': 2, '0111101': 3, '0100011': 4, '0110001': 5, '0101111': 6, '0111011': 7, '0110111': 8, '0001011': 9}

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    ans = -1
    for r in range(0, N):
        line = input()
        if ans!=-1:
            continue
        if int(line)==0:
            continue

        # start
        idx = M-1
        while True:
            if line[idx]=='0':
                idx -= 1
                continue
            else:
                line = line[:idx+1]
                break

        code = [0]*8
        isFail = False
        for i in range(0, 56, 7):
            code[-1-i//7] = info.get(line[len(line)-i-7:len(line)-i])
            if code[-1-i//7]==None:
                isFail = True
        if isFail:
            print(code)
            ans = 0
            continue

        verification = (code[0]+code[2]+code[4]+code[6])*3 + code[1]+code[3]+code[5]+code[7]
        if verification%10==0:
            ans = sum(code)
        else:
            ans = 0

    print(f'#{tc} {ans}')

