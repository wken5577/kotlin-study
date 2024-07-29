/*
 * delegation으로 변수의 값이 변하는 것을 관측하는 방법을 알아보자
 * kotlin.properties.Delegates는 observable이라는 함수를 가지고 있다.
 * observable은 변경을 관측만 가능하고 변경을 허가할지 불허할지는 결졍하지 못한다.
 * vetoable을 사용한다면 변경을 허가 또는 불허할 수 있다.
 *
 * observable은 람다식을 받고 해당 인벤트 함수를 값 변경시 호출한다.
 * 이벤트 함수는 속성, 이전 값, 새로운 값에 대한 파라미터 3개를 받는다. 그리고 아무것도 리턴하지 않는다.
 */

import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

var count by observable(0) { prop, old, new ->
    println("${prop.name} : $old -> $new")
}
println("count = $count")
count++
println("count = $count")
count--
println("count = $count")


println("=====vetoble=====")
/**
 * vetoable은 Boolean을 리턴하는 핸들러를 등록하여 그 값에 따라서 변경을 허가 또는 불허할 수 있다.
 */
var count1 by vetoable(0) { prop, old, new ->
    println("${prop.name} : $old -> $new")
    new >= 0
}
println("count1 = $count1")
count1++
println("count1 = $count1")
count1--
println("count1 = $count1")
count1--
println("count1 = $count1")