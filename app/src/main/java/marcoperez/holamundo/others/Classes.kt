package marcoperez.holamundo.others

import android.util.Log
import kotlin.math.log

class Classes {

    /*
    * DOC: https://kotlinlang.org/docs/reference/classes.html
    * DOC: https://kotlinlang.org/docs/reference/properties.html
    * DOC: https://kotlinlang.org/docs/reference/data-classes.html
    * DOC: https://kotlinlang.org/docs/reference/enum-classes.html
    * DOC: https://kotlinlang.org/docs/reference/object-declarations.html
     */
    //Clases son públicas y final por defecto
    //Si queremos que de una clase se pueda heredar, usamos open (open class ClassName)


    private fun showCase1(){
        //Las clases pueden tener un constructor primario y uno o más constructores secundarios
        //Primario se encuentra en la firma de la declaración de la clase.
        //Secundario se encuentra dentro de la declaración de la clase

        //Constructores primarios
        class Person1
        class Person2 constructor(var firstName: String) //constructor primario
        class Person3 (var firstName: String)// "constructor" puede ser omitido
        class Person4(val firstName: String, val lastName: String, var age: Int){
            init{
                /*
                * Se ejecuta después del constructor primario
                * Se ejecuta antes de los constructores secundarios
                 */
                age = 10
                //Los otros dos no se pueden cambiar porque son inmutables
            }
        }
        class Person5(val firstName: String = "Marco", val lastName: String = "Perez", var age: Int = 20)

        //Para crear instancias de objetos no usamos la palabra "new"
        val p1 = Person1()
        val p2 = Person2("Marco")
        val p3 = Person3("Marco")
        val p4 = Person4("Marco", "Perez", 20)
        val p5 = Person5("Roberto", "Lora", 27)
        val p5_2 = Person5()
        val p5_3 = Person5("Roberto")
        val p5_4 = Person5(age = 50)
    }

    private fun showCase2(){
        //Constructores secundarios son menos usados en Kotlin
        open class Person{
            constructor(firstName: String, lastName: String){
                Log.w("CLASSES-2", "Welcome $firstName $lastName!")
            }
        }

        class Person1 : Person {
            constructor(firstName: String) : super(firstName, "Perez")
            constructor(firstName: String, lastName: String) : super(firstName, lastName)
        }

        val p = Person1("Marco", "Perez")
        //No se puede acceder a firstName ni a LastName

    }

    private fun showCase3(){
        //Diferencia entre INIT y constructor secundario

        class Person1{
            init {
                Log.w("CLASSES-3", "Welcome from INIT!")
                //No se puede acceder a firstName ni lastName
            }
            constructor(firstName: String, lastName: String){
                Log.w("CLASSES-3", "Welcome from secondary constructor!")
            }
        }

        class Person2(firstName: String, lastName: String){
            init{
                //Aquí sí puede acceder a first y lastName
            }
            constructor() : this("Marco", "Perez")
        }

        val p1 = Person1("Marco", "Perez")
        val p2 = Person2()//Con dos o sin parámetros porque se mezclan los constructores.
        val p3 = Person2("Sebastián", "Lora")
    }

    private fun showCase4(){
        //VAL, VAR O NADA EN EL CONSTRUCTOR?
        class Person1(firstName: String)//No puedes acceder a firstName cuando crees la instancia
        class Person2(var firstName: String)//Puedes acceder a firstname cuando crees la instancia y puedes modificarlo.
        class Person3(val firstName: String)//Puedes acceder a firstName pero no puedes cambiar su valor

        val p1 = Person1("")
        val p2 = Person2("")
        val p3 = Person3("")
        // p1.firstName -> Error
        p2.firstName
        p3.firstName
    }

    private fun showCase5(){
        //Propiedades - Getters y Setters
        class Person1(var firstName: String)

        val p1 = Person1("Marco")
        p1.firstName //Sería equivalente getFirstname en Java
        p1.firstName = "Antonio" //Equivalente al setter

        class Person2{
            // field - representa a la propiedad, nunca usar this.propiedad
            var firstName: String
                get() = field.capitalize()
                set(value) {
                    field = value.capitalize()
                }
            constructor(firstName: String, lastName: String){
                this.firstName = firstName
            }
        }


    }

    private fun showCase6(){
        //Herencia e interfaces
        open class Person1(var name: String)
        open class Person2(open var name: String)
        open class Person3(open var name: String)

        //Si heredamos de Person1, las propiedades no se pueden llamar igual entre padre e hijo
        //class Person11(var name: String) : Person1(name)
        //Podemos mantener ambas con el mismo nombre, pero tenemos que añadir open y override
        class Person22(override var name: String) : Person2(name)

        //Todo junto
        class Person33(override var name: String, override var age: Int) : Person3(name), IPerson{
            override fun hello(){}
        }
    }

    private fun showCase7(){
        //Override y super
        abstract class Person(open var firstName: String, open var lastName: String){
            abstract fun hello()

            fun welcomeKotlin(){
                Log.w("CLASSES-5", "Welcome to Kotlin!")
            }

            open fun welcomeDevelopers(){
                Log.w("CLASSES-5", "Welcome developers!")
            }
        }

        class Man(override var firstName: String, override var lastName: String) : Person(firstName, lastName){
            override fun hello() {
                Log.w("CLASSES-7", "Hello, I am $firstName $lastName")
            }
            override fun welcomeDevelopers(){
                super.welcomeDevelopers()
                super.welcomeKotlin()
                Log.w("CLASSES-7", "Yay")
            }
        }

        val man = Man("Marco", "Perez")
        man.hello()
        man.welcomeKotlin()
        man.welcomeDevelopers()
    }

    private fun showCase8(){
        /*
        * Data classes
        * Según la documentación oficial, para hacer uso correcto de Data Classes debe:
        * El constructor primario necesita tener al menos 1 parámetro
        * Todos los parámetros del constructor primario ser marcados como "val" o "var"
        * Data classes no puede ser "abstract, open, sealed o inner"
         */

        data class Person(var firstName: String, var lastName: String)

        val p = Person("Marco", "Perez")
        val p2 = p
        val personString = p.toString()
        val personCopy = p.copy()
        val clone = p.copy(firstName = "Atnonio")//clon de todas pero cambia el firstName
        val (firstName, lastName) = p//Tiene destructuring

        Log.w("CLASSES-8", "Data class toString -> $personString")
        Log.w("CLASSES-8", "Data class copy() -> $personCopy")
        Log.w("CLASSES-8", "p must be the same reference as p2 -> ${p === p2}") // true, referencial
        Log.w("CLASSES-8", "p must have different reference than personCopy -> ${p !== personCopy}") // true, referencial
        Log.w("CLASSES-8", "p must have the same property values as personCopy -> ${p == personCopy}") // true, estructural
        Log.w("CLASSES-8", "p must have different reference than clone -> ${p !== clone}") // true, referencial
        Log.w("CLASSES-8", "p must have different values than clone -> ${p != clone}") // true, estructural
        Log.w("CLASSES-8", "firstName by destructuring must be 'Marco' -> $firstName")
        Log.w("CLASSES-8", "lastName by destructuring must be 'Perez' -> $lastName")
    }

    private fun showCase9(){
        //Enum classes

        Log.w("CLASSES-9", "ENUM DayOfWeek.MONDAY should be MONDAY -> ${DayOfWeek.MONDAY.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.MONDAY should be 0 -> ${DayOfWeek.MONDAY.ordinal}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.FRIDAY should be FRIDAY -> ${DayOfWeek.FRIDAY.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.FRIDAY should be FRIDAY -> ${DayOfWeek.FRIDAY.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.FRIDAY should be 4 -> ${DayOfWeek.FRIDAY.name}")
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
    }

}

interface IPerson{
    var age: Int
    fun hello()
}

enum class DayOfWeek { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}