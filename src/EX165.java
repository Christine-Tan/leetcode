/**
 * Created by Seven on 26/01/2019.
 */
public class EX165 {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        while (p1 < v1.length || p2 < v2.length) {
            if (p1 < v1.length && p2 < v2.length) {
                //compare two string
                int vp1 = Integer.valueOf(v1[p1]);
                int vp2 = Integer.valueOf(v2[p2]);
                System.out.println(vp1 + " " + vp2);
                if (vp1 > vp2) return 1;
                else if (vp1 < vp2) return -1;
                else {
                    p1++;
                    p2++;
                }
            } else if (p1 < v1.length) {
                int vp1 = Integer.valueOf(v1[p1]);
                if (vp1 > 0) return 1;
                p1++;
            } else {
                int vp2 = Integer.valueOf(v2[p2]);
                if (vp2 > 0) return -1;
                p2++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        EX165 ex = new EX165();
        System.out.println(ex.compareVersion("1.0.1", "1"));


        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");

    }

}
