//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计
package com.aseara.leetcode.editor.cn.a155;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 155.最小栈 <br />
 * Date: 2019/11/10 <br/>
 *
 * @author qiujingde
 */
class MinStackTest {
    
    @Test
    void test1() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }
}


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private Node top = null;
    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        Node node = new Node(x);
        node.next = top;
        top = node;
        min = Math.min(x, min);
    }
    
    public void pop() {
        Node tmp = top;
        top = top.next;
        if (tmp.val == min) {
            refreshMin();
        }
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return min;
    }

    private void refreshMin() {
        min = Integer.MAX_VALUE;
        for (Node node = top; node != null; node = node.next) {
            min = Math.min(node.val, min);
        }
    }

    private static class Node {
        int val;
        Node next;
        Node (int val) {
            this.val = val;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
