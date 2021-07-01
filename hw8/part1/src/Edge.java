/** An Edge represents a relationship between two
 *  vertices.
 *  @author Koffman and Wolfgang
 */
public class Edge<E> {
    public static final double UNWEIGHTED_EDGE = 0;
	/** The source vertex */
    private int source;
    /** The destination vertex */
    private int dest;
    /** The weight-time-quality */
    private E edgeProperties;
    
    /** Construct an Edge with a source of from
     * and a destination of to. Set the weight to 1.0.
     * @param source - The source vertex
     * @param dest - The destination vertex
     */
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
       // weight = 1.0;
    }
    /** Construct a weighted edge with a source of from and a destination of to.
     * Set the weight to w.
     * @param source - The source vertex
     * @param dest - The destination vertex
     * @param w - The weight
     */
    public Edge(int source, int dest,E edgeProperties) {
        this.source = source;
        this.dest = dest;
        this.edgeProperties = edgeProperties;
    }
    /** Get the source
     * @return The value of source
     */
    public int getSource() {
        return source;
    }
    /** Get the destination
     * @return The value of dest
     */
    public int getDest() {
        return dest;
    }
    /** Get the weight
     * @return the value of weight
     */
    public E getEdgeProperties() {
        return edgeProperties;
    }
    /** Return a String representation of the edge
     * @return A String representation of the edge
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[(");
        sb.append(source);
        sb.append(", ");
        sb.append(dest);
        sb.append("): ");
        sb.append(edgeProperties);
        sb.append("]");
        return sb.toString();
    }
    /** Return true if two edges are equal.
     * Edges are equal if the source and destination are equal.
     * Weight is not considered.
     * @param obj The object to compare to
     * @return true if the edges have the same source and destination
     */
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge edge = (Edge) obj;
            return (source == edge.source && dest == edge.dest);
        }
        else {
            return false;
        }
    }
    /** Return a hash code for an edge.
     * The hash code is the source shifted left 16 bits exclusive or with the dest.
     * @return a hash code for an edge
     */
    public int hashCode() {
        return (source << 16) ^ dest;
    }
}