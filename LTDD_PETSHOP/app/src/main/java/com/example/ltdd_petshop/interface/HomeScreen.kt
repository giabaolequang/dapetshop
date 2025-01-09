
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ltdd_petshop.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var menuExpanded by remember { mutableStateOf(false) } // State to control the menu

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("PetShop", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { menuExpanded = !menuExpanded }) {
                        Icon(
                            painter = painterResource(id = R.drawable.menu), // Replace with your menu icon resource
                            contentDescription = "Menu",
                            modifier = Modifier.size(36.dp),
                            tint = Color.White
                        )
                        DropdownMenu(
                            expanded = menuExpanded,
                            onDismissRequest = { menuExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Home") },
                                onClick = {
                                    menuExpanded = false
                                    // Navigate to Home
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Dogs") },
                                onClick = {
                                    menuExpanded = false
                                    // Navigate to Dogs
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Cats") },
                                onClick = {
                                    menuExpanded = false
                                    // Navigate to Cats
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Sales") },
                                onClick = {
                                    menuExpanded = false
                                    // Navigate to Sales
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Profile") },
                                onClick = {
                                    menuExpanded = false
                                    // Navigate to Profile
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Liên hệ") },
                                onClick = {
                                    menuExpanded = false
                                    // Navigate to Profile
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Hỗ trợ khách hàng") },
                                onClick = {
                                    menuExpanded = false
                                    // Navigate to Profile
                                }
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { /* Search action */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFC0CB)
                )
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color(0xFFFFC0CB)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = { /* Navigate to Dogs */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.imgguarantee),
                            contentDescription = "Dogs",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                    IconButton(onClick = { /* Navigate to Home */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.dog),
                            contentDescription = "Home",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                    IconButton(onClick = { /* Navigate to Cats */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.cat),
                            contentDescription = "Cats",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                    IconButton(onClick = { /* Navigate to Sale */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.sale),
                            contentDescription = "Sale",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                    IconButton(onClick = { /* Navigate to User */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "User",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Navigate to Cart */ },
                shape = CircleShape,
                containerColor = Color(0xFFFFC0CB),
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Cart Icon",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "Banner",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp)
                ) {
                    item {
                        ProductCard(
                            imageRes = R.drawable.husky,
                            name = "Chó Husky đen trắng mã HH445",
                            price = "9.000.000 đ"
                        )
                    }
                    item {
                        ProductCard(
                            imageRes = R.drawable.border,
                            name = "Chó Border Collie đen trắng mã BCL692",
                            price = "8.500.000 đ"
                        )
                    }
                }
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp)
                ) {
                    item {
                        ProductCard(
                            imageRes = R.drawable.longngan,
                            name = "Mèo Anh lông dài mã BiColor",
                            price = "6.000.000 đ"
                        )
                    }
                    item {
                        ProductCard(
                            imageRes = R.drawable.batu,
                            name = "Mèo Ba Tư vàng kem mã HML654",
                            price = "8.000.000 đ"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductCard(imageRes: Int, name: String, price: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp)
        )
        Text(text = name, fontSize = 14.sp, modifier = Modifier.padding(horizontal = 8.dp))
        Text(text = price, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Red)
    }
}
