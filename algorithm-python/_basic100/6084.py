# 6084 : [기초-종합] 소리 파일 저장용량 계산하기
h, b, c, s = map(int, input().split())
volume = (h*b*c*s)/8
result = round(volume/(2**20), 1)   # 반올림
# result = format(volume/(1024*1000), "1.f")    # 소수점 출력 제한

print(result, "MB")
