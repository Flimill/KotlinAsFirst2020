@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import ru.spbstu.kotlin.typeclass.classes.defaultValue

/**
 * Класс "Величина с размерностью".
 *
 * Предназначен для представления величин вроде "6 метров" или "3 килограмма"
 * Общая сложность задания - средняя, общая ценность в баллах -- 18
 * Величины с размерностью можно складывать, вычитать, делить, менять им знак.
 * Их также можно умножать и делить на число.
 *
 * В конструктор передаётся вещественное значение и строковая размерность.
 * Строковая размерность может:
 * - либо строго соответствовать одной из abbreviation класса Dimension (m, g)
 * - либо соответствовать одной из приставок, к которой приписана сама размерность (Km, Kg, mm, mg)
 * - во всех остальных случаях следует бросить IllegalArgumentException
 */
fun Reg(s: String): Pair<Double, String> {
    if (!Regex("""\d+ [a-zA-Z]+""").matches(s)) throw IllegalArgumentException()
    return (Pair(Regex("""\d+""").find(s)!!.value.toDouble(), Regex("""[a-zA-Z]+""").find(s)!!.value))
}

class DimensionalValue(value: Double, dimension: String) : Comparable<DimensionalValue> {
    /**
     * Величина с БАЗОВОЙ размерностью (например для 1.0Kg следует вернуть результат в граммах -- 1000.0)
     */

    private fun check(value: Double, dimension: String): Pair<Double, Dimension> {
        val SetDimension = Dimension.values().toSet()
        val MapDimension = mutableMapOf<String, Dimension>()
        for (Dimension in SetDimension)
            MapDimension[Dimension.abbreviation] = Dimension

        val SetDimensionPrefix = DimensionPrefix.values().toSet()
        val MapDimensionPrefix = mutableMapOf<String, Double>()
        for (Prefix in SetDimensionPrefix)
            MapDimensionPrefix[Prefix.abbreviation] = Prefix.multiplier

        return if (dimension in MapDimension)
            Pair(value, MapDimension[dimension]!!)
        else if (dimension[0].toString() in MapDimensionPrefix && dimension.substring(1) in MapDimension)
            Pair(value * MapDimensionPrefix[dimension[0].toString()]!!, MapDimension[dimension.substring(1)]!!)
        else throw IllegalArgumentException()
    }

    val value = check(value, dimension).first


    /**
     * БАЗОВАЯ размерность (опять-таки для 1.0Kg следует вернуть GRAM)
     */
    val dimension = check(value, dimension).second

    /**
     * Конструктор из строки. Формат строки: значение пробел размерность (1 Kg, 3 mm, 100 g и так далее).
     */
    constructor(s: String) : this(Reg(s).first, Reg(s).second)

    /**
     * Сложение с другой величиной. Если базовая размерность разная, бросить IllegalArgumentException
     * (нельзя складывать метры и килограммы)
     */
    operator fun plus(other: DimensionalValue): DimensionalValue {
        if (this.dimension == other.dimension) {
            return DimensionalValue(this.value + other.value, this.dimension.abbreviation)
        } else throw IllegalArgumentException()
    }

    /**
     * Смена знака величины
     */
    operator fun unaryMinus(): DimensionalValue = TODO()

    /**
     * Вычитание другой величины. Если базовая размерность разная, бросить IllegalArgumentException
     */
    operator fun minus(other: DimensionalValue): DimensionalValue {
        if (this.dimension == other.dimension) {
            return DimensionalValue(this.value - other.value, this.dimension.abbreviation)
        } else throw IllegalArgumentException()
    }

    /**
     * Умножение на число
     */
    operator fun times(other: Double): DimensionalValue = TODO()

    /**
     * Деление на число
     */
    operator fun div(other: Double): DimensionalValue = TODO()

    /**
     * Деление на другую величину. Если базовая размерность разная, бросить IllegalArgumentException
     */
    operator fun div(other: DimensionalValue): Double = TODO()

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = TODO()

    /**
     * Сравнение на больше/меньше. Если базовая размерность разная, бросить IllegalArgumentException
     */
    override fun compareTo(other: DimensionalValue): Int = TODO()
}

/**
 * Размерность. В этот класс можно добавлять новые варианты (секунды, амперы, прочие), но нельзя убирать
 */
enum class Dimension(val abbreviation: String) {
    METER("m"),
    GRAM("g");
}

/**
 * Приставка размерности. Опять-таки можно добавить новые варианты (деци-, санти-, мега-, ...), но нельзя убирать
 */
enum class DimensionPrefix(val abbreviation: String, val multiplier: Double) {
    KILO("K", 1000.0),
    MILLI("m", 0.001);
}