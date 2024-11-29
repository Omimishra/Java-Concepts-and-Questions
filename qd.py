from collections import defaultdict, deque

def calculation(e,s):
    a = defaultdict(list)
    degree = defaultdict(int)
    
    for p, c in e:
        a[p].append(c)
        degree[c] += 1
        if p not in degree:
            degree[p] = 0
    root = None
    for node, d in degree.items():
        if d == 0:
            root = node
            break
    
    if not root:
        return -1
    l = {}
    q = deque([(root, 1)]) 
    
    while q:
        curr,level = q.popleft()
        l[curr] = level
        for i in a[curr]:
            q.append((i, level + 1))
    v = 0
    for i in s:
        v += l.get(i, -1)
    
    return v
n = int(input())
e = [input().split() for i in range(n)]
s = input().split()
result = calculation(e, s)
print(result)