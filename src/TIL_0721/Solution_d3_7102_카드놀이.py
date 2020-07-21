# Solution_d3_7102_카드놀이

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    
    arrN = list(range(1,N+1))
    arrM = list(range(1,M+1))
    sum_dic = {}
    for n in arrN:
        for m in arrM:
            sum2 = n + m
            if sum2 in sum_dic:
                sum_dic[sum2] += 1
            else:
                sum_dic[sum2] = 1
        
    for key, value in sum_dic.items():
        if value==max(sum_dic.values()):
            print(f'#{tc} {key}')