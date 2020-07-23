T = int(input())

def pdb(n):
    if n < 4:
        if ans_list[n]==0:
            ans_list[n] = 1
        return ans_list[n]
    elif n==4 or n==5:
        if ans_list[n]==0:
            ans_list[n] = 2
        return ans_list[n]        
    else:
        if ans_list[n]==0:
            ans_list[n] = pdb(n-1) + pdb(n-5)
        return ans_list[n]

for tc in range(1, T+1):
    N = int(input())
    ans_list = [0]*(N+1)
    print(f'#{tc} {pdb(N)}')