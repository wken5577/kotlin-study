package async16

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import java.net.URL

class Weather(@Json(name = "Temp") val temperature : Array<String>)

class Airport (
    @Json(name = "IATA") val code : String,
    @Json(name = "Name")  val name : String,
    @Json(name = "Delay") val delay : Boolean,
    @Json(name = "Weather") val weather : Weather
) {
    companion object{
        fun getAirportData(code : String) : Airport?{
            // add some request entry point
            val url = "https://soa.smext.faa.gov/asws/api/airport/status/$code"
            return Klaxon().parse<Airport>(URL(url).readText())
        }
    }
}