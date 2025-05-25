package game;

public class Table {

    private Tile[][] tilesArray;

    public Table(int sizeX, int sizeY) {
        tilesArray = new Tile[sizeX][sizeY];
    }

    public void placeTile(Tile tile, int x, int y) {
        tilesArray[x][y] = tile;
    }

    public Tile getTile(int x, int y) {
        return tilesArray[x][y];
    }

    public int getSizeX() {
        return tilesArray.length;
    };

    public int getSizeY() {
        return tilesArray[0].length;
    };

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSizeX(); i++) {
            for (int j = 0; j < getSizeY(); j++) {
                if (getTile(i, j)==null)
                    sb.append("__");
                else
                    sb.append(getTile(i, j).toString());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}