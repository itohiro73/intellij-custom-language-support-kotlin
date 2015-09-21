import com.intellij.lang.Language

public class SimpleLanguage private constructor(id: String = "Simple") : Language(id) {
    public val INSTANCE = SimpleLanguage()
}