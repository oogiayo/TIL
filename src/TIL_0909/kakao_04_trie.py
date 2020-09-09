class Trie:
    def __init__(self):
        self.childList = [None]*26
        self.cnt = 0

    def insert(self, word):
        current = self
        for letter in word:
            current.cnt += 1
            if current.childList[ord(letter)-ord('a')]:
                current = current.childList[ord(letter)-ord('a')]
            else:
                current.childList[ord(letter)-ord('a')] = Trie()
                current = current.childList[ord(letter)-ord('a')]

    def search(self, query):
        current = self

        for i in range(0, len(query)):
            if query[i]=='?':
                return current.cnt

            if current.childList[ord(query[i])-ord('a')]:
                current = current.childList[ord(query[i])-ord('a')]
            else:
                return 0

        return current.cnt


def solution(words, queries):
    answer = []
    words = set(words)
    queryDict = {}

    tries = [None for _ in range(0, 100001)] 
    rtries = [None for _ in range(0, 100001)]

    for word in words:
        if not tries[len(word)]:
            tries[len(word)] = Trie()
        tries[len(word)].insert(word)
        if not rtries[len(word)]:
            rtries[len(word)] = Trie()
        rtries[len(word)].insert(word[::-1])

    for query in queries:
        if query not in queryDict:
            cnt = 0
            if query[0]=='?' and rtries[len(query)]:
                cnt = rtries[len(query)].search(query[::-1])
            elif tries[len(query)]:
                cnt = tries[len(query)].search(query)
        
            queryDict[query] = cnt

        answer.append(queryDict[query])

    return answer



words = ["frodo", "front", "frost", "frozen", "kakao", "frame" ]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]

print(solution(words, queries))
