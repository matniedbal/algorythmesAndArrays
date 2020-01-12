package Lists;

import java.util.LinkedList;
import java.util.List;

public class Stock<E> {

    private Element top;

    public Stock() {
    }

    public Stock(E value) {
        this.top = new Element(value, null);
    }

    public Element getTop() {
        return this.top;
    }

    public List<E> leaveOnlyTop(){
        E pop1 = this.pop();
        List<E> temp= new LinkedList<>();
        while(!this.isEmpty()){
            E pop = this.pop();
            temp.add(pop);
        }
        push(pop1);
        return temp;
    }

    public int getStockSize(){ // ********* w main działa, a w metodzie isPalindrome już pokazuje zero ????? why ??????
        int counter = 0;
        Element actual;
        actual = this.top;
        while(actual != null){
            counter++;
            actual=actual.previous;

        }
        return counter;
    }

    public boolean isPalindrome(){
        // **************************** skopiowany kod ze wcześniejszej medody i działa
        int counter = 0;
        Element actual;
        actual = this.top;
        while(actual != null){
            counter++;
            actual=actual.previous;

        }
        //*****************************
        Element actualNormal = this.top;
        Element actualReversed = reverseStock().getTop();

        for (int i = 0; i < counter; i++) {
            System.out.println("NORM VAL: "+actualNormal.value+" REV VAL: "+actualReversed.value+" Lists.Stock size: "+counter);

            if(!actualNormal.value.equals(actualReversed.value)) return false;
            actualNormal = actualNormal.previous;
            actualReversed = actualReversed.previous;
        }
        return true;
    }

    public void push(E value){
        if(isEmpty() == true){
            Element elementToPush = new Element(value, null);
            this.top = elementToPush;
        }
        else {
            Element elementToPush = new Element(value, this.top);
            this.top = elementToPush;
        }
    }

    public E pop(){
        Element temp = this.top;
        this.top = this.top.previous;
        return (E) temp.value;
    }

    public E peek(){
        return (E) this.top.value;
    }

    public boolean isEmpty(){
        return this.top == null;
    }

    public void print(){
        String prev;
        if(this.top.previous == null) prev = "null";
        else prev = this.top.previous.value.toString();
        System.out.println("top value:"+this.top.value+" prev:"+prev);
    }

    public Stock reverseStock(){
        E pop1 = this.pop();
        Stock<E> temp= new Stock(pop1);
        while(!this.isEmpty()){
            E pop = this.pop();
            temp.push(pop);
        }
        return temp;
    }

    public E getValue() {
        return (E) top.value;
    }

    public Element getPrevious() {
        return top.previous;
    }

    public String toString(){
            String temp = "";
            temp = temp + "[";
            Element actual = this.top;
            temp = temp + actual.value + ", ";
            actual = actual.previous;
        for (int i = 1; i < getStockSize()-1; i++) {
            temp = temp + actual.value + ", ";
            actual = actual.previous;
        }
            temp = temp + actual.value +"]";
        return temp;
    }



    class Element<E> {

        private E value;
        private Element previous;



        public Element(E value, Element previous) {
            this.value = value;
            this.previous = previous;
        }
    }




}
