package jp.itohiro.intellij.simpleplugin

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression

public class SimpleLineMarkerProvider: RelatedItemLineMarkerProvider() {
    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>) {
        if(element is PsiLiteralExpression){
            val literalExpression: PsiLiteralExpression = element
            val value: String = literalExpression.value as String
            if(value.startsWith("simple:")){
                val project = element.project
                val properties = SimpleUtil.findProperties(project, value.substring(7))
                if(properties.size() > 0){
                    val builder = NavigationGutterIconBuilder.create(SimpleIcons.ICON).
                            setTargets(properties).
                            setTooltipText("Navigate to a simple property")
                    result.add(builder.createLineMarkerInfo(element))
                }
            }
        }
    }
}
