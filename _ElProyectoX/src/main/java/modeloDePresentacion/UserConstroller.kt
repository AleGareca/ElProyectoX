package modeloDePresentacion

import model.User
import org.uqbar.commons.model.annotations.Observable


@Observable
class UserConstroller(

    var idCard:String="",
    var firstName:String="",
    var lastName:String="",
    var email:String="",
    var password:String="",
    var isAdmin:Boolean=true){

    fun createUser():User= User(idCard, firstName, lastName, email, password, isAdmin)


}


