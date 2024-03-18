def solution(n):
    term = 0
    
    for i in range(n+1):
        if (i%2 == 0):
            term += i
    
    answer = term
    return answer