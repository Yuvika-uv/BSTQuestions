
public class StructuralIdenticalBST
{


    static class Node
    {
        int data;
        Node left;
        Node right;
    };


    static Node newNode(int data)
    {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return node;
    }


    static void inorder(Node root)
    {
        if (root == null)
            return;

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }


    static int isIdentical(Node root1,
                           Node root2)
    {

        if (root1 == null && root2 == null)
            return 1;


        else if (root1 != null &&
                root2 == null)
            return 0;
        else if (root1 == null &&
                root2 != null)
            return 0;
        else
        {

            if (root1.data == root2.data &&
                    isIdentical(root1.left, root2.left) == 1 &&
                    isIdentical(root1.right, root2.right) == 1)
                return 1;
            else
                return 0;
        }
    }


    public static void main(String[] args)
    {
        Node root1 = newNode(5);
        Node root2 = newNode(5);
        root1.left = newNode(3);
        root1.right = newNode(8);
        root1.left.left = newNode(2);
        root1.left.right = newNode(4);

        root2.left = newNode(3);
        root2.right = newNode(8);
        root2.left.left = newNode(2);
        root2.left.right = newNode(4);

        if (isIdentical(root1, root2)==1)
            System.out.print("Both BSTs are identical");
        else
            System.out.print("BSTs are not identical");
    }
}
