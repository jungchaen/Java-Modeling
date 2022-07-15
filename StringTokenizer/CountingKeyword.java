import java.io.*;
import java.util.StringTokenizer;

public class CountingKeyword {
    public static void main(String[] args) {
        String content = "";
        if (args.length != 1) {
            System.out.println("Usaage: java FileDetails FileName");
            return;
        }
        String fileName = args[0];

        // read file to String
        File file = new File(fileName);
        try (BufferedReader files = new BufferedReader(
                new InputStreamReader(new FileInputStream(file.getAbsolutePath())))) {
            String line = "";
            while ((line = files.readLine()) != null) {
                if (line.trim().length() > 0) {
                    content += line + "";
                }
            }
            files.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // StringTokenizer
        int i = 0;
        content = deleteOthers(content);
        StringTokenizer str = new StringTokenizer(content, ".|(|)| ");
        String[] strArray = new String[str.countTokens()];
        while (str.hasMoreTokens()) {
            strArray[i] = str.nextToken();
            i++;
        }

        // count function
        summerize(strArray);
    }

    /* Replace non-character values */
    public static String deleteOthers(String str) {
        str = str.replace("{", "");
        str = str.replace("}", "");
        str = str.replace("[", "");
        str = str.replace("]", "");
        str = str.replace("!", "");
        str = str.replace("\"", "");
        str = str.replace(";", "");
        str = str.replace(",", "");
        return str;
    }

    static void summerize(String[] content) {
        // JAVA Keywords 54
        String[] keywords = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally",
                "float", "for", "If", "goto", "Implements", "Import", "Instanceof", "Int", "interface", "long",
                "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static",
                "strict", "strictfp", "super", "switch", "synchronize", "this", "throw", "throws", "transient", "true",
                "try", "void", "volatile", "while" };

        // initialize count
        int[] count = new int[54];

        // increase count
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < 54; j++) {
                if (content[i].equals(keywords[j])) {
                    count[i] += 1;
                }
            }
        }

        // find same keyword int token
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < i; j++) {
                if (content[i].equals(content[j])) {
                    count[j] += 1;
                    count[i] = 0;
                }
            }
        }
        // print count
        for (int i = 0; i < keywords.length; i++) {
            if (count[i] > 0) {
                System.out.println(content[i] + ": " + count[i]);
            }
        }
    }
}
