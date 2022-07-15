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
        // JAVA Keywords
        String[] keywords = { "abstract", "default", "If", "package", "this", "assert", "do", "goto", "private",
                "throw", "boolean", "double", "Implements", "protected", "throws", "break", "else", "Import", "public",
                "transient", "byte", "enum", "Instanceof", "return", "true", "case", "extends", "Int", "short", "try",
                "catch", "false", "interface", "static", "void", "char", "final", "long", "strictfp", "volatile",
                "class", "finally", "native", "super", "while", "const", "float", "new", "switch", "continue", "for",
                "null", "synchronize" };

        // initialize count
        int[] count = new int[keywords.length];

        // increase count
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < keywords.length; j++) {
                if (content[i].equals(keywords[j])) {
                    count[j] += 1;
                }
            }
        }

        // print count
        for (int i = 0; i < keywords.length; i++) {
            if (count[i] > 0) {
                System.out.println(keywords[i] + ": " + count[i]);
            }

        }
    }
}
