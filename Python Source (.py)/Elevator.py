people = 20
floors = 100

upperbound = people
lowerbound = floors
expStops = (people / floors) * floors
for floors in range(1, people, floors / people):
    expStops += (people / floors) / floors
print expStops
20/100
people = 5
floors = 10
floor 1 = 0
floor 2 = 1/(5/10)
floor 2 or 3 #1 person gets off
floor 4 or 5 #2 person
floor 6 or 7 #3
floor 8 or 9 #4
1/(floorsLeft/peopleLeft)
peo