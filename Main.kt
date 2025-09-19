import kotlin.random.Random
import kotlin.math.*

class Human(
    private var fullName: String,
    private var age: Int,
    private var currentSpeed: Double
) {
    private var x: Double = 0.0
    private var y: Double = 0.0

    // Геттеры
    fun getFullName() = fullName
    fun getAge() = age
    fun getCurrentSpeed() = currentSpeed
    fun getPosition() = "(${"%.2f".format(x)}, ${"%.2f".format(y)})"

    // Сеттеры
    fun setFullName(newName: String) { fullName = newName }
    fun setAge(newAge: Int) { age = newAge }
    fun setCurrentSpeed(newSpeed: Double) { currentSpeed = newSpeed }

    // Метод движения (Random Walk)
    fun move() {
        val angle = Random.nextDouble(0.0, 2 * PI)
        x += currentSpeed * cos(angle)
        y += currentSpeed * sin(angle)
    }

    override fun toString(): String {
        return "$fullName ($age лет) - Скорость: ${"%.1f".format(currentSpeed)}, Позиция: ${getPosition()}"
    }
}

fun main() {
    // Создаем массив людей
    val humans = arrayOf(
        Human("Иванов Иван", 25, 1.5),
        Human("Петров Петр", 30, 2.0),
        Human("Сидорова Анна", 22, 1.2),
        Human("Кузнецов Алексей", 28, 1.8),
        Human("Смирнова Мария", 26, 1.6)
    )

    val simulationTime = 5 // секунд симуляции

    println("Начало симуляции ($simulationTime секунд)")
    println("Начальные позиции:")
    humans.forEach { println(it) }

    // Основной цикл симуляции
    repeat(simulationTime) { step ->
        println("\n--- Секунда ${step + 1} ---")
        humans.forEach {
            it.move()
            println("${it.getFullName()} переместился в ${it.getPosition()}")
        }
    }

    println("\nФинальные позиции:")
    humans.forEach { println(it) }
}