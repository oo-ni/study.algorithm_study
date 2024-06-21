import sys

v, e = map(int, sys.stdin.readline().split())
edges = []

# 부모 테이블 초기화
parent = [0] * (v+1)
for i in range(1, v+1):
    parent[i] = i

# find 연산
def find_parent(parent, x):
    if parent[x] != x:      # 부모 노드가 본인이 아닐 경우
        parent[x] = find_parent(parent, parent[x])  # 부모 노드의 값을 넣기 위해 재귀적 수행 
    return parent[x]

# union 연산
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

total_cost = 0

for i in range(e):
    a, b, cost = map(int, sys.stdin.readline().split())
    edges.append((a, b, cost))

edges.sort(key= lambda x:[x[2]])

for i in range(e):
    a, b, cost = edges[i]
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        total_cost += cost

print(total_cost)