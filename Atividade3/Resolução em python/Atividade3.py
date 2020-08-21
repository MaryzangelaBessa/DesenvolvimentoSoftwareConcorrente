from threading import Thread
from random import randint

# Equipe: Eduardo e Maryzangela

#arrayC = [9,8,7,6,5,4,3,2,1,0]
arrayC = [9,8,8,6,5,4,4,2,1,1]

print("Lista Desordenada: ", arrayC)

Ordenado = False

# ordenacao por pares
def ordenacao (arrayC, i, j):
    global Ordenado
    if arrayC[i] > arrayC[j]:
        arrayC[i], arrayC[j] = arrayC[j], arrayC[i]
        Ordenado = False

while not Ordenado:
    Ordenado = True

    threadsP = []

    for i in range(0, len(arrayC), 2):
        t = Thread(target=ordenacao, args=(arrayC, i, i+1))
        t.run()
        threadsP.append(t)

    (t.join() for t in threadsP)
        
    threadsI = []

    for i in range(1, len(arrayC)-1, 2):
        t = Thread(target=ordenacao, args=(arrayC, i, i+1))
        t.run()
        threadsI.append(t)

    (t.join() for t in threadsI)

print("Lista Ordenada:    ", arrayC)