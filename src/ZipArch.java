import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArch {

    public static void zipFiles(String path, List<String> savesPaths) {
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            Iterator iterator = savesPaths.iterator();
            int numOfZip = 0;
            while (iterator.hasNext()) {
                try (FileInputStream fis = new FileInputStream((String) iterator.next())) {
                    ZipEntry entry = new ZipEntry("packed_save" + numOfZip + ".txt");
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                    numOfZip++;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
