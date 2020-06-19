package marcoperez.holamundo.others

import android.util.Log

class Interfaces {

    //DOC : https://kotlinlang.org/docs/reference/interfaces.html

    private var anonymousObjectImplementingInterface: Any? = null

    private fun showCase1(){

        anonymousObjectImplementingInterface = object : Interface1 {
            override fun abstractMethod() {
                //Poner código es totalmente opcional pero toca sobreescribirlo
            }
        }
        //Se debe castear cómo la interfaz porque anonymousOb.. es Any por lo que Kotlin dice que puede cambiar
        //Con el 'as' nos aseguramos que sea un object anónimo de Interface1
        (anonymousObjectImplementingInterface as Interface1).methodWithImplementationByDefault()
        (anonymousObjectImplementingInterface as Interface1).abstractMethod()
    }

    private fun showCase2(){

        //Con esto se determina el tipo (objeto anónimo que implementa la interfaz 2)
        val aoii = object : Interface2{
            override val propertyAbstract: Int
                get() = 10
        }
        //No es necesario hacer el casteo.
        aoii.propertyAbstract
        aoii.propertyWithImplementation
        aoii.hello()
    }

    fun showCases(){
        showCase1()
        showCase2()
    }

}

//Es buena práctica hacerlas en diferentes archivos.

interface Interface1{

    //sin implementación Kotlin lo hace abstracto por lo que poner abstract es redudante
    fun abstractMethod()

    fun methodWithImplementationByDefault(){

    }

}

interface Interface2{

    //Es abstracta pues no tiene valor asigando.
    val propertyAbstract: Int
    var propertyWithImplementation: String
        get() = "ByDefault"
        set(value)  {this.propertyWithImplementation = value}
    fun hello(){
        Log.w("INTERFACE-2", "Is it working $propertyWithImplementation?, Yay! $propertyAbstract :)")
    }
}