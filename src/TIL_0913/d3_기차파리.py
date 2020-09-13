T = int(input())
 
def length(dist, n, tot):
    if n%2==0:
        dist_F = dist * F/(B+F)
        dist_next = dist*(1-(A+B)/(B+F))
    else:
        dist_F = dist * F/(A+F)
        dist_next = dist*(1-(A+B)/(A+F))
    tot += dist_F
    if dist_F <= 10**(-6):
        print(f'#{tc} {tot}')
        return
    length(dist_next, n+1, tot)
 
     
for tc in range(1, T+1):
    D, A, B, F = map(int, input().split())
    length(D, 0, 0)
