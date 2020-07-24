T = int(input())

for tc in range(1, T+1):
    str_input = input()
    now = 0
    tot = 0
    for i in range(0, len(str_input)):
        if i==0:
            now += int(str_input[i])
        elif now>=i or str_input[i]==0:
            now += int(str_input[i])
        else:
            added = i-now
            now += added + int(str_input[i])
            tot += added
    print(f'#{tc} {tot}')