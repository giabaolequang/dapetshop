import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.da_ltdd_petshop.R

@Composable
fun RegisterScreen() {
    val phoneNumber = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val confirmPassword = remember { mutableStateOf(TextFieldValue()) }
    val gmailAccount = remember { mutableStateOf(TextFieldValue()) }
    val gmailPassword = remember { mutableStateOf(TextFieldValue()) }
    val verificationCode = remember { mutableStateOf(TextFieldValue()) }
    val registerMethod = remember { mutableStateOf("Phone") }

    Box(
        modifier = Modifier
            .fillMaxSize(         )
            .background(Color(0xFFFFE4E1)), // Hồng nhạt
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(16.dp)
                .border(2.dp, Color.Gray, RoundedCornerShape(8.dp)) // Viền xám cho toàn bộ khung
                .background(Color.White, RoundedCornerShape(8.dp)) // Nền trắng
                .padding(16.dp)
        ) {
            // Thêm ảnh phía trên tiêu đề "Đăng kí"
            Image(
                painter = painterResource(id = R.drawable.user), // Đặt tên tệp hình ảnh trong `res/drawable`
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 8.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Đăng kí",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold,
                    color = Color.Black)
            )

            Text(
                text = "Chọn phương thức đăng ký",
                style = TextStyle(fontSize = 18.sp, color = Color.Black)
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = registerMethod.value == "Phone",
                        onClick = { registerMethod.value = "Phone" }
                    )
                    Text("Số điện thoại", style = TextStyle(fontSize = 16.sp, color = Color.Black))
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = registerMethod.value == "Gmail",
                        onClick = { registerMethod.value = "Gmail" }
                    )
                    Text("Gmail", style = TextStyle(fontSize = 16.sp, color = Color.Black))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (registerMethod.value == "Phone") {
                InputFieldWithBorder(
                    value = phoneNumber.value,
                    placeholder = "Số điện thoại",
                    onValueChange = { phoneNumber.value = it }
                )

                InputFieldWithBorder(
                    value = password.value,
                    placeholder = "Mật khẩu",
                    onValueChange = { password.value = it }
                )

                InputFieldWithBorder(
                    value = confirmPassword.value,
                    placeholder = "Nhập lại mật khẩu",
                    onValueChange = { confirmPassword.value = it }
                )
            } else if (registerMethod.value == "Gmail") {
                InputFieldWithBorder(
                    value = gmailAccount.value,
                    placeholder = "Tài khoản Gmail",
                    onValueChange = { gmailAccount.value = it }
                )

                InputFieldWithBorder(
                    value = gmailPassword.value,
                    placeholder = "Mật khẩu",
                    onValueChange = { gmailPassword.value = it }
                )

                InputFieldWithBorder(
                    value = verificationCode.value,
                    placeholder = "Mã xác thực",
                    onValueChange = { verificationCode.value = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button (
                onClick = {
/*if (registerMethod.value == "Phone") {
    onRegisterClick(
        phoneNumber.value.text,
        password.value.text,
        confirmPassword.value.text
    )
} else {
    onRegisterClick(
        gmailAccount.value.text,
        gmailPassword.value.text,
        verificationCode.value.text
    )
}

 */
},
colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F91)) // Hồng đậm
) {
Text("Đăng Kí", style = TextStyle(fontSize = 16.sp, color = Color.White))
}
}
}
}

@Composable
fun InputFieldWithBorder(
value: TextFieldValue,
placeholder: String,
onValueChange: (TextFieldValue) -> Unit
) {
Box(
modifier = Modifier
.fillMaxWidth()
.border(1.dp, Color.Gray, RoundedCornerShape(8.dp)) // Thêm viền cho từng trường nhập
.background(Color.White, RoundedCornerShape(8.dp)) // Nền trắng bên trong
.padding(8.dp)
) {
BasicTextField(
value = value,
onValueChange = onValueChange,
modifier = Modifier.fillMaxWidth(),
decorationBox = { innerTextField ->
Box {
if (value.text.isEmpty())
    Text(placeholder, style = TextStyle(fontSize = 16.sp, color = Color.Gray))
innerTextField()
}
}
)
}
}
