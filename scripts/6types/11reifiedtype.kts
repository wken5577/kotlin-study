
abstract class Book(val name : String)
class Fiction(name : String) : Book(name)
class NonFiction(name : String) : Book(name)

val books : List<Book> = listOf(Fiction("aa"), NonFiction("aaaa"), Fiction("DS"))

// books에는 Fiction과 NonFiction이 섞여있다. 이제 우리가 list안의 Fiction과 NonFiction중 특정 타입의 첫 번째 인스턴스를 찾아야 한다면?
// 코틀린 코드를 Java처럼 이런식으로 작성할 수도 있을 것이다.
// 하지만 이런식으로 작성한다면 실행 시간에 타입 정보를 계속해서 추가적인 아규먼트로 전달해야 한다

/*

fun <T> findFirst(books : List<Book>, ofClass: Class<T>) : T {
    val selected = books.filter { book -> ofClass.isInstance(book)}
    if (selected.size == 0)
        throw RuntimeException("Not found")
    return ofClass.cast(selected[0])
}

println(findFirst(books, NonFiction::class.java).name)

*/

// kotlin에는 reified 타입 파라미터라는 좋은 대용품이 있다
// kotlin은 파라미터 타입이 reidied라고 마크되어 있고 함수가 inline으로 선언 되었다면 우리가 파라미터 타입을 사용할 수 있도록 권한을 준다.
// reidied는 inline함수에서만 사용 가능하다
// 다음은 java style의 findFirst를 리팩토링 한 것이다 (T를 타입 체크와 캐스팅용으로 사용)

inline fun <reified T> findFirst (books : List<Book>) : T{
    val selected = books.filter { book -> book is T }
    if (selected.size == 0)
        throw RuntimeException("Not found")
    return selected[0] as T
}

println(findFirst<NonFiction>(books).name) //aaaa