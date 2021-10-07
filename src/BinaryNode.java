public class BinaryNode {
    private String value = null;
    private BinaryNode left;
    private BinaryNode right;
    private int level;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }



    @Override
    public String toString() {
        return "BinaryNode" +
                "value :" + value +
                ", left :" + left +
                ", right :" + right +
                ", height :" + level;
    }
}