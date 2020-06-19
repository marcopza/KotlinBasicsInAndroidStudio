package marcoperez.holamundo.others

//DOC: https://kotlinlang.org/docs/reference/visibility-modifiers.html

//Para hacer una clase "heredable" tenemos que marcarlo cómo open
//En Java es open por defecto y en Kotlin es final por defecto, así que no puede ser extendida sin el uso de 'open'

open class AccessModifiers {

    // private -- sólo visible dentro de la clase
    // protected -- sólo visible dentro de la clase y de sus subclases (herencia)
    // public -- visible desde dentro de la clase, desde sus subclases y desde fuera.

    val prop1 = "Public by defualt" //redundant modifier (son públicas por default)
    private val prop2 = "Marked as private"
    protected val prop3 = "Marked as protected"//protected es práctiamente private en clases final

    private fun showCase(){
        val test = AccessModifiers()
        test.prop1
    }

}

class AccessModifiersChild : AccessModifiers(){

    private fun showCase(){
        prop1
        this.prop1
    }

}