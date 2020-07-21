T = int(input())

for tc in range(1, T+1):
    score_list = input().split()
    tot = 0
    for i in score_list:
        if int(i)<40:
            i = 40
        tot += int(i)
    print(f'#{tc} {tot//len(score_list)}')    