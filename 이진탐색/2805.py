n, m = map(int, input().split())
height = list(map(int, input().split()))

start = 1
end = max(height)

while start <= end:
    mid = (start + end) // 2
    print(mid)
    cnt = 0
    
    for i in height:
        if i > mid:
            cnt += i - mid

    if cnt < m:
        end = mid - 1
    else:
        start = mid + 1

print(end)