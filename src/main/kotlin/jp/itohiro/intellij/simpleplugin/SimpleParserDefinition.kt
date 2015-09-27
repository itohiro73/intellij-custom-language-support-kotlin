package jp.itohiro.intellij.simpleplugin

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import jp.itohiro.intellij.simpleplugin.psi.SimpleTypes

public class SimpleParserDefinition : ParserDefinition {
    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
    val COMMENTS = TokenSet.create(SimpleTypes.COMMENT)

    val FILE = IFileElementType(Language.findInstance(SimpleLanguage.javaClass))

    override fun createParser(project: Project): PsiParser {
        return SimpleParser()
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return SimpleFile(viewProvider)
    }

    override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun createLexer(project: Project): Lexer {
        return FlexAdapter(SimpleLexer(null))
    }

    override fun createElement(node: ASTNode): PsiElement {
        return SimpleTypes.Factory.createElement(node)
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }
}