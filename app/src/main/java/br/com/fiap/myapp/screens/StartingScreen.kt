package br.com.fiap.myapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.myapp.ui.theme.MyAppTheme
import br.com.fiap.myapp.ui.theme.quickSandSemibold
import br.com.fiap.myapp.R
import br.com.fiap.myapp.ui.theme.quickSandBold

@Composable
fun StartingScreen(navController: NavController) {
    MyAppTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.validoc_logo),
                contentDescription = "Logo ValiDoc",
                modifier = Modifier
                    .padding(vertical = 48.dp)
                    .fillMaxWidth(0.5f)
            )
            Button(
                onClick = {
                    navController.navigate("cadastro")
                },
                modifier = Modifier
                    .padding(top = 64.dp)
                    .fillMaxWidth(0.5f),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.azul_escuro))
            ) {
                Text(
                    buildAnnotatedString {
                        append("Entrar com ")
                        withStyle(
                            style = SpanStyle
                                (fontFamily = quickSandBold)
                        ) {
                            append("guv.br")
                        }
                    },
                    modifier = Modifier
                        .padding(vertical = 6.dp),
                    fontFamily = quickSandSemibold
                )
            }
            Button(
                onClick = {
                    navController.navigate("cadastro")
                },
                modifier = Modifier
                    .padding(top = 64.dp)
                    .fillMaxWidth(0.5f),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.azul_escuro))
            ) {
                Text(
                    "Criar conta",
                    modifier = Modifier
                        .padding(vertical = 6.dp),
                    fontFamily = quickSandSemibold
                )
            }
        }

    }
}