package apps

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import java.lang.Exception

data class Airport(@Json(name = "IATA") val code: String,
                   @Json(name = "Name") val name: String,
                   @Json(name = "Delay") val delay: Boolean) {
    companion object {
        fun sort(airports: List<Airport>): List<Airport> {
            return airports.sortedBy { it.name }
        }

        fun fetchData(code: String): String {
            throw NotImplementedError("not implemented")
        }

        fun getAirportData(code: String): Airport {
          try{
              return Klaxon().parse<Airport>(fetchData(code)) as Airport
          } catch (ex : Exception) {
            return Airport(code, "Invalid Airport", false)
          }
        }
    }
}