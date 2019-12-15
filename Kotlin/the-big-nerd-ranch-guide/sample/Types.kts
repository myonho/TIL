/**
 * variable and constant
 * static type system
 * */

class SamplePrimitiveType(
    val string: String,
    val char: Char,
    val Bool: Boolean,
    val int: Int,
    val doub: Double,
    val list: List<Any>,
    val set: Set<Any>,
    val map: Map<Any>
)

/** val は厳密には再代入可能
 * const は 決定的にイミュータブル（compile-time constant）: コンパイル時定数*/
val fuga
/** valは関数の実行時に代入される constはコンパイル時に代入される ので、static typeである必要がある */
const val piyo
