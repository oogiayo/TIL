T = int(input())

for tc in range(1, T+1):
    S_set = set()
    D_set = set()
    H_set = set()
    C_set = set()
    strs = input()

    cnt = 0
    for i in range(0, len(strs), 3):
        if strs[i]=='S':
            S_set.add(strs[i+1:i+3])
        elif strs[i]=='D':
            D_set.add(strs[i+1:i+3])
        elif strs[i]=='H':
            H_set.add(strs[i+1:i+3])
        elif strs[i]=='C':
            C_set.add(strs[i+1:i+3])
        cnt += 1

    if cnt != len(S_set)+len(D_set)+len(H_set)+len(C_set):
        print(f'#{tc} ERROR')
    else:
        print(f'#{tc} {13-len(S_set)} {13-len(D_set)} {13-len(H_set)} {13-len(C_set)}')