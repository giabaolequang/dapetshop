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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun SettingScreen()
{
    Box(modifier = Modifier
        .fillMaxSize()
        . background(color = Color(0xFFF3EDF7))
    )
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
                            Icon(Icons.Filled.ArrowBack,
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
        {it ->
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Spacer(modifier= Modifier.padding(top = 30.dp))
                BoxThongTin("Tên {Lê Quang Gia Bảo}", )
                BoxThongTin("Ngày sinh {user.date}")
                BoxGioiTinh(false)
                BoxThongTin("Số điện thoại {user.phone}")
                BoxThongTin("Địa chỉ {user.address}")
                Bton()
                BoxLuaChon( R.drawable.imginf,"Thông tin cá nhân ")
                BoxLuaChon( R.drawable.imgguarantee,"Thông tin và chính sách bảo hành ")
                BoxLuaChon( R.drawable.imgpoint,"Điểm ")
                BoxLuaChon( R.drawable.imgpurchasehistory,"Lịch sử mua hàng")
                BoxLuaChon( R.drawable.imglogout,"Đăng xuất ")

            }
        }
    }

}


@Composable
fun BoxThongTin(title: String)
{
    Box(modifier= Modifier
        .padding(top = 10.dp,
            bottom = 10.dp)
        .fillMaxWidth()
        .height(50.dp).
        background(color = Color(0xFFFFD8E4)),
        contentAlignment = Alignment.CenterStart
    )
    {
        Text( text = title ,
            color= Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(5.dp))
    }
}

@Composable
fun BoxGioiTinh(Sex:Boolean)
{
    val lsGenders = mutableListOf("Nam", "Nữ")
    var selection by remember { mutableStateOf(lsGenders[0]) }
    Row(modifier= Modifier
        .padding(top = 10.dp,
            bottom = 10.dp)
        .fillMaxWidth()
        .height(50.dp).
        background(color = Color(0xFFFFD8E4)),
    )
    {
        Text( text = "Giới tính:",
            color= Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(5.dp))
        lsGenders.forEach { gender ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = selection == gender,
                    onClick = { selection = gender })
                Text(text = gender)
            }
        }
    }

}

@Composable
fun Bton()
{
    Button(modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAC4D5))
    ) {
        Text(text = "Chỉnh sửa",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}


@Composable
fun BoxLuaChon( img: Int, content: String)
{
    Box(modifier= Modifier
        .padding(top = 10.dp,
            bottom = 10.dp)
        .fillMaxWidth()
        .height(50.dp).
        background(color = Color(0xFFFFD8E4)),
    )
    {
        Row (modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource( id = img),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
            )
            Text(text = content,
                color= Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}