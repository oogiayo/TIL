T = int(input())
list = []
for tc in range(1, T+1):
    N = input()
    list.append(int(N))
# end of input

month1 = [1, 3, 5, 7, 8, 10, 12]
month2 = [2, 4, 6, 9, 11]
for x in list:
    AB = int(x/100)
    CD = int(x%100)
    if(0<AB<13 & 0<CD<13):
        print("AMBIGUOUS")
    elif(0<AB<13):
        print("MMYY")
    elif(0<CD<13):
        print("YYMM")
#end of output
