course_list = [(4, 8), (3, 5), (2, 4), (1, 4), (8, 10), (6, 8), (5, 7), (4, 5), (5, 8), (9, 11)] # 입력 조건

course_list.sort(key=lambda x: x[1]) # 종료시간을 기준으로 오름차순 정렬 (하나의 수업이 끝난 후의 시간을 기준으로 정해야하므로)
pre_end_time = 0 # 이전 수업 시간 초기화
optimal_courses = [] # 최적의 강의 시간표 리스트 초기화

for course in course_list:
  start_time, end_time = course # 시작시간과 종료시간 각각 저장
  if start_time > pre_end_time: # 이전 수업보다  시간이 뒤일 경우
    optimal_courses.append(course) # 해당 수업을 바로 시간표에 추가
    pre_end_time = end_time # 이전 수업 시간이 추가되면 끝나는 시간 변경
print(optimal_courses) # 최적의 강의 시간표 출력
