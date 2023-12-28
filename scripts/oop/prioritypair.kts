/**
 * first와 second를 정렬해서 보관하는 priortypair를 만들어보자
 * 생성자의 두 인자를 compareTo로 비교할 것이기 때문에 T는 Comparable을 구현한 객체여야 한다.
 */

class PrioirtyPair<T : Comparable<T>> (member1 : T, member2 : T){
    val first : T
    val second : T
    init{
        if (member1 >= member2){
            first = member1
            second = member2
        }else{
            first = member2
            second = member1
        }
    }

    override fun toString(): String {
        return "$first, $second"
    }
}

println(PrioirtyPair<Int>(2, 1)) //2, 1
println(PrioirtyPair<String>("A", "B")) //B, A