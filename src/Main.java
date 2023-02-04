public class Main {
        //задание полей
        static float telescope = 14_000; // стоимость телескопа
        static int account = 1_000; // счёт пользователя
        static float stipend = 2500; // ежемесячная стипендия
        static int percentFree = 100; // доля  стипендии на любые траты
        static float percentBank = 5; // годовая процентная ставка на накопления
        static float[] monthPayments = new float[120];

    static private float telescopePriceWithContribution() {
            return telescope - account;}
    static public float telescopeCosts(float amount, int percent) {
            return (amount*percent)/100;
        }
    static public int countMonth(float total, float telescopeCosts, float percentBankYear){
            float percentBankMonth = percentBankYear / 12;
            int count = 0;
            while (total > 0) {
                count++;
                total = (total + (total*percentBankMonth) / 100) - telescopeCosts;

                if (total > telescopeCosts) {
                    monthPayments[count - 1] = telescopeCosts;
                } else {
                    monthPayments[count - 1] = total;
                }
            }
            return count;
        }
        public static void main(String[] args) {

            System.out.println("Средства будут накапливаться " + countMonth(telescopePriceWithContribution(), telescopeCosts(stipend, percentFree), percentBank) + " месяцев");
            String monthlyPaymentsList = "";
            for (float list : monthPayments) {
                if(list>0) {
                    monthlyPaymentsList = monthlyPaymentsList + Float.toString(list) + " монет ";}
                else {
                    break; }
            }
            System.out.println("Первоначальный взнос " + account + " монет, ежемесячные выплаты: "+ monthlyPaymentsList);
        }
    }