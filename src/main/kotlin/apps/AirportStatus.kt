package apps

suspend fun getAirportStatus(airportCodes : List<String>) : List<Airport> =
    Airport.sort(airportCodes.map { Airport.getAirportData(it) })