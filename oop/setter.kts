// 코틀린에서 class의 필드는 필요한 경우에만 자동으로 생성된다.
// 커스텀 getter, setter를 가진 필드를 정의하고 field키워드를 사용한 백킹 필드를 사용하지 않는다면 백킹 필드가 생성되지 않는다.
// getter나 setter중 하나만 작성한다면 필드가 생성된다.


/*
* 여기서 생성자에 우리는 하나의 속성(yearOfMAke)를 정의하고 theColor이라는 하나의 파라미터 (필드가 아님)를 사용했다
* 이 파라미터에는 val이나 var을 사용하지 않았다.
* 클래스 내부에서 fuelLevel이라는 속성을 생성하고 값을 100으로 초기화했다
* fuelLevel의 타입은 컴파일러의 타입 추론 기능으로 Int가 된다 fuelLevel 속성은 생성자에 전달되는 파라미터에 의해서 성정되지 않는다.
* 속성 color를 생성하면서 생성자에서 받아온 파라미터인 theColor값을 color에 할당했다.
* fuelLevel속성에 사용되는 getter, setter은 자동으로 생성된다.
* color 속성은 getter만 만들고 setter은 아래 정의한 set 함수를 사용하게 된다.
* */

import java.lang.Exception
import java.lang.RuntimeException

class Car (val yearOfMake : Int, theColor : String){
    var fuelLevel = 100
    var color = theColor
        // set method앞에 접근 제어자 (private, protected등)을 사용할 수 있다
        set(value){
            if (value.isBlank())
                throw RuntimeException("Blank XXXX")
            field = value
        }
}

val car = Car(2019, "Red")
car.color = "Green"
car.fuelLevel--
println(car.fuelLevel) //99
try{
    car.color = ""
} catch (ex : Exception){
    println(ex.message)
}
println(car.color) //Green
