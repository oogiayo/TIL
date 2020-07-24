T = int(input())

for tc in range(1, T+1):
    A, B = map(int, input().split())
    mult = A//B
    print(f'#{tc} {mult**2}')