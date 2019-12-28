public class Factorial {

    private int number;
    private Stock<Integer> stock;

    public Factorial(int number) {
        this.number = number;
        this.stock = new Stock();
        makeFullStock();
    }

    private void makeFullStock(){
        for(int i = 1; i < this.number; i++){
           this.stock.push(i);
        }
    }

    public Stock<Integer> getStock() {
        return stock;
    }

    public int result(){
        int a , b;
        while(this.stock.getTop().previous!=null) {
            a = this.stock.pop();
            b = this.stock.pop();
            stock.push(a * b);
        }
        return (int) this.stock.getTop().value;
    }

}
