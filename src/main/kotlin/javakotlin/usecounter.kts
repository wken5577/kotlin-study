import javakotlin.Counter

//kotlin에서는 연산자 오버로딩이 가능하기 때문에 다음과 같이 더할 수 있다
//하지만 Java에서 사용할 때는 불가능하다. 대신 plus함수를 쓰면 된다.
val counter = Counter(1)
println(counter + counter)
