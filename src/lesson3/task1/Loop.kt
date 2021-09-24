@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var k = 0
    var x = n
    if (x == 0) return 1
    while (x > 0) {
        x = (x / 10)
        k++
    }
    return k
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var a = 1
    var b = 1
    var c = 1
    for (i in 3..n) {
        c = a + b;
        a = b
        b = c
    }
    if (n <= 2) return 1
    else return c
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var del = 0
    var k = 1
    while (del == 0) {
        k++
        if (n % k == 0) del = k
    }
    return del
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var del = 0
    var k = 1
    while (del == 0) {
        k++
        if (n % k == 0) del = k
    }
    return (n / del)
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var y = x
    var count = 0
    while (y != 1) {
        y= when {
            y % 2 == 0 -> y/ 2
            else -> 3 * y + 1
        }
        count++
    }
    return count

}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    val x = if (m > n) m else n
    for (i in x..(m * n - 1)) {
        if ((i % n == 0) && (i%m == 0)) return i
    }
    return m * n
}


/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    for (i in 2..m) {
        if ((n % i == 0) && (m % i == 0)) return false
    }
    return true
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean = TODO()

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var x = n
    var n2 = 0
    if (n < 10) return n
    while (x > 0) {
        n2 = n2 * 10 + x % 10
        x /= 10

    }
    return n2
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var x = n
    var k = 0
    var a = 0
    var b = 0
    if (n < 10) return true
    while (x > 0) {
        x /= 10
        k++
    }
    for (i in 1..(k / 2)) {
        //15751
        a = (n / (10.0.pow((k - i).toDouble())).toInt()) % 10
        if (i == 1) b = n % 10
        else b = (n / (10.0.pow((i - 1).toDouble())).toInt()) % 10
        if (a != b) return false
    }
    return true
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var mn = setOf<Int>()
    var x = n
    if (x < 10) return false
    while (x > 0) {
        mn += x % 10
        x /= 10
    }
    if (mn.count() == 1) return false
    return true
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var x0 = x
    var zn = 1
    var k1=0
    var k2=0
    while (x0 - 2 * PI*k1 > 0.0) k1++
    x0-=2 * PI*k1
    while (x0 + 2 * PI*k2 < 0.0) k2++
    x0+=2 * PI*k2
    if (x0 >= PI) {
        zn = -1
        x0 -= PI
    }
    var a = x0
    var sin=x0
    var factor = 1 * 2 * 3
    var n = 3
    var count = 1
    while (abs(a) >= eps) {
        if (count % 2 == 1) a = -(x0.pow(n) / factor)
        else a = (x0.pow(n) / factor)
        sin += a
        factor *= (n + 1) * (n + 2)
        n += 2
        count++
    }
    return zn*sin
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var x0 = x
    var zn = 1
    var k1=0
    var k2=0
    while (x0 - 2 * PI*k1 > 0.0) k1++
    x0-=2 * PI*k1
    while (x0 + 2 * PI*k2 < 0.0) k2++
    x0+=2 * PI*k2
    if ((x0 >= PI/2) && (x0 <= 3* PI/2)) {
        zn=-1
        if (x0< PI) x0-= PI
        else x0= PI-x0
    }
    if (x0 > 3* PI/2) x0=2* PI-x0

    var a = 1.0
    var cos=1.0
    var factor = 1 * 2
    var n = 2
    var count = 1
    if (x== PI/2) {
        cos=0.0
        a=0.0
        zn=1
    }
    while (abs(a) >= eps) {
        if (count % 2 == 1) a = -(x0.pow(n) / factor)
        else a = (x0.pow(n) / factor)
        cos += a
        factor *= (n + 1) * (n + 2)
        n += 2
        count++
    }
    return zn*cos
}

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var i = 1
    var count = 0
    var x = 0
    while (true) {
        x = sqr(i)
        while (x > 0) {
            x /= 10
            count++
        }
        if (count == n) return sqr(i) % 10
        if (count > n) return (sqr(i) / (10.0.pow((count - n).toDouble()).toInt())) % 10
        i++

    }
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var a = 1
    var b = 1
    var c = 1
    var count = 2
    var x = 0
    if (n < 3) return 1
    while (true) {
        a = b
        b = c
        c = a + b
        x=c
        while (x > 0) {
            x /= 10
            count++
        }
        if (count == n) return c % 10
        if (count > n) return (c / (10.0.pow((count - n).toDouble()).toInt())) % 10

    }
}
