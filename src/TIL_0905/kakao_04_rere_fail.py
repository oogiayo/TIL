def solution(words, queries):
    answer = []

    check = dict()
    for query in queries:

        if not check.get(query):

            i = 0

            left = True        
            l = ''
            r = ''

            if query[0]=='?':
                temp = query.split('?')
                l = temp[:-1]
                r = temp[-1]
            else:
                left = False
                temp = query.split('?')
                l = temp[0]
                r = temp[1:]

            idx = len(l)

            cnt = 0
            for word in words:
                if len(word)==len(query):
                    if left:
                        if word[idx:]==r:
                            cnt += 1
                    else:
                        if word[:idx]==l:
                            cnt += 1

            check[query] = cnt

        answer.append(check[query])

    return answer
