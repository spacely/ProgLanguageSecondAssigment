public class SyntaxException extends RuntimeException{
  public final String text;
  public final int position;

  public SyntaxException(String text,int position){
    super(text + "expected at position " + position);
    this.expected = text;
    this.position = position;
  }


}
