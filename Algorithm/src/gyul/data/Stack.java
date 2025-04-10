package gyul.data;

// 배열로 구현한 스택
public class Stack {
    private static final int INIT_SIZE = 10; // 스택의 기본 크기
    private int[] stack; // 실제 스택의 데이터들이 저장되는 공간
    private int topPos;  // 마지막 데이터가 위치한 인덱스 정보
    
    public Stack() {
        stack = new int[INIT_SIZE];
        topPos = -1;
    }
    
    // stack에 데이터 삽입
    public void push(int data) {
        if (stack.length - 1 == topPos) {
            resize();
        }
        topPos++;
        stack[topPos] = data;
    }
    
    // stack의 마지막 데이터 제거
    public void pop() {
        stack[topPos] = 0;
        topPos--;
    }
    
    // stack의 마지막 데이터 반환
    public int top() {
        return stack[topPos];
    }
    
    // 스택의 현재 크기를 반환
    public int size() {
        return topPos + 1;
    }
    
    // 스택에 저장된 값이 있는지 없는지 반환
    // 저장된 값이 없다면 true, 아니면 false 반환
    public boolean empty() {
        return topPos == -1 ? true : false;
    }
    
    private void resize() {
        int[] tempArr = stack;
        stack = new int[tempArr.length * 2];
        for (int i = 0; i < tempArr.length; i++) {
            stack[i] = tempArr[i];
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        
        while (!s.empty()) {
            System.out.println(s.top());
            s.pop();
        }
    }
}