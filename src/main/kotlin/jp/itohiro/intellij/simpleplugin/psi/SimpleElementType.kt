package jp.itohiro.intellij.simpleplugin.psi

import com.intellij.psi.tree.IElementType
import jp.itohiro.intellij.simpleplugin.SimpleLanguage
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull

public class SimpleElementType constructor(@NotNull @NonNls debugName: String): IElementType(debugName, SimpleLanguage) {
}