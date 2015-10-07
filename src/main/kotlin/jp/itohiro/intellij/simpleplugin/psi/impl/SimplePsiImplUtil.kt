package jp.itohiro.intellij.simpleplugin.psi.impl

import jp.itohiro.intellij.simpleplugin.psi.SimpleProperty
import jp.itohiro.intellij.simpleplugin.psi.SimpleTypes

public class SimplePsiImplUtil {
    companion object {
        @JvmStatic
        fun getKey(element : SimpleProperty) : String? {
            val keyNode = element.node.findChildByType(SimpleTypes.KEY)
            return keyNode?.text
        }

        @JvmStatic
        fun getValue(element : SimpleProperty) : String? {
            val valueNode = element.node.findChildByType(SimpleTypes.VALUE)
            return valueNode?.text
        }
    }
}