T = int(input())

for tc in range(1, T+1):
    s = input()
    line15_1st = '..#.'
    line24_1st = '.#.#'
    line15 = ''
    line24 = ''
    line3 = ''
    for l in s:
        line15 += line15_1st
        line24 += line24_1st
        line3 += f'#.{l}.'
    print(line15 + '.')
    print(line24 + '.')
    print(line3 + '#')
    print(line24 + '.') 
    print(line15 + '.')