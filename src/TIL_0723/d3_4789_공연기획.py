T = int(input())

for tc in range(1, T+1):
    str_input = input()
    now = 0
    cnt = 0
    for i in range(0, len(str_input)):
        if i==0:
            now += int(str_input[i])
        if i>=now:
            now += int(str_input[i])
        else:
            cnt += (i-now)
            now += cnt + int(str_input[i])

    print(f'#{tc} {cnt}')