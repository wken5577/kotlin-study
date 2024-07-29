// var -> mutable
// val -> immutable
// 결과는 0이 나온다. factor를 mutable로 선언했기 때문에 doubleIt 함수가 실행되는 시점에 factor의 값이 0이 되었기 때문이다.

var factor = 2
fun doubleIt(n : Int) = n * factor
factor = 0
println(doubleIt(2))