import java.io.StringWriter
import java.lang.Appendable

// fun <T : AutoClosable> useAndClose(input : T) = inpit.close()
// 다음과 같이 지네릭 타입에 제약을 걸어서 AutoClosable를 구현한 클래스만이 T에 올 수 있도록 만들 수 있다.
// 제약조건이 여러 개라면 where을 사용하여 제약조건을 걸 수 있다.


// T는 AutoCloseable과 Appendable를 모두 구현한 객체만 올 수 있다.
fun <T> useAndclose(input : T)
where T : AutoCloseable,
        T : Appendable {
    input.append("there")
    input.close()
}

val writer = StringWriter()
writer.append("hello ")
useAndclose(writer)
println(writer)