T = int(input())

prime_list = []
for num in range(2, 1000):
    check_num = True    # initial value
    for i in range(2, int(num**2/2)):
        if num%i==0 and num!=i:
            check_num = False   # is not prime number
            break
    if check_num:
        prime_list.append(num)
        
for tc in range(1, T+1):
    N = int(input())
    tot = 0
    for i in range(0, len(prime_list)):
        for j in range(i, len(prime_list)):
            for k in range(j, len(prime_list)):
                if prime_list[i]+prime_list[j]+prime_list[k]==N:
                    tot += 1

    print(f'#{tc} {tot}')



# T = int(input())

# def Recombination(ans, idx, r):
#     if r==3:
#         sum_of_3 = sum(ans)
#         if sum_of_3==N:
#             tot_list[0] += 1
#         return
#     if idx==len(prime_list):
#         return
#     if ans[0] > N/3:
#         return
#     ans[r] = prime_list[idx]
#     Recombination(ans, idx, r+1)
#     Recombination(ans, idx+1, r)

# prime_list = [2]

# for tc in range(1, T+1):
#     N = int(input())
#     for num in range(prime_list[-1]+1, N):
#         check_num = True    # initial value
#         for i in range(2, int(num**2/2)):
#             if num%i==0 and num!=i:
#                 check_num = False   # is not prime number
#                 break
#         if check_num:
#             prime_list.append(num)
    
#     tot_list = [0]
#     Recombination([0]*3, 0, 0)
#     print(f'#{tc} {tot_list[0]}')



# T = int(input())

# def Recombination(ans, idx, r):
#     if r==3:
#         sum_of_3 = sum(ans)
#         if sum_of_3==N:
#             tot_list[0] += 1
#         return
#     if idx==len(prime_list):
#         return
#     ans[r] = prime_list[idx]
#     Recombination(ans, idx, r+1)
#     Recombination(ans, idx+1, r)

# check_list = [False for p in range(0, N-3)]
# prime_list = [2]

# for tc in range(1, T+1):
#     N = int(input()

#     for num in range(prime_list[-1], N-3):
#         if check_list[num]==False:
#             prime_list.append(num)
#             n_next = num + num
#             while n_next <= N-4:
#                 check_list[n_next] = True
#                 n_next += num

#     tot_list = [0]
#     Recombination([0]*3, 0, 0)
#     print(f'#{tc} {tot_list[0]}')