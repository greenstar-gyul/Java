package gyul.data;

// ArrayList(동적배열), 내부는 배열로 만들어져요!
public class ArrayList implements List {
    private static final int INIT_SIZE = 10;

    private int[] arrayList;
    private int lastPos;

    public ArrayList() {
        arrayList = new int[INIT_SIZE];
        lastPos = -1;
    }

    // ArrayList의 마지막에 데이터 추가!
    @Override
    public void add(int data) {
        // 마지막에 값을 추가하려는데 배열이 가득찼다면?
        // → 배열의 크기를 늘려주는 작업 필요!
        if (lastPos == arrayList.length - 1) {
            resize();
        }

        // 여기를 완성해주세요!
        lastPos++;
        arrayList[lastPos] = data;
    }

    // index에 위치하는 데이터 반환!
    @Override
    public int get(int index) {
        return arrayList[index];
    }

    // index에 위치하는 데이터 삭제!
    // 데이터를 삭제하고 데이터들을 앞으로 당겨주는 작업이 필요해요
    @Override
    public void remove(int index) {
        // 여기를 완성해주세요!
        for (int i = index; i < lastPos; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        lastPos--;
    }

    // index에 있는 데이터를 변경!
    @Override
    public void set(int index, int data) {
        // 여기를 완성해주세요!
        arrayList[index] = data;
    }

    // 현재 배열의 크기를 반환!
    // arrayList 배열의 크기가 아니라, 
    // 데이터들이 몇 개 저장이 되었는지를 뜻해요!
    @Override
    public int size() {
        // 여기를 완성해주세요!
        return lastPos + 1;
    }

    // 배열이 가득찼을 때 배열의 최대 크기를 늘려주기!
    // 힌트)
    // 1. 원래 arrayList에 있는 값을 잠시 저장해둘 배열(tempList) 지정
    // 2. arrayList의 크기를 변경 (기존 크기의 2배로 늘려주세요!)
    // 3. 바뀐 크기의 arrayList에 잠시 저장해둔 값들을 다시 저장
    private void resize() {
        int[] tempList = arrayList;
        arrayList = new int[tempList.length * 2];
        for (int i = 0; i < tempList.length; i++) {
            arrayList[i] = tempList[i];
        }
    }
    
    // 아래의 main 메소드는 실제로 메소드를 잘 구현했는지를 확인하는 부분이에요!
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(10);
        list.add(20);
        list.add(30);

        // 10, 20, 30이 한줄씩 출력되어야해요!
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.set(1, 25);
        list.add(45);

        // 10, 25, 30, 45가 한줄씩 출력되어야해요!
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
