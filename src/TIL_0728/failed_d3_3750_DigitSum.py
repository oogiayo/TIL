# def digitSum(n):
#     if n<10:
#         return n
#     else:
#         next = 0
#         while n>0:
#             next += n%10
#             n //= 10
#         return digitSum(next)

# T = int(input())

# for tc in range(1, T+1):
#     N = int(input())

#     print(f'#{tc} {digitSum(N)}')



# m = [0]*(10^18+1)

# T = int(input())
# for tc in range(1, T+1):
#     N0 = int(input())
#     N = N0
#     while N>=10:
#         if m[N]!=0:
#             N = m[N]
#             break

#         next = 0
#         while N>0:
#             next += N%10
#             N //= 10
#         N = next
        
#     print(f'#{tc} {N}')