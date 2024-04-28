credits = []
grades = []

translation = {"A+": 4.5, "A0": 4.0, "B+": 3.5, "B0": 3.0, "C+":2.5, "C0":2.0, "D+": 1.5, "D0": 1.0, "F":0.0}

for i in range(20):
    _, credit, grade = input().split()
    if grade != "P":
        credits.append(float(credit))
        grades.append(translation[grade])

total_credits = sum(credits) 
total_grades = 0.0
for (c, g) in zip(credits, grades):
    total_grades += c*g
print(total_grades/total_credits)