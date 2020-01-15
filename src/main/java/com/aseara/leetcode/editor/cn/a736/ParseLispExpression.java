//给定一个类似 Lisp 语句的表达式 expression，求出其计算结果。 
//
// 表达式语法如下所示: 
//
// 
// 表达式可以为整数，let 语法，add 语法，mult 语法。表达式的结果总是一个整数。 
// (整数可以是正整数、负整数、0) 
// let 语法表示为 (let v1 e1 v2 e2 ... vn en expr), 其中 let语法总是以字符串 "let"来表示，接下来会跟随一个或
//多个交替变量或表达式，也就是说，第一个变量 v1被分配为表达式 e1 的值，第二个变量 v2 被分配为表达式 e2 的值，以此类推；最终 let 语法的值为 e
//xpr表达式的值。 
// add语法表示为 (add e1 e2)，其中 add 语法总是以字符串 "add"来表示，该语法总是有两个表达式e1、e2, 该语法的最终结果是 e1 
//表达式的值与 e2 表达式的值之和。 
// mult语法表示为 (mult e1 e2) ，其中 mult 语法总是以字符串"mult"表示， 该语法总是有两个表达式 e1、e2，该语法的最终结果是
// e1 表达式的值与 e2 表达式的值之积。 
// 在该题目中，变量的命名以小写字符开始，之后跟随0个或多个小写字符或数字。为了方便，"add"，"let"，"mult"会被定义为"关键字"，不会在表达式的
//变量命名中出现。 
// 最后，要说一下范围的概念。在做计算时，需要注意优先级，在最内层(根据括号)的表达式的值应该先计算,然后依次计算外层的表达式。我们将保证每一个测试的表达式都
//是合法的。有关范围的更多详细信息，请参阅示例。 
// 
//
// 
//
// 示例: 
//
// 
//输入: (add 1 2)
//输出: 3
//
//输入: (mult 3 (add 2 3))
//输出: 15
//
//输入: (let x 2 (mult x 5))
//输出: 10
//
//输入: (let x 2 (mult x (let x 3 y 4 (add x y))))
//输出: 14
//解释: 
//表达式 (add x y), 在获取 x 值时, 我们应当由最内层依次向外计算, 首先遇到了 x=3, 所以此处的 x 值是 3.
//
//
//输入: (let x 3 x 2 x)
//输出: 2
//解释: let 语句中的赋值运算按顺序处理即可
//
//输入: (let x 1 y 2 x (add x y) (add x y))
//输出: 5
//解释: 
//第一个 (add x y) 计算结果是 3，并且将此值赋给了 x 。
//第二个 (add x y) 计算结果就是 3+2 = 5 。
//
//输入: (let x 2 (add (let x 3 (let x 4 x)) x))
//输出: 6
//解释: 
//(let x 4 x) 中的 x 的作用范围仅在()之内。所以最终做加法操作时，x 的值是 2 。
//
//输入: (let a1 3 b2 (add a1 1) b2) 
//输出: 4
//解释: 
//变量命名时可以在第一个小写字母后跟随数字.
//
// 
//
// 
//
// 注意: 
//
// 
// 我们给定的 expression 表达式都是格式化后的：表达式前后没有多余的空格，表达式的不同部分(关键字、变量、表达式)之间仅使用一个空格分割，并且在相
//邻括号之间也没有空格。我们给定的表达式均为合法的且最终结果为整数。 
// 我们给定的表达式长度最多为 2000 (表达式也不会为空，因为那不是一个合法的表达式)。 
// 最终的结果和中间的计算结果都将是一个 32 位整数。 
// 
//
// 
// Related Topics 字符串

package com.aseara.leetcode.editor.cn.a736;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 736.Lisp 语法解析 <br />
 * Date: 2020/1/15 <br/>
 *
 * @author qiujingde
 */
class ParseLispExpression {
    private Solution solution = new Solution();
    
    @Test
    void test1() {
        assertEquals(3, solution.evaluate("(add 1 2)"));
        assertEquals(15, solution.evaluate("(mult 3 (add 2 3))"));
        assertEquals(10, solution.evaluate("(let x 2 (mult x 5))"));
        assertEquals(14, solution.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        assertEquals(2, solution.evaluate("(let x 3 x 2 x)"));
        assertEquals(5, solution.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
        assertEquals(6, solution.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
        assertEquals(4, solution.evaluate("(let a1 3 b2 (add a1 1) b2)"));
        assertEquals(-12, solution.evaluate("(let x 7 -12)"));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evaluate(String expression) {
        return evaluate(new Expression(expression));
    }

    private int evaluate(Expression expression) {
        String str = expression.expression;
        if (str.charAt(0) == '(') {
            str = str.substring(1, str.length() - 1);
        }
        expression.expression = str;
        if (str.startsWith("add ")) {
            return add(expression);
        } else if (str.startsWith("mult ")) {
            return mult(expression);
        } else if (str.startsWith("let ")) {
            return let(expression);
        } else {
            return value(expression);
        }
    }

    private int add(Expression expression) {
        String str = expression.expression;
        Scope scope = expression.scope;
        Expression sub1 = subExpression(str, 4, scope);
        Expression sub2 = subExpression(str, 5 + sub1.expression.length(), scope);
        return evaluate(sub1) + evaluate(sub2);
    }

    private int mult(Expression expression) {
        String str = expression.expression;
        Scope scope = expression.scope;
        Expression sub1 = subExpression(str, 5, scope);
        Expression sub2 = subExpression(str, 6 + sub1.expression.length(), scope);
        return evaluate(sub1) * evaluate(sub2);
    }

    private int let(Expression expression) {
        String str = expression.expression;
        Scope scope = expression.scope;
        List<Expression> subs = new ArrayList<>();
        int start = 4;
        while (start < str.length()) {
            Expression sub = subExpression(str, start, scope);
            subs.add(sub);
            start += sub.expression.length() + 1;
        }

        for (int i = 0; i < subs.size() - 1; i += 2) {
            String variable = subs.get(i).expression;
            Expression exp = subs.get(i + 1);
            scope.setValue(variable, evaluate(exp));
        }

        return evaluate(subs.get(subs.size() - 1));
    }

    private int value(Expression expression) {
        if (Character.isDigit(expression.expression.charAt(0)) || expression.expression.charAt(0) == '-') {
            return Integer.parseInt(expression.expression);
        }
        return expression.scope.getValue(expression.expression);
    }

    private Expression subExpression(String expression, int start, Scope scope) {
        int end = start + 1;
        if (expression.charAt(start) != '(') {
            while (end < expression.length() && expression.charAt(end) != ' ') {
                end ++;
            }
            return new Expression(expression.substring(start, end), scope);
        }
        int stack = 1;
        while (stack != 0) {
            if (expression.charAt(end) == '(') {
                stack ++;
            } else if (expression.charAt(end) == ')') {
                stack --;
            }
            end ++;
        }
        Scope subScope = new Scope(scope);
        return new Expression(expression.substring(start, end), subScope);
    }

    private static class Scope {
        Scope parent;
        private Map<String, Integer> variables = new HashMap<>();

        Scope() {}
        Scope(Scope parent) {
            this.parent = parent;
        }

        public int getValue(String variable) {
            return variables.containsKey(variable) ?
                    variables.get(variable) :
                    parent.getValue(variable);
        }

        public void setValue(String variable, int value) {
            variables.put(variable, value);
        }
    }

    private static class Expression {
        String expression;
        Scope scope;
        Expression(String str) {
            this(str, new Scope());
        }
        Expression(String str, Scope scope) {
            expression = str;
            this.scope = scope;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
