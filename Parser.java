
import java.util.ArrayList;
import java.util.List;


/**
* A class that takes in a token and analyses it to generate an AST presenting our program.
*
**/
public class Parser{

  int position;
  private String input;

  public ExpressionParser(String input){
    this.input = input;

  }


  private void whitespace(){
      while(position < input.length() && Character.isWhitespace(input.charAt(position))){
        position = position +1 ;
      }

  }

  private void consume(String token){
    whitespace();
    if(position + token.length() <= input.length() && input.substring(position,position+token.length()).equals(token)){
      position = position + token.length();

    }else {
      throw new SyntaxException(token,position);
    }

  }

  private boolean test(String token){
      int start = position;
      boolean success;
      try {
          consume(token);
          success = true;

      }catch (SyntaxException se){
        success = false;
      }
    position = start;
    return success;
  }

  private enum Operator{MINUS,PLUS}


  private static class OperatorWithExpression {
          private final Operator operator;
          private final Expression expression;

          OperatorWithExpression(Operator operator, Expression expression) {
              this.operator = operator;
              this.expression = expression;
          }
      }
  Expression expression(){
      Expression firstAtom = atom();
      List<OperatorWithExpression> moreAtoms = new ArrayList<OperatorWithExpression>();

      while(testOperator()) {
            Operator operator = operator();
            Expression expression = atom();
            moreAtoms.add(new OperatorWithExpression(operator, expression));
        }
        Expression expression = firstAtom;
       for (OperatorWithExpression atom: moreAtoms) {
           switch (atom.operator) {
               case PLUS:
                   expression = new Addition(expression, atom.expression);
                   break;
               case MINUS:
                   expression = new Subtraction(expression, atom.expression);
                   break;
           }
       }
       return expression;



  }

  private Operator operator(){
    whitespace();
    char next = (char) 0;
    if(position < input.length()){
      next = input.charAt(position);
      position = position + 1;
    }
    if(next == '+'){
      return Operator.PLUS;
    }else if(next == '-'){
      return Operator.MINUS;
    }
    else {
      throw new SyntaxException("Operator",position);
    }


  }

  private boolean testOperator{


    
  }





}
