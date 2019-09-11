package vista

import model.User
import modeloDePresentacion.UserConstroller
import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner


class VentanaDeAgregarUsuario(owner:WindowOwner,model:UserConstroller?): Dialog<UserConstroller>(owner,model) {
    override fun createFormPanel(mainPanel: Panel?) {
        Panel(mainPanel) with {
            asVertical()
            Label(it).setText("Nombre")
            TextBox(it) bindTo "firstName"
            Label(it).setText("Apellido")
            TextBox(it) bindTo "lastName"
            Label(it).setText("Correo electronico")
            TextBox(it) bindTo "email"
            Label(it).setText("Constraseña")
            TextBox(it) bindTo "password"
            Label(it).setText("es Administador")
            CheckBox(it) bindTo "isAdmin"
            Button(it)with {
                caption="Aceptar"
                onClick{
                    thisWindow.modelObject.createUser()
                    accept()}
            }
        }
    }
}