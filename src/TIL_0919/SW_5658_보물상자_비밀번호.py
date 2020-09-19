T = int(input())

for tc in range(1, T+1):
    N, K = map(int, input().split())
    n = N//4
    # n : 한 변의 숫자 개수
    arr = input()

    nums = set()
    for i in range(0, n):
        for j in range(0, len(arr), n):
            nums.add(arr[j:j+n])
        arr = arr[-1] + arr[:-1]
    
    nums = list(nums)
    nums.sort()
    password = nums[-K]
    x = 16**(n-1)
    # 현재 자리수의 16진수 크기

    ans = 0
    for i in range(0, n):
        char_num = ord(password[i])
        if 65<=char_num<=70:
            char_num -= 55
        else:
            char_num -= 48

        ans += char_num * x
        x//=16
        # 뒤로 한칸 이동했음을 의미

    print(f'#{tc} {ans}')
