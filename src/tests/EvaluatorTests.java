/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.Token;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("[1, -1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testAbsEvaluation() {
		String abs1 = "abs(1)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		
		ExpressionTreeNode expr = expTreeGen.makeExpression(abs1);
		for ( int i = -1; i <= 1; i++ ) {
			assertEquals(new RGBColor(Math.abs(1), Math.abs(1), Math.abs(1)), expr.evaluate(i, i));
		}
		
		String abs2 = "abs(x)";
		expr = expTreeGen.makeExpression(abs2);
		for ( int i = -1; i <= 1; i++ ) {
			assertEquals(new RGBColor(Math.abs(i), Math.abs(i), Math.abs(i)), expr.evaluate(i, i));
		}
		
	}
	
  @Test
	public void testSinEvaluation() {
		String s= "sin(1)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		ExpressionTreeNode expr= expTreeGen.makeExpression(s);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.sin(1), Math.sin(1), Math.sin(1)), expr.evaluate(i, i));
		}
		
		String s2= "sin(x)";
		expr=expTreeGen.makeExpression(s2);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), expr.evaluate(i, i));
		}
		
		String s3= "sin(y)";
		expr=expTreeGen.makeExpression(s3);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), expr.evaluate(i, i));
		}
	}

  @Test
	public void testCosEvaluation() {
		String s= "cos(1)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		ExpressionTreeNode expr= expTreeGen.makeExpression(s);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.cos(1), Math.cos(1), Math.cos(1)), expr.evaluate(i, i));
		}
		
		String s2= "cos(x)";
		expr=expTreeGen.makeExpression(s2);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), expr.evaluate(i, i));
		}
		
		String s3= "cos(y)";
		expr=expTreeGen.makeExpression(s3);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), expr.evaluate(i, i));
		}
	}

	// TODO: More tests of evaluation

	@Test
	public void testCeilEvaluation() {
		String s0= "ceil(1)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		ExpressionTreeNode expr= expTreeGen.makeExpression(s0);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.ceil(1), Math.ceil(1), Math.ceil(1)), expr.evaluate(i, i));
		}
		
		String s1= "ceil(0.5)";
		expr=expTreeGen.makeExpression(s1);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.ceil(1), Math.ceil(1), Math.ceil(1)), expr.evaluate(i, i));
		}
		
		String s2= "ceil(0)";
		expr=expTreeGen.makeExpression(s2);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.ceil(0), Math.ceil(0), Math.ceil(0)), expr.evaluate(i, i));
		}
		
		String s3= "ceil(-0.5)";
		expr=expTreeGen.makeExpression(s3);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.ceil(0), Math.ceil(0), Math.ceil(0)), expr.evaluate(i, i));
		}
		
		String s4= "ceil(-1)";
		expr=expTreeGen.makeExpression(s4);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(-1,-1,-1), expr.evaluate(i, i));
		}
		
		String s5= "ceil(-1 + -1)";
		expr=expTreeGen.makeExpression(s5);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.ceil(-2), Math.ceil(-2), Math.ceil(-2)), expr.evaluate(i, i));
		}
		
		String s6= "ceil(x)";
		expr=expTreeGen.makeExpression(s6);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), expr.evaluate(i, i));
		}
		
		String s7= "ceil(y)";
		expr=expTreeGen.makeExpression(s7);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.ceil(i), Math.ceil(i), Math.ceil(i)), expr.evaluate(i, i));
		}		
	}
	
	@Test
	public void testFloorEvaluation() {
		String s0= "floor(1)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		ExpressionTreeNode expr= expTreeGen.makeExpression(s0);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.floor(1), Math.floor(1), Math.floor(1)), expr.evaluate(i, i));
		}
		
		String s1= "floor(0.5)";
		expr=expTreeGen.makeExpression(s1);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.floor(0.5), Math.floor(0.5), Math.floor(0.5)), expr.evaluate(i, i));
		}
		
		String s2= "floor(0)";
		expr=expTreeGen.makeExpression(s2);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.floor(0), Math.floor(0), Math.floor(0)), expr.evaluate(i, i));
		}
		
		String s3= "floor(-0.5)";
		expr=expTreeGen.makeExpression(s3);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.floor(-0.5), Math.floor(-0.5), Math.floor(-0.5)), expr.evaluate(i, i));
		}
		
		String s4= "floor(-1)";
		expr=expTreeGen.makeExpression(s4);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(-1,-1,-1), expr.evaluate(i, i));
		}
		
		String s5= "floor(-1 + -1)";
		expr=expTreeGen.makeExpression(s5);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.floor(-2), Math.floor(-2), Math.floor(-2)), expr.evaluate(i, i));
		}
		
		String s6= "floor(x)";
		expr=expTreeGen.makeExpression(s6);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.floor(i), Math.floor(i), Math.floor(i)), expr.evaluate(i, i));
		}
		
		String s7= "floor(y)";
		expr=expTreeGen.makeExpression(s7);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(Math.floor(i), Math.floor(i), Math.floor(i)), expr.evaluate(i, i));
		}		
	}
	
	@Test
	public void testPlusEvaluation() {
		String s0= "1+0";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		ExpressionTreeNode expr= expTreeGen.makeExpression(s0);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(1,1,1), expr.evaluate(i, i));
		}
		
		String s1= "1+0.5";
		expr=expTreeGen.makeExpression(s1);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(1.5, 1.5, 1.5), expr.evaluate(i, i));
		}
		
		
		String s2= "1 + -1";
		expr=expTreeGen.makeExpression(s2);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(0, 0, 0), expr.evaluate(i, i));
		}
		
		String s3= "0.1 + 0.3 + 0.1";
		expr=expTreeGen.makeExpression(s3);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(0.5, 0.5, 0.5), expr.evaluate(i, i));
		}
		
		String s4= "-1 + 0";
		expr=expTreeGen.makeExpression(s4);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(-1, -1, -1), expr.evaluate(i, i));
		}
		
		String s5= "-0.5 + -0.3";
		expr=expTreeGen.makeExpression(s5);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(-0.8, -0.8, -0.8), expr.evaluate(i, i));
		}
		
		String s6= "-0.5 + -0.6";
		expr=expTreeGen.makeExpression(s6);
		for (int i= -1; i<=1; i++) {
			assertEquals(new RGBColor(-1.1, -1.1, -1.1), expr.evaluate(i, i));
		}
		
		String s7= "x + y";
		expr=expTreeGen.makeExpression(s7);
		for (int i=-1; i<=1; i++) {
			assertEquals(new RGBColor(i+i, i+i, i+i), expr.evaluate(i, i));			
		}
	}
	
	@Test
	public void testImageWrap() {
		String s= "imageWrap(x,y)";
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		ExpressionTreeNode expr= expTreeGen.makeExpression(s);
		for (int i=-1; i<=1; i++) {
			
			assertEquals(new RGBColor(i,i,i), expr.evaluate(i, i));
		}
	}
}
