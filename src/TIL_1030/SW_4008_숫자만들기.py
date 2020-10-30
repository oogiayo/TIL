from collections import deque

def repermutation(idx, acc):
    global max_acc, min_acc
    if idx==N-1:
        if acc > max_acc:
            max_acc = acc
        if acc < min_acc:
            min_acc = acc
        return
    for i in range(0, 4):
        if operators[i]:
            operators[i] -= 1
            if i==0:
                repermutation(idx+1, acc + numbers[idx+1])
            elif i==1:
                repermutation(idx+1, acc - numbers[idx+1])
            elif i==2:
                repermutation(idx+1, acc * numbers[idx+1])
            else:
                repermutation(idx+1, int(acc / numbers[idx+1]))
            operators[i] += 1
        

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    operators = list(map(int, input().split()))
    numbers = list(map(int, input().split()))
    min_acc = 100000000
    max_acc = -100000000
    repermutation(0, numbers[0])
    ans = max_acc - min_acc
    print(f'#{tc} {ans}')
