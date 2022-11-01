package uet.oop.bomberman.handlelevel;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.util.Scanner;

public class Handle {
    public static String[][] matrix = new String[100][100];
    public static int[][] matrixTile = new int[100][100];
    public static int[][] getXY = new int[100][100];
    public static int r; //row
    public static int c; //column
    public static int level = 1;
    public static int portalX;
    public static int portalY;

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int num) {
        level = num;
    }

    // test demo ndva
    public static void handleFile() {
        System.out.println(level);
        try {
            File myFile = new File("res/levels/Level" + String.valueOf(getLevel()) + ".txt");
            Scanner sc = new Scanner(myFile);
            String line1 = sc.nextLine();
            String[] parts = line1.split(" ");
            int l = Integer.parseInt(parts[0]);
            c = Integer.parseInt(parts[2]); // c= 31
            r = Integer.parseInt(parts[1]); // r = 13
            int line = r;
            int check = 0;
            while (sc.hasNextLine()) {
                String element = sc.nextLine();
                for(int j = 0; j < c; j++) {
                    matrix[check][j] = String.valueOf(element.charAt(j));
                }
                check++;

                if (check == line) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Handle.r; i++) {
            for (int j = 0; j < Handle.c; j++) {
                if (Handle.matrix[i][j].equals("#")) { // wall
                    matrixTile[i][j] = 0;
                } else if (Handle.matrix[i][j].equals("*")) {
                    matrixTile[i][j] = 1;
                } else if (Handle.matrix[i][j].equals("1")) {
                    matrixTile[i][j] = 3;
                } else if (Handle.matrix[i][j].equals("2")) {
                    matrixTile[i][j] = 4;
                } else if (Handle.matrix[i][j].equals("3")) {
                    matrixTile[i][j] = 5;
                } else if (Handle.matrix[i][j].equals("b")) {
                    matrixTile[i][j] = 6;
                    getXY[i][j] = 0;
                } else if (Handle.matrix[i][j].equals("s")) {
                    matrixTile[i][j] = 7;
                    getXY[i][j] = 1;
                } else if (Handle.matrix[i][j].equals("f")) {
                    matrixTile[i][j] = 8;
                    getXY[i][j] = 2;
                } else if (Handle.matrix[i][j].equals("x")) {
                    matrixTile[i][j] = 9;
                    getXY[i][j] = 3;
                    portalX = j;
                    portalY = i;
                } else if (Handle.matrix[i][j].equals("4")) {
                    matrixTile[i][j] = 10;
                } else if (Handle.matrix[i][j].equals("k")) {
                    matrixTile[i][j] = 11;
                    getXY[i][j] = 4;
                }

                else {
                    matrixTile[i][j] = 2;
                }
            }
        }
    }

}
