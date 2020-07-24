# T = int(input())

# for tc in range(1, T+1):
#     N = int(input())
#     line_list = []
#     for i in range(0, N):
#         line_list.append(tuple(map(int, input().split())))
#     P = int(input())
#     bus_dict = {}
#     for cj in range(0, P):
#         bus_dict[int(input())] = 0
   
#     for a, b in line_list:
#         for i in range(a, b+1):
#             bus_dict[i] += 1
    
#     ans = ''    
#     for value in bus_dict.values():
#         ans += f'{str(value)} '

#     print(f'#{tc} {ans}')


T = int(input())

for tc in range(1, T+1):
    N = int(input())
    busstop_list = [0]*5001
    for i in range(0, N):
        a, b = map(int, input().split())
        for j in range(a, b+1):
            busstop_list[j] += 1

    ans = ''  
    P = int(input())
    for i in range(1, P+1):
        ans += f'{str(busstop_list[int(input())])} '  

    print(f'#{tc} {ans}')