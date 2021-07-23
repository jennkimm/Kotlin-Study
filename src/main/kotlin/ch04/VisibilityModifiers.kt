package ch04

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

internal fun  TalkativeButton.giveSpeech() { // 클래스 - 이 클래스보다 가시성이 더 낮은 타입은 참조하지 못한다. (같거나 높아야 함)
    // 메소드의 시그니처(메서드 이름 + 매개변수 리스트) - 이 메소드와 가시성이 같거나 더 높아야 참조 가능
    // yell() - 컴파일 에러
    // whisper() - 컴파일 에러
}