package sohu.test.collectionUtils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by qigao212074 on 2016/8/16.
 */
public class Test1 {

    public static void main(String[] args) {
        String[] arrayA = new String[] { "1", "2", "3",  "4", "5" };
        String[] arrayB = new String[] { "3", "4"};
        List<String> a = Arrays.asList(arrayA);
        List<String> b = Arrays.asList(arrayB);
        //并集
        Collection<String> union = CollectionUtils.union(a, b);
        //交集
        Collection<String> intersection = CollectionUtils.intersection(a, b);
        //交集的补集
        Collection<String> disjunction = CollectionUtils.disjunction(a, b);
        //集合相减
        Collection<String> subtract = CollectionUtils.subtract(a, b);
        Collections.sort((List<String>) union);
        Collections.sort((List<String>) intersection);
        Collections.sort((List<String>) disjunction);
        Collections.sort((List<String>) subtract);
        System.out.println("A: " + ArrayUtils.toString(a.toArray()));
        System.out.println("B: " + ArrayUtils.toString(b.toArray()));
        System.out.println("--------------------------------------------");
        System.out.println("Union(A, B): " + ArrayUtils.toString(union.toArray()));
        System.out.println("Intersection(A, B): " + ArrayUtils.toString(intersection.toArray()));
        System.out.println("Disjunction(A, B): " + disjunction.toString());
        System.out.println("Subtract(A, B): " + ArrayUtils.toString(subtract.toArray()));
    }
}
