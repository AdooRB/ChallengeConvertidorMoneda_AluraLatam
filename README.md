<h1 align = "center">Challenge Convertidor de Modeda </h1>

<p align = "center">

![Static Badge](https://img.shields.io/badge/Estado-En%20Desarrollo-purple?style=for-the-badge)

![Static Badge](https://img.shields.io/badge/Actualizado-Mayo%202025-greenlight?style=for-the-badge)

</p>

# Indice

*   [Descripción](#Descripción)

*   [Funcionalidad](#Funcionalidad)

*   [Acceso del Proyecto](#Acceso-del-Proyecto)

*   [Apoyos y Herramientas](#Apoyos-y-Herramientas)

*   [Diagrama de Flujo](#Diagrama-de-Flujo)

*   [Desarrollador](#Desarrollador)

<br>

# Descripción
   Este Challenge forma parte del curso Alura Latam del grupo G8. Consiste en crear una aplicación que convierta diferentes divisas.

# Funcionalidad
<p>
Al ejecutar la aplicación se muestra el menú sobre las opciones de conversión, historial y salir de la aplicación.
</p>
Como se muestra en la siguiente imagen.
-------------Imagen Menu--------------------

### Mostrar el resultado
<p>
Una vez que se haya elgindo una opción y la cantidad a convertir, se mostrará la cantidad original con su divisa largo (nnombreDivisa) y la cantidad convertida con su nombre largo.
</p>
Como se muestra a continuación:  
--------------Imagen Resultado----------

### Mostrar historial
<p>
Al elegir la opción historial, se desplegará el listado almacendo con un formato: numeral, fecha, Hora, y la conversión en formato corto.
</p>
Como en la siguiente imagen:

------imagen historial----------

### Agregar divisas

<p align="justify">    
En la clase Principal.java, tiene el objeto "Menu", se encarga de generar el menú de divisas; pero antes se definen las divisas a mostrar en el menú. Esto se hace con el método del objeto menu <b>agregarDivisa(divisa, nombreDivisa)</b>.
</p>

 Como se muestra en el código:
    
```Java
    menu.agregarDivisa("USD", "Dólar");
    menu.agregarDivisa("JPY", "Yen");
    menu.agregarDivisa("BRL", "Real");
    menu.agregarDivisa("MXN", "Peso Mexicano");
```

Se observa, dos parámetros en el método 'agregarDivisa' :
* <b>divisa: </b>  hace referencia al código ISO de la divisa. Como el <i><u>peso mexicano</u></i> es <i><u>MXN</u></i>.
* <b>nombreDivisa</b>: hace referencia el nombre largo de la divisa. Como <i><u>dólar canadiense</i></u>, <i><u>dólar estaudense</i></u>, porque hay muchos tipos.

<b>Nota: </b>Es importante que esté bien la <i>divisa (parámetro)</i> para que funcione correctamente la aplicación.

### Divisa Principal
<p align = "justify"> 
La divisa principal se encargará de ser el cambio de moneda común en todas las opciones del menú. Al igual en "Agregar Divisas", se define desde el objeto menu con el método <b>setDivisaPrincipal(divisa)</b>.
</p>


```Java
menu.setDivisaPrincipal("USD");
```
<p align = "justify">
Se observa, el único parámetro es divisa, se debe a la nesesidad de colocar la divisa principal al menu con el método <b>agregarDivisa</b> también, donde se define el nombre de la divisa.
</p>

### Historial
<p align = "justify">
El historial siempre es la penúltima opción del menú. Para que esté actualizando cada vez que se ejecute la aplicación, se guarda los datos en un archivo json.
<br> 
Este archivo json se encuentra como "Notas.jason", y se está actualizando cada vez que se hacer  una conversión. Si se requiere eleminar el historial, se tiene que borrar el archivo de manera manual.
</p>

# Acceso del Proyecto


# Apoyos y Herramientas


# Diagrama de Flujo


# Desarrollador

|[<img src="https://avatars.githubusercontent.com/u/68716029?s=400&u=0469787aea0aaff6920dc019417972c5471cd8ba&v=4" width=115><br><sub>Aldo Flores</sub>](https://github.com/AdooRB)|
| :---: |