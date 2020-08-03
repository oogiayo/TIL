
def BubbleSort(a): #정렬할 List
    for i in range(len(a)-1, 0, -1):
        for j in range(0, i):
            if a[j] > a[j+1]:
                a[j], a[j+1] = a[j+1], a[j]
                # 파이썬은 tuple 형태로 SWAP 가능!

a = [3, 1, 2, 9, 4, 3, 3, 2, 0]
BubbleSort(a)
print(a)