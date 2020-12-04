def solution_part1(lines):
    for x in lines:
        y = 2020 - x        
        if y in lines:
            return (x*y)
    return 0

def solution_part2(lines):
    for x in lines:
        for y in lines:      
            for z in lines:      
                if x + y + z == 2020:            
                    return (x * y * z)
    return 0

f = open("day01.txt", "r")
lines = list(map(int,f.readlines()))
print (solution_part1(lines))
print (solution_part2(lines))

