package marcoperez.holamundo.others

import android.util.Log
import java.util.*

class Functions{

    //DOC: https://kotlinlang.org/docs/reference/functions.html
    //DOC: https://kotlinlang.org/docs/reference/inline-functions.html
    //DOC: https://kotlinlang.org/docs/reference/lambdas.html

    private fun showCase1(){
        //Funciones, parámetros y Unit

        fun function1(){}//declaración mínima
        val result1 = function1()//todas las funciones devuelven un objeto (Unit por default)
        fun function2(): Unit{}
        val result2: Unit = function2()

        //Los parámetros de las funciones necesitan especificar su tipo siempre
        fun function3(param1: String, param2: String): String{
            return "$param1, $param2"
        }
        val result3 = function3("Marco", "Perez")

        fun function4(param: Int = 5){}//recibe parámetro y si es vacío se le pasa 5
        fun function5(param: Int?){}//toca pasarle un parámetro que puede ser null o int
    }

    private fun showCase2(){
        //funciones con funciones como parámetros (callback) y llamados por lambda

        fun printSum(num1: Int, num2: Int, printer:(result: Int) -> Unit){
            printer(num1 + num2)
        }

        printSum(5, 5){ result ->
            Log.w("FUNCTIONS-2", "Lambda expression printing the sum result (10) -> $result")
        }

        //Si el callback recibe solo un parámetro, podemos omitir ese "result" -> it
        printSum(12, 12){
            Log.w("FUNCTIONS-2", "Lambda expression printing the sum result (10) -> $it")
        }

        fun printSum2(num1: Int, num2: Int, printer:(result: Int, param1: Int, param2:Int) -> Unit){
            printer(num1 + num2, num1, num2)
        }

        printSum2(7, 7){result, param1, param2 ->
            Log.w("FUNCTIONS-2", "Lambda expression printing the sum result (14) -> $result")
        }

        printSum2(7, 7){ result, _, _ ->//cambiar parámetros no usados por _ es buena práctica
            Log.w("FUNCTIONS-2", "Lambda expression printing the sum result (14) -> $result")
        }

    }

    private fun showCase3(){
        //Named arguments
        fun function1(firstName:String, lastName: String, age: Int, city: String, dateOfBirth: Date){
            //
        }
        function1("", "", 20, "", Date())
        function1(age =20, dateOfBirth = Date(), firstName = "Marco", city = "Cali", lastName = "Perez")
    }

    private fun showCase4(){
        //SingleExpression functions
        fun sum(param1: Int, param2: Int) = param1 + param2//retorna eso y se ahorra código

    }

    private fun showCase5(){
        //Variable number of arguments (Varargs)
        fun sumAll(vararg numbers: Int) = numbers.sum()

        val result = sumAll(1,2,3,4,5,6,7,8,9,10) //No se manda un array
        Log.w("FUNCTIONS-5", "vararg result is 55 $result")
    }

    private fun showCase6(){
        //Extension functions

        //Si es declarada dentro de este método, sólo tenemos acceso a ella en este mismo cntexto de función
        fun String.welcome(){
            Log.w("FUNCTIONS-6", "Welcome to Kotlin and to Extension Functions!")
        }
        //Estamos añadiendo el método welcome a la clase String, entonces
        "".welcome() // Llama al método de arriba!!!!
    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        "".welcomeKotlin()
    }

}
//Si se hace por fuera de la clase, se puede acceder desde toda la app!
fun String.welcomeKotlin(){
    Log.w("FUNCTIONS-6", "Welcome to Kotlin and to Extension Functions Globally!")
}