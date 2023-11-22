word = [input() for _ in range(5)]      # 값 5개 입력
l = [len(k) for k in word]              # 입력 값의 길이 리스트
result = []

for i in range(max(l)):                 # 최대 값 만큼 열 인덱스 지정
    for j in range(5):
        if i < len(word[j]):            # i 보다 word[j]의 길이가 쟉으면 word j번째 행의 i번째 원소가 없다는 것이므로 해당 경우는 제외.
            result.append(word[j][i])

print(*result, sep='')      # *은 리스트의 원소를 대괄호와 따옴표 없이 출력, sep=''은 사이의 공백 없이 출력.