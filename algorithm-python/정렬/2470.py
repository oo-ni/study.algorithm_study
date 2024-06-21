n = int(input())
solution = list(map(int, input().split()))
solution.sort()

left = 0
right = n-1

temp = abs(solution[left] + solution[right])
result = [solution[left], solution[right]]

while left < right:
    left_val = solution[left]
    right_val = solution[right]

    sum = left_val + right_val

    if abs(sum) < temp:
        temp = abs(sum)
        result = [left_val, right_val]
        if temp == 0:
            break
    if sum < 0:
        left += 1
    else:
        right -= 1
        

print(result[0], result[1])