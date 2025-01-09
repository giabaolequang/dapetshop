package com.example.ban_meo.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ltdd_petshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(onBackClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFFC0CB)), // Nền màu hồng
        title = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Nút quay lại bên trái sử dụng biểu tượng mũi tên từ Material Icons
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, // Biểu tượng mũi tên quay lại
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }

                // Biểu tượng nhỏ bên phải với kích thước lớn hơn một chút
                IconButton(
                    onClick = { /* Xử lý sự kiện khi nhấn vào biểu tượng nhỏ */ },
                    modifier = Modifier
                        .padding(end = 8.dp) // Khoảng cách từ biên phải
                        .size(50.dp) // Kích thước lớn hơn một chút của biểu tượng
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.decore), // Thay bằng tài nguyên của bạn
                        contentDescription = "Small Icon",
                        tint = Color.Unspecified
                    )
                }
            }
        }
    )
}
