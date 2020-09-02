T = int(input())
for tc in range(1, T+1):
    cards = input()
    
    draw = set()
    deck = [13]*4

    cnt = 0
    while len(cards)>0 :
        draw.add(cards[0:3])
        cnt += 1
        cards = cards[3:]

    if len(draw)!=cnt:
        print(f'#{tc} ERROR')
    else:
        for card in draw:
            if card[0]=='S':
                deck[0] -= 1
            if card[0]=='D':
                deck[1] -= 1
            if card[0]=='H':
                deck[2] -= 1
            if card[0]=='C':
                deck[3] -= 1          

        print(f'#{tc}', end=' ')
        for ans in deck:
            print(ans, end=' ')
        print()
