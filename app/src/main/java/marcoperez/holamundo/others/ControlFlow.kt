package marcoperez.holamundo.others

import android.util.Log

class ControlFlow {

    //DOC : https://kotlinlang.org/docs/reference/control-flow.html

    private fun showCase1(){
        //If
        val num1 = 5
        val num2 = 10
        if(num1 > num2){
            Log.w("CCONTROL-FLOW-1", "NUM1 es mayor que NUM1")
        }
        if(num1 < num2){
            Log.w("CCONTROL-FLOW-1", "NUM2 es mayor que NUM1")
        }
    }

    private fun showCase2(){
        //If else
        val num1 = 5
        val num2 = 10
        if(num1 > num2){
            Log.w("CCONTROL-FLOW-2", "NUM1 es mayor que NUM1")
        }else{
            Log.w("CCONTROL-FLOW-2", "NUM2 es mayor que NUM1")
        }
        //Como expresión; no es buena práctica
        if(num1 > num2) Log.w("CONTROL-FLOW-2", "NUM1 es mayor que NUM2") else Log.w("CCONTROL-FLOW-1", "NUM2 es mayor que NUM1")
        //Como expresión asignando a una variable externa; mejor que el de arriba.
        val result = if(num1 > num2) num1 else num2
    }

    private fun showCase3(){
        //When (equivalente a un switch de Java)
        val x = 1

        // Con argumentos (x)
        when (x) {
            1 -> Log.w("CONTROL-FLOW-3", "x === 1")//case 1
            2 -> Log.w("CONTROL-FLOW-3", "x === 2")//case 2
            else -> Log.w("CONTROL-FLOW-3", "x es otr número")//case default (no es obligatorio en este caso)
        }

        when (x){
            0, 1 -> Log.w("CONTROL-FLOW-3", "x === 1 o x ===1")//case 0 y 1
        }

        // Sin argumento (x)
        when {
            (x % 2 == 0) -> Log.w("CONTROL-FLOW-3", "El número es par")
            (x % 2 == 1) -> Log.w("CONTROL-FLOW-3", "El número es impar")
        }

        //Sin argumento y devolviendo un valor
        val isEven = when{
            (x % 2 == 0) -> true
            else -> false
        }
    }

    private fun showCase4(){
        //For
        val numbers = arrayOf(1, 2, 3, 4, 5)

        for(number in numbers) Log.w("CONTROL-FLOW-4", number.toString())

        // Especificando el tipo
        for(number: Int in numbers){
            Log.w("CONTROL-FLOW-4", number.toString())
        }

        // Con índices
        for((index, number) in numbers.withIndex()){
            //withIndex() retorna dos variables por cada uno de los valores del array
            Log.w("CONTROL-FLOW-4", "$index: $number")
        }

    }

    private fun showCase5(){
        //while & do while
        var x = 10

        while(x > 0){
            Log.w("CONTROL-FLOW-5", x--.toString())
        }

        do{
            Log.w("CONTROL-FLOW-5", "Primera y única iteración")
        }while(x > 0)
    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
    }

}