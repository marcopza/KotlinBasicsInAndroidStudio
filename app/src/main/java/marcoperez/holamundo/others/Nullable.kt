package marcoperez.holamundo.others

class Nullable {

    //DOC : https://kotlinlang.org/docs/reference/null-safety.html

    /*
    *Operadores relaciones con la nulabilidad:
    *   - only-safe (?)
    *   - non-null asserted (!!)
    *
    * Sistemas de tipado de Kotlin está pensado en eliminar de nuestro código el NullPointerException
    * Los cuatro únicos posibles casos para NPE son:
    *   1) Una llamada explícita al error NullPointerException()
    *   2) Uso del operador !!
    *   3) Código externo Java
    *   4) Alguna incosistencia de datos en relación a la inicialización
     */

    private lateinit var variable1: String
    private var variable2: String? = null

    private fun showCase1(){
        throw NullPointerException()
    }

    private fun showCase2(var1: String?){
        var1.toString() // Devuelve null en caso de que var1 sea null
        var1!!.toString() // Lanza NullPointerException en caso de que var1 sea null
    }

    private fun showCase3(){
        //Se debería de crear una clase en Java y se llama.
    }

    private fun showCase4(){
        variable1.length // Devuelve un NPE porque variable1 no ha sido lateinit y se ha marcado cómo tal
        //variable2.length Kotlin no deja porque debo usar ? o !!
        variable2?.length
        variable2!!.length
    }

    fun showCases(){
        showCase1()
        showCase2("")
        showCase3()
        showCase4()
    }
}