def heappush(value):
    global heapcount

    heapcount += 1
    heap[heapcount] = value
    cur = heapcount
    parent = cur//2

    while parent and heap[parent] > heap[cur]:
        heap[parent], heap[cur] = heap[cur], heap[parent]
        cur = parent
        parent //= 2

def heappop():
    global heapcount
    retValue = heap[1]

    heap[1] = heap[heapcount]
    heap[heapcount] = 0
    heapcount -= 1

    parent = 1
    child = parent * 2

    if child+1 <= heapcount:
        if heap[child] > heap[child+1]:
            child += 1

    while child <= heapcount and heap[parent] > heap[child]:
        heap[parent], heap[child] = heap[child], heap[parent]
        parent = child
        child = parent*2
        if child + 1 <= heapcount:
            if heap[child] > heap[child+1]:
                child += 1

    return retValue

heapcount = 0
temp = [7, 2, 5, 3, 4, 6]
N = len(temp)
heap = [0] * (N+1)
for i in range(N):
    heappush(temp[i])
    print(heap)

for i in range(N):
    print(heappop(), end = ' ')
print()


