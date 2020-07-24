T = int(input())

for tc in range(1, T+1):
    word = input()
    N = len(word)

    # 홀수일 경우 한가운데 문자를 제거해준다.(팰린드룸 판단에는 아무 상관없으므로)
    if N%2==1:
        word = word[0:N//2] + word[N//2+1:]
        N -= 1
    
    ans = 'Exist'
    for i in range(0, N//2):
        if word[i:i+1]!=word[N-1-i:N-i]:
            if word[i:i+1]=='?' or word[N-1-i:N-i]=='?':
                continue
            else:
                ans = 'Not exist'
                break

    print(f'#{tc} {ans}')