// Generated from com\kiraged\script\parser\KiragedScript.g4 by ANTLR 4.8
package com.kiraged.script.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KiragedScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OP_ADD=1, OP_SUB=2, OP_MUL=3, OP_DIV=4, ASSIGN=5, NOT_EQUALS=6, EQUALS=7, 
		GREATER_THAN=8, GREATER_THAN_EQ=9, LOWER_THAN=10, LOWER_THAN_EQ=11, AND=12, 
		OR=13, COMMA=14, SEMICOLON=15, START_PARENTHESIS=16, END_PARENTHESIS=17, 
		START_BLOCK_STATEMENT=18, END_BLOCK_STATEMENT=19, BOOLEAN_TRUE=20, BOOLEAN_FALSE=21, 
		DOUBLE_SEPERATION=22, VOID_KEYWORD=23, TYPE=24, WHILE_KEYWORD=25, IF_KEYWORD=26, 
		ELSE_KEYWORD=27, INT_KEYWORD=28, DOUBLE_KEYWORD=29, BOOLEAN_KEYWORD=30, 
		VAR_KEYWORD=31, RETURN_KEYWORD=32, INT=33, DOUBLE=34, BOOLEAN=35, ID=36, 
		WS=37, COMMENT=38, LINE_COMMENT=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "ASSIGN", "NOT_EQUALS", "EQUALS", 
			"GREATER_THAN", "GREATER_THAN_EQ", "LOWER_THAN", "LOWER_THAN_EQ", "AND", 
			"OR", "COMMA", "SEMICOLON", "START_PARENTHESIS", "END_PARENTHESIS", "START_BLOCK_STATEMENT", 
			"END_BLOCK_STATEMENT", "BOOLEAN_TRUE", "BOOLEAN_FALSE", "DOUBLE_SEPERATION", 
			"VOID_KEYWORD", "TYPE", "WHILE_KEYWORD", "IF_KEYWORD", "ELSE_KEYWORD", 
			"INT_KEYWORD", "DOUBLE_KEYWORD", "BOOLEAN_KEYWORD", "VAR_KEYWORD", "RETURN_KEYWORD", 
			"INT", "DOUBLE", "BOOLEAN", "ID", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'='", "'!='", "'=='", "'>'", "'>='", 
			"'<'", "'<='", "'&&'", "'||'", "','", "';'", "'('", "')'", "'{'", "'}'", 
			"'true'", "'false'", "'.'", "'void'", null, "'while'", "'if'", "'else'", 
			"'int'", "'double'", "'boolean'", "'var'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "ASSIGN", "NOT_EQUALS", 
			"EQUALS", "GREATER_THAN", "GREATER_THAN_EQ", "LOWER_THAN", "LOWER_THAN_EQ", 
			"AND", "OR", "COMMA", "SEMICOLON", "START_PARENTHESIS", "END_PARENTHESIS", 
			"START_BLOCK_STATEMENT", "END_BLOCK_STATEMENT", "BOOLEAN_TRUE", "BOOLEAN_FALSE", 
			"DOUBLE_SEPERATION", "VOID_KEYWORD", "TYPE", "WHILE_KEYWORD", "IF_KEYWORD", 
			"ELSE_KEYWORD", "INT_KEYWORD", "DOUBLE_KEYWORD", "BOOLEAN_KEYWORD", "VAR_KEYWORD", 
			"RETURN_KEYWORD", "INT", "DOUBLE", "BOOLEAN", "ID", "WS", "COMMENT", 
			"LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public KiragedScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KiragedScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u00f8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\5\31\u0093\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3"+
		"!\3!\3\"\6\"\u00c2\n\"\r\"\16\"\u00c3\3#\6#\u00c7\n#\r#\16#\u00c8\3#\3"+
		"#\6#\u00cd\n#\r#\16#\u00ce\3$\3$\5$\u00d3\n$\3%\3%\7%\u00d7\n%\f%\16%"+
		"\u00da\13%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\7\'\u00e4\n\'\f\'\16\'\u00e7\13"+
		"\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u00f2\n(\f(\16(\u00f5\13(\3(\3("+
		"\3\u00e5\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)\3\2\7\3\2\62;\4\2C\\c|\5\2\62;C\\c|"+
		"\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0100\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2\2\2\13Y\3"+
		"\2\2\2\r[\3\2\2\2\17^\3\2\2\2\21a\3\2\2\2\23c\3\2\2\2\25f\3\2\2\2\27h"+
		"\3\2\2\2\31k\3\2\2\2\33n\3\2\2\2\35q\3\2\2\2\37s\3\2\2\2!u\3\2\2\2#w\3"+
		"\2\2\2%y\3\2\2\2\'{\3\2\2\2)}\3\2\2\2+\u0082\3\2\2\2-\u0088\3\2\2\2/\u008a"+
		"\3\2\2\2\61\u0092\3\2\2\2\63\u0094\3\2\2\2\65\u009a\3\2\2\2\67\u009d\3"+
		"\2\2\29\u00a2\3\2\2\2;\u00a6\3\2\2\2=\u00ad\3\2\2\2?\u00b5\3\2\2\2A\u00b9"+
		"\3\2\2\2C\u00c1\3\2\2\2E\u00c6\3\2\2\2G\u00d2\3\2\2\2I\u00d4\3\2\2\2K"+
		"\u00db\3\2\2\2M\u00df\3\2\2\2O\u00ed\3\2\2\2QR\7-\2\2R\4\3\2\2\2ST\7/"+
		"\2\2T\6\3\2\2\2UV\7,\2\2V\b\3\2\2\2WX\7\61\2\2X\n\3\2\2\2YZ\7?\2\2Z\f"+
		"\3\2\2\2[\\\7#\2\2\\]\7?\2\2]\16\3\2\2\2^_\7?\2\2_`\7?\2\2`\20\3\2\2\2"+
		"ab\7@\2\2b\22\3\2\2\2cd\7@\2\2de\7?\2\2e\24\3\2\2\2fg\7>\2\2g\26\3\2\2"+
		"\2hi\7>\2\2ij\7?\2\2j\30\3\2\2\2kl\7(\2\2lm\7(\2\2m\32\3\2\2\2no\7~\2"+
		"\2op\7~\2\2p\34\3\2\2\2qr\7.\2\2r\36\3\2\2\2st\7=\2\2t \3\2\2\2uv\7*\2"+
		"\2v\"\3\2\2\2wx\7+\2\2x$\3\2\2\2yz\7}\2\2z&\3\2\2\2{|\7\177\2\2|(\3\2"+
		"\2\2}~\7v\2\2~\177\7t\2\2\177\u0080\7w\2\2\u0080\u0081\7g\2\2\u0081*\3"+
		"\2\2\2\u0082\u0083\7h\2\2\u0083\u0084\7c\2\2\u0084\u0085\7n\2\2\u0085"+
		"\u0086\7u\2\2\u0086\u0087\7g\2\2\u0087,\3\2\2\2\u0088\u0089\7\60\2\2\u0089"+
		".\3\2\2\2\u008a\u008b\7x\2\2\u008b\u008c\7q\2\2\u008c\u008d\7k\2\2\u008d"+
		"\u008e\7f\2\2\u008e\60\3\2\2\2\u008f\u0093\59\35\2\u0090\u0093\5;\36\2"+
		"\u0091\u0093\5=\37\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091"+
		"\3\2\2\2\u0093\62\3\2\2\2\u0094\u0095\7y\2\2\u0095\u0096\7j\2\2\u0096"+
		"\u0097\7k\2\2\u0097\u0098\7n\2\2\u0098\u0099\7g\2\2\u0099\64\3\2\2\2\u009a"+
		"\u009b\7k\2\2\u009b\u009c\7h\2\2\u009c\66\3\2\2\2\u009d\u009e\7g\2\2\u009e"+
		"\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a18\3\2\2\2\u00a2"+
		"\u00a3\7k\2\2\u00a3\u00a4\7p\2\2\u00a4\u00a5\7v\2\2\u00a5:\3\2\2\2\u00a6"+
		"\u00a7\7f\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7d\2\2"+
		"\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00ac<\3\2\2\2\u00ad\u00ae\7d\2"+
		"\2\u00ae\u00af\7q\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2"+
		"\7g\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7p\2\2\u00b4>\3\2\2\2\u00b5\u00b6"+
		"\7x\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7t\2\2\u00b8@\3\2\2\2\u00b9\u00ba"+
		"\7t\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7w\2\2\u00bd"+
		"\u00be\7t\2\2\u00be\u00bf\7p\2\2\u00bfB\3\2\2\2\u00c0\u00c2\t\2\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4D\3\2\2\2\u00c5\u00c7\t\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cc\5-\27\2\u00cb\u00cd\t\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cfF\3\2\2\2\u00d0\u00d3"+
		"\5)\25\2\u00d1\u00d3\5+\26\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"H\3\2\2\2\u00d4\u00d8\t\3\2\2\u00d5\u00d7\t\4\2\2\u00d6\u00d5\3\2\2\2"+
		"\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9J\3"+
		"\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\t\5\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00de\b&\2\2\u00deL\3\2\2\2\u00df\u00e0\7\61\2\2\u00e0\u00e1\7,\2\2\u00e1"+
		"\u00e5\3\2\2\2\u00e2\u00e4\13\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3"+
		"\2\2\2\u00e5\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00e9\7,\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ec\b\'\2\2\u00ecN\3\2\2\2\u00ed\u00ee\7\61\2\2\u00ee\u00ef"+
		"\7\61\2\2\u00ef\u00f3\3\2\2\2\u00f0\u00f2\n\6\2\2\u00f1\u00f0\3\2\2\2"+
		"\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\b(\2\2\u00f7P\3\2\2\2\13\2\u0092"+
		"\u00c3\u00c8\u00ce\u00d2\u00d8\u00e5\u00f3\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}