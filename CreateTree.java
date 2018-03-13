package controlWork;

import java.io.File;

public class CreateTree {
    public String printDirectoryTree(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);
        //add to ArrayList

        return sb.toString();
    }

    private void printDirectoryTree(File folder, int indent,
                                    StringBuilder sb) {

        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        sb.append(getIndentString(indent));
        sb.append("|+--");
        sb.append(folder.getName());
        sb.append("/");
        sb.append("\n");
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
//                System.out.println("file " + file + " " + file.length() + "б");
                printDirectoryTree(file, indent + 1, sb);
            } else {
//                System.out.println("ffile " + file + " " + file.length() + "б");
                printFile(file, indent + 1, sb);
            }
        }

    }

    private void printFile(File file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("|+--");
        sb.append(file.getName());
        sb.append("\n");
    }

    private String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        return sb.toString();
    }
}
