/*
 * also, apply, let, run
 * 해당 참조에서 여러 일을 행할 수 있다. (에를들어 여러 함수 호출 등)
 * 각 메소드의 receiver가 다르고 리턴되는 값도 다르다.
 */

val format = "%-10s%-10s%-10s%-10s"
val str = "context"
val result = "RESULT"
fun toString() = "lexical"
println(String.format("%-10s%-10s%-10s%-10s%-10s", "Method", "Argument", "Receiver", "Return", "Result"))
println("========================================================")

val result1 = str.let { arg ->
    print(String.format(format, "let", arg, this, result))
    result
}
println(String.format("%-10s", result1))
val result2 = str.also { arg ->
    print(String.format(format, "also", arg, this, result))
    result
}
println(String.format("%-10s", result2))
val result3 = str.run {
    print(String.format(format, "run", "N/A", this, result))
    result
}
println(String.format("%-10s", result3))
val result4 = str.apply {
    print(String.format(format, "apply", "N/A", this, result))
    result
}
println(String.format("%-10s", result4))

/**
 *   Method    Argument  Receiver  Return    Result
 *  ========================================================
 *  let       context   lexical   RESULT    RESULT
 *  also      context   lexical   RESULT    context
 *  run       N/A       context   RESULT    RESULT
 *  apply     N/A       context   RESULT    context
 *
 *  결과를 살펴보면
 *  let: let을 호출한 객체를 아규먼트로 전달, this의 스코프는 lexical 스코프이고 람다가 리턴한 결과가 let의 호출 결과로 리턴된다.
 *  also: also를 호출한 객체를 아규먼트로 전달, this의 스코프는 lexical 스코프이고 결과를 무시하고 자기자신을 리턴한다.
 *   -> also가 전달받은 람다의 리턴 타입은 Unit이기때문에 result의 리턴이 무시되는 것이다.
 *
 *   run: 람다에 아규먼트 x, 실행 객체(String)를 this에 바인딩한다. 리턴값 무시되지 않음
 *   apply: 람다에 아규먼트 x, 실행 객체(String)를 this에 바인딩한다. 리턴값 무시됨 (자기자신 리턴)
 */



// 장황한 코드를 구현해봤다.
class Mailer {
    val details = StringBuilder()
    fun from(addr : String) = details.append("from: $addr\n")
    fun to(addr : String) = details.append("to: $addr\n")
    fun subject(line : String) = details.append("subject: $line\n")
    fun body(msg : String) = details.append("body: $msg\n")
    fun send() = "...sending...\n $details"
}

val mailer = Mailer()
mailer.from("aaaaa@asd.com")
mailer.to("asdasd@asdasd.com")
mailer.subject("subject")
mailer.body("body")
val res = mailer.send()
println(res)

// apply를 사용하면 이렇게 간단하게 구현할 수 있다. (반복 참조 제거, 체이닝 가능)
val res2 = Mailer()
    .apply { from("asdasdasdasd") }
    .apply { to("asdasdasdasd") }
    .apply { subject("asdasdasdasd") }
    .apply { body("asdasdasdasd") }
    .send()


// apply를 다음과 같이 사용하여 축약할 수도 있다
// apply는 apply를 호출한 객체에 컨텍스트에서 람다를 실행시킨다. 즉 Mailer에서 from, to 등의 함수들이 실행된다
val res3 = Mailer().apply {
    from("asdasdasdasd")
    to("asdasdasdasd")
    subject("asdasdasdasd")
    body("asdasdasdasd")
}.send()

/**
 * run을 이용한 결과 얻기
 * apply는 자기 자신의 참조를 리턴하는데 run은 람다의 결과를 리턴한다.
 * 마지막에 타깃 객체를 유지하고 싶다면 apply, 람다의 결과를 유지하고 싶다면 run을 사용하면 된다.
 * run 역시 run을 호출한 객체에 컨텍스트에서 람다를 실행시킨다.
 * 대신 결과를 호출한 객체를 리턴하는 것이 아닌 람다함수의 결과를 리턴하기 때문에 send 함수의 결과인 String이 반환된다.
 */

val res4 = Mailer().run {
    from("asdasdasdasd")
    to("asdasdasdasd")
    subject("asdasdasdasd")
    body("asdasdasdasd")
    send()
}

/**
 * val mailer = createMailer()
 * val result = prepareAndSend(mailer)
 * -> 두 함수를 이용하는 코드가 좀 가독성이 좋지는 않다.
 *
 * let을 이용해 객체를 아규먼트로 넘기기
 * createMailer().let { mailer -> prepareAndSend(mailer) } 이렇게 수정이 가능하다
 * 단순히 람다의 arg를 특정 함수에 넘기기만 한다면 코드를 다음과 같이 더 간결하게 할 수 있다
 *  createMailer().let(::prepareAndSend)
 */

fun createMailer() = Mailer()
fun prepareAndSend(mailer : Mailer) = mailer.run {
    from("asdasdasdasd")
    to("asdasdasdasd")
    subject("asdasdasdasd")
    body("asdasdasdasd")
    send()
}

val res5 = createMailer().let(::prepareAndSend)


// also를 사용한 void함수 체이닝
// also는 체이닝을 사용할 수 없는 void함수를 체이닝 하려고 할 때 유용하다
fun prepareAndSend2(mailer: Mailer) : Unit {
    mailer.run {
        from("asdasdasdasd")
        to("asdasdasdasd")
        subject("asdasdasdasd")
        body("asdasdasdasd")
    }
}

fun sendMail(mailer : Mailer) : Unit {
    mailer.send()
    println("Mail sent")
}

createMailer().also(::prepareAndSend2).also(::sendMail)