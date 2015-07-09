#Sets up bins
bins = {}
for x in range(0,10):
    bins[x] = []

# sets up list. Couldn't be bothered to type all those quotion marks.
theList = [345, 200, 400, 672, 123, 111]
for x in range(0, len(theList)):
    theList[x] = str(theList[x])

#does the thing
digit = 2
while digit >= 0:
    for n in theList:
        bins[int(n[digit])].insert(0, n)
    digit -= 1
    theList = []
    for b in range(0,10):
        while len(bins[b]) > 0:
            theList.append(bins[b].pop())

# prints the thing and then your computer explodes.
print(theList)

# FIN

