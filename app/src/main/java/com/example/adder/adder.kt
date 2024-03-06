package com.example.adder

fun main(args: Array<String>){

    val num1:Int = try{
        Integer.valueOf(readLine())
    }catch (e: NumberFormatException){
        println("숫자를 입력하셔야 합니다.계산을 종료합니다.")
        return
    }
    val op: String? = readLine() //null이 될수 있는 타입 지원
    val num2: Int = try{
        Integer.valueOf(readLine()) //예외가 발생 할수 있는 코드
    }catch (e: NumberFormatException){  //예외 클래스
        println("숫자를 입력하셔야 합니다. 계산을 종료합니다.") // 예외가 발생했을 때 수행 코드
        return
    }
    val result =
        when(op){
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            "%" -> num1 % num2
            else -> throw Exception("연산자여야 합니다.") // 에러가 발생했을 때 수행 코드
        }

    println("${num1} ${op} ${num2} = ${result}")

}