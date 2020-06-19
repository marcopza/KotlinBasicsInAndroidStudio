package marcoperez.holamundo.others

import android.util.Log

// DOC: https://kotlinlang.org/docs/reference/basic-types.html
/*
* En Kotlin todo es un objeto!
* No hay primitivos en cuanto al usuario conscierne; en runtime algunos sí pueden.
* No existe void. Si algo no devuelve nada, devuelve Unit object.
* Las variables pueden ser mutables o inmutables.
* Se deben usar inmutables siempre que sea posible (buena práctica)
* var es mutable; val es inmutable.
* Los tipos son definidos después del nombre de la variable con dos puntos espacio.
* (var nombre: tipo; val nombre: tipo)
* usar ; no es necesario, se considera buena práctica no usurlos
 */
class Variables{

    private var variable0 = 1 //Acá no se le da tipo; se infiere.
    private var variable1 = 1.toByte()
    private var variable2 = -123
    private var variable3 = 2147483648
    private var variable4 = 1.1.toFloat()
    private var variable5 = 1.9
    private var variable6 = 'a'
    private var variable7 = "a"
    private var variable8 = true
    private var variable9 = arrayOf(1, 2, 3, 4, 5)
    private var variable10 = arrayOfNulls<Int>(10)
    private val variable11 = "Esta variable es read-only/inmutable/constantes"

    //Show Case para Byte
    private fun showCase1() {
        Log.w("VARIABLE-0","Es variable0 un Int? -->" + (variable0 is Int) + "Por qué no un Byte?")
        Log.w("VARIABLE-0","Es variable1 un Byte? -->" + (variable1 is Byte) + "Por qué no un Int?")
    }

    //Show Case para Int
    private fun showCase2() {
        Log.w("VARIABLE-2","Es un valor Integer")
        variable2 = Int.MAX_VALUE
    }

    //Show Case para Long
    private fun showCase3() {
        Log.w("VARIABLE-2","Es un valor Long? -->" + (variable3 is Long))
    }

    //Show Case para Float
    private fun showCase4() {
        Log.w("VARIABLE-4","Es un valor Float? -->" + (variable4 is Float))
    }

    //Show Case para Double
    private fun showCase5() {
        Log.w("VARIABLE-5","Es un valor Double? -->" + (variable5 is Double))
    }

    //Show Case para Char
    private fun showCase6() {
        Log.w("VARIABLE-6","Es un valor Char? -->" + (variable6 is Char))
    }

    //Show Case para String
    private fun showCase7() {
        Log.w("VARIABLE-7","Es un valor String? -->" + (variable7 is String))

        // String literals
        variable7 = "¡Hola Mundo!¬\n¡Adiós Mundo!" //Estilo Java
        variable7 = """
                        ¡Hola Mundo!
                        ¡Adiós Mundo!
                    """ //Estilo Kotlin

        //String Templates
        var points = 9
        var maxPoints = 10
        variable7 = "Hola, tengo " + points + " puntos sobre " + maxPoints//Java
        variable7 = "Hola, tengo $points puntos sobre $maxPoints"
        variable7 = "Hola, tengo ${points *10} puntos sobre ${maxPoints * 10}"
    }

    //Show Case para Boolean
    private fun showCase8() {
        Log.w("VARIABLE-8","Es un valor Boolean? -->" + (variable8 is Boolean))
    }

    //Show Case para Array<Int>
    private fun showCase9() {
        Log.w("VARIABLE-9","Es un valor Array<Int>? -->" + (variable9 is Array<Int>))
    }

    //Show Case para Array<Int?>
    private fun showCase10() {
        Log.w("VARIABLE-10","Es un valor Array<Int?>? -->" + (variable10 is Array<Int?>))

        //variable10[0].toFloat() No deja porque puede ser null
        variable10[0]?.toFloat()//Safe calls -- en caso de ser null, devuelve null
        variable10[0]?.toFloat() ?: "Error"//Elvis Operator -- Si es null, devuelve "Error"
        //variable10[0]!!.toFloat() //The !! operator - cuando estamos seguros que no es nulo al 100%, si lo fuera lanza NullPointer

    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase8()
        showCase9()
        showCase10()
    }

}