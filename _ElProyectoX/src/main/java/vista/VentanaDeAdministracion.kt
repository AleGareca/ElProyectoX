package vista


import model.User
import modeloDePresentacion.DigitalWalletController
import modeloDePresentacion.UserConstroller

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.WindowOwner

class VentanaDeAdministracion(owner:WindowOwner,model: DigitalWalletController?):
       Dialog<DigitalWalletController>(owner,model) {
    override fun createFormPanel(mainPanel: Panel) {
        title = "Ventana de Administraion"
         setMinHeight(250)
        ErrorsPanel(mainPanel, "")
        Panel(mainPanel) with {
            asHorizontal()
            Label(it).setText("Filtrar")
            //TextBox(it) bindTo "filtrar"

            Button(it) with {
                caption = "Ver"
            }
           Button(it) with {
                caption = "Agregar"
                onClick {
                        val user=UserConstroller()
                    VentanaDeAgregarUsuario(thisWindow,user) with {
                        onAccept { addUser(this@VentanaDeAdministracion.modelObject.initUser()) }
                        open()
                    }
                }
            }
            Button(it) with {
                caption = "Modificar"
            }
            Button(it) with {
                caption = "Eliminar"
            }
        }
tablaDeUsuarios(mainPanel)
    }


    private fun tablaDeUsuarios(mainPanel: Panel) {
        table<User>(mainPanel) with {
            visibleRows = 5
            bindItemsTo("filtrarUsuarios")
            //bindSelectionTo("seleccionarUsuario")
           /* column {
                title = "Nombre"
                fixedSize = 200
                bindContentsTo("firstName")
            }
            column {
                title = "Apellido"
                fixedSize = 200
                bindContentsTo("lastName")
            }
            column {
                title = "Correo electronico"
                fixedSize = 200
                bindContentsTo("email")
            }
            /*  column{
            title="Estado"
            fixedSize=200
            bindContentsTo("estado")
        }*/
            column {
                title = "Seleccionar"
                fixedSize = 200
                //seleccion
            }*/
        }
    }

    private fun addUser(user: User) =modelObject.addUser(user)
    }
