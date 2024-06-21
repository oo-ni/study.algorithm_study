# n = int(input())

# for i in range(1, n+1):
#     s = str(i)
#     scount = s.count("3") + s.count("6") + s.count("9")
#     if scount != 0: 
#         s = "-"*scount
#     else:
#         i += 1
    
#     print(s, end=" ")

import re

n = int(input())

for i in range(n):
    i = str(i)
    p = re.compile("[369]")

    
    print("-"*len(p.findall(i)), end=' ')
