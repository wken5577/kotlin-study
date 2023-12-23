// 인자로 list를 받을 때에는 List<Fruit>에 List<Banana>를 전달할 수 있다
// 하지만 array를 받을 때에는 Array<Fruit>에 Array<Banana>를 전달하려고 할 때 컴파일 에러를 발생시킨다.
// Array는 제한하고 List는 풀어주는 것이다. 왜냐하면 Array<T>는 뮤터블 하지만 List<T>는 이뮤터블하다.

open class Fruit을
class Banana : Fruit()
class Orange : Fruit()

fun receiveFruits(fruits : List<Fruit>){
    println("Number of fruits : ${fruits.size}")
}

val bananas : List<Banana> = listOf()
receiveFruits(bananas)

