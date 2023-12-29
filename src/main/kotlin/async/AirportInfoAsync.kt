package async

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
 * async의 결과는 Deferred로 감싸져서 나온다.
 * async는 즉시 Deffered<Airport?>를 반환하고
 * 마지막에 해당 결과값들을 await로 받아서 처리한다.
 *
 * async를 아규먼트 없이 바로 사용한다면 main쓰레드가 Airport.getAirportData(code)를 비동기적으로 실행하기 때문에 성능상에 이득이 없다
 * 왜냐하면 main쓰레드가 비동기 작업도 해야하기 때문에 결국 await에 도달해서야 직접적으로 apicall을 하게 되기 때문이다.
 * 따라서 async에 (Dispatchers.IO)를 넣어서 비동기 작업을 다른 코루틴컨텍스트(쓰레드)에서 실행하도록 해야한다.
 *
 */

fun main(){
    runBlocking {
        val format = "%-10s%-20s%-10s"
        println(String.format(format, "Code", "Temperature", "Delay"))
        val time = measureTimeMillis {
            val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
            val airportData : List<Deferred<Airport?>> =
                airportCodes.map {code ->
                    async (Dispatchers.IO){
                        Airport.getAirportData(code)
                    }
                }
            airportData.mapNotNull { it.await() }
                .forEach {
                    println(String.format(format, it.code, it.weather.temperature[0], it.delay))
                }
        }
        println("Time taken: $time ms")
    }
}