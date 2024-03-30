#단지번호붙이기
from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(graph, start, visited):
    n = len(graph)
    queue = deque()
    queue.append((start, visited))
    graph[start][visited] = 0
    count = 1

    while queue:
        x, y = queue.popleft()
        #지정된 방향의 노드 값에 따라 단지 여부를 구분.
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
                count += 1
    return count


n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))   #2차원 리스트

result = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            result.append(bfs(graph, i, j))

result.sort()
print(len(result))
for i in range(len(result)):
    print(result[i])