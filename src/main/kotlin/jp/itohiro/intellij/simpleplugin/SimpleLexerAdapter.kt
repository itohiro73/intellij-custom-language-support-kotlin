package jp.itohiro.intellij.simpleplugin

import com.intellij.lexer.FlexAdapter

public class SimpleLexerAdapter : FlexAdapter(SimpleLexer(null)){
}