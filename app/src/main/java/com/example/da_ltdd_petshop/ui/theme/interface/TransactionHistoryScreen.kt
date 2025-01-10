package com.example.ban_meo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.da_ltdd_petshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionHistoryScreen ( )
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
    {it->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .background(color = Color(0xFFF3EDF7)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {
            Spacer(modifier = Modifier.padding(10.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFEAC4D5)),
                contentAlignment = Alignment.Center,
            )
            {
                Text("Lịch sử giao dịch",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                        .background(
                            color = Color(0xFFEAC4D5),
                            shape = RoundedCornerShape(20.dp)))
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row {
                TextField( value = " Nhập nội dung tìm kiếm",
                    onValueChange = {},
                    modifier = Modifier,
                    colors = TextFieldDefaults.colors(Color(0xFFEAC4D5)) ,
                    shape = RoundedCornerShape(20.dp)  )
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "",
                    Modifier.clickable {  }
                        . size(30.dp, 70.dp)

                )
            }
            Spacer(modifier =Modifier.padding(10.dp))

            LazyColumn {
                items(10)
                {
                    item ->
                    BoxXemLaiHoaDon(1)
                    BoxXemLaiHoaDon(2)
                    BoxXemLaiHoaDon(3)
                    BoxXemLaiHoaDon(4)
                    BoxXemLaiHoaDon(5)
                    BoxXemLaiHoaDon(6)
                    BoxXemLaiHoaDon(7)
                    BoxXemLaiHoaDon(8)
                    BoxXemLaiHoaDon(9)
                    BoxXemLaiHoaDon(10)


                }
            }

        }
    }
}


@Composable
fun BoxXemLaiHoaDon(id :Int)
{
    var col: Color

    if(id%2 == 0)
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
            .background(color = col), )
    {
        Column(modifier = Modifier
            .fillMaxSize()) {
            Text(
                text = "{dthd.address}| {dthd.date}",
                fontSize = 25.sp
            )

            Text(
                text = "Mã hóa đơn: {dthd.id}",
                fontSize = 18.sp
            )
            Text(
                text = "Tên khách hàng: {dthd.cusName}",
                fontSize = 18.sp
            )
            Text(
                text = "Sản phẩm: {dthd.proName}",
                fontSize = 18.sp
            )
            Text(
                text = "Ghi chú: {dthd.note}",
                fontSize = 18.sp
            )


        }

    }
}
