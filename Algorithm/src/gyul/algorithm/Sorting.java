package gyul.algorithm;

public class Sorting {
    private int[] intArr1 = { 7, 3, 5, 8, 4 };
    private int[] intArr2 = { 7, 3, 5, 8, 4 };
    private int[] intArr3 = { 7, 3, 5, 8, 4 };

    // intArr1 배열을 버블 정렬로 오름차순 정렬해주세요!
    // 버블 정렬은 데이터의 앞뒤를 계속 비교해서 마지막에 가장 큰 값이 와요!
    private void bubbleSort() {
        // 버블 정렬을 여기에 구현해주세요!
        int tmp = 0;

        for (int i = 0; i < intArr1.length - 1; i++) {
            for (int j = 1; j < intArr1.length; j++) {
                if (intArr1[j - 1] > intArr1[j]) {
                    tmp = intArr1[j];
                    intArr1[j] = intArr1[j - 1];
                    intArr1[j - 1] = tmp;
                }
            }
        }

        System.out.println("버블 정렬 결과");
        showArrStatus(intArr1);
    }

    // intArr2 배열을 버블 정렬로 오름차순 정렬해주세요!
    // 선택 정렬은 가장 작은 값을 선택해서 맨 앞으로 보내요!
    private void selectSort() {
        // 선택 정렬을 여기에 구현해주세요!
        int min = 0;
        int tmp = 0;
        int idx = 0;
        
        for (int i = 0; i < intArr2.length - 1; i++) {
            min = intArr2[i];
            idx = i;
            for (int j = i; j < intArr2.length; j++) {
                if (intArr2[j] < min) {
                    min = intArr2[j];
                    idx = j;
                }
            }
            tmp = intArr2[i];
            intArr2[i] = min;
            intArr2[idx] = tmp;
        }

        System.out.println("선택 정렬 결과");
        showArrStatus(intArr2);
    }

    // intArr3 배열을 버블 정렬로 오름차순 정렬해주세요!
    // 삽입 정렬은 데이터를 하나씩 적절한 위치에 끼워넣으며 정렬해요!
    public void insertSort() {
        // 삽입 정렬을 여기에 구현해주세요!
        int tmp = 0;
        int idx = 0;
        
        for (int i = 1; i < intArr3.length; i++) {
            tmp = intArr3[i];
            idx = i;
            for (int j = i - 1; j >= 0; j--, idx--) {
                if (intArr3[j] > tmp) {
                    intArr3[idx] = intArr3[j];
                    intArr3[j] = tmp;
                }
            }
        }

        System.out.println("삽입 정렬 결과");
        showArrStatus(intArr3);
    }

    // 아래 메소드들은 구현하지 않으셔도 됩니다!
    // 지금 배열의 상태를 출력해주는 메소드에요.
    // 정렬이 잘 진행되고 있는지 확인하고 싶을 때 중간에 호출하셔도 돼요!
    private void showArrStatus(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    // 정렬이 잘 수행되었는지 확인해보는 main 메소드에요!
    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        sorting.bubbleSort();
        System.out.println();
        sorting.selectSort();
        System.out.println();
        sorting.insertSort();
    }
}