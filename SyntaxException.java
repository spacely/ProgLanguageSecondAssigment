public class SyntaxException extends RuntimeException{
  public final String expected;
  public final int position;

  public SyntaxException(String expected,int position){
    super(expected + "expected at position " + position);
    this.expected = expected;
    this.position = position;
  }


}
