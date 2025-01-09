
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ltdd_petshop.R

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Lấy dữ liệu từ Intent khi chuyển từ MainActivity
        val productName = intent.getStringExtra("PRODUCT_NAME") ?: "Unknown"
        val productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION") ?: "No Description"
        val productPrice = intent.getStringExtra("PRODUCT_PRICE") ?: "$0"
        val productImage = intent.getIntExtra("PRODUCT_IMAGE", R.drawable.border)
        val productQuantity = intent.getIntExtra("PRODUCT_QUANTITY", 0)
        val productType = intent.getStringExtra("PRODUCT_TYPE") ?: "Unknown"
        val productGender = intent.getStringExtra("PRODUCT_GENDER") ?: "Unknown"
        val productIntroduction = intent.getStringExtra("PRODUCT_INTRODUCTION") ?: "No Introduction"
        val productPros = intent.getStringExtra("PRODUCT_PROS") ?: "No Pros"
        val productCons = intent.getStringExtra("PRODUCT_CONS") ?: "No Cons"
        val productTemperament = intent.getStringExtra("PRODUCT_TEMPERAMENT") ?: "Unknown"
        val productOrigin = intent.getStringExtra("PRODUCT_ORIGIN") ?: "Unknown"

        // Set nội dung màn hình sử dụng Compose
        setContent {
            PetProductDetailScreen(
                productName,
                productDescription,
                productPrice,
                productImage,
                productQuantity,
                productType,
                productGender,
                productIntroduction,
                productPros,
                productCons,
                productTemperament,
                productOrigin
            )
        }
    }
}

@Composable
fun PetProductDetailScreen(
    productName: String,
    productDescription: String,
    productPrice: String,
    productImage: Int,
    productQuantity: Int,
    productType: String,
    productGender: String,
    productIntroduction: String,
    productPros: String,
    productCons: String,
    productTemperament: String,
    productOrigin: String
) {
    // Dùng Box để đảm bảo nền full màn hình
    Box(
        modifier = Modifier
            .fillMaxSize()  // Lấp đầy toàn bộ màn hình
            .background(Color(0xFFF3EDF7)) // Màu nền hồng
    ) {
        // Sử dụng ScrollView để cuộn nội dung
        Column(
            modifier = Modifier
                .fillMaxSize() // Đảm bảo Column chiếm toàn bộ không gian
                .padding(16.dp) // Padding cho nội dung bên trong
                .verticalScroll(rememberScrollState()) // Cho phép cuộn dọc
        ) {
            // Image of the Pet
            Image(
                painter = painterResource(id = productImage),
                contentDescription = "Hình ảnh thú cưng",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )

            // Product Name
            Text(
                text = productName,
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Product Description
            Text(
                text = productDescription,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Product Price
            Text(
                text = "Giá: $productPrice",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                color = Color.Green,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Quantity Left
            Text(
                text = "Số lượng còn lại: $productQuantity",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Product Type
            Text(
                text = "Loại: $productType",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Gender
            Text(
                text = "Giới tính: $productGender",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Introduction
            Text(
                text = "Giới thiệu: $productIntroduction",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Pros
            Text(
                text = "Ưu điểm: $productPros",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Cons
            Text(
                text = "Nhược điểm: $productCons",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Temperament
            Text(
                text = "Tính cách: $productTemperament",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Origin
            Text(
                text = "Nơi xuất xứ: $productOrigin",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Buy Button
            Button(
                onClick = { /* Handle Buy Action */ },
                shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mua Ngay", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(8.dp)) // Khoảng cách giữa các nút

            // Add to Cart Button
            Button(
                onClick = { /* Handle Add to Cart Action */ },
                shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Thêm vào giỏ hàng", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(8.dp)) // Khoảng cách giữa các nút

            // Send Message Button
            Button(
                onClick = { /* Handle Send Message Action */ },
                shape = MaterialTheme.shapes.medium.copy(CornerSize(8.dp)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Nhắn tin", fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductDetail() {
    PetProductDetailScreen(
        productName = "Golden Retriever",
        productDescription = "Golden Retrievers are known for their friendly and intelligent nature. They make great family pets and are highly trainable.",
        productPrice = "$500",
        productImage = R.drawable.border,
        productQuantity = 10,
        productType = "Chó",
        productGender = "Đực",
        productIntroduction = "Golden Retrievers are friendly and intelligent dogs, perfect for families.",
        productPros = "Thân thiện, thông minh, dễ huấn luyện",
        productCons = "Cần nhiều thời gian vận động",
        productTemperament = "Hiền lành, thân thiện",
        productOrigin = "Hoa Kỳ"
    )
}
