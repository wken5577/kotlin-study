// kotlin은 try-catch를 강제하지 않는다.
// 개발자가 직접 다루지 않는 예외는 자동으로 호출한 코드로 전파된다.

println("test test")
Thread.sleep(1000)
println("hello")