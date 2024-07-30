package async16

import kotlin.system.measureTimeMillis


fun main(){
    val format = "%-10s%-20s%-10s"
    println(String.format(format, "Code", "Temperature", "Delay"))
    val time = measureTimeMillis {
        val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
        val airportData : List<Airport> =
            airportCodes.mapNotNull { Airport.getAirportData(it) }
        airportData.forEach {
            println(String.format(format, it.code, it.weather.temperature[0], it.delay))
        }
    }
    println("Time taken: $time ms")
}