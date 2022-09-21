import java.io.File;
import java.util.ArrayList;

public class Node
{
    private final File folder;
    private final ArrayList<Node> children;
    private long size;
    private int level;
    private long limit;

    public Node(File folder)
    {
        this.folder = folder;
        children = new ArrayList<>();
    }

    public Node(File folder, long limit)
    {
        this(folder);
        this.limit = limit;
    }

    public File getFolder()
    {
        return folder;
    }

    public void addChild(Node node)
    {
        node.setLevel(level + 1);
        node.setLimit(limit);
        children.add(node);
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());

        builder.append(folder.getName()).append(" - ").append(size).append("\n");

        for (Node child : children)
        {
            if(child.getSize() < limit) {
                continue;
            }
            builder.append(" ".repeat(level + 1)).append(child);
        }
        return builder.toString();
    }

    private void setLimit(long limit) {
        this.limit = limit;
    }
}
