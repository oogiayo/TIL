T = 10
for tc in range(1, T+1):
    L = int(input())
    table = [list(map(int, input().split())) for _ in range(0, L)]
     
    cnt = 0        
    # 각 열별로 체크해준다 (열 간에는 교착여부 상관 X)
    for c in range(0, L):
        stack = []
        for r in range(0, L):
            
            # 자석 1(N극인가?) 발견하면 일단 stack에 넣는다.
            if table[r][c]==1:
                stack.append(1)
 
            # stack에 1이 담겨있는 상태에서 자석 2 (S극)를 만나면 둘이 교착되는거니까 cnt++ 해준다
            elif len(stack)>0 and table[r][c]==2:
                cnt += 1
                stack = []

            # S극 위로 사라지는거나 N극 밑으로 사라지는거 or 같은극에 달라붙는거는 교착개수랑 상관없어서 딱히 예외는 없는듯? 대충풀어서긍가
    
    print(f'#{tc} {cnt}')
