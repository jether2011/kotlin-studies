package com.jetherrodrigues

abstract class Carro(open val marca: String)

open class Car(marca: String, open val speed: Int, open val name: String) : Carro(marca)

data class Cruze(override val marca: String, override val speed: Int, override val name: String) : Car(marca, speed, name)

open class PaymentEvent(open val paymentId: String)
data class PaymentSucceededEvent(override val paymentId: String, val ticketNumber: String) : PaymentEvent(paymentId)

fun main() {
    val cruzeCar = Cruze("Chevrolet", 240, "Cruze LTZ")
    println(cruzeCar)

    val succeededEvent = PaymentSucceededEvent("123", "123456")
    println(succeededEvent)

    println(getPaymentEvent())
}

private fun getPaymentEvent() : PaymentEvent = PaymentSucceededEvent("555", "151515")