public class PackageSorter {
    private static final String STANDARD = "STANDARD";
    private static final String SPECIAL = "SPECIAL";
    private static final String REJECTED = "REJECTED";
    private static final int sizeLimit = 150;
    private static final long massLimit = 1_000_000;

    public PackageSorter() {
    }

    public static String sort(int width, int height, int length, int mass) {
        boolean bulkyByDimension = width >= sizeLimit || height > sizeLimit || length >= sizeLimit;
        boolean bulkyByVolume = (long) width * height * length >= massLimit;
        boolean isBulky = bulkyByDimension || bulkyByVolume;

        boolean isHeavy = mass >= 20;
        if (isBulky && isHeavy) {
            return REJECTED;
        }

        if (isBulky || isHeavy) {
            return SPECIAL;
        }

        return STANDARD;
    }

    public static void main(String[] args) {
        System.out.println(sort(20, 20, 20, 10));  // STANDARD
        System.out.println(sort(100, 100, 100, 10));  // SPECIAL
        System.out.println(sort(200, 100, 100, 10));  // SPECIAL
        System.out.println(sort(100, 100, 100, 25));  // REJECTED
        System.out.println(sort(200, 200, 200, 25));  // REJECTED
    }
}

