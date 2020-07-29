# 1~N
# 1 3 5 ... 2N-1
# 2 4 6 8 ...  2N

T = int(input())

for tc in range(1, T+1):
    N = int(input())

    S1 = round((1+N)*N/2)
    S2 = round((1+(2*N-1))*N/2)
    S3 = round((2+(2*N))*N/2)
    
    print(f'#{tc} {S1} {S2} {S3}')