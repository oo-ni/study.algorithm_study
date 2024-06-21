# - 플로이드 워셜 알고리즘
    # - 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우
# - 2차원 리스트에 ‘최단 거리’ 정보를 저장
# - 점화식 Dab = min(Dab , Dak + Dkb)
    # - ‘A에서 B로 가는 최소 비용’과 ‘A에서 K를 거쳐 B로 가는 비용’을 비교하여 더 작은 값으로 갱신

import sys

input = sys.stdin.readline
INF = int(1e9)

n = int(input())  # 도시의 개수
m = int(input())  # 버스의 개수

#2차원 리스트를 만들고, 모든 값을 무한으로 초기화 
graph = [[INF] * (n + 1) for _ in range(n + 1)] 

# 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
for a in range(1, n + 1):
    for b in range(1, n + 1):
        if a == b:
            graph[a][b] = 0

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(c, graph[a][b])   

# 점화식에 따라 플로이드 워셜 알고리즘을 수행 
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])


for a in range(1, n + 1):
    for b in range(1, n + 1):
        if graph[a][b] == INF:
            print("0",  end=" ") # 갈 수 없는 경우 0을 출력
        else:
            print(graph[a][b], end=" ") # 가는데 필요한 최소 비용
    print()