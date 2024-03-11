def binary_search(target, data):
    start = 0
    end = n - 1

    while start <= end:
        mid = (start + end) // 2

        if data[mid] == target:
            return True

        elif data[mid] < target:
            start = mid + 1
        else:
            end = mid - 1

    return False

import sys
input = sys.stdin.readline

n = int(input())
a = sorted(list(map(int, input().split())))

m = int(input())
a2 = list(map(int, input().split()))

for i in a2:
    if binary_search(i, a):
        print(1)
    else:
        print(0)