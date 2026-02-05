package lab_13.prob_02;

import java.util.*;

public class GroupUtil {
    /**
     *
     * 	public static Group<?> copy(Group<?> group) {
     * 	    List<?> elements = group.getElements();
     * 		Group<?> grp = new Group<?>(group.getSpecialElement(), elements);
     * 		return grp;
     * }
     *
     * Group<?> grp = new Group<?>(...) = This is invalid syntax.
     * Java does not allow instantiating a generic type with a wildcard (<?>).
     * The compiler has no idea what actual type T is, so it cannot verify type safety.
     */

    /**
     * SOLUTION
     * @param group - group parameter
     * @return Group<?>
     */
    public static Group<?> copy(Group<?> group) {
        return copyHelper(group);
    }

    private static <T> Group<T> copyHelper(Group<T> group) {
        List<T> elements = group.getElements();
        T special = group.getSpecialElement();
        return new Group<>(special, elements);
    }

    /**
     * main method
     * @param args - terminal arguments
     */
	//Test using this main method
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4);
		Group<Integer> group = new Group<>(0, list);

        Group<?> copiedGroup = GroupUtil.copy(group);

        System.out.println("original: " + group);
        System.out.println("copied: " + copiedGroup);
        System.out.println(group);
	}
}
