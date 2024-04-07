import sys
input = sys.stdin.readline

n, m = map(int, input().split())
note = {}

for i in range(n):
    word = input().strip()      # readline 사용 시 발생하는 개행문자 제거.
    if len(word) >= m:
        if word in note:
            note[word] += 1
        else:
            note[word] = 1

note = sorted(note.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for i in note:
    print(i[0])