package kr.easw.lesson3;

import java.util.Random;
import java.util.Scanner;

public class SnakeGameWithoutTails {

    private static final int BOARD_SIZE = 10;
    private static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private static final Random RANDOM = new Random();
    private static int score = 0;
    private static SnakeLocation location = new SnakeLocation(0, 0);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    printBoard();
			    System.out.print("[우측 (r) | 좌측 (l) | 위 (u) | 아래 (d) | 종료 (0) ] : ");
			    if (!nextDirection(scanner.next())) {
			        System.out.println("게임 오버!");
			        System.out.printf("점수: %d\n", score);
			        break;
			    }
			    if (!hasItemOnBoard())
			        placeRandomItem();
			}
		}
    }

    private static boolean nextDirection(String keyword) {
        switch (keyword) {
            case "r":
                if (location.getY() < BOARD_SIZE - 1) {
                    location = location.adjust(0, 1);
                }
                break;
            case "l":
                if (location.getY() > 0) {
                    location = location.adjust(0, -1);
                }
                break;
            case "u":
                if (location.getX() > 0) {
                    location = location.adjust(-1, 0);
                }
                break;
            case "d":
                if (location.getX() < BOARD_SIZE - 1) {
                    location = location.adjust(1, 0);
                }
                break;
            case "0":
                return false; // 게임 종료
            default:
                System.out.println("잘못된 입력입니다.");
        }
        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (location.getX() == x && location.getY() == y) {
                    System.out.print("◼ ");
                    continue;
                }
                switch (board[x][y]) {
                    case 0:
                        System.out.print("・ ");
                        break;
                    case 1:
                        System.out.print("◼");
                        break;
                    case 2:
                        System.out.print("* ");
                        break;
                }
            }
            System.out.println();
        }
    }

    private static void placeRandomItem() {
        int toPlace = (int) (RANDOM.nextDouble() * 10);
        for (int i = 0; i < toPlace; i++) {
            int retry = 0;
            while (retry < 5) {
                SnakeLocation locate = new SnakeLocation((int) (RANDOM.nextDouble() * (BOARD_SIZE - 1)), (int) (RANDOM.nextDouble() * (BOARD_SIZE - 1)));
                if (board[locate.getX()][locate.getY()] != 0) {
                    retry++;
                    continue;
                }
                board[locate.getX()][locate.getY()] = 2;
                break;
            }
        }
    }

    private static boolean hasItemOnBoard() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (board[x][y] == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class SnakeLocation {
        private final int x;
        private final int y;

        public SnakeLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public SnakeLocation adjust(int x, int y) {
            return new SnakeLocation(this.x + x, this.y + y);
        }
    }
}
