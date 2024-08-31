package br.com.fiap.myapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import br.com.fiap.myapp.ui.theme.MyAppTheme
import br.com.fiap.myapp.ui.theme.quickSandSemibold
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import br.com.fiap.myapp.R
import br.com.fiap.myapp.model.Estado
import br.com.fiap.myapp.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CadastroScreen(navController: NavController) {
    MyAppTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.validoc_logo),
                contentDescription = "Logo ValiDoc",
                modifier = Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth(0.5f)
            )
            ArrowBack(navController)
            FormBox("Digite seu CPF/CNPJ", "CPF/CNPJ")
            FormBox("Digite seu nome", "Nome")
            FormBox(
                "Digite sua senha", "Senha",
                painterResource(id = R.drawable.baseline_eye_24),
                "Ícone de olho"
            )

            DropdownEstados("UF")
            //DropdownCidades("Cidade", idEstadoSelecionado)

            Button(
                onClick = {
                    navController.navigate("menu")
                },
                modifier = Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth(0.5f),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.azul_escuro))
            ) {
                Text(
                    "Continuar",
                    Modifier
                        .padding(vertical = 6.dp),
                    fontFamily = quickSandSemibold
                )
            }
            // para o botão não ficar colado na parte inferior
            Spacer(modifier = Modifier.height(100.dp))
        }

    }
}

@Composable
fun ArrowBack(navController: NavController) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Seta para voltar",
        modifier = Modifier
            .padding(end = 320.dp)
            .clickable {
                navController.navigate("start")
            }
    )
}


@Composable
fun FormBox(
    placeholder: String,
    label: String,
    icon: Any? = null,
    iconDescription: String? = null
) {

    var texto by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = texto,
            onValueChange = { novoTexto -> texto = novoTexto },
            singleLine = true,
            placeholder = { Text(placeholder) },
            label = { Text(label) },
            trailingIcon = {
                when (icon) {
                    is ImageVector -> {
                        Icon(
                            imageVector = icon,
                            contentDescription = iconDescription
                        )
                    }

                    is Painter -> {
                        Icon(
                            painter = icon,
                            contentDescription = iconDescription
                        )
                    }
                }
            },
            visualTransformation = if (label == "Senha") PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = if (label == "CPF/CNPJ") KeyboardOptions(keyboardType = KeyboardType.Number) else KeyboardOptions.Default
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownEstados(nome: String) {

    var listaEstadoState by remember { mutableStateOf(listOf<String>()) }

    val call = RetrofitFactory().getLocalidadeService().getEstados()

    call.enqueue(object : Callback<List<Estado>> {
        override fun onResponse(call: Call<List<Estado>>, response: Response<List<Estado>>) {
            //Log.i("ValiDoc","onResponse: ${response.body()}")
            listaEstadoState = response.body()!!.map { it.nome }
        }

        override fun onFailure(call: Call<List<Estado>>, t: Throwable) {
            Log.i("ValiDoc", "onResponse: ${t.message}")
        }

    })

    val list = listaEstadoState.sorted()
    var isExpanded by remember { mutableStateOf(false) }
    var estadoSelecionado by remember { mutableStateOf(nome) }

    Column(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = !isExpanded }) {

        OutlinedTextField(
            modifier = Modifier.menuAnchor(),
            value = estadoSelecionado,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
        )

        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            list.forEachIndexed { index, text ->
                DropdownMenuItem(
                    text = { Text(text) },
                    onClick = {
                        estadoSelecionado = list[index]
                        isExpanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}

