package async16

import kotlinx.coroutines.*


/*
 * launch를 사용하고 에러를 핸들링하려면 exception handler를 반드시 설정해야 한다.
 * CoroutineExceptionHandler가 등록되어 있다면 컨텍스트 세부사항과 예외 정보와 함께 핸들러가 트리거된다.
 * launch함수는 코루틴이 시작됐다는 의미를 가지는 JOB객체를 리턴한다. 우리는 Job객체를 코루틴이 성공하던 실패하던 일단 종료되는 것을 기다리는데 사용할 수 있다.
 * join함수를 호출하면 해당 코루틴이 종료될 때까지 기다린다.
 * 그리고 Job객체의 isCanceled 프로퍼티를 이용해서 작업이 성공적으로 완료되었는지 아니면 실패했는지 알 수 있다.
 *
 *
 */
fun main() = runBlocking {
    val handler = CoroutineExceptionHandler{
        context, ex ->
        println("Caught : ${context[CoroutineName]} : ${ex.message}")
        println("context thread: ${Thread.currentThread().name}")
    }
    try{
        val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
        val jobs : List<Job> = airportCodes.map { code ->
            launch(Dispatchers.IO + CoroutineName(code) + handler + SupervisorJob()){
                val airport = Airport.getAirportData(code)
                println("${airport?.code} : ${airport?.weather?.temperature}")
            }
        }
        jobs.forEach { it.join() }
        jobs.forEach { println("Canceled : ${it.isCancelled}") }
    } catch (ex : Exception){
        println("Caught : ${ex.message}")
    }
}