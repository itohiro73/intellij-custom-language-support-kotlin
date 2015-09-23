import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

public object SimpleFileType : LanguageFileType(SimpleLanguage) {

    override fun getIcon(): Icon? {
        return SimpleIcons.ICON
    }

    override fun getName(): String {
        return "Simple File"
    }

    override fun getDefaultExtension(): String {
        return "simple"
    }

    override fun getDescription(): String {
        return "Simple language file"
    }

}