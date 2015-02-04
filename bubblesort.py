def bubble(l):
    for x in range(0, len(l)-1):
        for i in range(0, len(l)-1-x):
            if l[i] > l[i+1]:
                temp = l[i]
                l[i] = l[i+1]
                l[i+1] = temp
    return l

print(bubble([2, 6, 1, 9, 4, 7, 1, 0, 44, 7]))