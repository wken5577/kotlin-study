// 공변성을 활용하면 Array<T>에 T를 상속받은 F가 있을 때 Array<F>를 대입할 수 있다.
// 즉 컴파일러가 자식 클래스를 부모 클래스에 자리에 사용할 수 있도록 해준다.
// 하지만 해당 변수는 읽기만 수행이 가능하도록 된다.

open class Fruit
class Banana : Fruit()
class Orange : Fruit()

//out을 사용해서 Fruit의 자식 객체들을 담은 Array를 받을 수 있도록 했다. 이제 from는 readonly가 되었고 다음과 같은 연산은 error를 발생시킨다.
// from[i] = Fruit()
// from.set(i, to[i])

fun copyFromTo(from : Array<out Fruit>, to : Array<Fruit>){
    for (i in 0 until from.size){
        to[i] = from[i]
    }
}

val fruitBasket = Array<Fruit>(3) { _ -> Fruit()}
val bananaBasket = Array<Banana>(3) { _ -> Banana()}
copyFromTo(bananaBasket, fruitBasket)