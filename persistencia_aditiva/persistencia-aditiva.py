n = input("Digite un numero: ")
arr = list(str(n))
count = 0
while(len(arr) > 1):
    sum = 0
    for value in arr:
        sum += int(value)
    arr = list(str(sum))
    count += 1

print("Persistencia aditiva = " + str(count))