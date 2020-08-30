def solution(p):
    answer = ''

    if len(p)==0:
        return ''
    else:
        u = ''
        v = ''
        cnt = 0
        for i in range(0, len(p)):
            u += p[i]
            if p[i]=='(':
                cnt += 1
            if cnt*2 == i+1:
                v = p[i+1:]
                break
        
        stack = []  
        isRight = True
        for i in range(0, len(u)):
            if u[i]=='(':
                stack.append(u[i])
            else:
                if len(stack)==0:
                    isRight = False
                    break
                else:
                    stack.pop()
        
        if isRight:
            answer = u + solution(v)
        else:
            new = '(' + solution(v) + ')'
            for i in range(1, len(u)-1):
                if u[i]=='(':
                    new += ')'
                else:
                    new += '('
            answer += new
    return answer
