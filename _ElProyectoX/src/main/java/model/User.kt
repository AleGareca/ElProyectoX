package model

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable



@Accessors

@Observable

data class User(
        var  idCard: String,
        var firstName: String,
        var lastName: String,
        var email: String,
        var password: String,
        var isAdmin: Boolean
){
    /*var account: Account? = null
        set(value) {
            if (field != null) throw UnsupportedOperationException("User already have account")
            field = value
        }
*/
    fun fullName() = "$firstName $lastName"


}
