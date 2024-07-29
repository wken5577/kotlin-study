/*
 * 코틀린에서 내부 반복자는 콜렉션 사이즈가 작을 때 사용해야 한다.
 * 사이즈가 큰 콜렉션에서는 시퀀스를 사용해서 내부 반복자를 사용해야 한다.
 * 이유는 콜렉션의 연산이 계속 실행되는 것과는 다르게 시퀀스에서 호출되는 함수는 지연되어 실행된다.
 * 지연 연산은 코트의 실행이 불필요한 경우 실행을 연기한다는 것이다.
 */

class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31),
        Person("Charles", 22), Person("Dan", 21), Person("Eli", 19), Person("Frank", 30))

fun isAdult(person: Person) : Boolean {
    println("isAdult = ${person.age}")
    return person.age >= 21
}

fun fetchFirstName(person : Person) : String {
    println("first name = ${person.name}")
    return person.name
}

/*
 * 시퀀스를 사용하지 않으면 모든 사람의 나이를 확인하여 성인인지 확인하고, 성인이면 이름을 확인한다.
 * n * 2 번의 연산이 필요하다.
 */

val nameOfFirstAdult = people
    .filter(::isAdult)
    .map (::fetchFirstName)
    .first()
println(nameOfFirstAdult)

/*
 * asSequence를 사용하면 filter, map연산은 first()에서 호출되기 전까지 실행되지 않는다.
 * first()가 호출되면서 필요한 최소한의 연산만 실행한다.
 * 콜렉션의 크기가 크다면 sequance를 사용하자
 * 하지만 콜렉션의 크기가 작다면 그냥 collection에서 내부반복자를 실행시키자, 그래야 디버그하기 편하고 추론하기 쉽다.
 */

println("====== sequance ======")
val nameOfFirstAdultSeq = people.asSequence()
    .filter (::isAdult)
    .map (::fetchFirstName)
    .first()
println(nameOfFirstAdultSeq)


/*
 * generateSequence를 사용해서 무한 시퀀스를 만들 수 있다.
 * tailrec은 stackoverflow를 방지하기 위해 사용한다.
 */
fun isPrime(n : Long) = n > 1 && (2 until n).none { i -> n % i == 0L }
tailrec fun nextPrime(n : Long) : Long =
    if (isPrime(n + 1)) n + 1 else nextPrime(n + 1)

/*
 * 5부터 시작하는 소수의 무한 시퀀스
 * generateSequence함수는 첫번째 인자로 시작점, 두번째 인자로 다음 데이터를 만드는 람다를 받는다
 *
 * 무한 시퀀스는 시간, 공간적으로 말이 안되는 것처럼 보인다.
 * 하지만 시퀀스는 지연 연산이기 때문에 실제로는 5부터 시작하는 소수의 무한 시퀀스를 만들지 않는다.
 * take메소드를 사용해서 요청할 때까지 시퀀스를 만들지 않는다. (그래서 무한 시퀀스가 가능한 것임)
 */
println("====== generateSequence ======")
val primes = generateSequence(5, ::nextPrime)
println(primes.take(10).toList())

/*
 * sequance함수를 이용해서 시퀀스를 만들 수 있다.
 * sequence 안에 소수를 생성하는 무한루프 구현
 */

val primes2 = sequence {
    var i : Long = 0
    while (true) {
        i++
        if (isPrime(i)) yield(i) // 값을 호출자에게 리턴
    }
}
println(primes2.take(10).toList())

// drop()함수로 앞에 2개를 버릴 수도 있다
println(primes2.drop(2).take(10).toList())