
# for i in range(0, len(A)):
#     for k in range(0, len(B)):
#         if A[i:i+1]==B[k:k+1]:
#             x = A[i:i+1]
#             common_str += x
            
#             for j in range(i+1, len(A)):
#                 for l in range(k+1, len(B)):
#                     if A[j:j+1]==B[l:l+1]:
#                         x = A[j:j+1]
#                         common_str += x

def common_sq(A, B, i, j, ans):
    if i==len(A) and j==len(B):
        print(ans)
        return
    if A[i]==B[j]:
        ans += B[j]
        i += 1
        j += 1
    else:
        common_sq(A, B, i+1, j, ans)
        common_sq(A, B, i, j+1, ans)

A, B = map(str, input().split())

for n in range(0,100):
    common_sq(A, B, 0, 0, '')
