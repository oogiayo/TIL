def heappush(value):
    global heapcount

    heapcount += 1
    heap[heapcount] = value
    cur = heapcount
    parent = cur//2
    
    while parent and heap[parent] >= heap[cur]:
        heap[parent], heap[cur] = heap[cur], heap[parent]
        cur = parent
        parent //= 2

def postOrder(ans):
    global heapcount
    
    cur = heapcount
    parent = cur//2

    while parent:        
        ans += heap[parent]
        cur = parent
        parent = cur//2
    
    return ans

T = int(input())

for tc in range(1, T+1):
    N = int(input())
    vals = list(map(int, input().split()))
    heap = [0] * (N+1)
    heapcount = 0

    for i in range(0, N):
        heappush(vals[i])

    print(f'#{tc} {postOrder(0)}')
