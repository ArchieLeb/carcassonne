package main;

import game.Tile;
import game.Table;

public class TextMain {
    public static void main(String[] args) {
        Table matchTable = new Table(3,4);
        Tile tile1 = new Tile("Base_Game_C2_Tile_A.png");
        matchTable.placeTile(tile1,0,0);
        Tile tile2 = new Tile("Base_Game_C2_Tile_B.png");
        matchTable.placeTile(tile2,0,1);
        Tile tile3 = new Tile("02");
        matchTable.placeTile(tile3,0,2);
        Tile tile4 = new Tile("Base_Game_C2_Tile_E.png");
        matchTable.placeTile(tile4,1,1);
        Tile tile5 = new Tile("06");
        matchTable.placeTile(tile5,1,2);
        Tile tile6 = new Tile("Kirche");
        matchTable.placeTile(tile6,1,3);

        //Iteration zum Finden des längsten Tile-Namens
        int max = 0;
        int filenameLength;
        for (int i = 0; i < matchTable.getSizeX(); i++) {
            for (int j = 0; j < matchTable.getSizeY(); j++) {
                if (matchTable.getTile(i, j) == null) {
                    continue;
                } else {
                    filenameLength = matchTable.getTile(i, j).toString().length();
                    if (filenameLength > max) {
                        max = filenameLength;
                    }
                }
            }
        }
        // Verlängern aller Tile-Namen, so dass einheitliches Spielfeld entsteht
        int extra;
        for (int i = 0; i < matchTable.getSizeX(); i++) {
            for (int j = 0; j < matchTable.getSizeY(); j++) {
                if (matchTable.getTile(i, j) == null) {
                    Tile tile = new Tile("       no_tile ");
                    matchTable.placeTile(tile,i,j);
                }
                filenameLength = matchTable.getTile(i,j).toString().length();
                extra = max - filenameLength;
                StringBuilder sb = new StringBuilder(matchTable.getTile(i, j).toString());
                for (int k = 0; k < extra; k++) {
                    sb.append(" ");
                }
                matchTable.getTile(i, j).setName(sb.toString());
                }
            }

        System.out.println("\nSpielfeld");
        System.out.println(matchTable);
        System.out.println("\nKommentare");

        for (int i = 0; i < matchTable.getSizeX(); i++) {
            for (int j = 0; j < matchTable.getSizeY(); j++) {
                matchTable.getTile(i,j).loadImage(matchTable.getTile(i,j).toString());
                }
            }

//        System.out.println(tile.toString());
//        System.out.println("01 02 06 __");
//        System.out.println("02 __ 06 __");
//        System.out.println("__ __ __ __");
    }
}
