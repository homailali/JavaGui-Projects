package com.Homail.CustomJavaCode.CustomArrayList;
public interface CALMethodsToShow<T>{
    T get(int index);
    int size();
    void add(T type);
    void printArrayList();
    void remove(int index);
    void set (int index,T type);
    void removeAll(T type);
    void replaceAll(T replaceThis,T withThis);
    boolean arrayContainsThis(T type);
    boolean isSame(CustomArrayList cAl);
}