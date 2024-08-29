package br.com.fiap.myapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.myapp.R
import br.com.fiap.myapp.ui.theme.MyAppTheme
import br.com.fiap.myapp.ui.theme.quickSandBold
import br.com.fiap.myapp.ui.theme.quickSandRegular
import br.com.fiap.myapp.ui.theme.quickSandSemibold

@Composable
fun MenuScreen() {
    MyAppTheme {
        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .padding(vertical = 54.dp)
                    .padding(horizontal = 36.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Ícone da home",
                    Modifier.size(36.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "Ícone do usuário",
                        Modifier
                            .size(56.dp)
                            .padding(end = 12.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.options),
                        contentDescription = "Ícone de opções",
                        Modifier.size(24.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {

                Text("Meus documentos",
                    fontFamily = quickSandSemibold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {

                    Box(modifier = Modifier.fillMaxWidth()) {
                        CardMaker("RG", Color.Blue, 0.dp)
                        CardMaker("CNH", Color.Yellow, 72.dp)
                        CardMaker("RCN", Color.Green, 144.dp)
                    }
                    }

                Text("Validações",
                    fontFamily = quickSandSemibold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp))

            }
        }
    }
}

@Composable
fun CardMaker(name: String, color: Color, dp: Dp) {
    Card(
        modifier = Modifier
            .height(180.dp)
            .width(360.dp)
            .padding(start = dp),
        colors = CardDefaults
            .cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(36.dp)
    ) {
        Text(name,
            fontFamily = quickSandSemibold,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(12.dp))

    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen()
}