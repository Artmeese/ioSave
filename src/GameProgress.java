import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {

    private static final long serialVersionUID = 1L;
    private static List<String> savesPaths = new ArrayList<>();
    private static int numOfSaves = 1;
    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public static List<String> getSavesPaths() {
        return savesPaths;
    }

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public static void saveGame(String path, GameProgress saveProgress) {
        try (FileOutputStream fos = new FileOutputStream(path + "//save" + numOfSaves +".dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(saveProgress);
            savesPaths.add(path + "//save" + numOfSaves +".dat");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        numOfSaves++;
    }

    public static void deleteSaves() {
        Iterator iterator = savesPaths.iterator();
        while (iterator.hasNext()) {
            File file = new File((String) iterator.next());
            try {
                if (file.delete()) {
                    System.out.println("Save " + file.getName() + " has been deleted");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}