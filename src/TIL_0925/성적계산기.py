# 신소재공학개론 A+
# 재료열역학 A
# 전자재료개론 A
# 신소재공학 A
# 공학수학1 B+
# 공학수학2 B
# 공학과컴퓨터1 A
# 공학과컴퓨터2 A+
# 재료물리화학1 B
# 재료물리화학2 B
# 재료역학 B+
# 창의공학기초설계 B

num = 0
tot = 0
for i in range(0, 12):
    subject, score = map(str, input().split())
    if score=='A+':
        tot += 4.5
    elif score=='A':
        tot += 4
    elif score=='B+':
        tot += 3.5
    elif score=='B':
        tot += 3
    num += 1

print(tot/num)
