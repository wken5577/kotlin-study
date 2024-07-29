// kotlinc-jvm Hello.kt -d Hello.jar -> Hello.kt 파일을 jar파일로 변환시킨다.

// java -jar Hello.jar
// jar 파일로 변환 되었기 때문에 다음과 같이 실행시킬 수 있으나 kotlin native라이브러리를 사용했다면
// java -classpath Hello.jar:$KOTLIN_PATH/lib/kotlin-stdlib.jar HelloKt classpath를 다음과 같이 명시해야 한다.
// 그렇지 않으면 NoClassDefFoundError error가 발생한다

// kotlin -classpath Hello.jar HelloKt
// java와 kotlin은 혼용하는 경우에는 위처럼 java를 활용하고 kotlin만 사용한다면 다음과 같이 코틀린 툴을 사용해서 실행하자
// 이러면 kotlin-stdlib.jar를 참조할 필요가 없다.

fun main() = println("Hello World")