package sohu.test.dagGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qigao212074 on 2016/8/10.
 */
public class Node {

    /* 点的所有关系的集合 */
    List<ArcT> outgoing;
    //点的字母
    String word;
    public Node(String word){
        this.word=word;
        outgoing=new ArrayList<ArcT>();
    }
}
