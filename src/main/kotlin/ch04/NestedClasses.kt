package ch04

import java.io.Serializable

interface State: Serializable

// 필요한 모든 데이터를 다른 도우미 클래스로 복사
interface View {
    fun getCurrentState(): State // 뷰의 상태를 가져와
    fun restoreState(state: State) {} // 저장
}

class Button3 : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
        /* ... */
    }

    class ButtonState : State {
        /* ... */
    }
}