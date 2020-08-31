T = 10
for tc in range(1, T+1):
    N = int(input())
    infix = input()

    postfix = ''
    stack = []
    for l in infix:
        if l=='(':
            stack.append(l)
        elif l==')':
            while len(stack) > 0:
                x = stack.pop()
                if x == '(':                    
                    break
                postfix += x
        elif l=='+':
            while len(stack) > 0 and stack[-1] != '(':
                postfix += stack.pop()
            stack.append(l)
        elif l=='*':    
            while len(stack) > 0 and stack[-1] == '*':
                postfix += stack.pop()
            stack.append(l)

        else:
            postfix += l

    while len(stack) > 0:
        postfix += stack.pop()

    ans = 0
    for l in postfix:
        if l=='*':
            stack.append( int(stack.pop()) * int(stack.pop()) )
        elif l=='+':
            stack.append( int(stack.pop()) + int(stack.pop()) )
        else:
            stack.append(l)

    print(f'#{tc} {stack[0]}')
