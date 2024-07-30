package async16

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
        val airportData : List<Deferred<Airport?>> =
            airportCodes.map {code ->
                async (Dispatchers.IO){
                    Airport.getAirportData(code)
                }
            }
        for (data in airportData) {
            try{
             data.await()
            }catch (e: Exception){
                println("Error: ${e.message}")
            }
        }
    }
}