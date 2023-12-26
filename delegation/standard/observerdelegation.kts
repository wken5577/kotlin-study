/*
 * delegation으로 변수의 값이 변하는 것을 관측하는 방법을 알아보자
 * kotlin.properties.Delegates는 observable이라는 함수를 가지고 있다.
 * observable은 변경을 관측만 가능하고 변경을 허가할지 불허할지는 결졍하지 못한다.
 * vetoable을 사용한다면 변경을 허가 또는 불허할 수 있다.
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