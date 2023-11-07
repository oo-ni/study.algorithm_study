from collections import deque
import copy
import sys

input = sys.stdin.readline
n, m = map(int, input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

# 4가지 이동 방향에 대한 리스트 
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def virus():
    global result
    queue = deque()
    tmp_arr = copy.deepcopy(arr)
    for i in range(n):
        for j in range(m):
            if tmp_arr[i][j] == 2:
                queue.append((i,j))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
						# 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
            if 0 <= nx < n and 0 <= ny < m: 
                if tmp_arr[nx][ny] == 0:
										# 해당 위치에 바이러스 배치
                    tmp_arr[nx][ny] = 2
                    queue.append((nx,ny))
    cnt = 0
    for i in range(n):
        for j in range(m):
            if tmp_arr[i][j] == 0:
                cnt += 1
    result = max(result,cnt)
    
def build_wall(cnt):
    if cnt == 3:
        virus()
        return
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 0:
                arr[i][j] = 1
                build_wall(cnt+1)
                arr[i][j] = 0
                
result = 0
build_wall(0)
print(result)