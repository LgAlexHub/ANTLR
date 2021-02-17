// Generated from calcul.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calculParser}.
 */
public interface calculListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link calculParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(calculParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(calculParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(calculParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(calculParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(calculParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(calculParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(calculParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(calculParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(calculParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(calculParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link calculParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(calculParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link calculParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(calculParser.FinInstructionContext ctx);
}