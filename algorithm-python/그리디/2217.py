n = int(input())
rope = [int(input()) for _ in range(n)]
rope.sort(reverse=True)

weight = []         # 로프별 들 수 있는 최대 무게를 구해야함.
for i in range(n):
    weight.append(rope[i] * (i+1))      # ex) [100*1, 50*2, 30*3, 30*4, 10*5]

print(max(weight))