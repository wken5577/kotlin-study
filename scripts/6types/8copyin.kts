// to 인자에 Array<Any> 타입 넣으려고 한다면 어떻게 될까??  error: type mismatch: inferred type is Array<Any> but Array<Copyin.Fruit> was expected
// kotlin의 타입 불변성이 해당 변수를 보호하기 때문에 컴파일 에러가 발생한다.
// to 파라미터에 in 키위드를 추가하면 Fruit의 부모 를 담고있는 List객체가 올 수 있게된다
// 또한 해당 값을 읽을 수 없고, 리턴하거나 다른 곳으로 보낼 수 없는 반공변성으로 만든다.

// 공변성은 부모 객체에 자식을 담을 수 있도록 하는것, 반공변성은 자식 객체에 부모를 담을 수 있는 것이라고 생각하면 된다.
// 또한 가변성이란 하위 자료형을 상위 자료형에 할당할 수 있는 것처럼 타입이 변할 수 있다는 성질을 의미한다.

open class Fruit
class Banana : Fruit()
class Orange : Fruit()

fun copyFromTo(from : Array<out Fruit>, to : Array<in Fruit>){
    for (i in 0 until from.size){
        to[i] = from[i]
    }
}
val things = Array<Any>(3) { _ -> Fruit() }
val bananaBasket = Array<Banana>(3) { _ -> Banana() }

copyFromTo(bananaBasket, things)