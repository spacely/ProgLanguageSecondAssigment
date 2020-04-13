package parser;

import java.util.ArrayList;
import java.util.List;


/**
* A class that takes in a token and analyses it to generate an AST presenting our program.
*
**/
public class ExpressionParser{

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





}
