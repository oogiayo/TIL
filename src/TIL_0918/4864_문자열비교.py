T = int(input())
for tc in range(1, T+1):
    str1 = input()
    str2 = input()
    ans = 0
    if str1 in str2:
        ans = 1
    print(f'#{tc} {ans}')
