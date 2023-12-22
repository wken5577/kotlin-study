// createPerson ("Jake", 12, 152, 43)
// 다음과 같이 함수를 호출한다면 각 인자가 어떤 의미인지 알기 어렵다.
// kotlin에서는 이런 문제를 해결하기 위해 named arguments를 제공한다.
// named arguments를 사용하면 인자의 이름을 명시할 수 있다.
// named arg를 사용할 때 꼭 모든 인자에 대해 이름을 명시할 필요는 없다.
// named arg를 사용하면 인자의 순서를 바꿀 수도 있다.

createPerson(name = "Jake", age = 12, weight = 43, height = 152)
createPerson("Jake", age = 12, height = 152, weight = 43)

fun createPerson(name : String, age: Int = 1, height : Int, weight : Int){
    println("Name: $name, Age: $age, Height: $height, Weight: $weight")
}