<?php

function imprimirLinea($longitud = 40, $caracter = '-') {
    echo str_repeat($caracter, $longitud) . PHP_EOL;
}

function imprimirTitulo($titulo) {
    imprimirLinea(40, '=');
    echo strtoupper($titulo) . PHP_EOL;
    imprimirLinea(strlen($titulo));
}

function imprimirSubtitulo($subtitulo) {
    imprimirLinea(strlen($subtitulo));
    echo $subtitulo . PHP_EOL;
    imprimirLinea(strlen($subtitulo));
}

imprimirTitulo("Primitivos");

imprimirSubtitulo("Números");

$precio = 12;
$otroPrecio = $precio;
echo ($precio === $otroPrecio ? "true" : "false") . PHP_EOL;

$otroPrecio = 24;
echo ($precio === $otroPrecio ? "true" : "false") . PHP_EOL;

$otroPrecio = 12;
echo ($precio === $otroPrecio ? "true" : "false") . PHP_EOL;

imprimirSubtitulo("Strings");

$cadenaTexto = "Una cadena";
$otraCadena = $cadenaTexto;
$terceraCadena = "Una cadena";

echo "$cadenaTexto - $otraCadena - $terceraCadena" . PHP_EOL;
echo ($cadenaTexto === $otraCadena ? "true" : "false") . PHP_EOL;
echo ($cadenaTexto === $terceraCadena ? "true" : "false") . PHP_EOL;

imprimirTitulo("Arrays");

$array1 = array(1, 2, 3);
$array2 = $array1;
$array3 = $array1;  

echo "Los arrays tienen el mismo contenido: " . (json_encode($array1) === json_encode($array3) ? "true" : "false") . PHP_EOL;
echo "Los arrays son el mismo objeto: " . ($array1 === $array2 ? "true" : "false") . PHP_EOL;
echo "Los arrays son diferentes objetos: " . ($array1 !== $array3 ? "true" : "false") . PHP_EOL;

$array2[0] = 100;
echo "Primer elemento de arr1: " . $array1[0] . PHP_EOL;

$array4 = [1, 2, 3];
$array5 = &$array4;
$array5[0] = 100;
echo "array4[0]: " . $array4[0] . "\n";  


imprimirTitulo("Objetos");

$objeto1 = (object) ['nombre' => "Alice"];
$objeto2 = $objeto1;
$objeto3 = clone $objeto1;  

echo "Los nombres son iguales: " . ($objeto1->nombre === $objeto3->nombre ? "true" : "false") . PHP_EOL;
echo "Los objetos son el mismo objeto: " . ($objeto1 === $objeto2 ? "true" : "false") . PHP_EOL;
echo "Los objetos son diferentes objetos: " . ($objeto1 !== $objeto3 ? "true" : "false") . PHP_EOL;

$objeto2->nombre = "Bob";
echo "Nombre de obj1: " . $objeto1->nombre . PHP_EOL;

?>
