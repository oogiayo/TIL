T = int(input())

for tc in range(1, T+1):
    N, A, B = map(int, input().split())
    
    # A*|R - C| + B*(N - R*C) 의 가능한 최댓값
    ans_min = A*N + B*N
    RC = N
    while RC>0:
        for R in range(int(N**(1/2)), 0, -1):
            if RC%R==0:
                ans_eq = A*abs(R-RC//R) + B*(N-RC)
                if ans_eq < ans_min:
                    ans_min = ans_eq
                    break
            RC -= 1

    print(f'#{tc} {ans_min}')