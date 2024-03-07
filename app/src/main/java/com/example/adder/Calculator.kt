package com.example.adder
import java.util.Scanner

abstract class AbstractOperation {
    abstract fun calculator(num1: Int, num2: Int): Int
}
class Calculator() {
    fun operation(op: AbstractOperation, num1: Int, num2: Int): Int = op.calculator(num1, num2)

}
 class AddOperation : AbstractOperation()  {
    override fun calculator(num1: Int,num2: Int): Int = (num1 + num2)

}
class SubstractOperation : AbstractOperation() {
    override fun calculator(num1: Int,num2: Int): Int = (num1 - num2)
}

class MultiplyOperation : AbstractOperation() {
    override fun calculator(num1: Int,num2: Int): Int = (num1 * num2)
}

class DivideOperation : AbstractOperation() {
    override fun calculator(num1: Int,num2: Int): Int = (num1 / num2)
}

class remainderOperation : AbstractOperation() {
    override fun calculator(num1: Int,num2: Int): Int = (num1 % num2)
}

    fun main(args: Array<String>) {


            val sc = Scanner(System.`in`)
            val menu = "1.계산하기\n2.나가기\n3.이스터 에그"
            var op = ""
            while (true) {

                println(menu)
                val choice: Int = try {
                    Integer.valueOf(readLine())
                } catch (e: NumberFormatException) {
                    println("잘못된 문자를 입력하였습니다")
                    return
                }
                if (choice == 3) {
                    println("-1 == 종료,-2 == 제작자 생일...... 구현중 ")
                    continue
                } else if (choice == -1) {
                    println("종료")
                    break
                } else if (choice == -2) {
                    println("10월 17일")
                    continue
                }
                if (choice == 2) {
                    println("종료")
                    break
                }
                if (choice != 1) {
                    println("잘못입력하셨습니다. 다시 입력해주세요")
                    continue
                }
                println("계산을 시작합니다. 숫자를 입력해주세요")

                val num1 = try {
                    Integer.parseInt(sc.next())
                } catch (e: NumberFormatException) {
                    println("잘못된 문자를 입력하였습니다")
                    return
                }
                op = sc.next()
                val num2 = try {
                    Integer.parseInt(sc.next())
                } catch (e: NumberFormatException) {
                    println("잘못된 문자를 입력하였습니다")
                    return
                }



                val sop = when (op) {
                    "+" -> AddOperation()
                    "-" -> SubstractOperation()
                    "*" -> MultiplyOperation()
                    "/" -> DivideOperation()

                    "%" -> remainderOperation()


                    else ->{throw Exception("사칙 연산의 연산자여야 합니다.")
                    return
                    }
                }

                val calculate = Calculator()
                val result = calculate.operation(sop,num1,num2)
                println("${num1}${op}${num2} = ${result}")
            }
    }

