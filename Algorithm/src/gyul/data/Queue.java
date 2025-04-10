package gyul.data;

public class Queue {
    private static final int INIT_SIZE = 10; // 큐의 기본 크기
    private int[] queue; // 실제 스택의 데이터들이 저장되는 공간
    private int topPos;  // 마지막 데이터가 위치한 인덱스 정보
    
    public Queue() {
        queue = new int[INIT_SIZE];
        topPos = -1;
    }
    
    // queue에 데이터 삽입
    public void push(int data) {
        if (queue.length - 1 == topPos) {
            resize();
        }
        queue[topPos + 1] = data;
        topPos++;
    }
    
    // queue의 맨 앞의 데이터 제거
    public void pop() {
        // 맨 앞의 데이터를 제거했으니 queue 배열의 값들을 앞으로 당겨주는 작업 필요!
        for (int i = 0; i < topPos; i++) {
            queue[i] = queue[i + 1];
        }
        queue[topPos] = 0;
        topPos--;
    }
    
    // queue의 맨 앞의 데이터 반환
    public int front() {
        return queue[0];
    }
    
    // 큐의 현재 크기를 반환
    public int size() {
        return topPos + 1;
    }
    
    // 큐에 저장된 값이 있는지 없는지 반환
    // 저장된 값이 없다면 true, 아니면 false 반환
    public boolean empty() {
        return topPos == -1 ? true : false;
    }
    
    private void resize() {
        int[] tempArr = queue;
        queue = new int[tempArr.length * 2];
        for (int i = 0; i < tempArr.length; i++) {
            queue[i] = tempArr[i];
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(10);
        q.push(20);
        q.push(30);
        
        while (!q.empty()) {
            System.out.println(q.front());
            q.pop();
        }
    }
}