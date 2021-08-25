package ch09

import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

interface FieldValidator<in T> { // T에 대해 반공변인 인터페이스를 선언
    fun validate(input: T): Boolean // T를 "인" 위치에만 사용함(이 메소드는 T 타입의 값을 소비함)
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

// 검증기 컬렉션에 대한 접근 캡슐화하기
object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    fun <T: Any> registerValidator(
        kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator // 어떤 클래스와 검증기가 타입이 맞아 떨어지는 경우에만 그 클래스와 검증기 정보를 맵에 키/값 쌍으로 넣음
    }

    @Suppress("UNCHECKED_CAST") // FieldValidator<T> 캐스팅이 안전하지 않다는 경고를 무시하게 만듦
    operator fun <T: Any> get (kClass: KClass<T>) : FieldValidator<T> =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException(
                "No Validator for ${kClass.simpleName}"
            )
}

fun main(args: Array<String>) {
    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

    //validators[String::class]!!.validate("") // 컴파일 오류

    // 검증기를 가져오면서 명시적 타입 캐스팅 사용하기
    val stringValidator = validators[String::class] as FieldValidator<String>
    println(stringValidator.validate("")) // false


    // 검증기를 잘못 가져온 경우
    val stringValidator2 = validators[Int::class] as FieldValidator<String> // 검증기를 잘못 가져왔지만 컴파일과 타입 캐스팅시 아무 문제 없음
    //stringValidator2.validate("") // 검증기를 사용해야 비로소 오류 발생



    // 검증기 컬렉션에 대한 접근 캡슐화 테스트
    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)
    println(Validators[String::class].validate("Kotlin")) // true
    println(Validators[Int::class].validate(42)) // true
}