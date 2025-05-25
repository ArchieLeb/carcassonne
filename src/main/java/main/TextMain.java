package main;

import game.Tile;
import game.Table;

public class TextMain {
    public static void main(String[] args) {
        Table matchTable = new Table(3,4);
        Tile tile1 = new Tile("01");
        matchTable.placeTile(tile1,0,0);
        Tile tile2 = new Tile("02");
        matchTable.placeTile(tile2,0,1);
        Tile tile3 = new Tile("06");
        matchTable.placeTile(tile3,0,2);
        Tile tile4 = new Tile("02");
        matchTable.placeTile(tile4,1,0);
        Tile tile5 = new Tile("06");
        matchTable.placeTile(tile5,1,2);

        System.out.println(matchTable);

//        System.out.println(tile.toString());
//        System.out.println("01 02 06 __");
//        System.out.println("02 __ 06 __");
//        System.out.println("__ __ __ __");
    }
}
