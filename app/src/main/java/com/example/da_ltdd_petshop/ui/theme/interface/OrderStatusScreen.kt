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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.da_ltdd_petshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderStatusScreen(navController: NavController)
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
        },
        bottomBar =
        {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFFD8E4))
                .height(70.dp),
                horizontalArrangement = Arrangement.SpaceAround)
            {
                ImgChucNang(R.drawable.menu)
                ImgChucNang(R.drawable.dog)
                ImgChucNang(R.drawable.dog)
                ImgChucNang(R.drawable.cat)
                ImgChucNang(R.drawable.sale)

            }

        }



    )
    { it->
        Column(modifier = Modifier
            .padding(it)
            .background(color = Color(0xFFF3EDF7))
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.padding(20.dp))
            Box(modifier = Modifier
                .height(130.dp)
                .fillMaxWidth()
                .padding(10.dp)
                .background(color = Color(0xFFEAC4D5),
                    shape = RoundedCornerShape(100.dp)),
                contentAlignment = Alignment.Center

                 )
            {
                Text(text = "Trạng thái đơn hàng",
                    color = Color.White,
                    fontSize = 40.sp)
            }

            Spacer(modifier = Modifier.padding(10.dp))
            Image(painter = painterResource(R.drawable.container),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                )
            Spacer(modifier = Modifier.padding(20.dp))

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically)
            {
                StatusBox("  Xác nhận   đơn đặt")
                StatusBox("  Đang vận   chuyển")
                StatusBox("  Giao   thành công")
            }
            Spacer(modifier = Modifier.padding(10.dp))

            Text(text = "Sản phẩm tương tự",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 30.dp))


        }
    }
}



@Composable
fun StatusBox(trangthai:String)
{
    Box(modifier = Modifier
        .background(color = Color(0xFFD6EADF),
            shape = RoundedCornerShape(50.dp))
        .size(100.dp, 100.dp),
        contentAlignment = Alignment.Center
    )
    {
        Text(text ="$trangthai",
            fontSize = 18.sp,
            color = Color.Black)

    }
}

@Composable
fun ImgChucNang(id:Int)
{
    Image(modifier = Modifier.size(70.dp)
        .clickable {  },
        painter = painterResource(id),
        contentDescription = "")
}