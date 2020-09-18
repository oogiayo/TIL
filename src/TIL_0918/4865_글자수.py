T = int(input())
for tc in range(1, T+1):
    str1 = input()
    str2 = input()
    ans = 0
    letter_dict = {}
    for letter in str1:
        letter_dict[letter] = 0

    for letter in str2:
        if letter in letter_dict:
            letter_dict[letter] += 1

    ans = 0
    for val in letter_dict.values():
        if val > ans:
            ans = val
            
    print(f'#{tc} {ans}')
