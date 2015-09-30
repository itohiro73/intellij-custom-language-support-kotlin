package jp.itohiro.intellij.simpleplugin

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import jp.itohiro.intellij.simpleplugin.psi.SimpleTypes

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import org.jetbrains.annotations.NotNull

public class SimpleSyntaxHighlighter: SyntaxHighlighterBase() {
    companion object {
        public val SEPARATOR = createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        public val KEY = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        public val VALUE = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
        public val COMMENT = createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        public val BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }

    @NotNull
    override fun getTokenHighlights(tokenType: IElementType?): Array<out TextAttributesKey> {
        if (tokenType == SimpleTypes.SEPARATOR) {
            return SEPARATOR_KEYS;
        } else if (tokenType == SimpleTypes.KEY) {
            return KEY_KEYS;
        } else if (tokenType == SimpleTypes.VALUE) {
            return VALUE_KEYS;
        } else if (tokenType == SimpleTypes.COMMENT) {
            return COMMENT_KEYS;
        } else if (tokenType == TokenType.BAD_CHARACTER) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

    @NotNull
    override fun getHighlightingLexer(): Lexer {
        return SimpleLexerAdapter()
    }
}