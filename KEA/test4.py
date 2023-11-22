import heapq

def dijkstra(graph, start, end):
    # 최단 거리를 저장하는 딕셔너리
    distances = {station: float('inf') for station in graph}
    distances[start] = 0

    # 우선순위 큐를 사용하여 최단 거리를 갱신하며 탐색
    priority_queue = [(0, start)]
    previous_nodes = {station: None for station in graph}

    while priority_queue:
        current_distance, current_station = heapq.heappop(priority_queue)
        
        # 현재 노드가 이미 처리된 경우, 스킵
        if current_distance > distances[current_station]: 
            continue

        for neighbor, weight in graph[current_station].items():
            distance = current_distance + weight

            # 더 짧은 경로를 찾았을 경우 업데이트
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                previous_nodes[neighbor] = current_station
                heapq.heappush(priority_queue, (distance, neighbor))

    path = []
    current = end

    while previous_nodes[current] is not None:
        path.insert(0, current)
        current = previous_nodes[current]

    path.insert(0, start)

    return path

def main():
    # 사용자로부터 역과 비용 정보를 입력 받기
    stations = {}
    # 역(노드) 개수 입력
    num_stations = int(input("전체 역 개수: "))

    for _ in range(num_stations):
        # 역 이름 입력
        station_name = input("역 이름: ")

        # 인접 역(노드) 개수 입력
        num_neighbors = int(input("인접 역 개수: "))
        neighbors = {}

        for _ in range(num_neighbors):
            # 인접 역 이름 입력
            neighbor_name = input("인접 역 이름: ")
            # 인접 역 까지 비용 정보 입력
            neighbor_weight = int(input("인접 역 비용: "))
            neighbors[neighbor_name] = neighbor_weight

        stations[station_name] = neighbors

    # 출발 역 및 도착 역 정보 입력
    start_station = input("출발 역: ")
    end_station = input("도착 역: ")

    # 다익스트라 알고리즘 실행
    result = dijkstra(stations, start_station, end_station)

    # 결과 출력
    if result[-1] == end_station:
        print("->".join(result))
        print("Completed")
    else:
        print("No Path")

if __name__ == "__main__":
    main()
>>>>>>> 8e91cd3fd7c37de09b47a6b3b3de2f83a290ad2c
