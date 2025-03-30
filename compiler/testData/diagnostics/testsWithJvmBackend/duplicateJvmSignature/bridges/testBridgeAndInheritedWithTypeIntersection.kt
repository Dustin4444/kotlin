// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// ISSUE: KT-13712

interface RA
interface RB

object RImpl : RA, RB

interface Itf<T> where T : RA, T : RB {
    fun f(x: T) {
    }
}

open class A {
    open fun f(x: RA) {
    }
    open fun f(x: RB) {
    }
}

<!CONFLICTING_INHERITED_JVM_DECLARATIONS!>class ItfImpl : Itf<RImpl>, A()<!>
