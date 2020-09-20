N = int(input())

for i in range(0, N):
    cards = {'4': 0, '3':0, '2':0, '1':0}
    A = input().split()[1:]
    for key in A:
        cards[key] += 1
    B = input().split()[1:]
    
    ans = ''
    for key in B:
        cards[key] -= 1

        if cards['4'] < 0:
            ans = 'B'
            break
        elif cards['4'] == 0:
            if cards['3'] < 0:
                ans = 'B'
                break
            elif cards['3'] == 0:
                if cards['2'] < 0:
                    ans = 'B'
                    break
                elif cards['2'] == 0:
                    if cards['1'] < 0:
                        ans = 'B'
                        break
    
    if not ans:
        for val in cards.values():
            if val > 0:
                ans = 'A'
                break
    
    if not ans:
        ans = 'D'

    print(ans)
