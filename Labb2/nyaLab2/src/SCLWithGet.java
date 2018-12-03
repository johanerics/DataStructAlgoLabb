public class SCLWithGet <E extends Comparable<? super E>>
        extends LinkedCollection<E>
        implements CollectionWithGet<E> {

    @Override
    public boolean add(E element)
    {
       return false; 
    }

    @Override
    public E get(E e) {
        return null;
    }
}
