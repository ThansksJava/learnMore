package strategy;

import java.util.Random;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/4/20 16:04
 */
public class ProbStrategy implements Strategy {
    private Random random;
    private int currentHandValue;
    private int preHandValue;
    private int [][] history = {
        {1,1,1},
        {1,1,1},
        {1,1,1}
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue = 0;
        if(bet < history[currentHandValue][0]){
            handValue = 0;
        }else if(bet < history[currentHandValue][0]+history[currentHandValue][1]){
            handValue = 1;
        }else{
            handValue = 2;
        }
        preHandValue = currentHandValue;
        currentHandValue = handValue;
        return Hand.getHand(handValue);
    }

    @Override
    public void study(boolean win) {
        if(win){
            history[preHandValue][currentHandValue]++;
        }else {
            history[preHandValue][(currentHandValue+1) % 3]++;
            history[preHandValue][(currentHandValue+2) % 3]++;
        }
    }
    private int getSum(int hv){
        int sum = 0;
        for(int i=0;i < 3;i++){
            sum += history[hv][i];
        }
        return sum;
    }
}
