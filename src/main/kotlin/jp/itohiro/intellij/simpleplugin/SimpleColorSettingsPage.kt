package jp.itohiro.intellij.simpleplugin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import org.jetbrains.annotations.Nullable
import javax.swing.Icon

public class SimpleColorSettingsPage: ColorSettingsPage {
    private val DESCRIPTORS = arrayOf(
                AttributesDescriptor("Key", SimpleSyntaxHighlighter.KEY),
                AttributesDescriptor("Separator", SimpleSyntaxHighlighter.SEPARATOR),
                AttributesDescriptor("Value", SimpleSyntaxHighlighter.VALUE)
            )

    @Nullable
    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null;
    }

    @Nullable
    override fun getIcon(): Icon? {
        return SimpleIcons.ICON;
    }

    @Nullable
    override fun getHighlighter(): SyntaxHighlighter {
        return SimpleSyntaxHighlighter()
    }

    @Nullable
    override fun getDemoText(): String {
        return "# You are reading the \".properties\" entry.\n" +
                "! The exclamation mark can also mark text as comments.\n" +
                "website = http://en.wikipedia.org/\n" +
                "language = English\n" +
                "# The backslash below tells the application to continue reading\n" +
                "# the value onto the next line.\n" +
                "message = Welcome to \\\n" +
                "          Wikipedia!\n" +
                "# Add spaces to the key\n" +
                "key\\ with\\ spaces = This is the value that could be looked up with the key \"key with spaces\".\n" +
                "# Unicode\n" +
                "tab : \\u0009";
    }

    @Nullable
    override fun getAttributeDescriptors(): Array<out AttributesDescriptor> {
        return DESCRIPTORS
    }

    @Nullable
    override fun getColorDescriptors(): Array<out ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    @Nullable
    override fun getDisplayName(): String {
        return "Simple"
    }

}