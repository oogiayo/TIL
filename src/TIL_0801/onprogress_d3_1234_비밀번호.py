from collections import deque

T = 10
for tc in range(1, T+1):
    N, arr = input().split()
    N = int(N)

    arrList = [[n] for n in arr]
    q = deque()
        
    idx = 0
    while idx < N-1:
        if arr[idx]==arr[idx+1]:
            q.appendleft((idx, idx+1))
            idx += 2
            continue
        else:
            idx += 1
            continue
    
    # cnt = N
    while len(q):
        (x1, x2) = q.popleft()
        arrList[x1][0] = '-'
        arrList[x2][0] = '-'
        # cnt -= 2
        while 0 <= x1:
            if arrList[x1][0]=='-':
                x1 -= 1
            else:
                break
        while x2 <= N-1:
            if arrList[x2][0]=='-':
                x2 += 1
            else:
                break
        next1 = arrList[x1][0]
        next2 = arrList[x2][0]
        
        if next1!='-' and next2!='-' and next1==next2:
            q.appendleft((x1, x2))

    ans = ''
    for num_str in arrList:
        if num_str[0]!='-':
            ans += num_str[0]
    print(f'#{tc} {ans}')
