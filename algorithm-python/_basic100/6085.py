# 6085 : [기초-종합] 그림 파일 저장용량 계산하기
w, h, b = map(int, input().split())
volume = (w*h*b)/8
result = volume/(2**20)

print(f"{result:.2f}", "MB")    # f-string 활용 자릿수 표시. f"{실수.표시할자릿수}"