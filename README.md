# U3_a14felipecm
U3_a14felipecm

#Unidade 3 - Práctica
  Nesta ocasión imos crear unha aplicación coas seguintes características:

##Nome do proxecto
  Nome do proxecto e da activity principal: U3_nome_de_pila

##Activity Principal

    Botón: "DATOS/TELEFONO/BUSCADOR"
    Se se fai Click lanza unha segunda activity na que poder introducir unha cadea de texto e un teléfono (fai que a caixa de texto do teléfono amose o teclado numérico).
    Se se fai longClick lánzase un cadro de diálogo onde o usuario pode escoller lanzar o teléfono marcando por defecto o número introducido no paso anterior ou ben lanzar o buscador de google buscando por defecto o texto introducido no paso anterior.
    Se non introduxo o número de teléfono non se debe continuar e débese sacar un Toast de aviso.
    Se non introduxo unha cadea de búsqueda buscará por defecto a palabra casa.

##Botón: "DATOS"

    Se se fai Click realiza un Toast amosando a cadea e teléfono indicados polo usuario na actividade secundaria.
    Se se xira o dispositivo en apaisado e se volve premer no botón debe amosar o mesmo resultado que en vertical.
    Non se poden usar atributos de clase (é necesario gardar o estado da activity)
    Lembrar os métodos que se executan no ciclo de vida cando se xira o dispositivo.

##Activity secundaria

    EditText: que pida a cadea de búsqueda e o teléfono. O teclado que debe aparecer no caso do teléfono é o numérico.
    Botón: Pechar: realiza o necesario para pasarlle os datos indicados polo usuario á activity chamadora e pecha a activity secundaria.

