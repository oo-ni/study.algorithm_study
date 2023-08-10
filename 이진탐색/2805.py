n, m = map(int, input().split())
height = list(map(int, input().split()))

start, end = 1, sum(height)

while start <= end:
    mid = (start + end) // 2
    cnt = 0
    
    for i in height:
        if i > mid:
            cnt += i - mid

    if cnt >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)