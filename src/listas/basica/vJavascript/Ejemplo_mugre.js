const List = require('./List_mugre');

function viewLine(list) {
    const array = list.listAll();
    console.log("LA FILA" + "-".repeat(18));
    array.forEach(sobrino => {
        console.log(sobrino);
    });
    console.log("-".repeat(25));
}

const nephews = new List();

viewLine(nephews);
console.log("Esta vacia? " + nephews.isEmpty());

nephews.insertEnd("Juanito");
nephews.insertEnd("Pepito");
nephews.insertEnd("Anita");

console.log("Esta vacia? " + nephews.isEmpty());

viewLine(nephews);

nephews.insertEnd("Luisito");

console.log("Tamaño: " + nephews.size());

nephews.delete();
console.log("Tamaño: " + nephews.size());

viewLine(nephews);
