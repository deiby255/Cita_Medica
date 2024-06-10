package com.example.cita_medica

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reservas(navController: NavController){


    var showDialogReserva by remember {
        mutableStateOf(false)
    }

    var showDialogConfirmar by remember {
        mutableStateOf(false)
    }


    var run by remember {
        mutableStateOf("")
    }

    var isExpandedEsp by remember {
        mutableStateOf(false)
    }

    var especialidad by remember {
        mutableStateOf("")
    }

    var fechaReserva by remember {
        mutableStateOf("")
    }

    var isExpandedHora by remember {
        mutableStateOf(false)
    }

    var horaReserva by remember {
        mutableStateOf("")
    }

    var datosReserva by remember {
        mutableStateOf("")
    }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){

        Text(text = "Ingresa datos requeridos para reserva")

        Spacer(modifier = Modifier.height(16.dp))

        //Ingreso de cedula
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Ingrese cedula")
        OutlinedTextField(value = run, onValueChange = {
            run = it

        }, label = {
            Text(text = "cedula")
        })

        Spacer(modifier = Modifier.height(16.dp))

        //Seleccion de Especialidad
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seleccione Especialidad")

        ExposedDropdownMenuBox(
            expanded = isExpandedEsp,
            onExpandedChange = {isExpandedEsp = it})
        {
            TextField(
                value = especialidad,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedEsp)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpandedEsp,
                onDismissRequest = { isExpandedEsp=false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = "Cirujano")
                    },
                    onClick = {
                        especialidad = "Cirujano"
                        isExpandedEsp = false

                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(text = "Dentista")
                    },
                    onClick = {
                        especialidad = "Dentista"
                        isExpandedEsp = false

                    }
                )

            }


        }




        Spacer(modifier = Modifier.height(16.dp))

        //Seleccion de Fecha
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seleccione Fecha")
        OutlinedTextField(value = fechaReserva, onValueChange = {
            fechaReserva = it
        }, label = {
            Text(text = "Fecha")
        })

        Spacer(modifier = Modifier.height(16.dp))

        //Seleccion de Hora
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seleccione Hora")

        ExposedDropdownMenuBox(
            expanded = isExpandedHora,
            onExpandedChange = {isExpandedHora = it})
        {
            TextField(
                value = horaReserva,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedHora)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpandedHora,
                onDismissRequest = { isExpandedHora=false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = "08:00")
                    },
                    onClick = {
                        horaReserva = "08:00"
                        isExpandedHora = false

                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(text = "08:30")
                    },
                    onClick = {
                        horaReserva = "08:30"
                        isExpandedHora = false

                    }
                )

            }


        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showDialogReserva = true
            //navController.navigate("Reservas")
        }


        ) {
            Text(text = "Reservar")
            if (showDialogReserva){
                AlertDialog(
                    onDismissRequest = {
                        //showDialogReserva = false
                    },
                    confirmButton = {
                        TextButton(onClick = {showDialogConfirmar = true})
                        {
                            Text(text = "Confirmar Reserva")

                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            showDialogReserva = false
                        }) {
                            Text(text = "Cancelar")
                        }
                    },

                    title = { Text("Datos de Reserva")},

                    text = {
                        Column {
                            Text(text = "cedula: " + run)
                            Text(text = "Especialidad: " + especialidad)
                            Text(text = "Fecha: " + fechaReserva)
                            Text(text = "Hora: " + horaReserva)
                            datosReserva=run + especialidad + fechaReserva + horaReserva
                        }
                    }

                )
            }
            if (showDialogConfirmar){
                AlertDialog(
                    onDismissRequest = {
                        //showDialogConfirmar = false
                    },
                    confirmButton = {
                        TextButton(onClick = {showDialogConfirmar=false }) {
                            Text(text = "Listo")

                        }
                    },
                    text = {
                        Column {
                            Text(text = "¡Reserva realizada con Éxito!")
                            showDialogReserva=false
                            run=""
                            especialidad=""
                            fechaReserva=""
                            horaReserva=""
                        }
                    }

                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))


        Text(text = "Presione para volver al login")
        Button(onClick = {
            navController.navigate("Login")
        }) {
            Text(text = "Ir a Login")
        }
    }

}

