import heapq

n = int(input())
card = []

for i in range(n):
    heapq.heappush(card, int(input()))

result = 0

if len(card) == 1:
    print(result)
else:
    for i in range(n-1):
        a = heapq.heappop(card)
        b = heapq.heappop(card)

        result += (a+b)
        heapq.heappush(card, a+b)
    
    print(result)
