T = int(input())
for tc in range(1, T+1):
    code = input()
    stack = []
    
    bracket = {'(': ')', '{': '}'}
    ans = 1
    for letter in code:
        if letter=='(' or letter=='{':
            stack.append(bracket.get(letter))        
        elif letter==')' or letter=='}':
            if len(stack)==0:
                ans = 0
                break
            else:
                if stack.pop()!=letter:
                    ans = 0
                    break
    if len(stack)!=0:
        ans = 0

    print(f'#{tc} {ans}')
