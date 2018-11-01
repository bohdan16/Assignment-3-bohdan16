package com.company;
import java.util.Arrays;

public class DaryHeap {
    public int d;
    public int[] array;
    public int[] newarray;

    DaryHeap(int d)
    {
        this.array= new int[10];
        this.d=d;
    }

    public void insert(int k){
        int i=0;
        int t=0;
        while(i<array.length && t<1){
            i++;
            if(i>=array.length){
                doubleArray();
                System.out.println(i);
            }
            if (array[i]<1){
                array[i]=k;
                t++;
            }

            }
        showArray();
        swim(i);


    }

    void showArray(){
        System.out.println(Arrays.toString(array));
    }
    void shownewArray(){System.out.println(Arrays.toString(newarray));}

    private void doubleArray(){
        int w= array.length*2;
        this.newarray = new int[w];
        int g;
        for(g=0;g<array.length;g++){
            newarray[g]=array[g];
        }
        this.array=this.newarray;
    }

    public int[] DaryHeapsort(){
        int k=0;
        for(int i=0;i<array.length-1;i++){
            if(array[i]>0){
                k++;
                System.out.println(k);
            }
        }
        this.newarray = new int [k];
        int g;
        for(g=k;g>0;g--){
            newarray[g-1]=array[g-1];
        }
        shownewArray();
        for(int n=0;n<newarray.length-1;n++){
            if(newarray[n]>newarray[n+1]){
                int m= newarray[n];
                newarray[n]=newarray[n+1];
                newarray[n+1]=m;
            }
        }
        shownewArray();
        return newarray;
    }

    public int delMax(){
        int max = array[0];
        System.out.println("max is "+max);
        int last = 0;
        int k=0;
        for(int i=0; i<array.length-1; i++){
            if(array[i]<=0){
                last=array[k-1];
                System.out.println("last is "+last);
                i=array.length;
            }
            k++;
        }
        array[0]=last;
        array[k-1]=0;
        showArray();
        Sink(0);
        return max;
    }

    private void swim(int k){
        int c;
        System.out.println("Comparing " + array[k] + " and " + array[k/d]);
        while(array[k]>0 && array[k]>array[k/d]){
            c=array[k];
            array[k] = array[k/d];
            array[k/d] = c;
            k=k/d;
            showArray();
        }
    }
    private void Sink(int k){
        int j;
        System.out.println("Comparing " + array[k] + " and " + array[(k+1)*d]);
        if(array[k]<array[k+1]){
            j=array[k];
            array[k]=array[k+1];
            array[k+1]=j;
            k=1;
        }
        while((k*d)<=array.length && array[k]< array[k*d]){
            if(array[k]< array[k*d]){
                j=array[k];
                array[k]=array[k*d];
                array[k*d]=j;
                k=k*d;
                showArray();
            }
        }
    }
}