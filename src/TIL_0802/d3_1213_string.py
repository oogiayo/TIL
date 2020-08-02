T = 10
for tc in range(1, T+1):
    tc = int(input())
    word = input()
    sentence = input()
    cnt = 0
    while True:
        idx = sentence.find(word)
        if idx == -1:
            break
        cnt += 1
        sentence = sentence[idx+len(word):]

    print(f'#{tc} {cnt}')    
        