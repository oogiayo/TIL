T = int(input())

for tc in range(1, T+1):
    N, M, K = map(int, input().split())

    time_list = list(map(int, input().split()))
    time_list.sort()

    start_list = [0]*time_list[-1]

    ans = 'Possible'
    made = 0
    saled = 0
    for sec in time_list:
        made = sec//M*K
        made -= saled
        if made==0:
            ans = 'Impossible'
            break
        else:
            saled += 1

    print(f'#{tc} {ans}')