from collections import deque

n = int(input())
card = deque(range(1, n+1))
result = []

while len(card) > 1:
    result.append(card.popleft())
    card.append(card.popleft())

print(*result, card[0])