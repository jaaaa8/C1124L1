package bt_anh_hai;

public class random {
    public static int migratoryBirds(int[] arr) {
        for(int i = 0; i < arr.length-1; ++i){
            for(int j = i+1; j < arr.length;++j){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int lowestId = arr[0],tempId;
        int templength = 1, constlength = 1;
        for(int i = 0; i < arr.length-1;++i){
            if(arr[i+1] ==  arr[i]){
                templength++;
            }else{
                if(templength > constlength){
                    constlength = templength;
                    lowestId = arr[i];
                }else if(templength == constlength){
                    tempId = arr[i];
                    if(tempId < lowestId) lowestId = tempId;
                }
                templength = 1;
            }
        }
        return lowestId;
    }

    public static void main(String[] args) {
        int[] a = {1 ,4, 4, 4, 5, 3};
        System.out.println(migratoryBirds(a));
    }
}
