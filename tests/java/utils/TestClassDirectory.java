package utils;

/**
 * @author Vladyslav Dovhopol
 */
public final class TestClassDirectory {

    private TestClassDirectory() {}

    /**
     * Example: if input class is "package1.package2.AnyClassTest" then output will be "package1/package2/".
     * @param testClass Class for which path will be found.
     * @return Path to class relative to root.
     */
    public static String getPath(Class testClass) {
        Package classPackage = testClass.getPackage();
        String packageName = classPackage.getName();
        String path = packageName.replace(".", "/");
        return path + "/";
    }
}
