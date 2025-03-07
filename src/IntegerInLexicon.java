import java.util.*;

public class IntegerInLexicon {

    public List<Integer> lexicalOrder(int n) {

        Node root = new Node();
        root.value = 0;
        for (int i = 1 ; i <= 9; i++)
        {
            Node newNode = new Node();
            newNode.value = i;
            root.children.add(newNode);
            fillTree(newNode, i, n);
        }

        List<Integer> list = new ArrayList<>();
        readTree(root, 0,list);
        return list;
    }

    void readTree(Node root, int currentVal,List<Integer> list)
    {
        currentVal *=10;
        currentVal += root.value;
        list.add(currentVal);
        for (Node node : root.children)
        {
            readTree(node, currentVal,list);
        }
    }


    void fillTree(Node node, int nodeVal, int limit)
    {

        for (int i = 0;i <= 9;i++)
        {
            if (nodeVal*10 + i <= limit)
            {
                Node newNode = new Node();
                newNode.value = i;
                node.children.add(newNode);
                fillTree(newNode, nodeVal*10 + i, limit);
            }
            else
                break;
        }

    }

    class Node
    {
        int value;
        List<Node> children = new ArrayList();
    }

    public static void main(String[] args)
    {
        IntegerInLexicon lexico = new IntegerInLexicon();

        lexico.lexicalOrder(13);

    }
}
