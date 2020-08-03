def countingSort(arr, sorted_arr, maxArr):
    counts = [0]*(maxArr+1)
    # 카운팅
    for i in range(0, len(arr)):
        counts[arr[i]] += 1
    # 누적
    for i in range(1, len(counts)):
        counts[i] += counts[i-1]
    print(f'counts = {counts}')
        
    # 정렬
    for i in range(0, len(sorted_arr)): #len(sorted_arr)-1, -1, -1):
        sorted_arr[counts[arr[i]]-1] = arr[i]
        counts[arr[i]] -= 1
    # list는 메모리 구조가 heap 영역이기 때문에 return 필요 X
    # list의 변수는 참조형 변수.

arr = [0, 4, 1, 3, 1, 2, 4, 1]
sorted_arr = [0] * len(arr)
countingSort(arr, sorted_arr, 4)

print(f'arr = {arr}')
print(f'sorted arr = {sorted_arr}')