global arr, visited
arr = ['A', 'B', 'C']
visited = [0, 0, 0]

def Subset(idx, ans):
    if idx==len(arr):
        set = ""
        for i in range(0, idx):
            if ans[i]=="0":
                set += arr[i]
                set += " "
        print("→ "+set)
        return
    ans.append("0")
    Subset(idx+1, ans)
    ans.pop()
    ans.append("1")
    Subset(idx+1, ans)
    ans.pop()

def Permutation(idx, ans):
    if idx==len(arr):
        print("→", ans)
        return
    for i in range(0, len(arr)):
        if(visited[i]==0):
            visited[i] = 1
            ans.append(arr[i])
            Permutation(idx+1, ans)
            ans.pop()
            visited[i] = 0

def Repermutation(idx, ans):
    if idx == len(arr):
        print("→", ans)
        return
    for i in range(0, len(arr)):
        ans.append(arr[i])
        Permutation(idx + 1, ans)
        ans.pop()

# def Combination(idx, r, ans):
#     if r == len(arr)-1:
#         print("→", ans)
#         return
#     if idx == len(arr):
#         return
#
#
#     ans[r] = arr[idx]
#     Combination(idx+1, r, ans)
#     ans[r] = ""
#     ans[r] = arr[idx]
#     Combination(idx, r+1, ans)
#     ans[r] = ""
# ----------------------------------

print("<Subset>")
Subset(0, [])

print("\n", "<Permutation>")
Permutation(0, [])

print("\n", "<Repermutation>")
Repermutation(0, [])

# print("\n", "<Combination>")
# Combination(0, 0, ["", ""])