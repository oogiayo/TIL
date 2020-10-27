from copy import deepcopy


def chg(num, N):
    x = 0
    t = 1
    for i in range(len(num)-1, -1, -1):
        x += t * int(num[i])
        t *= N
    return x


T = int(input())
for tc in range(1, T+1):
    binaryNum = list(input())
    ternaryNum = list(input())
    
    ans = 0
    idx = -1
    
    for i in range(0, len(binaryNum)):
        for j in range(0, len(ternaryNum)):
            
            for k in range(0, 2):
                if binaryNum[i]==str(k):
                    continue
                n2 = deepcopy(binaryNum)
                n2[i] = str(k)

                for l in range(0, 3):
                    if ternaryNum[j]==str(l):
                        continue
                    n3 = deepcopy(ternaryNum)
                    n3[j] = str(l)

                    a = chg(n2, 2)
                    b = chg(n3, 3)
                    if a==b:
                        ans = a
                        break
                
    print(f'#{tc} {ans}')

    
