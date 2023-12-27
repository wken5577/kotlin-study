
/*
 * 우리는 서드파티 클래스의 연산저도 오버로딩할 수 있다.
 */

operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(first + other.first, second + other.second)
}

/*
 * 복소수를 나타내는 클래스에 두 개의 복소수를 곱하기 위해 * 연산자를 오버로딩한다.
 * times 메소드는 * 연산자를 의미하고 위에서 본 plus 연산자는 + 연산자를 의미한다.
 * 이런식으로 연산자를 나타내기 위해서 특화된 메소드 이름이 아닌 메소드에 operator 키워드를 사용하면 에러가 발생한다.
 */

data class Complex(val real: Int, val imaginary: Int){
    operator fun times(other: Complex): Complex {
        return Complex(real * other.real - imaginary * other.imaginary,
                real * other.imaginary + imaginary * other.real)
    }
    private fun sign () = if (imaginary < 0) "-" else "+"
    override fun toString(): String {
        return "$real ${sign()} ${Math.abs(imaginary)}i"
    }
}

println(Complex(1, 2) * Complex(2, 3))

/*
 * 연산자를 오버로딩할 때에는 규칙이 있다
 * 예를 들어서 +나 - 연산자를 오버로딩할 때 객체를 변경하면 안된다.
 * 이런 규칙은 객체를 변경시키는 ++이나 -- 연산자에도 적용이 된다. 해당 연산자들은 객체를 변경시켜야 한다.
 */

class Counter(val value : Int){
    operator fun inc() = Counter(value + 1)
    operator fun dec() = Counter(value - 1)
    override fun toString() = "$value"
}

var counter = Counter(10)
println(counter)
println(counter++)
println(++counter)
println(counter--)
println(--counter)
