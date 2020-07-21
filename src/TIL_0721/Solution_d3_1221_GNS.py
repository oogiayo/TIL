T = int(input())

num_dict = {'ZRO': 0, 'ONE': 1, 'TWO': 2, 'THR': 3, 'FOR': 4, 'FIV': 5, 'SIX': 6, 'SVN': 7, 'EGT': 8, 'NIN': 9}

for tc in range(1, T+1):
    t_num, N = map(str, input().split())
    N = int(N)
    num_list = input().split()
    for i in range(0, len(num_list)):
        num_list[i] = num_dict[num_list[i]]
    
    for i in range(0, len(num_list)):
        for j in range(i+1, len(num_list)):
            if num_list[i]>num_list[j]:
                temp = num_list[j]
                num_list[j] = num_list[i]
                num_list[i] = temp
    num_dict_reverse = {v:k for k, v in num_dict.items()}

    print(f'{t_num}')
    for n_i in num_list:
        print(num_dict_reverse.get(n_i), end=' ')