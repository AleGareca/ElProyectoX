package modeloDePresentacion
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable

@Observable
class LoginController( val digitalWalletConstroller: DigitalWalletController) {

    var email:String=""
    var password:String=""
    var esLogiable:Boolean= true

   /* @Dependencies("res")
    fun esLogiable(): Boolean {
        val v = users.count { it.email == email && it.password == password }
        var res = (v == 0)
        return res
    }*/

    fun validarUsuario() {
        digitalWalletConstroller.login(email, password)
    }
}