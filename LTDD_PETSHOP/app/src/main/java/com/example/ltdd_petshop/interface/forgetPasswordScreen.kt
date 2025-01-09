
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ltdd_petshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen(onBackClick: () -> Unit, onSendCodeClick: (String) -> Unit) {
    var phoneNumber by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("PetShop", color = Color.White) },
                navigationIcon = {
                    IconButton (onClick = { onBackClick() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    // Thêm biểu tượng góc phải
                    Row  {
                        Image(
                            painter = painterResource(id = R.drawable.decore), // Thay bằng ID hình ảnh của bạn
                            contentDescription = "Pet Shop",
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 8.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFC0CB)
                )
            )
        },
        content = { padding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Tiêu đề chính
                Text(
                    text = "ĐĂNG NHẬP TÀI KHOẢN",
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Tiêu đề phụ
                Text(
                    text = "Đặt lại mật khẩu",
                    fontSize = 16.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Nhập số điện thoại
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = { Text("Số điện thoại") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Ghi chú dưới ô nhập
                Text(
                    text = "Nhập số điện thoại của bạn để nhận mã xác nhận lấy lại mật khẩu",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Nút "Lấy lại mật khẩu"
                Button (
                    onClick = { onSendCodeClick(phoneNumber) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC0CB))
                ) {
                    Text(text = "Lấy lại mật khẩu", color = Color.Black, fontSize = 16.sp)
                }
            }
        }
    )
}
