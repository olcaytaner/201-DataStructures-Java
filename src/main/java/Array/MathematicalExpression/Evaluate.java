package Array.MathematicalExpression;

public class Evaluate {

    static void infixToPostFix(Element[] infixExpression){
        Token e1;
        Stack c = new Stack(100);
        for (int i = 0; i < infixExpression.length; i++){
            Token e = infixExpression[i].getData();
            if (e.type == TokenType.OPERAND){
                System.out.print(e.operand + " ");
            } else {
                if (e.operator == '('){
                    c.push(infixExpression[i]);
                } else {
                    if (e.operator == ')'){
                        e1 = c.pop().getData();
                        while (e1.operator != '('){
                            System.out.print(e1.operator + " ");
                            e1 = c.pop().getData();
                        }
                    } else {
                        while (!c.isEmpty() && e.precedence <= c.peek().getData().precedence){
                            e1 = c.pop().getData();
                            System.out.print(e1.operator + " ");
                        }
                        c.push(infixExpression[i]);
                    }
                }
            }
        }
        while (!c.isEmpty()){
            e1 = c.pop().getData();
            System.out.print(e1.operator + " ");
        }
    }

    static int evaluate(Element[] postfixExpression){
        Stack c = new Stack(100);
        for (int i = 0; i < postfixExpression.length; i++){
            Token e = postfixExpression[i].getData();
            switch (e.type){
                case OPERAND:
                    c.push(postfixExpression[i]);
                    break;
                case OPERATOR:
                    Element e2 = c.pop();
                    Element e1 = c.pop();
                    Element result = eval(e.operator, e1.getData().operand, e2.getData().operand);
                    c.push(result);
                    break;
            }
        }
        Element e = c.pop();
        return e.getData().operand;
    }


    static Element eval(char ch, int operand1, int operand2){
        int result = 0;
        switch (ch){
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        return new Element(new Token(result));
    }

    public static void main(String[] args){
        Element[] postfix = new Element[5];
        postfix[0] = new Element(new Token(3));
        postfix[1] = new Element(new Token(4));
        postfix[2] = new Element(new Token(7));
        postfix[3] = new Element(new Token('*'));
        postfix[4] = new Element(new Token('+'));
        System.out.println(evaluate(postfix));
        Element[] infix = new Element[5];
        infix[0] = new Element(new Token(3));
        infix[1] = new Element(new Token('+'));
        infix[2] = new Element(new Token(4));
        infix[3] = new Element(new Token('*'));
        infix[4] = new Element(new Token(7));
        infixToPostFix(infix);
    }
}
