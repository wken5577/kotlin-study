// 명시적 타입캐스팅은 컴파일러가 타입을 확실하게 셜정할 수 없어 스마트 캐스팅을 하지 못할 경우에만 사용하자
// 예를들어 var 변수가 채크와 사용 사이에서 변경되었다면? 컴파일러는 스마트 캐스팅을 할 수 없다.
// kotlin은 명시적 타입 캐스트를 위해서 2가지 연산자를 제공한다 : as, as?

fun fetchMessage(id : Int) : Any =
        if (id == 1) "Record found" else StringBuilder("Record not found")

// as를 사용해서 명시적 타입 캐스팅을 할 수 있다.
// 하지만 as는 현재 코드에서 ClassCastException을 발생시킬 수 있다.
// 따라서 as?를 사용해서 케스트가 불가능할시에 null을 반환하도록 하고 후처리를 하는 것이 안전하다.
for(id in 1..2){
    println("Message length : ${(fetchMessage(id) as? String)?.length ?: "==="}")
}