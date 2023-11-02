lecture_list = [(4, 8), (3, 5), (2, 4), (1, 4), (8, 10), (6, 8), (5, 7), (4, 5), (5, 8), (9, 11)]

lecture_list.sort(key=lambda x: x[1])   # 강의 리스트를 종료 시간를 기준으로 정렬

optimal_list = []   # 최적 시간표 리스트 초기화
end = 0

for i in lecture_list:
  start, finish = i
  if start > end:    # 현재 강의의 시작 교시가 이전 강의의 종료 시간보다 뒤일 경우
    optimal_list.append(i)
    end = finish
    
print(optimal_list)
