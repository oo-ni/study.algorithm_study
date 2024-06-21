a, b = 0, 0

list = [int(input()) for i in range(9)]

total = sum(list)

for i in range(9):
  for j in range(i+1, 9):
    if total - (list[i] + list[j]) == 100:
      a = list[i]
      b = list[j]

list.remove(a)
list.remove(b)
list.sort()

for i in list:
  print(i)