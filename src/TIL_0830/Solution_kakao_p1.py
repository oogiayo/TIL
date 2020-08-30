def solution(s):
    answer = len(s)
    for i in range(1, len(s)//2 + 1):
        
        new = ''
        cnt = 1
        
        sl = s[:i]
        
        for j in range(i, len(s)+i, i):
            if sl == s[j:j+i]:
                cnt += 1
            else:
                if cnt > 1:
                    new += str(cnt) + sl
                else:
                    new += sl
                
                cnt = 1
                sl = s[j:j+i]
            
        if len(new) < answer:
            answer = len(new)
        
    return answer
