package jp.itohiro.intellij.simpleplugin

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.jetbrains.annotations.NotNull

public class SimpleFile(@NotNull viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SimpleLanguage) {
    @NotNull
    override fun getFileType(): FileType {
        return SimpleFileType
    }

    override fun toString(): String {
        return "Simple File"
    }
}