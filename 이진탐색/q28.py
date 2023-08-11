n = int(input())
seq = list(map(int, input().split()))

start = 0
end = len(seq)
result = -1

while start <= end:
    mid = (start + end) // 2

    if seq[mid] == mid:
        result = mid
        break

    elif seq[mid] > mid:
        end = mid - 1

    else:
        start = mid + 1
    
print(result)
