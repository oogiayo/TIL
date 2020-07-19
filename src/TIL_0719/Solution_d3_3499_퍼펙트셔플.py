T = int(input())

for tc in range(1, T+1):
    N = int(input())
    card_list = input().split()
    if N%2 = 0:
        A_list = card_list[0:N//2]
        B_list = card_list[N//2:N]
    else :
        A_list = card_list[0:N//2+1]
        B_list = card_list[N//2+1:N]

    ans = "#" + str(tc)
    for i in range(0, len(B_list)):
        ans += " " + str(A_list[i])
        ans += " " + str(B_list[i])
    if len(A_list)>len(B_list):
        ans += " " + str(A_list[-1])

    print(ans)