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
// apply는 apply를 마지막으로 호출한 객체에 컨텍스트에서 람다를 실행시킨다.
val res3 = Mailer().apply {
    from("asdasdasdasd")
    to("asdasdasdasd")
    subject("asdasdasdasd")
    body("asdasdasdasd")
}.send()


// run을 이용한 결과 얻기
// apply는 자기 자신의 참조를 리턴하는데 run은 람다의 결과를 리턴한다.
// 마지막에 타깃 객체를 유지하고 싶다면 apply, 람다의 결과를 유지하고 싶다면 run을 사용하면 된다.
val res4 = Mailer().run {
    from("asdasdasdasd")
    to("asdasdasdasd")
    subject("asdasdasdasd")
    body("asdasdasdasd")
    send()
}

// let을 이용해 객체를 아규먼트로 넘기기
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