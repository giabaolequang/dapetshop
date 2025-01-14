package com.example.ban_meo.ui.theme

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.da_ltdd_petshop.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPersonalInformationScreen( navController: NavController )
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
                TextFieldEditInfor("Tên","Lê Quang Gia Bảo" )
                TextFieldEditInfor("Ngày sinh ","02/04/2004" )
                TextFieldEditInfor("Số điện thoại ","0306221305" )
                TextFieldEditInfor("Địa chỉ ","1183 Phạm Thế Hiển" )
                TextFieldEditInfor("Mật khẩu ","************" )
                Spacer(modifier=Modifier.padding(30.dp))
                Row (modifier=Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically){
                    Button(modifier=Modifier,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEAC4D5),
                            contentColor = Color.White
                        ),
                        onClick = {})
                    {
                        Text(text="Hủy")
                    }
                    Button(modifier=Modifier,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEAC4D5),
                            contentColor = Color.White
                        ),
                        onClick = {})
                    {
                        Text(text="Lưu")
                    }

                }
            }
        }
    }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEditInfor(title: String, thuoctinh: String)
{
TextField(modifier= Modifier
    .padding(vertical = 15.dp)
    .fillMaxWidth()
    .height(50.dp),
    value = "",
    onValueChange = {},
    colors = TextFieldDefaults.textFieldColors(
        containerColor = Color(0xFFFFD8E4),
        focusedIndicatorColor = Color.Green),
    textStyle = TextStyle(color = Color.White),
    label = { Text(text = "$title: $thuoctinh") }
)


    }

