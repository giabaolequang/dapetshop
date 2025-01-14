import java.util.Date

data class dataUser(
    val user_id: Int,
    val user_name: String,
    val user_sex :Boolean,
    val user_birthday: Date,
    val user_phone: Int,
    val user_address: String,
    val user_password: String,
   	val user_type: String,
    val user_numberofpurchases: Int,
    val user_note: String
)