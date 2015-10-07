package jp.itohiro.intellij.simpleplugin

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.FileBasedIndex
import jp.itohiro.intellij.simpleplugin.psi.SimpleProperty
import java.util.*

public class SimpleUtil {
    companion object {
        @JvmStatic
        fun findProperties(project: Project, key: String): List<SimpleProperty>?{
            var result: MutableList<SimpleProperty>? = null
            val virtualFiles: Collection<VirtualFile> = FileBasedIndex.getInstance().getContainingFiles(
                    FileTypeIndex.NAME,
                    SimpleFileType,
                    GlobalSearchScope.allScope(project));
            for(virtualFile in virtualFiles){
                val simpleFile = PsiManager.getInstance(project).findFile(virtualFile)
                val properties : Array<out SimpleProperty>? = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty::class.java)
                properties?.forEach { property ->
                    if(key == property.getKey()){
                        if (result == null) {
                            result = ArrayList<SimpleProperty>()
                        } else {
                            result?.add(property)
                        }
                    }
                }
            }
            return if (result != null) result?.toList() else Collections.EMPTY_LIST as List<SimpleProperty>?
        }


        @JvmStatic
        fun findProperties(project: Project): List<SimpleProperty>? {
            var result: MutableList<SimpleProperty>? = null
            val virtualFiles = FileBasedIndex.getInstance().getContainingFiles(
                    FileTypeIndex.NAME,
                    SimpleFileType,
                    GlobalSearchScope.allScope(project));
            for (virtualFile in virtualFiles) {
                val simpleFile =  PsiManager.getInstance(project).findFile(virtualFile)
                val properties: Array<out SimpleProperty>? = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty::class.java)
                if (properties!=null) result?.addAll(properties)
            }
            return result;
        }
    }
}