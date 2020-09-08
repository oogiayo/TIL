def findMin(idx, tot):
    global B, min_h
    if tot >= B:
        if(tot-B < min_h):
            min_h = tot-B
        return
    if idx==N:
        return
    
    findMin(idx+1, tot+height[idx])
    findMin(idx+1, tot)


T = int(input())

for tc in range(1, T+1):
    N, B = map(int, input().split())
    height =  list(map(int, input().split()))
    
    min_h = sum(height)
    findMin(0, 0)
    print(f'#{tc} {min_h}')
