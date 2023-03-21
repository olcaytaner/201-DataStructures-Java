package Array.MathematicalExpression;

public class Token {

    TokenType type;
    int operand;
    char operator;
    int precedence;

    public Token(int operand){
        this.type = TokenType.OPERAND;
        this.operand = operand;
    }


    public Token(char operator){
        this.type = TokenType.OPERATOR;
        this.operator = operator;
        switch (operator){
            case '(':
                precedence = 0;
                break;
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            case ')':
                precedence = 3;
                break;
        }
    }
}
