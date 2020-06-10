package com.kiraged.script;

import com.kiraged.script.ast.AstNode;
import com.kiraged.script.ast.CompileUnitNode;
import com.kiraged.script.ast.FunctionDeclarationNode;
import com.kiraged.script.ast.ParameterDeclarationNode;
import com.kiraged.script.ast.expression.ExpressionNode;
import com.kiraged.script.ast.expression.FunctionExpressionNode;
import com.kiraged.script.ast.expression.compare.ComparisonExpressionNode;
import com.kiraged.script.ast.expression.compare.ComparisonOperator;
import com.kiraged.script.ast.expression.logic.AndExpressionNode;
import com.kiraged.script.ast.expression.logic.OrExpressionNode;
import com.kiraged.script.ast.expression.math.MathExpressionNode;
import com.kiraged.script.ast.expression.math.MathOperator;
import com.kiraged.script.ast.expression.variable.BooleanNode;
import com.kiraged.script.ast.expression.variable.DoubleNode;
import com.kiraged.script.ast.expression.variable.IntNode;
import com.kiraged.script.ast.expression.variable.VariableNode;
import com.kiraged.script.ast.statement.*;
import com.kiraged.script.parser.KiragedScriptBaseVisitor;
import com.kiraged.script.parser.KiragedScriptLexer;
import com.kiraged.script.parser.KiragedScriptParser;

import java.util.List;
import java.util.stream.Collectors;

public class BuildAstVisitor extends KiragedScriptBaseVisitor<AstNode> {
    @Override
    public AstNode visitCompileUnit(KiragedScriptParser.CompileUnitContext ctx) {
        List<StatementNode> statements = getStatements(ctx.statement());
        List<FunctionDeclarationNode> functions = getFunctions(ctx.functionDecl());
        return new CompileUnitNode(statements, functions);
    }

    @Override
    public AstNode visitFunctionDecl(KiragedScriptParser.FunctionDeclContext ctx) {
        Type type = Type.forKeyword(ctx.returnType.getText());
        List<ParameterDeclarationNode> parameters = getParameters(ctx.parameterDecl());
        return new FunctionDeclarationNode(type, ctx.func.getText(), parameters, (BlockStatementNode) visit(ctx.blockStatement()));
    }

    @Override
    public AstNode visitParameterDecl(KiragedScriptParser.ParameterDeclContext ctx) {
        Type type = Type.forKeyword(ctx.TYPE().getText());
        return new ParameterDeclarationNode(type, ctx.ID().getText());
    }

    @Override
    public AstNode visitReturnStmt(KiragedScriptParser.ReturnStmtContext ctx) {
        ExpressionNode expression = null;
        if (ctx.expr() != null) {
            expression = (ExpressionNode) visit(ctx.expr());
        }
        return new ReturnStatementNode(expression);
    }

    @Override
    public AstNode visitVarDeclStmt(KiragedScriptParser.VarDeclStmtContext ctx) {
        Type type = Type.forKeyword(ctx.type.getText());
        ExpressionNode node = null;
        if (ctx.expr() != null) {
            node = (ExpressionNode) visit(ctx.expr());
        }
        return new VariableDeclarationNode(type, ctx.name.getText(), node);
    }

    @Override
    public AstNode visitExprStmt(KiragedScriptParser.ExprStmtContext ctx) {
        return new ExpressionStatementNode((ExpressionNode) visit(ctx.stmtExpr));
    }

    @Override
    public AstNode visitBlockStmt(KiragedScriptParser.BlockStmtContext ctx) {
        return super.visit(ctx.blockStatement());
    }

    @Override
    public AstNode visitWhileStmt(KiragedScriptParser.WhileStmtContext ctx) {
        return new WhileStatement((ExpressionNode) visit(ctx.expr()), (StatementNode) visit(ctx.statement()));
    }

    @Override
    public AstNode visitBlockStatement(KiragedScriptParser.BlockStatementContext ctx) {
        List<StatementNode> statements = getStatements(ctx.statement());
        return new BlockStatementNode(statements);
    }

    @Override
    public AstNode visitIfStmt(KiragedScriptParser.IfStmtContext ctx) {
        List<StatementNode> statements = getStatements(ctx.statement());

        StatementNode thenStmt = statements.get(0);
        StatementNode elseStmt = null;
        if (statements.size() > 1) {
            elseStmt = statements.get(1);
        }

        return new IfStatement((ExpressionNode) visit(ctx.expr()), thenStmt, elseStmt);
    }

    @Override
    public AstNode visitLogicalExpr(KiragedScriptParser.LogicalExprContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.left);
        ExpressionNode right = (ExpressionNode) visit(ctx.right);
        switch (ctx.op.getType()) {
            case KiragedScriptLexer.AND:
                return new AndExpressionNode(left, right);
            case KiragedScriptLexer.OR:
                return new OrExpressionNode(left, right);
        }
        return null;
    }

    @Override
    public AstNode visitAssignVarStmt(KiragedScriptParser.AssignVarStmtContext ctx) {
        return new AssignVariableStatement(ctx.ID().getText(), (ExpressionNode) visit(ctx.expr()));
    }

    @Override
    public AstNode visitParensExpr(KiragedScriptParser.ParensExprContext ctx) {
        return super.visit(ctx.expr());
    }

    @Override
    public AstNode visitVariableExpr(KiragedScriptParser.VariableExprContext ctx) {
        return new VariableNode(ctx.value.getText());
    }

    @Override
    public AstNode visitCompareExpr(KiragedScriptParser.CompareExprContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.left);
        ExpressionNode right = (ExpressionNode) visit(ctx.right);

        ComparisonOperator operator;
        switch (ctx.cpr.getType()) {
            case KiragedScriptLexer.EQUALS:
                operator = ComparisonOperator.EQUALS;
                break;
            case KiragedScriptLexer.NOT_EQUALS:
                operator = ComparisonOperator.NOT_EQUALS;
                break;
            case KiragedScriptLexer.GREATER_THAN:
                operator = ComparisonOperator.GREATER_THAN;
                break;
            case KiragedScriptLexer.GREATER_THAN_EQ:
                operator = ComparisonOperator.GREATER_THAN_EQUALS;
                break;
            case KiragedScriptLexer.LOWER_THAN:
                operator = ComparisonOperator.LOWER_THAN;
                break;
            case KiragedScriptLexer.LOWER_THAN_EQ:
                operator = ComparisonOperator.LOWER_THAN_EQUALS;
                break;
            default:
                return null;
        }

        return new ComparisonExpressionNode(operator, left, right);
    }

    @Override
    public AstNode visitIntExpr(KiragedScriptParser.IntExprContext ctx) {
        return new IntNode(ctx.INT().getText());
    }

    @Override
    public AstNode visitDoubleExpr(KiragedScriptParser.DoubleExprContext ctx) {
        return new DoubleNode(ctx.DOUBLE().getText());
    }

    @Override
    public AstNode visitBooleanExpr(KiragedScriptParser.BooleanExprContext ctx) {
        return new BooleanNode(Boolean.parseBoolean(ctx.value.getText()));
    }

    @Override
    public AstNode visitInfixExpr(KiragedScriptParser.InfixExprContext ctx) {
        ExpressionNode left = (ExpressionNode) visit(ctx.left);
        ExpressionNode right = (ExpressionNode) visit(ctx.right);

        MathOperator operator;
        switch (ctx.op.getType()) {
            case KiragedScriptLexer.OP_MUL:
                operator = MathOperator.MULTIPLICATION;
                break;
            case KiragedScriptLexer.OP_DIV:
                operator = MathOperator.DIVISION;
                break;
            case KiragedScriptLexer.OP_ADD:
                operator = MathOperator.ADDITION;
                break;
            case KiragedScriptLexer.OP_SUB:
                operator = MathOperator.SUBTRACTION;
                break;
            default:
                return null;
        }
        return new MathExpressionNode(operator, left, right);
    }

    @Override
    public AstNode visitFuncExpr(KiragedScriptParser.FuncExprContext ctx) {
        List<ExpressionNode> arguments = getExpressions(ctx.expr());
        return new FunctionExpressionNode(ctx.ID().getText(), arguments);
    }

    private List<StatementNode> getStatements(List<KiragedScriptParser.StatementContext> statements) {
        return statements
                .stream()
                .map(this::visit)
                .map(node -> (StatementNode) node)
                .collect(Collectors.toList());
    }

    private List<FunctionDeclarationNode> getFunctions(List<KiragedScriptParser.FunctionDeclContext> functions) {
        return functions
                .stream()
                .map(this::visit)
                .map(node -> (FunctionDeclarationNode) node)
                .collect(Collectors.toList());
    }

    private List<ParameterDeclarationNode> getParameters(List<KiragedScriptParser.ParameterDeclContext> parameters) {
        return parameters
                .stream()
                .map(this::visit)
                .map(node -> (ParameterDeclarationNode) node)
                .collect(Collectors.toList());
    }

    private List<ExpressionNode> getExpressions(List<KiragedScriptParser.ExprContext> expressions) {
        return expressions
                .stream()
                .map(this::visit)
                .map(node -> (ExpressionNode) node)
                .collect(Collectors.toList());
    }
}
