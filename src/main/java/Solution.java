    class Solution {
        public String fractionAddition(String expression) {
            boolean startsWithMinus = false;
            String[] fractions = expression.split("[-+]");
            long[] num = new long[fractions.length];
            long[] den = new long[fractions.length];
            for(int i = 0; i < num.length; i++){
                if(fractions[i].isEmpty()) {
                    startsWithMinus = true;
                    continue;
                }
                String[] f = fractions[i].split("/");
                num[i] = Long.parseLong(f[0]);
                den[i] = Long.parseLong(f[1]);
            }
            int n  = fractions.length - 1;
            int j = 0;
            int k = 1;



            while(n > 0) {
                if(expression.charAt(j) == '-') {
                    num[k] = -num[k];
                    k++;
                    n--;
                }else if(expression.charAt(j) == '+') {
                    n--;
                    k++;
                }
                j++;
            }
            long common = 1;
            for(int i = 0; i < den.length; i++) {
                if(startsWithMinus && i == 0) {
                    continue;
                }
                common *= Math.abs(den[i]);
            }
            long denSum = 0;
            for(int i = 0; i < num.length; i++) {
                if(startsWithMinus && i == 0) {
                    continue;
                }
                num[i] = num[i] * (common / den[i]);
                denSum += num[i];
            }


            long gcd = gcd(Math.abs(denSum), common);
            denSum /= gcd;
            common /= gcd;
            return  denSum + "/" + common;


        }
        public  long gcd(long a, long b) {
            while (b != 0) {
                long temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }