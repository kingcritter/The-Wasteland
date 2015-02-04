import random

def mystery():
    return random.choice((True, False))

def random_integer(start, stop):
    l = range(start, stop)
    while len(l) > 1:
        choice = mystery()
        if choice: 
            l = l[(len(l))//2:]
        else: 
            l = l[:(len(l))//2]
    return l[0]


print(random_integer(1, 11))