package vista
import model.DigitalWallet
import model.User
import modeloDePresentacion.DigitalWalletController
import modeloDePresentacion.LoginController
import modeloDePresentacion.UserConstroller
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow


fun main(){

    var pedro= User("123","Pedro","Sosa","123@gmail.com","123",false)
    var digitalWallet=DigitalWallet()
    digitalWallet.register(pedro)
    print(digitalWallet.users.size)
    VentanaLogin(LoginController(DigitalWalletController(digitalWallet))).startApplication()

}



class VentanaLogin(model: LoginController):MainWindow<LoginController>(model) {
    override fun createContents(mainPanel: Panel?) {
        title = "Login"

        Panel(mainPanel) with {
            asVertical()
            ErrorsPanel(it, "")
            Label(it).setText("Correo electronico")
            TextBox(it).bindTo("email")
            Label(it).setText("Contraseña")
           // PasswordField(it).bindTo("password")
            Button(it) with {
                caption = "Ingresar"
                bindEnabledTo("esLogiable")
                onClick {
                       // thisWindow.modelObject.validarUsuario()
                      // thisWindow.close()
                    VentanaDeAdministracion(thisWindow,thisWindow.modelObject.digitalWalletConstroller).open()
                }
            }
        }

    }
}





