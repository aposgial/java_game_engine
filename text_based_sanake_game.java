import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    private Queue<Point> snake = new LinkedList<>();
    private Point food;
    private Random random = new Random();
    private int score = 0;

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.run();
    }

    private void run() {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            draw();
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            move(input);
            if (isGameOver()) {
                System.out.println("Game over! Your score is " + score);
                break;
            }
        }
        scanner.close();
    }

    private void init() {
        snake.add(new Point(WIDTH / 2, HEIGHT / 2));
        food = new Point(random.nextInt(WIDTH), random.nextInt(HEIGHT));
    }

    private void draw() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Point p = new Point(x, y);
                if (snake.contains(p)) {
                    System.out.print("O ");
                } else if (p.equals(food)) {
                    System.out.print("X ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("Score: " + score);
    }

    private void move(String direction) {
        Point head = snake.peek();
        int x = head.x;
        int y = head.y;
        switch (direction.toLowerCase()) {
            case "up":
                y--;
                break;
            case "down":
                y++;
                break;
            case "left":
                x--;
                break;
            case "right":
                x++;
                break;
        }
        Point newHead = new Point(x, y);
        snake.add(newHead);
        if (!newHead.equals(food)) {
            snake.remove();
        } else {
            score++;
            food = new Point(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
    }

    private boolean isGameOver() {
        Point head = snake.peek();
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            return true;
        }
        for (Point p : snake) {
            if (p.equals(head) && !p.equals(snake.peek())) {
                return true;
            }
        }
        return false;
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
