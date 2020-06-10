// Generated from com\kiraged\script\parser\KiragedScript.g4 by ANTLR 4.8
package com.kiraged.script.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KiragedScriptParser extends Parser {
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
	public static final int
		RULE_compileUnit = 0, RULE_functionDecl = 1, RULE_parameterDecl = 2, RULE_statement = 3, 
		RULE_blockStatement = 4, RULE_expr = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "functionDecl", "parameterDecl", "statement", "blockStatement", 
			"expr"
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

	@Override
	public String getGrammarFileName() { return "KiragedScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KiragedScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompileUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(KiragedScriptParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitCompileUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << START_PARENTHESIS) | (1L << START_BLOCK_STATEMENT) | (1L << BOOLEAN_TRUE) | (1L << BOOLEAN_FALSE) | (1L << VOID_KEYWORD) | (1L << TYPE) | (1L << WHILE_KEYWORD) | (1L << IF_KEYWORD) | (1L << VAR_KEYWORD) | (1L << RETURN_KEYWORD) | (1L << INT) | (1L << DOUBLE) | (1L << ID))) != 0)) {
				{
				setState(14);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(12);
					statement();
					}
					break;
				case 2:
					{
					setState(13);
					functionDecl();
					}
					break;
				}
				}
				setState(18);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(19);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public Token returnType;
		public Token func;
		public TerminalNode START_PARENTHESIS() { return getToken(KiragedScriptParser.START_PARENTHESIS, 0); }
		public TerminalNode END_PARENTHESIS() { return getToken(KiragedScriptParser.END_PARENTHESIS, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TerminalNode ID() { return getToken(KiragedScriptParser.ID, 0); }
		public TerminalNode VOID_KEYWORD() { return getToken(KiragedScriptParser.VOID_KEYWORD, 0); }
		public TerminalNode TYPE() { return getToken(KiragedScriptParser.TYPE, 0); }
		public List<ParameterDeclContext> parameterDecl() {
			return getRuleContexts(ParameterDeclContext.class);
		}
		public ParameterDeclContext parameterDecl(int i) {
			return getRuleContext(ParameterDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KiragedScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KiragedScriptParser.COMMA, i);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			((FunctionDeclContext)_localctx).returnType = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==VOID_KEYWORD || _la==TYPE) ) {
				((FunctionDeclContext)_localctx).returnType = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(22);
			((FunctionDeclContext)_localctx).func = match(ID);
			setState(23);
			match(START_PARENTHESIS);
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(24);
				parameterDecl();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(30);
				match(COMMA);
				setState(31);
				parameterDecl();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(END_PARENTHESIS);
			setState(38);
			blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterDeclContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(KiragedScriptParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(KiragedScriptParser.ID, 0); }
		public ParameterDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitParameterDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclContext parameterDecl() throws RecognitionException {
		ParameterDeclContext _localctx = new ParameterDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parameterDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(TYPE);
			setState(41);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprStmtContext extends StatementContext {
		public ExprContext stmtExpr;
		public TerminalNode SEMICOLON() { return getToken(KiragedScriptParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StatementContext {
		public TerminalNode WHILE_KEYWORD() { return getToken(KiragedScriptParser.WHILE_KEYWORD, 0); }
		public TerminalNode START_PARENTHESIS() { return getToken(KiragedScriptParser.START_PARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode END_PARENTHESIS() { return getToken(KiragedScriptParser.END_PARENTHESIS, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignVarStmtContext extends StatementContext {
		public TerminalNode ID() { return getToken(KiragedScriptParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(KiragedScriptParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(KiragedScriptParser.SEMICOLON, 0); }
		public AssignVarStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitAssignVarStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtContext extends StatementContext {
		public TerminalNode IF_KEYWORD() { return getToken(KiragedScriptParser.IF_KEYWORD, 0); }
		public TerminalNode START_PARENTHESIS() { return getToken(KiragedScriptParser.START_PARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode END_PARENTHESIS() { return getToken(KiragedScriptParser.END_PARENTHESIS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE_KEYWORD() { return getToken(KiragedScriptParser.ELSE_KEYWORD, 0); }
		public IfStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmtContext extends StatementContext {
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public BlockStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode RETURN_KEYWORD() { return getToken(KiragedScriptParser.RETURN_KEYWORD, 0); }
		public TerminalNode SEMICOLON() { return getToken(KiragedScriptParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclStmtContext extends StatementContext {
		public Token type;
		public Token name;
		public TerminalNode SEMICOLON() { return getToken(KiragedScriptParser.SEMICOLON, 0); }
		public TerminalNode ID() { return getToken(KiragedScriptParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(KiragedScriptParser.TYPE, 0); }
		public TerminalNode VAR_KEYWORD() { return getToken(KiragedScriptParser.VAR_KEYWORD, 0); }
		public TerminalNode ASSIGN() { return getToken(KiragedScriptParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitVarDeclStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				blockStatement();
				}
				break;
			case 2:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				((VarDeclStmtContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TYPE || _la==VAR_KEYWORD) ) {
					((VarDeclStmtContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(45);
				((VarDeclStmtContext)_localctx).name = match(ID);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(46);
					match(ASSIGN);
					setState(47);
					expr(0);
					}
				}

				setState(50);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				match(ID);
				setState(52);
				match(ASSIGN);
				setState(53);
				expr(0);
				setState(54);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				match(RETURN_KEYWORD);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << START_PARENTHESIS) | (1L << BOOLEAN_TRUE) | (1L << BOOLEAN_FALSE) | (1L << INT) | (1L << DOUBLE) | (1L << ID))) != 0)) {
					{
					setState(57);
					expr(0);
					}
				}

				setState(60);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				match(IF_KEYWORD);
				setState(62);
				match(START_PARENTHESIS);
				setState(63);
				expr(0);
				setState(64);
				match(END_PARENTHESIS);
				setState(65);
				statement();
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(66);
					match(ELSE_KEYWORD);
					setState(67);
					statement();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				match(WHILE_KEYWORD);
				setState(71);
				match(START_PARENTHESIS);
				setState(72);
				expr(0);
				setState(73);
				match(END_PARENTHESIS);
				setState(74);
				statement();
				}
				break;
			case 7:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(76);
				((ExprStmtContext)_localctx).stmtExpr = expr(0);
				setState(77);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode START_BLOCK_STATEMENT() { return getToken(KiragedScriptParser.START_BLOCK_STATEMENT, 0); }
		public TerminalNode END_BLOCK_STATEMENT() { return getToken(KiragedScriptParser.END_BLOCK_STATEMENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(START_BLOCK_STATEMENT);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << START_PARENTHESIS) | (1L << START_BLOCK_STATEMENT) | (1L << BOOLEAN_TRUE) | (1L << BOOLEAN_FALSE) | (1L << TYPE) | (1L << WHILE_KEYWORD) | (1L << IF_KEYWORD) | (1L << VAR_KEYWORD) | (1L << RETURN_KEYWORD) | (1L << INT) | (1L << DOUBLE) | (1L << ID))) != 0)) {
				{
				{
				setState(82);
				statement();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(END_BLOCK_STATEMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableExprContext extends ExprContext {
		public Token value;
		public TerminalNode ID() { return getToken(KiragedScriptParser.ID, 0); }
		public VariableExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitVariableExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleExprContext extends ExprContext {
		public Token value;
		public TerminalNode DOUBLE() { return getToken(KiragedScriptParser.DOUBLE, 0); }
		public DoubleExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitDoubleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InfixExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_MUL() { return getToken(KiragedScriptParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(KiragedScriptParser.OP_DIV, 0); }
		public TerminalNode OP_ADD() { return getToken(KiragedScriptParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(KiragedScriptParser.OP_SUB, 0); }
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitInfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExprContext {
		public Token value;
		public TerminalNode INT() { return getToken(KiragedScriptParser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public Token func;
		public TerminalNode START_PARENTHESIS() { return getToken(KiragedScriptParser.START_PARENTHESIS, 0); }
		public TerminalNode END_PARENTHESIS() { return getToken(KiragedScriptParser.END_PARENTHESIS, 0); }
		public TerminalNode ID() { return getToken(KiragedScriptParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KiragedScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KiragedScriptParser.COMMA, i);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExprContext extends ExprContext {
		public Token value;
		public TerminalNode BOOLEAN_TRUE() { return getToken(KiragedScriptParser.BOOLEAN_TRUE, 0); }
		public TerminalNode BOOLEAN_FALSE() { return getToken(KiragedScriptParser.BOOLEAN_FALSE, 0); }
		public BooleanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(KiragedScriptParser.AND, 0); }
		public TerminalNode OR() { return getToken(KiragedScriptParser.OR, 0); }
		public LogicalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitLogicalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public TerminalNode START_PARENTHESIS() { return getToken(KiragedScriptParser.START_PARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode END_PARENTHESIS() { return getToken(KiragedScriptParser.END_PARENTHESIS, 0); }
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareExprContext extends ExprContext {
		public ExprContext left;
		public Token cpr;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GREATER_THAN() { return getToken(KiragedScriptParser.GREATER_THAN, 0); }
		public TerminalNode GREATER_THAN_EQ() { return getToken(KiragedScriptParser.GREATER_THAN_EQ, 0); }
		public TerminalNode LOWER_THAN() { return getToken(KiragedScriptParser.LOWER_THAN, 0); }
		public TerminalNode LOWER_THAN_EQ() { return getToken(KiragedScriptParser.LOWER_THAN_EQ, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(KiragedScriptParser.NOT_EQUALS, 0); }
		public TerminalNode EQUALS() { return getToken(KiragedScriptParser.EQUALS, 0); }
		public CompareExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KiragedScriptVisitor ) return ((KiragedScriptVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(91);
				match(START_PARENTHESIS);
				setState(92);
				expr(0);
				setState(93);
				match(END_PARENTHESIS);
				}
				break;
			case 2:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				((IntExprContext)_localctx).value = match(INT);
				}
				break;
			case 3:
				{
				_localctx = new DoubleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				((DoubleExprContext)_localctx).value = match(DOUBLE);
				}
				break;
			case 4:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				((BooleanExprContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==BOOLEAN_TRUE || _la==BOOLEAN_FALSE) ) {
					((BooleanExprContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 5:
				{
				_localctx = new VariableExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				((VariableExprContext)_localctx).value = match(ID);
				}
				break;
			case 6:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				((FuncExprContext)_localctx).func = match(ID);
				setState(100);
				match(START_PARENTHESIS);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << START_PARENTHESIS) | (1L << BOOLEAN_TRUE) | (1L << BOOLEAN_FALSE) | (1L << INT) | (1L << DOUBLE) | (1L << ID))) != 0)) {
					{
					setState(101);
					expr(0);
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(102);
						match(COMMA);
						setState(103);
						expr(0);
						}
						}
						setState(108);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(111);
				match(END_PARENTHESIS);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(115);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_MUL || _la==OP_DIV) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(116);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(118);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_ADD || _la==OP_SUB) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(119);
						((InfixExprContext)_localctx).right = expr(6);
						}
						break;
					case 3:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						((CompareExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(121);
						((CompareExprContext)_localctx).cpr = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_THAN) | (1L << GREATER_THAN_EQ) | (1L << LOWER_THAN) | (1L << LOWER_THAN_EQ))) != 0)) ) {
							((CompareExprContext)_localctx).cpr = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(122);
						((CompareExprContext)_localctx).right = expr(5);
						}
						break;
					case 4:
						{
						_localctx = new CompareExprContext(new ExprContext(_parentctx, _parentState));
						((CompareExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(124);
						((CompareExprContext)_localctx).cpr = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==NOT_EQUALS || _la==EQUALS) ) {
							((CompareExprContext)_localctx).cpr = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(125);
						((CompareExprContext)_localctx).right = expr(4);
						}
						break;
					case 5:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(127);
						((LogicalExprContext)_localctx).op = match(AND);
						setState(128);
						((LogicalExprContext)_localctx).right = expr(3);
						}
						break;
					case 6:
						{
						_localctx = new LogicalExprContext(new ExprContext(_parentctx, _parentState));
						((LogicalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(130);
						((LogicalExprContext)_localctx).op = match(OR);
						setState(131);
						((LogicalExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u008c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\7\2\21\n\2\f\2\16\2\24"+
		"\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\3\3\7\3"+
		"#\n\3\f\3\16\3&\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5\63"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5G\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5R\n\5\3\6\3\6"+
		"\7\6V\n\6\f\6\16\6Y\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\7\7k\n\7\f\7\16\7n\13\7\5\7p\n\7\3\7\5\7s\n\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7"+
		"\u0087\n\7\f\7\16\7\u008a\13\7\3\7\2\3\f\b\2\4\6\b\n\f\2\t\3\2\31\32\4"+
		"\2\32\32!!\3\2\26\27\3\2\5\6\3\2\3\4\3\2\n\r\3\2\b\t\2\u00a0\2\22\3\2"+
		"\2\2\4\27\3\2\2\2\6*\3\2\2\2\bQ\3\2\2\2\nS\3\2\2\2\fr\3\2\2\2\16\21\5"+
		"\b\5\2\17\21\5\4\3\2\20\16\3\2\2\2\20\17\3\2\2\2\21\24\3\2\2\2\22\20\3"+
		"\2\2\2\22\23\3\2\2\2\23\25\3\2\2\2\24\22\3\2\2\2\25\26\7\2\2\3\26\3\3"+
		"\2\2\2\27\30\t\2\2\2\30\31\7&\2\2\31\35\7\22\2\2\32\34\5\6\4\2\33\32\3"+
		"\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36$\3\2\2\2\37\35\3\2"+
		"\2\2 !\7\20\2\2!#\5\6\4\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'"+
		"\3\2\2\2&$\3\2\2\2\'(\7\23\2\2()\5\n\6\2)\5\3\2\2\2*+\7\32\2\2+,\7&\2"+
		"\2,\7\3\2\2\2-R\5\n\6\2./\t\3\2\2/\62\7&\2\2\60\61\7\7\2\2\61\63\5\f\7"+
		"\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64R\7\21\2\2\65\66\7&\2\2"+
		"\66\67\7\7\2\2\678\5\f\7\289\7\21\2\29R\3\2\2\2:<\7\"\2\2;=\5\f\7\2<;"+
		"\3\2\2\2<=\3\2\2\2=>\3\2\2\2>R\7\21\2\2?@\7\34\2\2@A\7\22\2\2AB\5\f\7"+
		"\2BC\7\23\2\2CF\5\b\5\2DE\7\35\2\2EG\5\b\5\2FD\3\2\2\2FG\3\2\2\2GR\3\2"+
		"\2\2HI\7\33\2\2IJ\7\22\2\2JK\5\f\7\2KL\7\23\2\2LM\5\b\5\2MR\3\2\2\2NO"+
		"\5\f\7\2OP\7\21\2\2PR\3\2\2\2Q-\3\2\2\2Q.\3\2\2\2Q\65\3\2\2\2Q:\3\2\2"+
		"\2Q?\3\2\2\2QH\3\2\2\2QN\3\2\2\2R\t\3\2\2\2SW\7\24\2\2TV\5\b\5\2UT\3\2"+
		"\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7\25\2\2[\13"+
		"\3\2\2\2\\]\b\7\1\2]^\7\22\2\2^_\5\f\7\2_`\7\23\2\2`s\3\2\2\2as\7#\2\2"+
		"bs\7$\2\2cs\t\4\2\2ds\7&\2\2ef\7&\2\2fo\7\22\2\2gl\5\f\7\2hi\7\20\2\2"+
		"ik\5\f\7\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mp\3\2\2\2nl\3\2\2\2"+
		"og\3\2\2\2op\3\2\2\2pq\3\2\2\2qs\7\23\2\2r\\\3\2\2\2ra\3\2\2\2rb\3\2\2"+
		"\2rc\3\2\2\2rd\3\2\2\2re\3\2\2\2s\u0088\3\2\2\2tu\f\b\2\2uv\t\5\2\2v\u0087"+
		"\5\f\7\twx\f\7\2\2xy\t\6\2\2y\u0087\5\f\7\bz{\f\6\2\2{|\t\7\2\2|\u0087"+
		"\5\f\7\7}~\f\5\2\2~\177\t\b\2\2\177\u0087\5\f\7\6\u0080\u0081\f\4\2\2"+
		"\u0081\u0082\7\16\2\2\u0082\u0087\5\f\7\5\u0083\u0084\f\3\2\2\u0084\u0085"+
		"\7\17\2\2\u0085\u0087\5\f\7\4\u0086t\3\2\2\2\u0086w\3\2\2\2\u0086z\3\2"+
		"\2\2\u0086}\3\2\2\2\u0086\u0080\3\2\2\2\u0086\u0083\3\2\2\2\u0087\u008a"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\r\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\20\20\22\35$\62<FQWlor\u0086\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}