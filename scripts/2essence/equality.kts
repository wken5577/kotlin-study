// java의 equals메소드, 코틀린의 == 연산자는 값을 비교
// java의 == 연산자, 코틀린의 === 연산자는 참조를 비교

// kotlin에서의 equals(==)는 java보다 뛰어나다. null 참조를 안전하게 다루기 때문

println("hi" == "hi")
println("hi" == "Hi")
println(null == "hi")
println("hi" == null)
println(null == null)