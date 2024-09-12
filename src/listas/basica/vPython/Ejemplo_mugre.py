from List_mugre import List

def view_line(nephews):
    print("LA FILA" + "-" * 18)
    for nephew in nephews.list_all():
        print(nephew)
    print("-" * 25)

def main():
    nephews = List()

    view_line(nephews)
    print(f"Esta vacia? {nephews.is_empty()}")

    nephews.insert_end("Juanito")
    nephews.insert_end("Pepito")
    nephews.insert_end("Anita")
    print(f"Esta vacia? {nephews.is_empty()}")

    view_line(nephews)

    nephews.insert_end("Luisito")
    print(f"Tamaño: {nephews.size()}")

    nephews.delete()
    print(f"Tamaño: {nephews.size()}")

    view_line(nephews)

if __name__ == "__main__":
    main()
