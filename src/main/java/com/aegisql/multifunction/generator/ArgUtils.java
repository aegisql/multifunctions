package com.aegisql.multifunction.generator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;

public class ArgUtils {

    static String applyTemplate(String t, int n) {
        String[] vals = new String[n];
        MessageFormat format = new MessageFormat(t);
        for(int i = 0,j = 1; i < n; i++,j++) {
            vals[i] = format.format(new Object[]{j});
        }
        return String.join(",",vals);
    }

    public static String types(int n) {
        return applyTemplate("A{0}",n);
    }

    public static String typedArgs(int n) {
        return applyTemplate("A{0} a{0}",n);
    }

    public static String args(int n) {
        return applyTemplate("a{0}",n);
    }

    public static String argsTemplate(int n) {
        return applyTemplate("'{'{0}'}'",n);
    }

    public static String superTypes(int n) {
        return applyTemplate("? super A{0}",n);
    }

    public static String lazyApplyArgs(int n) {
        StringBuilder lazyApplyArgListBuilder = new StringBuilder("applyArg1(a1)");
        for (int i = 2; i <= n; i++) {
            lazyApplyArgListBuilder.append(".").append("applyArg1(a"+i+")");
        }
        return lazyApplyArgListBuilder.toString();
    }

    public static String lazyAcceptArgs(int n) {
        StringBuilder lazyApplyArgListBuilder = new StringBuilder("acceptArg1(a1)");
        for (int i = 2; i <= n; i++) {
            lazyApplyArgListBuilder.append(".").append("acceptArg1(a"+i+")");
        }
        return lazyApplyArgListBuilder.toString();
    }

    public static String applyedArgs(int n, int m) {
        String[] args = new String[m-1];
        int j = 0;
        for(int i = 0; i < m; i++) {
            if((i+1)==n) {
                continue;
            } else {
                args[j] = "a" + (i+1);
                j++;
            }
        }
        return String.join(",",args);
    }

    public static String applyedTypes(int n, int m) {
        String[] args = new String[m-1];
        int j = 0;
        for(int i = 0; i < m; i++) {
            if((i+1)==n) {
                continue;
            } else {
                args[j] = "A" + (i+1);
                j++;
            }
        }
        return String.join(",",args);
    }

    public static String applyedTypedArgs(int n, int m) {
        String[] args = new String[m-1];
        int j = 0;
        for(int i = 0; i < m; i++) {
            if((i+1)==n) {
                continue;
            } else {
                args[j] = "A"+(i+1)+" a" + (i+1);
                j++;
            }
        }
        return String.join(",",args);
    }


    public static String applySupplierArg(int n, int m) {
        return args(m).replaceAll("a"+n+"(?=,|$)","a"+n+"Supplier.get()");
    }

    public static void saveClass(String className, String content) {
        Path path = Path.of("src/main/java/com/aegisql/multifunction/tmp/"+className+".java");
        try {
            Files.deleteIfExists(path);
            Files.writeString(path,content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed saving to "+path,e);
        }
    }

}
