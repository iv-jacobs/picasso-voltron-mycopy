/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinBW;
import picasso.parser.tokens.Token;

/**
 * Handles parsing for the PerlinBW function
 * 
 * @author Dario Fumarola
 *
 */
public class PerlinBWAnalyzer implements SemanticAnalyzerInterface {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		 
		ExpressionTreeNode right= SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode left= SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new PerlinBW(left, right);
	}
}
