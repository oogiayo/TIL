T = int(input())

num_dic = {
    'ZRO': 0, 'ONE': 1, 'TWO': 2, 
    'THR': 3, 'FOR': 4, 'FIV': 5, 
    'SIX': 6, 'SVN': 7, 'EGT': 8, 
    'NIN': 9
    }
num_table = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

for tc in range(1, T+1):
    t, N = input().split()
    N = int(N)
    num_list = input().split()

    for i in range(0, N):
        num_list[i] = num_dic.get(num_list[i])
    num_list.sort()

    num_keys = num_dic.keys()
    print(t)
    for num in num_list:
        print(num_table[num], end=' ')
    print()
