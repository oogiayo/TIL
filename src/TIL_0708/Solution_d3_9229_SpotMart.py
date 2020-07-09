TC = int(input())
for tc in range(1, TC+1):
    input_1 = input().split(" ")
    N = int(input_1[0])
    M = int(input_1[1])

    snack = []
    input_2 = input().split(" ")
    for i in range(0, N):
        a = int(input_2[i])
        snack.append(a)

    max = 0
    for i in range(0, N):
        for j in range(i+1, N):
            tot = snack[i] + snack[j]
            if(max<=tot<=M):
                max = tot
    if(max==0):
        max = -1

    print("#"+str(tc), max)
