package javakotlin

data class Counter(val value : Int){
    operator fun plus(other : Counter) = Counter(value + other.value)

    companion object {
        @JvmStatic
        fun create() = Counter(0)
    }
}
