T = 10
for tc in range(1, T+1):
    N, pw_s = input().split()
    N = int(N)
    
    while True:
        keepGoing = 0
        idx = 0
        while idx < len(pw_s)-1:
            if pw_s[idx]==pw_s[idx+1]:
                pw_s = pw_s[0:idx] + pw_s[idx+2:]
                keepGoing += 1
            idx += 1
        if keepGoing == 0:
            break

    print(f'#{tc} {pw_s}')