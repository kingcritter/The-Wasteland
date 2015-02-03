def calculate(string):
    operators = ["+", "-", "/", "*"]
    digits = []
    for character in string:
        if (not character.isdigit() and character not in operators
            and character != " "):
            return "Invalid character detected " + character
        digits.append(character)
    current = []
    for digit in digits:
        if digit.isdigit():
            current.append(int(digit))
        elif digit == "+":
            current = [sum(current)]
        elif digit == "-":
            for number in current[1:]:
                current[0] -= number
            current = [current[0]]
        elif digit == "*":
            for number in current[1:]:
                current[0] *= number
            current = [current[0]]
        elif digit == "/":
            for number in current[1:]:
                if number == 0:
                    return "OH SHIT A ZERO"
                current[0] /= number
            current = [current[0]]
    return current 

print(calculate("4 2 + 1 - 2 /"))
print(calculate("10 3 /"))
print(calculate("4 2 + 1 4 - 2 /"))