package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Sin;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Sine function
 * 
 * @author Jackson Jacobs
 */

public class SinAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		return new Sin(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
