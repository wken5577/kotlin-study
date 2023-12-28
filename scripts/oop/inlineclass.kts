/*
* 클래스를 만들면 명확성 띌 수 있다는 장점이 있다.
* 하지만 단순하게 프리미티브 타입으로 정의할 수 있는 데이터도 클래스로 만들면 오버헤드가 발생한다.
* inline클래스는 컴파일 시간에는 클래스의 장점을 취할 수 있고, 실행 시간에는 프리미티브 타입으로 취급된다.
* 예제에서 receiveSSN함수는 컴파일시에 SSN이 아닌 String을 받도록 변경되어 컴파일된다.
* 하지만 코틀린 컴파일러는 receiveSSN함수를 호출할 때 SSN인스턴스를 이용했는지를 검증한다.
* */

inline class SSN(val id: String)
fun receiveSSN(ssn : SSN){
    println("received $ssn")
}