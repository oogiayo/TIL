T = int(input())

for tc in range(1, T+1):
    N = int(input())
    words_list = input().split()
    ans = ''
    isSentence = 0
    cnt = 0
    for word in words_list:
        if len(word)==1:
            if 65<=ord(word[0:1])<=90:
                cnt += 1

        else:
            if word[-1:]=='.' or word[-1:]=='!' or word[-1:]=='?':
                isSentence = 1
            if 65<=ord(word[0:1])<=90:
                cnt += 1
                for i in range(1, len(word)):
                    # 마지막 letter는 따로 체크해준다.
                    if i==len(word)-1:
                        if word[i:i+1]=='.' or word[i:i+1]=='!' or word[i:i+1]=='?' or 97<=ord(word[i:i+1])<=122:
                            continue
                        else:
                            cnt -= 1
                            continue

                    if 97<=ord(word[i:i+1])<=122:
                        continue
                    else:
                        cnt -= 1
                        break
                    

            if isSentence==1:
                ans += str(cnt) + ' '
                isSentence = 0
                cnt = 0

    print(f'#{tc} {ans}')



# T = int(input())

# for tc in range(1, T+1):
#     N = int(input())
#     words_list = input().split()
#     ans = ''
#     isSentence = 0
#     cnt = 0
#     for word in words_list:
#         if word[-1:]=='.' or word[-1:]=='!' or word[-1:]=='?':
#             word = word[:-1]
#             isSentence = 1
#         if 65<=ord(word[0:1])<=90:
#             cnt += 1
#             if len(word)!=1:
#                 for i in range(1, len(word)-1):
#                     if 97<=ord(word[i:i+1])<=122:
#                         continue
#                     else:
#                         cnt = 0
#                 # 마지막 letter는 따로 체크해준다.
#                 l_end = word[-1:]
#                 if l_end=='.' or l_end=='!' or l_end=='?' or 97<=ord(l_end)<=122:
#                     pass
#                 else:
#                     cnt = 0

#             # 단어가 한글자일 경우도 따로 체크해준다.
#             elif len(word)==1:
#                 if 65<=ord(word)<=90:
#                     pass
#                 else:
#                     cnt = 0

#         if isSentence==1:
#             ans += str(cnt) + ' '
#             isSentence = 0
#             cnt = 0

#     print(f'#{tc} {ans}')



# T = int(input())

# for tc in range(1, T+1):
#     N = int(input())
#     words_list = input().split()
#     ans = ''
#     isSentence = 0
#     cnt = 0
#     for word in words_list:
#         if 65<=ord(word[0:1])<=90:
#             cnt += 1
#             for i in range(1, len(word)-1):
#                 if 97<=ord(word[i:i+1])<=122:
#                     continue
#                 else:
#                     cnt = 0
#             # 마지막 letter는 따로 체크해준다.
#             if 65<=ord(word[-1:])<=90 or 97<=ord(word[-1:])<=122:
#                 pass
#             elif word[-1:]=='.' or word[-1:]=='!' or word[-1:]=='?':
#                 pass
#                 isSentence = 1
#             else:
#                 cnt = 0
#         # 문장의 마지막 word일 경우 이름을 count한 결과를 붙여준다.
#         if isSentence==1:
#             ans += str(cnt) + ' '
#             isSentence = 0
#             cnt = 0

#     print(f'#{tc} {ans}')




        # 문장들을 list에 담는다.

    # sentences_list = input().split('!' or '?')
    # ans = ''
    # for sentence in sentences_list:
    #     cnt = 0
    #     words_list = sentence.split()
    #     for word in words_list:
    #         if 65<=ord(word[0:1])<=90:
    #             cnt += 1
    #             for i in range(1, len(word)):
    #                 if i==len(word)-1 and (word[i:]=='.' or word[i:]=='!' or word[i:]=='?'):
    #                     continue
    #                 if 97<=ord(word[i:i+1])<=122:
    #                     continue
    #                 else:
    #                     cnt = 0
    #     ans += str(cnt) + ' '