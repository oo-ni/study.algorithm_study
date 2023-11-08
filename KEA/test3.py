import sys

stations = input().split()
edges = []

# 부모 테이블 초기화
parent = {}
for station in stations:
    parent[station] = station

# find 연산
def find_parent(parent, x):
    if parent[x] != x:      # 부모 노드가 본인이 아닐 경우
        parent[x] = find_parent(parent, parent[x])  # 부모 노드의 값을 넣기 위해 재귀적 수행.
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

while True:
    e_input = input()
    if not e_input:     # 공백 문자열일 경우 break
        break
    cost, a, b = e_input.split()
    edges.append((int(cost), a, b))

edges.sort(key= lambda x:x[0])

min_cost_path = []

for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        min_cost_path.append(edge)

print(min_cost_path)