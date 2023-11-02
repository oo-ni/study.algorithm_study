distance1 = list(map(int, input().split(", "))) # 가천대 to 대전시청 경로 리스트
distance2 = list(map(int, input().split(", "))) # 대전시청 to 부산대 경로 리스트

min_distance1 = distance1[0]    # 첫번째 최단거리
for i in distance1:
  if i < min_distance1:
    min_distance1 = i

min_distance2 = distance2[0]    # 두번째 최단거리
for i in distance2:
  if i < min_distance2:
    min_distance2 = i

print(min_distance1 + min_distance2)    # 합 출력