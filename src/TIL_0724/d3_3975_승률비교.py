T = int(input())

for tc in range(1, T+1):
    A, B, C, D = map(int, input().split())
    # 엘리스 : B전 A승
    # 밥 : D전 C승
    compare = A/B-C/D

    if compare>0:
        ans = 'ALICE'
    elif compare<0:
        ans = 'BOB'
    else:
        ans = 'DRAW'

    print(f'#{tc} {ans}')


# T = int(input())

# for tc in range(1, T+1):
#     A, B, C, D = map(int, input().split())
#     # 엘리스 : B전 A승
#     # 밥 : D전 C승
#     winrate_Alice = A/B
#     winrate_Bob = C/D

#     if winrate_Alice > winrate_Bob:
#         ans = 'ALICE'
#     elif winrate_Alice < winrate_Bob:
#         ans = 'BOB'
#     else:
#         ans = 'DRAW'

#     print(f'#{tc} {ans}')