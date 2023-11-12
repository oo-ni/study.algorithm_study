import heapq

def dijkstra(graph, start):
    distances = {node: float('inf') for node in graph}          # 네트워크(그래프)상에 있는 노드들을 “inf”로 설정해서 distances에 할당 
    distances[start] = 0                                        # 첫번째 시작점을 0으로 초기화 설정
    queue = []                                                  # 힙을 사용하기 위해 큐를 초기화
    heapq.heappush(queue, [distances[start], start])            # 거리의 시작정(정점)과 정점의 거리(간선) 값을 힙에 넣어줌.

    while queue:                                                # 산출이 될때까지 While문 처리
        current_distance, current_node = heapq.heappop(queue)   # 현재의 거리와 현재의 노드에 상위에서 힙을 기반으로 최소값을 팝하고 할당 

        if distances[current_node] < current_distance:          # 약에 현재거리보다 더 짧은 경로가 있다면 계속 진행 
            continue

        for adjacent, weight in graph[current_node].items():    # 현재 그래프 노드를 기준으로 딕셔너리기반 adjacent, weight에 값을 할당
            distance = current_distance + weight                # 위의 힙을 통해 산출된 현재 간선간의 거리와 가중치값을 distance변수에 할당	

            if distance < distances[adjacent]:                  # 인접된 거리보다 짧다면 
                distances[adjacent] = distance                  # 현재 인접 거리 리스트에 할당
                heapq.heappush(queue, [distance, adjacent])     # 힙을 기반으로 큐에 해당 거리와 노드할당

    return "Completed"
