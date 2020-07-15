T = int(input())
for t in range(1, T+1):
    N = int(input())
    list = input().split()
    len = [0]*N
    for i in range(0, N):
        len[i] = 1
        for j in range(0, i):
            if list[j] < list[i] and len[i] < len[j]+1:
                len[i] = len[j]+1
    len.sort()
    print("#" + str(t), len[N-1])