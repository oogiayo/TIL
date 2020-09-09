T = int(input())

for tc in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))

    m = [False] * (sum(arr)+1)

    sums = [0]
    for score in arr:

        length = len(sums)
        for i in range(0, length):
            if not m[sums[i] + score]:
                m[sums[i] + score] = True
                sums.append(sums[i] + score)

    print(f'#{tc} {len(sums)}')

