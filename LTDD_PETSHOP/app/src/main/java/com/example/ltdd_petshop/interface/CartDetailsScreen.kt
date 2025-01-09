
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ltdd_petshop.R

@Composable
fun CartScreenParent() {
    val cartItems = remember {
        listOf(
            CartItem("Sản phẩm 1", 100000, 1),
            CartItem("Sản phẩm 2", 200000, 2),
            CartItem("Sản phẩm 3", 300000, 1)
        )
    }

    val removeItem: (CartItem) -> Unit = { item ->
        println("Xóa sản phẩm: ${item.name}")
    }

    val checkout: () -> Unit = {
        println("Thực hiện thanh toán")
    }

    val continueShopping: () -> Unit = {
        println("Tiếp tục mua sắm")
    }

    val viewProductDetails: (CartItem) -> Unit = { item ->
        println("Xem chi tiết sản phẩm: ${item.name}")
    }

    Scaffold(
        topBar = {
            CustomTopAppBar(onBackClick = { println("Quay lại màn hình trước đó") })
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding) // Áp dụng padding để tránh bị che bởi TopAppBar
        ) {
            CartScreen(
                cartItems = cartItems,
                onItemRemove = removeItem,
                onCheckoutClick = checkout,
                onContinueShoppingClick = continueShopping,
                onViewProductDetails = viewProductDetails
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(onBackClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFFC0CB)), // Nền màu hồng
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Nút quay lại bên trái sử dụng biểu tượng mũi tên từ Material Icons
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.pet),
                        contentDescription = "Small Icon",
                        tint = Color.Unspecified
                    )
                }
            }
        }
    )
}

@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    onItemRemove: (CartItem) -> Unit,
    onCheckoutClick: () -> Unit,
    onContinueShoppingClick: () -> Unit,
    onViewProductDetails: (CartItem) -> Unit
) {
    var selectedItems by remember { mutableStateOf(setOf<CartItem>()) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Tiêu đề
        Text(
            text = "Giỏ hàng",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Danh sách sản phẩm
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(cartItems) { item ->
                CartItemRow(
                    cartItem = item,
                    isSelected = selectedItems.contains(item),
                    onSelectItem = { isSelected ->
                        selectedItems = if (isSelected) {
                            selectedItems + item
                        } else {
                            selectedItems - item
                        }
                    },
                    onRemoveClick = { onItemRemove(item) },
                    onViewDetailsClick = { onViewProductDetails(item) }
                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tổng tiền và nút hành động
        Column(modifier = Modifier.fillMaxWidth()) {
            val totalPrice = cartItems.filter { selectedItems.contains(it) }.sumOf { it.price * it.quantity }
            Text(text = "Tổng cộng: ${totalPrice}₫", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Tiếp tục mua sắm")
                }

                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Thanh toán")
                }
            }

            Button(
                onClick = {
                    selectedItems.forEach { onItemRemove(it) }
                    selectedItems = emptySet()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Xóa tất cả sản phẩm đã chọn")
            }
        }
    }
}

@Composable
fun CartItemRow(
    cartItem: CartItem,
    isSelected: Boolean,
    onSelectItem: (Boolean) -> Unit,
    onRemoveClick: () -> Unit,
    onViewDetailsClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth() // Chiều ngang tràn viền
            .background(Color(0xFFFFC0CB)) // Màu nền hồng
            .padding(horizontal = 8.dp, vertical = 8.dp) // Padding bên trong nội dung
    ) {
        // CheckBox để chọn sản phẩm
        Checkbox(
            checked = isSelected,
            onCheckedChange = onSelectItem,
            modifier = Modifier.padding(end = 16.dp)
        )

        // Hình ảnh sản phẩm
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.Gray)
        ) {
            Text(text = "Ảnh", modifier = Modifier.align(Alignment.Center))
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Thông tin sản phẩm
        Column(modifier = Modifier.weight(1f)) {
            Text(text = cartItem.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Giá: ${cartItem.price}₫", style = MaterialTheme.typography.bodyMedium)
        }

        // Số lượng và các nút hành động
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "SL: ${cartItem.quantity}")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onRemoveClick) {
                Text(text = "Xóa")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onViewDetailsClick) {
                Text(text = "Xem chi tiết")
            }
        }
    }
}

data class CartItem(val name: String, val price: Int, val quantity: Int)
