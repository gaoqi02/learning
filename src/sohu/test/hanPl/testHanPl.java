package sohu.test.hanPl;

import com.hankcs.hanlp.HanLP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qigao212074 on 2016/10/20.
 */
public class testHanPl {

    private static void parseArticle(String article) {
        List<String> list = HanLP.extractSummary(article,3);

        System.out.println(list);

    }

    public static void main(String[] args) {
        String document = "The Pearl Diver is a compact second-stage, scuba regulator that incorporates a streamlined aesthetic. The product was designed to be more hydrodynamic, allowing easy movement through the water when scuba diving. Its functional form incorporates two styles of streamlined design: one very curvilinear with wavy smooth surfaces and the other industrial and geometrical with hard shapes and line accents.\n" +
                "\n" +
                "The placement of the hose makes for a less obstructive field of motion, moving from the side of the face, straight over the shoulder to the air supply on the back. The form also makes the bubbles flow around the back of the head when swimming to avoid getting in the way of the user’s vision.";

        parseArticle(document);
    }
}
