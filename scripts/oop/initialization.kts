/*
* class는 0개 이상의 init블록을 가질 수 있다. 이 블록들은 주 생성자의 실행의 한 부분으로써 실행된다.
* init블록의 코드는 top-down으로 순차적으로 실행된다.
* */

import java.lang.RuntimeException

class Car(val yearOfMake: Int, theColor : String){
    var fuelLevel = 100
        private set
    var color = theColor
        set(value){
            if (value.isBlank())
                throw RuntimeException("no empty")
            field = value
        }
    init {
        if (yearOfMake < 2020) fuelLevel = 90
    }
}