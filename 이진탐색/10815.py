import sys
input = sys.stdin.readline

def binary_search(data, target):
    start, end = 0, len(data) - 1
    ans = "0"

    while start <= end:
        mid = (start + end) // 2
        
        if data[mid] == target:
            ans = "1"
            break

        elif data[mid] < target:
            start = mid + 1

        else:
            end = mid - 1

    return ans

n = int(input())
card = list(map(int, input().split()))
card.sort()

m = int(input())
num = list(map(int, input().split()))

result = []

for i in num:
    result.append(binary_search(card, i))

print(*result)