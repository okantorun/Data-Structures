

public interface SearchTree<E> {
	int add(E item);
	boolean contains(E target);
	int find(E target);
	int remove(E target) throws Exception;
	boolean delete(E target) throws Exception;
}
