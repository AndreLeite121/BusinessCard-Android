package com.example.businesscard

import android.media.Image
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Deus(Nome = "André Leite", Desc = "Android Developer Jr", Tel = "+55 (38) 99803-4613", Git = "AndreLeite121", Email = "andreribeiro139@gmail.com")

                }
            }
        }
    }
}

@Composable
fun Cabecalho(Nome: String, Desc: String, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = Nome,
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,


        )
        Text(
            text = Desc,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color= colorResource(id = R.color.icon)
        )
    }
}

@Composable
fun CabecalhoImage(Nome: String, Desc: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(colorResource(id = R.color.imagem))
            .padding(
                start = 16.dp,
                top = 160.dp,
                end = 16.dp,
                bottom = 15.dp
            )
    ){
        Image(
            painter = image ,
            contentDescription = null,
            modifier = Modifier
                .background(colorResource(id = R.color.fundoImg))
                .size(110.dp)
        )
        Cabecalho(Nome = Nome, Desc = Desc)

    }


}

@Composable
fun Redes(Tel: String,
          Git: String,
          Email: String,
          modifier: Modifier = Modifier){
    Box(

    ){
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 160.dp,
                    end = 16.dp,
                    bottom = 15.dp
                )
                .background(colorResource(id = R.color.imagem))
        )
        {
            Row (
                modifier = Modifier
                    .padding(6.dp)
            ){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_local_phone_24),
                    tint = colorResource(id = R.color.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)


                )
                Text(
                    text = Tel,
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                        )

                    )
            }
            Row (
                modifier = Modifier
                    .padding(6.dp)
            ){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_share_24),
                    tint = colorResource(id = R.color.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = Git,
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                        )
                )
            }
            Row (
                modifier = Modifier
                    .padding(6.dp)
            ){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    tint = colorResource(id = R.color.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)

                )
                Text(
                    text = Email,
                    modifier = Modifier
                        .padding(
                            start = 10.dp,
                        )

                    )
            }



        }
    }

}

@Composable
fun Deus(Nome: String,
         Desc: String,
         Tel: String,
         Git: String,
         Email: String,
         ){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(colorResource(id = R.color.imagem))
            .padding(30.dp)
    ) {
        CabecalhoImage(
            Nome = Nome ,
            Desc = Desc ,
        )
        Redes(Tel = Tel,
            Git = Git,
            Email = Email
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Deus(Nome = "André Leite", Desc = "Android Developer Jr", Tel = "+55 (38) 99803-4613", Git = "AndreLeite121", Email = "andreribeiro139@gmail.com")

    }
}