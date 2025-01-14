package com.example.ban_meo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.da_ltdd_petshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreScreen(navController: NavController) {
    val thang = 6
    val nd: String = if (thang < 12) {
        "$thang tháng gần nhất"
    } else {
        ""
    }

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(modifier = Modifier
                .fillMaxWidth()
                .height(128.dp),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFFFD8E4),
                    titleContentColor = Color.White
                ),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(30.dp)
                                .clickable { }
                        )
                        Text(
                            text = "PET SHOP",
                            fontSize = 32.sp,
                            color = Color.White,
                        )
                        Image(
                            modifier = Modifier.size(136.dp, 128.dp),
                            painter = painterResource(R.drawable.decore),
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column  (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF3EDF7)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(720.dp, 200.dp)
                    .background(
                        color = Color(0xFFEAC4D5),
                        shape = RoundedCornerShape(
                            bottomEndPercent = 30,
                            bottomStartPercent = 30
                        )
                    )
            ) {
                Text(
                    text = "Điểm",
                    color = Color(0xFF2851D8),
                    fontSize = 50.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.End
            )
            {
                Text(
                    text = nd,
                    textAlign = TextAlign.End,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(5.dp),
                    color = Color(0xFF269E26)
                )
                Image(
                    painter = painterResource(R.drawable.imginf),
                    contentDescription = ""
                )
            }
            LazyColumn {
                items(10)
                {item->
                    BoxHoaDon(0)
                    BoxHoaDon(1)
                    BoxHoaDon(2)
                    BoxHoaDon(3)
                    BoxHoaDon(4)
                    BoxHoaDon(5)
                    BoxHoaDon(6)
                    BoxHoaDon(7)
                    BoxHoaDon(8)
                    BoxHoaDon(9)


                }
            }


        }
    }
}


@Composable
fun BoxHoaDon(id: Int)
{
    var col: Color

    if(id%2==0)
    {
        col= Color(0xFFEFE9E9)
    }
    else
    {
        col= Color(0xFFFFFFFF)

    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .background(color = col))
    {
        Column(modifier = Modifier
            .fillMaxWidth()) {
            Text(
                text = "902 Tạ Quang Bửu| 15/12 23:31:26",
                fontSize = 25.sp
            )

            Text(
                text = "Tổng hóa đơn ${id}          Điểm nhận      Điểm sử dụng",
                fontSize = 18.sp
            )
            Text(
                text = "29M đồng                    29k                          0",
                fontSize = 20.sp
            )

        }

    }
}
