package marcoperez.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import marcoperez.holamundo.others.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Corre los logs
        Variables().showCases()
        Nullable()//si llamamos a showCases tendremos NPE.
        Operators().showCases()
        ControlFlow().showCases()
        Classes().showCases()
        Functions().showCases()
        CompanionObject().showCases()
        "".welcomeKotlin()//Hasta aquí se puede usar!
    }
}