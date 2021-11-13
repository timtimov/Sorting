import java.util.Scanner;


/**
 *
 * @author Eftim
 */
class resArray{

    int mov = 0;
    int com = 0;
    int[] array;
    public resArray(int a) {
        array = new int[a];
    }
    
    public int[] getArray(){
        return this.array;
    }
    
    public void fillarray(int[] arr, int c){
        System.arraycopy(arr, 0, this.array, 0, c);
    }
    
    public void getMovCom(){
        System.out.print(this.mov + " " + this.com + " ");
    }
    
    public void setMovComtoZero(){
        this.mov = 0;
        this.com = 0;
    }
    
    void swap(int[] a, int first, int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
    
    void arrWrite(int[] array){
        for (int k = 0; k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println("");
    }
    
    public void insert(boolean write, boolean dir){
        
        if(write)
            this.arrWrite(this.array);
            
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int q = array[i];
            this.mov+=1;
            if(dir){
                while (j > 0 && array[j-1] > q){
                    this.com+=1;
                    array[j] = array[j-1];
                    this.mov+=1;
                    j-=1;
                }
            }else{
                while (j > 0 && array[j-1] < q){
                    this.com+=1;
                    array[j] = array[j-1];
                    this.mov+=1;
                    j-=1;
                }
            }
            if(j != 0)
                this.com+=1;
            array[j] = q;
            this.mov+=1;
            if(write){
                boolean line = true;
                for (int l = 0; l < array.length; l++) {
                    if(l == i+1 && line){
                        System.out.print("|" + " ");
                        l-=1;
                        line = false;
                    }else
                        System.out.print(array[l] + " ");
                }
                if(line)
                    System.out.print("|" + " ");
                System.out.println("");
            }
        }
    }
    
    public void select(boolean write, boolean dir){
        
        if(write)
            this.arrWrite(this.array);
        
        for (int i = 0; i < array.length - 1; i++) {
            int minmax = array[i];
            int m = i;
            if (dir){
                for (int j = i+1; j < array.length; j++) {
                    this.com+=1;
                    if(array[j] < minmax){
                        minmax = array[j];
                        m = j;
                    }
                }
            }
            else{
               for (int j = i+1; j < array.length; j++) {
                   this.com+=1;
                    if(array[j] > minmax){
                        minmax = array[j];
                        m = j;
                    }
                } 
            }
            swap(array, i, m);
            this.mov+=3;
            if(write){
                boolean line = true;
                for (int l = 0; l < array.length; l++) {
                    if(l == i+1 && line){
                        System.out.print("|" + " ");
                        l-=1;
                        line = false;
                    }else
                        System.out.print(array[l] + " ");
                }
                System.out.println("");
            }
        }
        
    }
    
    public void bubble(boolean write, boolean dir){
        if(write)
            this.arrWrite(this.array);
        int mem = 0;
        int mem2 = 0;
        int mem3 = array.length;
        boolean check = false;
	boolean writecheck = false;
        
        for (int i = 1; i < mem3; i++) {
            writecheck = true;
            for (int j = array.length - 1; j > mem2; j--) {
                if(dir){
                    this.com+=1;
                    if(array[j-1] > array[j]){
                        swap(array,j-1,j);
                        this.mov+=3;
                        mem = j;
                        check = true;
                    }
                }
                else{
                    this.com+=1;
                    if(array[j-1] < array[j]){
                        swap(array,j-1,j);
                        this.mov+=3;
                        mem = j;
                        check = true;
                    }
                }
            }
            if(check == false){
                mem3 = 0;
		mem2 = array.length - 1;
                mem = array.length;
            }
		mem2 = mem;
            if(write && writecheck){
                boolean line = true;
                for (int l = 0; l < array.length; l++) {
                    if(l == mem && line){
                        System.out.print("|" + " ");
                        l-=1;
                        line = false;
                    }else if(check == false && l == array.length - 1 && line){
			System.out.print("|" + " ");
                        l-=1;
                        line = false;
			}
                    else
                        System.out.print(array[l] + " ");
                }
                if(line)
                    System.out.print("|" + " ");
                System.out.println("");
            }
            check = false;
            writecheck = false;
        }
    }         
    
    int[] merge(int[] left, int[] right, boolean write, boolean dir){
        int[] marray = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int q = 0;
        while (i < left.length && j < right.length){
            if(dir){ 
                if(left[i] <= right[j]){
                    this.com+=1;
                    marray[q] = left[i];
                    i+=1;
                }else{
                    this.com+=1;
                    marray[q] = right[j];
                    j+=1;
                }
                this.mov+=2;
                q+=1;
            }else{
                if(left[i] >= right[j]){
                    this.com+=1;
                    marray[q] = left[i];
                    i+=1;
                }else{
                    this.com+=1;
                    marray[q] = right[j];
                    j+=1;
                }
                this.mov+=2;
                q+=1;
            }
            
        }
        while(i < left.length){
            marray[q++] = left[i++];
            this.mov+=2;
        }
        while(j < right.length){
            marray[q++] = right[j++];
            this.mov+=2;
        }
        
        if(write)
            this.arrWrite(marray);
        return marray;
    }
    
    public int[] mergesort(int[] arr, boolean write, boolean dir){
        if (arr.length <= 1)
            return arr;
        int mid = (arr.length -1) / 2 ;
        if(write){
            boolean line = true;
            for (int l = 0; l < arr.length; l++) {
                if(l == mid+1 && line){
                    System.out.print("|" + " ");
                    l-=1;
                    line = false;
                }else
                    System.out.print(arr[l] + " ");
            }
            System.out.println("");
        }
        int[] newarray = new int[mid+1];
        System.arraycopy(arr, 0, newarray, 0, mid+1);
        int[] le = mergesort(newarray, write, dir);
        int[] newarray2 = new int[arr.length-1-mid];
        System.arraycopy(arr, mid+1, newarray2, 0, arr.length-1-mid);
        int[] ri = mergesort(newarray2, write, dir);
        return merge(le,ri, write, dir);
    }
    
    int partition(int left, int right, boolean dir){
        
        int pivot = array[left];
        this.mov+=1;
        int le = left;
        int ri = right + 1;
        
        while(true){
            if (dir){    
                do{
                    le+=1;
                    this.com+=1;
                } while (array[le] < pivot && le < right);
                do{
                    ri-=1;
                    this.com+=1;
                }while (array[ri] > pivot);
            }else{
                do{
                    le+=1;
                    this.com+=1;
                } while (array[le] > pivot && le < right);
                do{
                    ri-=1;
                    this.com+=1;
                }while (array[ri] < pivot);
            }
            if (le >= ri)
                break;
            swap(array, le, ri);
            this.mov+=3;
        }
        swap(array, left, ri);
        this.mov+=3;
        return ri;
    }
    
    public void quick(int left, int right, boolean write, boolean dir){
        
        if(left >= right)
            return;
        int r = partition(left, right, dir);
        if(write){
            boolean linel = true;
            boolean liner = true;
            for (int l = left; l < right+1; l++) {
                if(l == r && linel){
                    System.out.print("|" + " ");
                    l-=1;
                    linel = false;
                }else if(l == r+1 && liner){
                    System.out.print("|" + " ");
                    l-=1;
                    liner = false;
                }
                else
                    System.out.print(array[l] + " ");
            }
            if(liner)
                System.out.print("|" + " ");
            System.out.println("");
        }
        quick(left, r - 1, write, dir);
        quick(r + 1, right, write, dir);
        
    }
             
}
public class Sorting {
    
    public static void main(String[] args) {
        
        
        try(Scanner sc = new Scanner(System.in)){
            int c = 0;
            int[] arr = new int[1];
            while(sc.hasNext()){
                c+=1;
                int[] newarr = new int[c];
                System.arraycopy(arr, 0, newarr, 0, c-1);
                newarr[c-1]=sc.nextInt();
                arr = new int[c];
                System.arraycopy(newarr, 0, arr, 0, c);
            }
            resArray array = new resArray(c);
            array.fillarray(arr, c);
            
            if(args[0].equals("trace")){
                switch(args[1]){
                    case "insert": 
                        if(args[2].equals("up"))
                            array.insert(true, true);
                        if(args[2].equals("down"))
                            array.insert(true, false);
                        break;
                    case "select":
                        if(args[2].equals("up"))
                            array.select(true, true);
                        if(args[2].equals("down"))
                            array.select(true, false);
                        break;
                    case "bubble":
                        if(args[2].equals("up"))
                            array.bubble(true, true);
                        if(args[2].equals("down"))
                            array.bubble(true, false);
                        break;
                    case "merge":
                        if(args[2].equals("up")){
                            array.arrWrite(array.getArray());
                            array.mergesort(array.getArray(), true, true);
                        }
                        if(args[2].equals("down")){
                            array.arrWrite(array.getArray());
                            array.mergesort(array.getArray(), true, false);
                        }
                        break;
                    case "quick":
                        if(args[2].equals("up")){
                            array.arrWrite(array.getArray());
                            array.quick(0, c-1, true, true);
                            array.arrWrite(array.getArray());
                        }
                        if(args[2].equals("down")){
                            array.arrWrite(array.getArray());
                            array.quick(0, c-1, true, false);
                            array.arrWrite(array.getArray());
                        }
                        break;     
                }
            }
            if(args[0].equals("count")){
                switch(args[1]){
                    case "insert":
                        if(args[2].equals("up")){
                            array.insert(false, true);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.insert(false, true);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.insert(false, false);
                            array.setMovComtoZero();
                            array.insert(false, true);
                            array.getMovCom();
                        }
                        if(args[2].equals("down")){
                            array.insert(false, false);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.insert(false, false);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.insert(false, true);
                            array.setMovComtoZero();
                            array.insert(false, false);
                            array.getMovCom();
                        }
                        break;
                    case "select":
                        if(args[2].equals("up")){
                            array.select(false, true);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.select(false, true);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.select(false, false);
                            array.setMovComtoZero();
                            array.select(false, true);
                            array.getMovCom();
                        }
                        if(args[2].equals("down")){
                            array.select(false, false);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.select(false, false);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.select(false, true);
                            array.setMovComtoZero();
                            array.select(false, false);
                            array.getMovCom();
                        }
                        break;
                    case "bubble":
                        if(args[2].equals("up")){
                            array.bubble(false, true);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.bubble(false, true);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.bubble(false, false);
                            array.setMovComtoZero();
                            array.bubble(false, true);
                            array.getMovCom();
                        }
                        if(args[2].equals("down")){
                            array.bubble(false, false);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.bubble(false, false);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.bubble(false, true);
                            array.setMovComtoZero();
                            array.bubble(false, false);
                            array.getMovCom();
                        }
                        break;
                    case "merge":
                        if(args[2].equals("up")){
                            array.fillarray((array.mergesort(array.getArray(), false, true)), c);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.fillarray((array.mergesort(array.getArray(), false, true)), c);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.fillarray((array.mergesort(array.getArray(), false, false)), c);
                            array.setMovComtoZero();
                            array.mergesort(array.getArray(), false, true);
                            array.getMovCom();
                        }
                        if(args[2].equals("down")){
                            array.fillarray((array.mergesort(array.getArray(), false, false)), c);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.fillarray((array.mergesort(array.getArray(), false, false)), c);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.fillarray((array.mergesort(array.getArray(), false, true)), c);
                            array.setMovComtoZero();
                            array.mergesort(array.getArray(), false, false);
                            array.getMovCom();
                        }
                        break;
                    case "quick":
                        
                        if(args[2].equals("up")){
                            array.quick(0, c-1, false, true);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.quick(0, c-1, false, true);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.quick(0, c-1, false, false);
                            array.setMovComtoZero();
                            array.quick(0, c-1, false, true);
                            array.getMovCom();
                        }
                        if(args[2].equals("down")){
                            array.quick(0, c-1, false, false);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.quick(0, c-1, false, false);
                            array.getMovCom();
                            array.setMovComtoZero();
                            
                            array.quick(0, c-1, false, true);
                            array.setMovComtoZero();
                            array.quick(0, c-1, false, false);
                            array.getMovCom();
                        }
                        break;
                        
                }
            }
            
        }catch(Exception e){
            e.getMessage();
        }
        

    }
}
