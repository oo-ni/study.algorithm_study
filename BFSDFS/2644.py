import sys
input = sys.stdin.readline

n = int(input())
t1, t2 = map(int, input().split())
m = int(input())
family = [[] for _ in range(n+1)]
for _ in range(m):
    parent, child = map(int, input().split())
    family[parent].append(child)
    family[child].append(parent)

visit = [0] * (n+1)
count = 0
result = 0

def dfs(current):
    global count, result

    if current == t2:
        result = count
        return

    for child in family[current]:
        if result: continue
        if visit[child]: continue
        count += 1
        visit[child] = 1
        dfs(child)
        count -= 1

visit[t1] = 1
dfs(t1)

print(result if result else -1)
