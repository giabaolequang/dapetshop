package com.example.ban_meo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ltdd_petshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatuePaymentScreen()
{
    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFFFD8E4),
                    titleContentColor = Color.White
                ),
                title = {
                    Row (modifier= Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {  })


                        Text(text = "PET SHOP" ,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp,
                            color = Color.White,)

                        Image(modifier = Modifier.size(136.dp, 128.dp),
                            painter = painterResource(R.drawable.decore),
                            contentDescription = "")
                    }

                }
            )
        })
    { it->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .background(color = Color(0xFFF3EDF7)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {
            Spacer(modifier = Modifier.padding(50.dp))
            Image(painter = painterResource(R.drawable.sucess),
                contentDescription = "",
                modifier = Modifier.size(200.dp)
                    .padding(20.dp)
            )
            Text("Thanh toán thành công",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(30.dp)
            )
            Spacer(modifier = Modifier.padding(30.dp))
            button("Tiếp tục mua sắm" )
            button("Trở về trang chủ")

        }
    }
}

@Composable
fun button( funtion: String)
{
    Button(modifier = Modifier
        .padding(20.dp)
        .size(300.dp, 100.dp),
        shape = RoundedCornerShape(50.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAC4D5))
    )
    {
        Text(text = "$funtion",
            color = Color.White,
            fontSize = 20.sp)
    }
}
