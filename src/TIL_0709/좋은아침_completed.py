import copy

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
    ans[idx] = "0"
    Subset(idx+1, copy.deepcopy(ans))
    ans[idx] = "1"
    Subset(idx+1, copy.deepcopy(ans))

def Permutation(idx, ans):
    if idx==len(arr):
        print("→", ans)
        return
    for i in range(0, len(arr)):
        if(visited[i]==False):
            visited[i] = 1
            ans[idx] = arr[i]
            Permutation(idx+1, copy.deepcopy(ans))
            visited[i] = 0

def Repermutation(idx, ans):
    if idx == len(arr):
        print("→", ans)
        return
    for i in range(0, len(arr)):
        ans[idx] = arr[i]
        Permutation(idx + 1, copy.deepcopy(ans))

def Combination(idx, r, ans):
    if r == len(arr)-1:
        print("→", ans)
        return
    if idx == len(arr):
        return
    ans[r] = arr[idx]
    Combination(idx+1, r, copy.deepcopy(ans))
    ans[r] = arr[idx]
    Combination(idx+1, r+1, copy.deepcopy(ans))

def Recombination(idx, r, ans):
    if r == len(arr)-1:
        print("→", ans)
        return
    if idx == len(arr):
        return
    ans[r] = arr[idx]
    Recombination(idx+1, r, copy.deepcopy(ans))
    ans[r] = arr[idx]
    Recombination(idx, r+1, copy.deepcopy(ans))
# ----------------------------------

print("<Subset>")
Subset(0, list(range(len(arr))))

print("\n", "<Permutation>")
Permutation(0, list(range(len(arr))))

print("\n", "<Repermutation>")
Repermutation(0, list(range(len(arr))))

print("\n", "<Combination>")
Combination(0, 0, list(range(len(arr)-1)))

print("\n", "<Recmbination>")
Recombination(0, 0, list(range(len(arr)-1)))