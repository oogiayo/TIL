def solution(words, queries):
    answer = []

    cases = dict()
    for word in words:
        for i in range(1, len(word)//2):
            if word[:i] + '?'*(len(word)-i) in queries:
                cases[word[:i] + '?'*(len(word)-i)] = cases.get(word[:i] + '?'*(len(word)-i), 0) + 1
            if '?'*i + word[i:] in queries:
                cases['?'*i + word[i:]] = cases.get('?'*i + word[i:], 0) + 1
    
    for query in queries:
        answer.append(cases.get(query, 0))

    return answer
