"""Decodes a given Base64 into ASCII.
   By Crispin A. Stichart"""

def decode(string):
    binary = convert_to_binary(string)
    if string[-1] == "=":
        padding = 1
        binary = binary >> 8 #six bits to get rid of "=" and
    elif string[-2] == "==": #two to get rid of padding
        padding == 2
        string = string[:-2]
        binary = binary >> 16 #(2*6) for the "==" + 4 for padding

    #chars is number of ASCII characters
    chars = (len(bin(binary)) -1 // 8)
    ascii = ""

    for char in range(chars-1, -1, -1):
        code = binary >> (8 * char)
        binary = binary - (code << (8*char))
        ascii += chr(code)        
    return ascii

def convert_to_binary(string):
    """Takes a string and packs each letter into an integer,
       then returns that number."""
    binary = 0
    count = len(string)-1
    for letter in string:
        code = ord(letter)
        if 65 <= code <= 90:
            b64 = (code - ord("A"))
        if 97 <= code <= 122:
            b64 = (code - ord("a") + 26)
        if 48 <= code <= 57:
            b64 = (code - ord("0") + 52)
        if code == ord("+"):
            b64 = 62   
        if code == ord("/"):
            b64 = 63
        binary = binary + (b64 << (6*count))
        count -= 1
    return binary

if __name__ == "__main__":
    print("Give me a line of Base64, and I'll give you the ASCII!")
    print("Give me a blank line (Just press enter!) to quit me.")
    while True:
        user_input = input(">>> ")
        if user_input == "": break
        print(decode(user_input))
        print("")
    print("Bye!") 