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
    fun InformationAndWarrantyPolicyScreen(  navController: NavController)
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
        {it ->
            Column(modifier= Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color(0xFFF3EDF7)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            )
            {
                Spacer(modifier= Modifier.padding(top = 30.dp))
                Box(modifier = Modifier
                    .size(680.dp, 130.dp)
                    .padding(top = 5.dp),
                )
                {
                    Text(text ="\t\t\tThông tin và chính sách" +
                            " \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbảo hành" ,
                        color = Color(0xFF2851D8),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp,
                        lineHeight = 30.sp,
                        modifier = Modifier
                            .background(color = Color(0xFFEAC4D5),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .align(Alignment.Center)
                    )
                }

                Text(
                    modifier = Modifier,
                    lineHeight = 25.sp,
                    softWrap = true,
                    text = "\tTất cả các bé thú cưng của PetHouse đều được bảo hành sức khỏe 7 ngày " +
                            "tính từ ngày bé về nhà mới. (Nhằm nâng cao chất lượng dịch vụ, Pet House " +
                            "mở bán gói dịch vụ bảo hành sức khỏe 365 ngày đối với khách hàng có nhu cầu)\n" +
                            "\tHỗ trợ và đồng hành tư vấn cùng khách hàng trong suốt quá trình nuôi thú cưng. " +
                            "Có bất kỳ vấn đề gì không rõ, khách hàng có thể gọi hoặc chát zalo với Pet" +
                            " House để được giải đáp nhanh nhất.\n" +
                            "`\tHơn thế nữa, chúng tôi sẽ hỗ trợ tư vấn cho khách hàng về dinh dưỡng và sức " +
                            "khỏe của bé trọn đời. Cụ thể là cách xử lý, điều trị các loại bệnh thông " +
                            "thường, hay làm sao để chăm cho bé mập, khỏe ,lông đẹp…\n" +
                            "\tTrong vòng 7 ngày đầu về nhà mới, nếu không may thú cưng của bạn bị bệnh, " +
                            "chúng tôi sẽ chịu hoàn toàn chi phí điều trị. Trường hợp xấu nhất là bé tử vong," +
                            " chúng tôi sẽ đền bù khách hàng một bé thú cưng khác có giá trị tương tự.\n" +
                            "\tPet House có liên kết với các bệnh viện thú y lớn ở Saigon và Hà Nội để hỗ trợ" +
                            " khách hàng và các bé thú cưng một cách nhanh và hiệu quả nhất, với chi phí tối ưu nhất.\n")
            }

        }

    }
