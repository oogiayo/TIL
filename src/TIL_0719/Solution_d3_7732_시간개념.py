T = int(input())
for tc in range(1, T+1):
    nh, nm, ns = map(int, input().split(':'))
    th, tm, ts = map(int, input().split(':'))

    t_n = nh*60*60 + nm*60 + ns
    t_t = th*60*60 + tm*60 + ts
    if t_t >= t_n:
        time = t_t - t_n
    else:
        time = 24*60*60 + t_t - t_n

    time_list = []
    time_list.append(time//(60*60))
    time %= (60*60)
    time_list.append(time//60)
    time %= 60
    time_list.append(time)

    ans = f'# {tc} '
    for i in range(0, 3):
        if time_list[i]<10:
            ans += f'0{time_list[i]}'
        else:
            ans += str(time_list[i])
        if i<2:
            ans += ':'
            
    print(ans)