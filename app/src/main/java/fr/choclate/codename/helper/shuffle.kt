import java.util.*


fun <T> Iterable<T>.shuffle(seed: Long? = null): MutableList<T> {
    val list = this.toMutableList()
    val random = if (seed != null) Random(seed) else Random()
    Collections.shuffle(list, random)
    return list
}