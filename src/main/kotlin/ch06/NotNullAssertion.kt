package ch06

import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JList

class CopyRowAction(val list: JList<String>) : AbstractAction() {
    override fun isEnabled(): Boolean = // 어떤 줄이 선택되었는지 여부를 검사
        list.selectedValue != null
    override fun actionPerformed(e: ActionEvent?) { // 선택된 줄의 정보를 가져오는 부분
        val value = list.selectedValue!! // 널이 될 수 없는 값을 얻기 위해
        // 또는 val value = list.selectedValue ?: return
        // value를 클립보드로 복사
        // 한 줄에 여러 단언문 사용을 지양하자
    }
}