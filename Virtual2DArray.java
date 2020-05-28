import java.util.Scanner;

public class Virtual2DArray {
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Create array:");
        System.out.print("# of Row:");
        int totalRows = input.nextInt();
        System.out.print("# of Columns:");
        int totalColumns = input.nextInt();
        
        int[] arr = createArr(totalRows, totalColumns);
        System.out.println("New array created with " + totalRows +
        "rows and " + totalColumns + "columns");
        
        
        boolean keepRunning = true;
        while(keepRunning){
            System.out.println("\nSelect a function: \n1. Insert Element \n2. Find Element \n3.Exit");
            int chooseFunction = input.nextInt();
            int rowInput, colInput;
            switch(chooseFunction){
                case 1:
                System.out.println("\nInsert Element");
                System.out.print("Row: ");
                rowInput = input.nextInt();
                System.out.print("Column: ");
                colInput = input.nextInt();
                System.out.print("Value: ");
                int value = input.nextInt();
                fillPosition(arr, totalRows, totalColumns, rowInput, colInput, value);
                break;
                case 2:
                System.out.println("\nFind Element");
                System.out.print("Row: ");
                rowInput = input.nextInt();
                System.out.print("Column: ");
                colInput = input.nextInt();
                System.out.println("Value = " + findPositionVal(arr, totalRows, totalColumns, rowInput, colInput));
                break;
                case 3:
                keepRunning = false;
                break;
            }
        }
        input.close();
        System.out.println("Array:\n");
        for(int i = 0; i < arr.length; i++){
            if(i % totalColumns == 0){
                System.out.println();
                System.out.print(arr[i] + " ");
            }
            else{
                System.out.print(arr[i] + " ");
            }
        }
    }
    
    static int [] createArr(int rows, int columns){
        int[] arr = new int [rows * columns];
        return arr;
    }
    
    static void fillPosition(int[] arr, int totalRows, int totalCols, int row, int col, int value){
        if(totalRows > row && totalCols > col){
            arr[(row * totalCols) + col] = value;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    static int findPositionVal(int [] arr, int totalRows, int totalCols, int row, int col) {
        if(totalRows > row && totalCols > col){
            return arr[(row * totalCols) + col];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}