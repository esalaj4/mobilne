package hr.ferit.petrakis.lv7

data class Products(
    val id: String,
    val brand: String,
    val name: String,
    val price : String,
    val price_sign: String?,
    val currency: String?,
    val image_link:String,
    val product_link: String,
    val website_link: String,
    val description:String,
    val rating: Float,
    val category:String?, //znaci da moze biti i null vrijednost
    val product_type: String

)
