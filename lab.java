public class lab {
    public static void main(String args[]){
       lab myObj = new lab();
       System.out.println(myObj.isValid(new int[]{7, 4, 10, 3, 6, 8, 15}));
        System.out.println(myObj.isValid(new int[]{20, 12, 32, 5, 18,28,38}));
       System.out.println(myObj.isValid(new int[]{11, 3, 33, 2, 8, 10, 44}));
       System.out.println(myObj.isValid(new int[]{55, 44, 77, 33, 48, 54, 95, 22, 34,45,57,53,70,85,98 }));
    }
    public static boolean isValid(int[] arr){
        int total = 0;
        boolean valid = false;
        int left = 1;
        int right = 2;
        for(int k = 0; total < arr.length; k++){
            total = (int) (Math.pow(2,k) - 1);
            if(total == arr.length){
                valid = true;
            }
        }
        if(valid == true) {
            for (int i = 0; i + right < arr.length; i++) {
                if (arr[i] < arr[i + left]) {
                    return false;
                }
                if (i - (left - 1) >= 0 && i % 2 == 0 && i != 0) {
                    if (arr[i + left] < arr[i - (left - 1)]) {
                        return false;
                    }
                }
                if (arr[i] > arr[i + right]) {
                    return false;
                }
                if (i - (right - 1) >= 0 && i % 2 == 1 && i != 0) {
                    if (arr[i + right] > arr[i - (right - 1)]) {
                        return false;
                    }
                }
                left++;
                right++;
            }
        }
        return valid;
    }
}
