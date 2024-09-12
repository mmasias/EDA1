def imprimir_linea(longitud=40, caracter='-'):
    print(caracter * longitud)

def imprimir_titulo(titulo):
    imprimir_linea(40, '=')
    print(titulo.upper())
    imprimir_linea(len(titulo))

def imprimir_subtitulo(subtitulo):
    imprimir_linea(len(subtitulo))
    print(subtitulo)
    imprimir_linea(len(subtitulo))

def main():
    imprimir_titulo("Primitivos")
    imprimir_subtitulo("Enteros")

    precio = 12
    otro_precio = precio
    print(precio == otro_precio)

    otro_precio = 24
    print(precio == otro_precio)

    otro_precio = 12
    print(precio == otro_precio)

    imprimir_subtitulo("Strings")

    cadena_texto = "Una cadena"
    otra_cadena = cadena_texto
    tercera_cadena = str("Una cadena")

    print(cadena_texto, otra_cadena, tercera_cadena)
    print(cadena_texto is otra_cadena)
    print(cadena_texto is tercera_cadena)

    cadena_texto = "XYZ"
    print(cadena_texto, otra_cadena, tercera_cadena)

    tercera_cadena = "ABC"
    print(cadena_texto, otra_cadena, tercera_cadena)

    imprimir_titulo("Listas")

    lista1 = [1, 2, 3]
    lista2 = lista1
    lista3 = [1, 2, 3]

    print("Las listas tienen el mismo contenido:", lista1 == lista3)
    print("Las listas son el mismo objeto:", lista1 is lista2)
    print("Las listas son diferentes objetos:", lista1 is not lista3)

    lista2[0] = 100
    print("Primer elemento de lista1:", lista1[0])

    imprimir_titulo("Objetos Personalizados")

    persona1 = Persona("Alice")
    persona2 = persona1
    persona3 = Persona("Alice")

    print("Los nombres son iguales:", persona1.nombre == persona3.nombre)
    print("Los objetos son el mismo objeto:", persona1 is persona2)
    print("Los objetos son diferentes objetos:", persona1 is not persona3)

    persona2.nombre = "Bob"
    print("Nombre de persona1:", persona1.nombre)

class Persona:
    def __init__(self, nombre):
        self.nombre = nombre

if __name__ == "__main__":
    main()
