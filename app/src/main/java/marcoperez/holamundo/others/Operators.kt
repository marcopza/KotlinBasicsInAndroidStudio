package marcoperez.holamundo.others

import android.util.Log

class Operators {

    //DOC: https://kotlinlang.org/docs/reference/keyword-reference.html
    //DOC: https://kotlinlang.org/docs/reference/equality.html

    /*
    *En esta clase se hace énfasis en las igualdades.
     */

    private fun showCase1(){
        var a = 5
        var b = 5

        //Curioso: Aquí sí los trata cómo primitivos por lo que la comparación referencial está deprecated.
        Log.w("OPERATORS-1", "Igualdad referencial. Es 'a' igual a 'b'? ${a === b}")// true
        //Aquí no da warning
        Log.w("OPERATORS-1", "Igualdad estructural. Es 'a' igual a 'b'? ${a == b}")// true
    }

    private fun showCase2(){
        val pn1 = PersonNormal()
        val pn2 = PersonNormal()
        Log.w("OPERATORS-1", "Igualdad referencial. Es 'pn1' igual a 'pn1'? ${pn1 === pn2}")// false
        Log.w("OPERATORS-1", "Igualdad estructural. Es 'pn1' igual a 'pn2'? ${pn1 == pn2}")// false porque no sobreescribe equals
    }

    private fun showCase3(){
        val pn1 = PersonEqualOverride()
        val pn2 = PersonEqualOverride()
        Log.w("OPERATORS-1", "Igualdad referencial. Es 'pn1' igual a 'pn1'? ${pn1 === pn2}")// false
        Log.w("OPERATORS-1", "Igualdad estructural. Es 'pn1' igual a 'pn2'? ${pn1 == pn2}")// true
    }

    private fun showCase4(){
        val pn1 = PersonDataClass()//Marco, 20
        val pn2 = PersonDataClass()//Marco, 20
        val pn3 = PersonDataClass("Sebastian")//Sebastian, 20
        Log.w("OPERATORS-1", "Igualdad referencial. Es 'pn1' igual a 'pn1'? ${pn1 === pn2}")// false
        Log.w("OPERATORS-1", "Igualdad estructural. Es 'pn1' igual a 'pn2'? ${pn1 == pn2}")// true
        Log.w("OPERATORS-1", "Igualdad estructural. Es 'pn1' igual a 'pn2'? ${pn1 == pn3}")// false
    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
    }

    class PersonNormal{
        val name = "marco"
    }

    class PersonEqualOverride{
        val name = "marco"
        override fun equals(other: Any?): Boolean {
            if (other === null) return false
            if (other is PersonEqualOverride){
                return other.name === this.name
            }
            return false
        }
    }

    data class PersonDataClass(val name: String = "Marco", val age: Int = 20)

}