import java.util.Random;

public class RandomNumberServiceImpl implements RandomNumberService {
    private Random random;

    public RandomNumberServiceImpl() {
        this.random = new Random();
    }

    @Override
    public int generateRandomNumber() {
        return random.nextInt(100) + 1;
    }
}
