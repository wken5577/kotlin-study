import kotlin.concurrent.fixedRateTimer

data class Person(val firstName : String, val age : Int)

val people = listOf(
    Person("Sara", 12),
    Person("Jill", 51),
    Person("Paula", 23),
    Person("Paul", 25),
    Person("Mani", 12),
    Person("Jack", 70),
    Person("Sue", 10)
)


/**
 * 내부 반복자를 이용해서 20살 이상인 사람의 이름을 대문자로 바꾸고 콤마로 구분해보자
 * filter는 people의 데이터를 20살 이상인 사람들로 필터링하고
 * map은 firstName을 추출하여 list로 만들고 해당 리스트를 또 uppercase해서 list로 만드는 역할을 했다
 * reduce의 첫번째 인자는 내부반복하며 지금까지 누적한 누적값을 두번째 인자는 현재 반복중인 데이터를 의미한다.
 * 첫번째 인자는 바로 이전 반복에서 리턴받은 데이터를 누적해서 인자로 받는다.
 */

val result = people.filter { person -> person.age > 20 }
    .map { person -> person.firstName }
    .map { name -> name.uppercase()}
    .reduce { names, name -> "$names, $name"}
//    .joinToString(", ") -> reduce함수 말고도 joinToString 사용 가능

println(result) //JILL, PAULA, PAUL, JACK

/**
 * totalAge = people.map { person -> person.age }
 *               .sum()
 * 다음과 같이 reduce()대신에 특화된 reduce연산인 sum을 사용할 수도 있다
 */
val totalAge = people.map { person -> person.age }
    .reduce { total, age -> total + age}

println(totalAge) // 203


/**
 *  플랫맵, 플랫화
 *  List<List<Person>> 같은 중첩된 리스트가 있다고 가정해보자
 */

val families = listOf(
    listOf(Person("Jack", 40), Person("Jill", 40)),
    listOf(Person("Eve", 18), Person("Adam", 40))
)

println(families.size) //2
println(families.flatten().size) //4

/**
 * map을 이용해서 name을 소문자로 바꾸고
 * flatMap을 활용해서 List<List<String>>의 형태를 만들어줌과 동시에 List<String>으로 변환했다
 */
val namesAndReversed = people.map { person -> person.firstName }
    .map { name -> name.lowercase() }
//    .map { name -> listOf(name, name.reversed()) } //여기까지 진행시 List<List<String>>의 형태
//    .flatten()
    .flatMap { name -> listOf(name, name.reversed()) } // flatMap을 활용하면 map,과 flatten함수를 동시에 활용한 것처럼 동작

println(namesAndReversed) // [sara, aras, jill, llij, paula, aluap, paul, luap, mani, inam, jack, kcaj, sue, eus]


/**
 * 정렬 후 firstname만 호출해서 모으기
 */

val namesSortByAge = people.filter { person -> person.age > 17 }
    .sortedBy { person -> person.age }
    .map { person -> person.firstName }

println(namesSortByAge) //[Paula, Paul, Jill, Jack]

/**
 * 객체를 그룹핑하기
 * groupBy는 람다가 리턴한 값을 key로하여 map에 저장하고 같은 key를 같은 것끼리 그룹핑한다.
 * 연산의 결과는 Map<L, List<T>>이다
 */

val groupBy1stLetter = people.groupBy { person -> person.firstName.first() }

println(groupBy1stLetter.get('S')) // [Person(firstName=Sara, age=12), Person(firstName=Sue, age=10)]

// 두번째 람다 파라미터도 사용할 수 있는데 첫번째 파라미터는 key를 만드는데 사용,
// 두번째는 value에 들어갈 리스트를 만드는데 사용가능

val namesBy1stLetter = people.groupBy (
    { person -> person.firstName.first() },
    { person -> person.firstName } // Person의 list가 아닌 String의 list를 value로 보관
)
println(namesBy1stLetter.get('S')) // [Sara, Sue]
