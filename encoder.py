# Crispin A. Stichart
# Assignment 1


user_input = "D"
container = 0
padding = 0

if len(user_input) % 3 != 0:
    if len(user_input)+1 % 3 == 0:
        padding = 1
    else: padding = 2


for letter in user_input:
    container = ord(letter) + (container << 8)
print(bin(container))


if padding == 2:
    container = container << 4
elif padding == 1:
    container = container << 8 
print(bin(container))

chars = (len(bin(container)) - 1) // 6
print(chars)
code = 0
b64 = ""
for char in range(chars-1, -1, -1):
    code = container >> (6 * char)
    container = container - (code << (6*char))
    if 0 <= code <= 25:
        b64 += chr(code + ord("A"))
    if 26 <= code <= 51:
        b64 += chr(code + ord("a") - 26)
    if 52 <= code <= 61:
        b64 += chr(code + ord("0") - 52)
    if code == 62:
        b64 += "+"   
    if code == 63:
        b64 += "/"   
b64 += "=" * padding
print(b64)