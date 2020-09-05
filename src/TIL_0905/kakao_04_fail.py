def solution(words, queries):
    answer = []

    for query in queries:
        
        i = 0

        left = True        
        l = ''
        r = ''
        idx = 0
        if query[0]=='?':
            while query[idx]=='?':
                l += query[idx]
                idx += 1
            r = query[idx:]
        else:
            left = False
            while query[idx]!='?':
                l += query[idx]
                idx += 1
            r = query[idx:]

        cnt = 0
        for word in words:
            if len(word)==len(query):
                if left:
                    if word[idx:]==r:
                        cnt += 1
                else:
                    if word[:idx]==l:
                        cnt += 1

        answer.append(cnt)

    return answer
