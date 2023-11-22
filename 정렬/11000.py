# import heapq

# sooup = int(input())
# heap = []

# for i in range(sooup):
#     start, end = map(int, input().split())
#     heap.append([start, end])

# heap.sort()

# room = []
# heapq.heappush(room, heap[0][1])

# for i in range(1, sooup):
#     if heap[i][0] < room[0]:
#         heapq.heappush(room, heap[i][1])
#     else:
#         heapq.heappop(room)
#         heapq.heappush(room, heap[i][1])

# print(len(room))

import heapq

n = int(input())

lecture_num = []
lecture_queue = []

for _ in range(n):
    start, end = map(int, input().split())
    lecture_num.append([start, end])

lecture_num.sort()

heapq.heappush(lecture_queue, lecture_num[0][1]) # 수업1의 끝나는 시간을 heap에 추가

for i in range(1, n): # 수업2부터 모든 강의에 대해 반복
    if lecture_num[i][0] < lecture_queue[0]:  # 현재 진행하는 강의의 시작시간이 우선순위 큐의 끝나는 시간 보다 작으면 현재 강의의 끝나는 시간을 우선순위 큐에 추가
        heapq.heappush(lecture_queue, lecture_num[i][1])
    else: # 겹치지 않는 경우
        heapq.heappop(lecture_queue)
        heapq.heappush(lecture_queue, lecture_num[i][1])

print(len(lecture_queue)) # 우선순위 큐에 들어있는 숫자의 개수