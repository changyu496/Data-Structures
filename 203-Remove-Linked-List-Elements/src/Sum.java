public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr,int l){
        if(l == arr.length){
            return 0;
        }
        return sum(arr,l+1)+arr[l];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));
    }
}
