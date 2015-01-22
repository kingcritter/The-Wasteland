"""Totes a program"""

def fizzbuzz(n):
    """Does the FizzBuzz thing n times"""
    for x in range(1, n+1):
        if x % 5 == 0 and x % 3 == 0:
            print("FizzBuzz")
        elif x % 3 == 0:
            print("Fizz")
        elif x % 5 == 0:
            print("Buzz")
        else:
            print(x)

if __name__ == "__main__":
    fizzbuzz(30)
