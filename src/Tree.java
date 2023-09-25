import java.io.File;

public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        if (files == null)
            return;
        int subDirTotal = 0;
        int fileTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
            else
                fileTotal++;
        }
        int subDirCounter = 0;
        int fileCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirCounter++;
                print(files[i], indent, subDirCounter == subDirTotal && fileCounter == fileTotal);
            } else {
                fileCounter++;
                printFile(files[i], indent, fileCounter == fileTotal);
            }
        }
    }

    public static void printFile(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile())
                subDirTotal++;
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                subDirCounter++;
                print(files[i], indent, subDirCounter == subDirTotal);
            }
        }
    }
}
