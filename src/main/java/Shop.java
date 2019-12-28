import org.apache.commons.lang3.RandomStringUtils;
import java.util.PriorityQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Shop {

    private InShop shop;

    public Shop(int numberOfClients) {
        this.shop = new InShop(numberOfClients);
    }

    public InShop getShop() {
        return shop;
    }


    public class Basket{

        private List<Product> basket;
        private int numberOfProds;
        private int totalBasketValue;


        public Basket(int numberOfProds) {
            totalBasketValue = 0;
            this.numberOfProds=numberOfProds;
            this.basket = new ArrayList<>();
            for (int i = 0; i < numberOfProds; i++) {
                this.basket.add(new Product());
            }
        }

        public List<Product> getBasket() {
            return basket;
        }

        public int getTotalBasketValue() {
            for(Product el: basket){
                totalBasketValue = totalBasketValue+el.getValue();
            }
            return totalBasketValue;
        }

        public  class Product{
            private String name;
            private int value;

            public Product() {
                this.name = RandomStringUtils.randomAlphabetic(1).toUpperCase()+RandomStringUtils.randomAlphabetic(9).toLowerCase();
                this.value = (int) ((Math.random()*((2000-10)+1))+10);
            }

            public String getName() {
                return name;
            }

            public int getValue() {
                return value;
            }
        }


    }



    public class InShop {

        private Cashier cashier;
        private Queue<Client> clients;
        private List<Long> waitingTimeList;
        private int numberOfClients;

        public List<Long> getWaitingTimeList() {
            return waitingTimeList;
        }

        public InShop(int numberOfClients) {
            this.numberOfClients = numberOfClients;
            this.clients = new Queue<>();
            for (int i = 0; i <= numberOfClients; i++) {
                clients.add(new Client());
            }
            this.waitingTimeList = new LinkedList<>();
            this.cashier = new Cashier();

        }

        public class Cashier{

            List<Basket.Product> soldProducts = new LinkedList<>();
            private int earnedMoney;

            public Cashier() {
                serving();
                for(Basket.Product el: soldProducts){
                    this.earnedMoney = this.earnedMoney + el.getValue();
                }

            }

            public void serving (){
                List<Basket.Product> tempList = new LinkedList<>();
                int counter2 = numberOfClients+1;
                int counter = 0;
                int totalEarn = 0;
                int totalWaitingTime = 0;
                if(clients.getNodeByIndex(0)!=null) {
                    do {

                        counter2--;
                        counter++;
                        tempList = clients.getNodeByIndex(0).getValue().basket.getBasket();
                        for(int i =0; i < tempList.size() ; i++) {
                            this.soldProducts.add(tempList.get(i));
                        }

                        System.out.print("Klient "+counter2+" has to pay "
                                +clients.getNodeByIndex(0).getValue().basket.getTotalBasketValue()+" $$, za "
                                +clients.getNodeByIndex(0).getValue().basket.numberOfProds+" produktów. Czekał ");
                        totalEarn += clients.getNodeByIndex(0).getValue().basket.getTotalBasketValue();
                        clients.getNodeByIndex(0).getValue().setServed();
                        waitingTimeList.add((long) clients.getNodeByIndex(0).getValue().waitingTime);
                        System.out.println(waitingTimeList.get(counter-1)+" nanosekund.");
                        totalWaitingTime += waitingTimeList.get(counter-1);
                        clients.quit(0);
                    } while (clients.getNodeByIndex(0).getNext() != null);
                    System.out.println("Całkowity czas obsługi klientów: "+totalWaitingTime);
                    System.out.println("Średni czas oczekiwania to: "+(totalWaitingTime/numberOfClients));

                    System.out.println("Całkowity zarobek: "+totalEarn);
                    System.out.println("Średni koszt sprzedanych produktów: "+totalEarn/this.soldProducts.stream().count());
                    System.out.println("Ilość sprzedanych produktów: "+this.soldProducts.stream().count());
                }

            }

        }

        public class Client{

            private Basket basket;
            private boolean isServed;
            private long startTime;
            private long endTime;
            private int waitingTime;

            public Client() {
                this.basket = new Basket((int) ((Math.random()*120)+10));
                this.isServed = false;
                this.startTime = System.nanoTime();
            }



            public void setServed() {
                for(int i = 0 ; i < basket.getBasket().size() ; i++)
                    basket.getBasket().remove(i);
                this.endTime = System.nanoTime();
                this.waitingTime = (int) (this.endTime-this.startTime);
            }
        }

    }


}

