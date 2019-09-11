package modeloDePresentacion

import model.DigitalWallet
import model.User
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.annotations.Transactional


@Observable
@Transactional

class DigitalWalletController(var digitalWallet: DigitalWallet) {


    var users= digitalWallet.users
    var filtrarUsuarios:MutableList<User> = users.toMutableList()
    var filtrar:String?=""
        set(value){
            field=value.toString().toLowerCase()
            buscar()
        }

    private fun buscar() {
        filtrarUsuarios=users.filter { it.firstName.toLowerCase()
                .contains(filtrar.toString()) }.toMutableList()
    }




    fun login(email: String, password: String) {
        digitalWallet.login(email,password)
    }
    fun initUser()=User("0", "",
               "", "",
               "", false)

    fun addUser(user: User)=digitalWallet.register(user)




}