def checkBabyjin(cardNumList):
    for i in range(0, 10):
        if cardNumList[i] >= 3:
            return True
        if i < 8 and cardNumList[i] and cardNumList[i+1] and cardNumList[i+2]:
            return True
    return False


T = int(input())
for tc in range(1, T+1):
    cards = list(map(int, input().split()))
    A = [0]*10
    B = [0]*10
    ans = 0
    for i in range(0, 6):
        A[cards[2*i]] += 1
        B[cards[2*i+1]] += 1

        if i >= 2:
            res_A = checkBabyjin(A)
            res_B = checkBabyjin(B)
            
            if res_A:
                ans = 1
                break
            if res_B:
                ans = 2
                break


    print(f'#{tc} {ans}')
    
