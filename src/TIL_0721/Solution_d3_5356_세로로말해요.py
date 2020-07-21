# Solution_d3_5356_세로로말해요

T = int(input())
for tc in range(1, T+1):
    max_len = 0
    str_list = [[]]*5
    for i in range(0, 5):
        str_list[i] = input()
        if len(str_list[i]) > max_len:
            max_len = len(str_list[i])
    
    ans = ''
    cnt = 0
    while True:
        if cnt == max_len:
            break
        for i in range(0, 5):
            check = 0
            if str_list[i]=='':
                continue
            else:
                ans += str_list[i][cnt:cnt+1]
                str_list[i]==str_list[i][cnt+1:-1]
        cnt += 1
        
    print(f'#{tc} {ans}')