package jp.itohiro.intellij.simpleplugin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression

public class SimpleAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if(element is PsiLiteralExpression) {
            val literalExpression: PsiLiteralExpression = element
            val value = literalExpression.value as String

            if (value.startsWith("simple:")) {
                val project = element.project
                val key = value.substring(7)
                val properties = SimpleUtil.findProperties(project, key)
                if (properties?.size() == 1) {
                    val range = TextRange(element.textRange.startOffset + 7, element.textRange.startOffset + 7)
                    val annotation = holder.createInfoAnnotation(range, null)
                    annotation.textAttributes = DefaultLanguageHighlighterColors.LINE_COMMENT
                } else if (properties?.size() == 0) {
                    val range = TextRange( element.textRange.startOffset + 8, element.textRange.endOffset)
                    holder.createErrorAnnotation(range, "Unresolved property")
                }
            }
        }
    }
}