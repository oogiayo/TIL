N = int(input())

for i in range(0, N):
    cards = [0 for _ in range(0, 5)]
    A = list(map(int, input().split()))[1:]
    B = list(map(int, input().split()))[1:]
    for card in A:
        cards[card] += 1
    for card in B:
        cards[card] -= 1

    ans = ''
    for i in range(4, 0, -1):
        if cards[i] > 0:
            ans = 'A'
            break
        elif cards[i] < 0:
            ans = 'B'
            break
    if not ans:
        ans = 'D'

    print(ans)
