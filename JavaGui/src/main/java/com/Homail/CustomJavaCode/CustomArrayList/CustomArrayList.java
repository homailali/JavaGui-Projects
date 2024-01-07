package com.Homail.CustomJavaCode.CustomArrayList;
public class CustomArrayList<T> implements CALMethodsToShow<T>{
    // Fields
    private int initialPlusSizeWhichWillBeDoubled=3;
    private int sizeOfNoOfObjects=0;
    private int sizeOfArrayAsAWholeAndToStoreElementsInArray=0;
    private T[] mainArray=(T[]) new Object[this.initialPlusSizeWhichWillBeDoubled];
    // Public methods
    public int size(){

        return sizeOfNoOfObjects;
    }
    public void add(T type){
        mainArray[this.sizeOfArrayAsAWholeAndToStoreElementsInArray]=type;
        this.sizeOfArrayAsAWholeAndToStoreElementsInArray++;
        this.sizeOfNoOfObjects++;
        if (this.sizeOfArrayAsAWholeAndToStoreElementsInArray>=this.initialPlusSizeWhichWillBeDoubled) increaseSize();
    }
    public T get(int index){
        try {
            return this.mainArray[index];
        } catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("Wrong input caused:ArrayIndexOutOfBoundsException");
        }
        return null;
    }
    public void printArrayList(){
        System.out.print("{");
        for (int i=0;i<this.sizeOfNoOfObjects;i++){
            System.out.print(this.mainArray[i]+(i!=this.sizeOfNoOfObjects-1?", ":""));
        }
        System.out.println("}");
    }
    public void remove(int index){
        T[] tempArr=(T[]) new Object[this.sizeOfNoOfObjects-1];
        int countForTempArr=0;
        for (int i=0;i<this.mainArray.length;i++){
            if (i!=index && countForTempArr<tempArr.length){
                tempArr[countForTempArr]=this.mainArray[i];
                countForTempArr++;
            }
        }
        this.mainArray=tempArr;
        this.sizeOfNoOfObjects=mainArray.length;
        this.sizeOfArrayAsAWholeAndToStoreElementsInArray=mainArray.length;
        this.initialPlusSizeWhichWillBeDoubled=mainArray.length;
        increaseSize();
    }
    public void removeAll(T type){
        CustomArrayList<T> customArrayList=new CustomArrayList<>();
        for (int i=0;i<this.sizeOfNoOfObjects;i++){
            if (this.mainArray[i]!=type) customArrayList.add(this.mainArray[i]);
        }
        T[] cALCopy=(T[]) new Object[customArrayList.size()];
        for (int i=0;i<cALCopy.length;i++){
            cALCopy[i]=customArrayList.get(i);
        }
        this.mainArray=cALCopy;
        sizeOfNoOfObjects=this.mainArray.length;
        this.initialPlusSizeWhichWillBeDoubled= mainArray.length;
        this.sizeOfArrayAsAWholeAndToStoreElementsInArray=mainArray.length;
        increaseSize();
    }
    public void set(int index,T type){
        if (index>=this.sizeOfNoOfObjects) throw new ArrayIndexOutOfBoundsException();
        else this.mainArray[index]=type;
    }
    public boolean arrayContainsThis(T type){
        for (int i=0;i<this.sizeOfNoOfObjects;i++){
            if (this.mainArray[i].equals(type)) return true;
        }
        return false;
    }
    public void replaceAll(T replaceThis,T withThis){
        for (int i=0;i<this.sizeOfNoOfObjects;i++){
            if (this.mainArray[i].equals(replaceThis)) this.mainArray[i]=withThis;
        }
    }
    public boolean isSame(CustomArrayList cAL){
        if (cAL.size()!=this.sizeOfNoOfObjects) return false;
        for (int i=0;i<cAL.size();i++){
            if (this.mainArray[i]!=cAL.get(i)) return false;
        }
        return true;
    }
    // Private Ones
    private void increaseSize(){
        this.initialPlusSizeWhichWillBeDoubled*=2;
        T[] oldArr=mainArray;
        mainArray=(T[]) new Object[this.initialPlusSizeWhichWillBeDoubled];
        fillArrayAfterInCreasingSize(oldArr);
    }
    private void fillArrayAfterInCreasingSize(T[] oldArr){
        for (int i=0;i<oldArr.length;i++){
            mainArray[i]=oldArr[i];
        }
    }
}