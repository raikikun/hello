import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kazuate {

    private static final int NUMBER = 45;
    private static final int LOW_NUMBER = 10;
    private static final int HIGH_NUMBER = 99;
    private static int challenge = 5;

    public Kazuate() {

    }

    public void hitNumber(){

        while (challenge != 0) {
            System.out.println("---------------------------------------------");
            System.out.println(LOW_NUMBER + "以上で" + HIGH_NUMBER + "以下の整数値を入力してください");
            System.out.println("挑戦回数は残り" + challenge + "回");
            int num = askNumber();
            challenge--;
            if (NUMBER == num) {
                System.out.println("当たり～！！");
                System.out.println("ゲーム終了");
                break;
            } else if (num > NUMBER) {
                System.out.println("それよりは小さいよー");
                if (num > (NUMBER + 20)) {
                    System.out.println("20以上小さいよー");
                }
            } else if (num < NUMBER) {
                System.out.println("それよりは大きいよー");
                if (num < (NUMBER - 20)) {
                    System.out.println("20以上大きいよー");
                }
            } else if ((num < LOW_NUMBER) || (num > HIGH_NUMBER)) {
                System.out.println("入力した数字が範囲外です。");

            }
            if(challenge == 0){
                System.out.println("挑戦回数の上限です。");
                System.out.println("ゲーム終了");
            }

        }
    }

    public int askNumber(){
        int num;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("数字を入力してね：");
        try {
            String line = br.readLine();
            num = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.err.println("フォーマット例外です．もう一度．");
            num = askNumber(); // 再帰呼び出し
        } catch (IOException e) {
            System.err.println("入出力例外です．もう一度．");
            System.out.println("----------------------------------");
            num = askNumber(); // 再帰呼び出し
        }
        return num;
    }

    public static void main(String[] args){
        Kazuate raiki = new Kazuate();
        raiki.hitNumber();

    }
}