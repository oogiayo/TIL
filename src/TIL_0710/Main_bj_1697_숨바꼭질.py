import queue

N, K = map(int, input().split())
visited = [0]*100001
dx = [-1,1,0]

class Pair:
    def __init__(self, x, sec):
        self._x = x
        self._sec = sec

    def x(self):
        return self._x

    def sec(self):
        return self._sec

q = queue.Queue()
q.put(Pair(N, 0))
visited[N] = 1
while q.qsize!=0:
    p = q.get()
    if p.x() == K:
        print(p.sec())
    for k in range(0, 3):
        nx = p.x() + dx[k]
        if k == 2:
            nx = p.x()*2
        if (0 <= nx <= 100000) and (visited[nx] == 0):
            visited[nx] = 1
            q.put(Pair(nx, p.sec()+1))
