import java.util.ArrayList;

class Main {

    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(7);
        num.add(37);
        num.add(8431);
        num.add(13033);
        num.add(524287);
        num.add(664283);
        num.add(3531271);
        num.add(2147483647);

        media(num);

    }

    private static int TestaPrimo(int n) {
        Integer EhPrimo = 1,
                d=2;
        if (n <= 1)
            EhPrimo = 0;

        while (EhPrimo == 1 && d <= n /2) {
            if (n % d  == 0)
                EhPrimo = 0;
            d = d + 1;
        }
        return EhPrimo;
    }

    public static boolean isPrime(int n) {
        if (n<= 1) {
            return false;
        }
        for (int i = 2; i< n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime02(int n){
        if (n <= 1) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    };

    private static void media(ArrayList<Integer> num){

        for(Integer valor: num){
            ArrayList<Double> tempo = new ArrayList<>(30);
            Double media = 0.0;
            for(int vez = 0; vez < 30; vez++) {
                Double inicio = Double.valueOf(System.currentTimeMillis());
                //TestaPrimo(valor);
                //isPrime(valor);
                isPrime02(valor);
                Double fim = Double.valueOf(System.currentTimeMillis());
                Double difer = (fim - inicio);
                tempo.add(difer);
                media += difer;
            }
            media = media/30;
            desvioPadrao(valor, media, tempo);
        }
    }

    private static void desvioPadrao(Integer valor, Double media, ArrayList<Double> tempo) {
        Double desvio = 0.0, x =0.0;

        for(Integer t=0; t < 30; t++){
            x += Math.pow((tempo.get(t)-(media)),2);
            desvio = Math.sqrt(x/30);
        }

        mensagem(valor,media,desvio);

    }

    private static void mensagem(Integer valor, Double media, Double desvio) {
        System.out.println(valor + " eh Primo? " + TestaPrimo(valor) + ". Tempo medio do numero foi de: " + media + " e seu Desvio Padrao foi de: " + desvio);

    }
}