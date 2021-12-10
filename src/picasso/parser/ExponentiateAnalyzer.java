package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Exponentiate;
import picasso.parser.language.expressions.Mult;
import picasso.parser.tokens.Token;


/**
 * Handles parsing the exponentiation or "exponentiation function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Dario Fumarola
 * 
 */
public class ExponentiateAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		
		return new Exponentiate(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens), SemanticAnalyzer.getInstance().generateExpressionTree(
						tokens) );
	}

}
