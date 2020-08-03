T = 10
for tc in range(1, T+1):
    N = int(input())
    heights = list(map(int, input().split()))

    cnt = 0
    for c in range(2, N-2):
        height = heights[c]
        while height>0:
            if height > max(heights[c-2], heights[c-1], heights[c+1], heights[c+2]):
                cnt += 1
            else:
                break 
            height -= 1

    print(f'#{tc} {cnt}')