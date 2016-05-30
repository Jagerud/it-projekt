package BetygReg;

import java.io.FileNotFoundException;

/**
 * Created by Jaeger on 2016-05-27.
 */
public class Start {
    public static void main (String[] args) throws FileNotFoundException {
        CourseAdmin courseAdmin = new CourseAdmin();
        courseAdmin.getCourse();
    }
}
