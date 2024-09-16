function main() {
    imprimirTitulo("Primitivos");

    imprimirSubtitulo("Números");

    let precio = 12;
    let otroPrecio = precio;
    console.log(precio === otroPrecio);

    otroPrecio = 24;
    console.log(precio === otroPrecio);

    otroPrecio = 12;
    console.log(precio === otroPrecio);

    imprimirSubtitulo("Strings");

    let cadenaTexto = "Una cadena";
    let otraCadena = cadenaTexto;
    let terceraCadena = new String("Una cadena").valueOf();

    console.log(cadenaTexto, otraCadena, terceraCadena);
    console.log(cadenaTexto === otraCadena);
    console.log(cadenaTexto === terceraCadena);

    imprimirTitulo("Arrays");

    let array1 = [1, 2, 3];
    let array2 = array1;
    let array3 = [...array1]; 

    console.log("Los arrays tienen el mismo contenido:", JSON.stringify(array1) === JSON.stringify(array3));
    console.log("Los arrays son el mismo objeto:", array1 === array2);
    console.log("Los arrays son diferentes objetos:", array1 !== array3);

    array2[0] = 100;
    console.log("Primer elemento de arr1:", array1[0]);

    imprimirTitulo("Objetos");

    let objeto1 = { nombre: "Alice" };
    let objeto2 = objeto1;
    let objeto3 = { ...objeto1 }; 

    console.log("Los nombres son iguales:", objeto1.nombre === objeto3.nombre);
    console.log("Los objetos son el mismo objeto:", objeto1 === objeto2);
    console.log("Los objetos son diferentes objetos:", objeto1 !== objeto3);

    objeto2.nombre = "Bob";
    console.log("Nombre de Objeto1:", objeto1.nombre);
}

main();


function imprimirLinea(longitud = 40, caracter = '-') {
    console.log(caracter.repeat(longitud));
}

function imprimirTitulo(titulo) {
    imprimirLinea(40, '=');
    console.log(titulo.toUpperCase());
    imprimirLinea(titulo.length);
}

function imprimirSubtitulo(subtitulo) {
    imprimirLinea(subtitulo.length);
    console.log(subtitulo);
    imprimirLinea(subtitulo.length);
}