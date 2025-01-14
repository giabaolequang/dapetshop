import java.util.Date

data class DataPet
    (
   val pet_id: Int,
   val pet_type: String,
   val pet_name: String,
   val pet_breed :String,
   val pet_color: String,
   val pet_origin: String,
   val pet_status: Boolean,
   val pet_details_id: Int,
   val pet_health: String,
   val pet_vaccinationDay: Date,
   val pet_dewormingStatus: Boolean,
   val pet_dewormingDay: Date,
   val pet_decristion : String
            )


