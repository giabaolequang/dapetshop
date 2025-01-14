import java.util.Date

data class DataPromotion
    (
    val prom_id:Int,
    val prom_name:String,
    val prom_decription : String,
    val prom_discount: Int,
    val prom_startdate: Date,
    val prom_enddate: Date,
    val prom_status: Boolean
            )