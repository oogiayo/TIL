T = int(input())

isPrime = [1]*(10**6+1)
isPrime[1] = 0
for i in range(2, 10**6+1):
    if isPrime[i]==1:
        i_mult = i + i
        while i_mult<=10**6:
            isPrime[i_mult] = 0
            i_mult += i

for tc in range(1, T+1):
    D, A, B = map(int, input().split())

    tot = 0
    for num in range(A, B+1):
        if isPrime[num]==1 and str(D) in str(num):
            tot += 1

    print(f'#{tc} {tot}')



# T = int(input())

# for tc in range(1, T+1):
#     D, A, B = map(int, input().split())

#     tot = 0
#     isPrime = [1]*(B+1)
#     # isPrime[1] = 0
#     for i in range(2, B+1):
#         if isPrime[i]==1: # isPrime[i]==1:
#             # visited[i] = 1
#             if A<=i and '3' in str(i):
#                 tot += 1

#             i_mult = i + i
#             while i_mult<=B:
#                 isPrime[i_mult] = 0
#                 # isPrime[i_mult] = 0
#                 i_mult += i


#     print(f'#{tc} {tot}')