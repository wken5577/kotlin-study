// {} 블록 바디를 이용해서 함수를 정의하면 항상 리턴 타입을 명시해야 한다.
// 코틀린은 블록 안으로 들어가서 타입을 추론하지 않는다
// 따라서 블록 바디를 사용하면 리턴타입은 Unit으로 추론된다.

fun max (numbers : IntArray) : Int{
    var large = Int.MIN_VALUE
    for (number in numbers){
        large = if (number > large) number else large
    }
    return large
}
println(max(intArrayOf(1,2,3,4,5,6,7,8,9,10)))