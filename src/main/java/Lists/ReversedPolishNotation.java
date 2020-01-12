//package Lists;
//
//
//public class ReversedPolishNotation {
//
//    private String expression;
//    private Stock stock;
//
//    public ReversedPolishNotation(String expression) {
//        this.expression = expression;
//        this.stock = new Stock();
//    }
//
//    private String[] expressionStringArray(){
//        return this.expression.trim().split(" ");
//    }
//
//    private static boolean isNumeric(String string) {
//        if (string == null) {
//            return false;
//        }
//        try {
//            double d = Double.parseDouble(string);
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//        return true;
//    }
//
//    private static int expressionResult(String sign, Integer a, Integer b){
//        if(sign.equals("+")) return b+a;
//        else if(sign.equals("-")) return b-a;
//        else if(sign.equals("*")) return b*a;
//        else if(sign.equals("/")) return b/a;
//        else return 0;
//    }
//
//    public int result() throws ArithmeticException {
//        Integer a = 0, b = 0;
//        for(String el: expressionStringArray()) {
//            if(isNumeric(el)) {
//                stock.push(el);
//                System.out.println("push "+stock.getTop().value);
//            }
//            else{
//                a = Integer.parseInt(stock.pop().toString());
//                b = Integer.parseInt(stock.pop().toString());
//                System.out.println("expression "+el+" -> "+a+el+b+"="+expressionResult(el,a,b));
//                stock.push(expressionResult(el,a,b));
//                System.out.println("push "+stock.getTop().value);
//            }
//        }
//        return (int) stock.getTop().value;
//    }
//
//    public String toString(){
//        return this.expression+" = "+this.result();
//    }
//
//}
