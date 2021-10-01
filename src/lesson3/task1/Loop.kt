@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.*

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
    var num = abs(n)
    var res = 0
    do {
        num /= 10
        res++
    } while (num > 0)
    return res
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */

fun fib(n: Int): Int {
    val size = n - 3
    var n1 = 1
    var n2 = 1
    var tmp: Int
    for (i in 0..size) {
        tmp = n1 + n2
        n1 = n2
        n2 = tmp
    }
    return n2
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var ret = n
    for (i in 2..sqrt(n * 1.0).toInt()) {
        if (n % i == 0) {
            ret = i
            break
        }
    }
    return ret
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = n / minDivisor(n)

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
    var cp = x
    var count = 0
    while (cp > 1) {
        if (cp % 2 == 0)
            cp /= 2
        else
            cp = 3 * cp + 1
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
fun gcd(m: Int, n: Int): Int = when {
    m % n == 0 -> n
    n % m == 0 -> m
    m > n -> gcd(m % n, n)
    else -> gcd(m, n % m)
}

fun lcm(m: Int, n: Int): Int = (m * n) / gcd(m, n)

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = gcd(m, n) == 1

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
private fun runByNumber(n: Int, needLen: Boolean): Int {
    //needLen = true    - return len of number
    //needLen = false   - return reverting number
    var cp = n
    var res = 0
    while (cp > 0) {
        if (needLen) res++ else res = res * 10 + (cp % 10)
        cp /= 10
    }
    return res
}

fun revert(n: Int): Int = runByNumber(n, false)

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun getLen(n: Int): Int = runByNumber(n, true)

fun isPalindrome(n: Int): Boolean {
    val len = getLen(n)
    val res = revert((n % 10.0.pow(len / 2)).toInt())
    return (n / 10.0.pow(len - len / 2).toInt()) == res * 10.0.pow(len / 2 - getLen(res)).toInt()
}

/*
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var cp = n / 10
    val count = n % 10
    while (cp > 0) {
        if (cp % 10 != count)
            return true
        cp /= 10
    }
    return false
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
    val cp = x - (x / (2 * PI)).toInt() * (2 * PI)
    return when {
        (cp >= 0 && cp < PI) || (cp >= -2 * PI && cp < -PI) ->
            sqrt(1 - cos(cp, eps).pow(2))
        else -> -sqrt(1 - cos(cp, eps).pow(2))
    }
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
fun nonUsualCos(x: Double, eps: Double): Double {
    var res = 0.0
    var memberOfNumber: Double
    var i = 0
    do {
        memberOfNumber = x.pow(i * 2) / factorial(i * 2)
        res += when (i % 2) {
            0 -> memberOfNumber
            else -> -memberOfNumber
        }
        i++
    } while (memberOfNumber > eps)
    return if (res > 0.0) min(res, 1.0) else max(res, -1.0)
}

fun cos(x: Double, eps: Double): Double {
    val cp = x - (x / (2 * PI)).toInt() * (2 * PI)
    return when (cp) {
        0.0 -> 1.0
        PI / 2.0, 3.0 * PI / 2.0 -> 0.0
        PI -> -1.0
        else -> nonUsualCos(cp, eps)
    }
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

private fun findNumInSequence(n: Int, mode: Boolean): Int {
    //mode = true    - squareSequenceDigit
    //mode = false   - fibSequenceDigit
    if (!mode && (n == 1 || n == 2))
        return 1
    var n1 = 1
    var i = if (mode) 0 else 1
    var tmp: Int
    val need = n - 1
    var haveChars = if (mode) 0 else 2
    while (true) {
        if (mode) {
            i = i + 2 * sqrt(i.toDouble()).toInt() + 1 // x^2+2x+1
        } else {
            // считаю использование функции неуместным ввиду усложнения алгоритма из-за многократного "прогона" цикла
            // от 0 до n-3 внутри функции fib
            tmp = n1 + i
            n1 = i
            i = tmp
        }
        val len = getLen(i)
        if (haveChars + len > need) {
            return ((i) / 10.0.pow(len - (need - haveChars) - 1).toInt()) % 10
        }
        haveChars += len
    }

}

fun squareSequenceDigit(n: Int): Int = findNumInSequence(n, true)

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int = findNumInSequence(n, false)
