def combination(idx, start_team, link_team):
    global N
    if len(start_team)==N//2 and len(link_team)==N//2:
        calStat(start_team, link_team)
        return
    if idx==N:
        return
    combination(idx+1, start_team + [idx], link_team)
    combination(idx+1, start_team, link_team + [idx])


def calStat(start_team, link_team):
    global ans
    stat_st = 0
    stat_lt = 0
    for i in range(0, N//2):
        for j in range(i+1, N//2):
            stat_st += stat[start_team[i]][start_team[j]]
            stat_st += stat[start_team[j]][start_team[i]]

            stat_lt += stat[link_team[i]][link_team[j]]
            stat_lt += stat[link_team[j]][link_team[i]]

    stat_difference = abs(stat_st - stat_lt)
    if stat_difference < ans:
        ans = stat_difference


N = int(input())

stat = [list(map(int, input().split())) for _ in range(0, N)]
people = []
ans = 100*20*20//2

combination(0, [], [])
print(ans)
