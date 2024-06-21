n, c = map(int, input().split())
x = []
for _ in range(n):
    x.append(int(input()))
x.sort()

start = 1
end = x[-1] - x[0]
result = 0

while start <= end:
    mid = (start + end) // 2
    temp = x[0]
    cnt = 1

    for i in range(1, len(x)):
        if x[i] >= temp + mid:
            cnt += 1
            temp = x[i]

    if cnt >= c:
        start = mid + 1
        result = mid

    else:
        end = mid - 1

print(result)