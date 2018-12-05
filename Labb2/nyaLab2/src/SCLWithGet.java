import java.util.Iterator;

public class SCLWithGet <E extends Comparable<? super E>>
        extends LinkedCollection<E>
        implements CollectionWithGet<E> {


    public SCLWithGet() {

    }

    @Override
    public boolean add(E element)
    {
        if ( element == null )
            throw new NullPointerException();
        else {
            head = new Entry( element, head );
            return true;
        }
    }

    @Override
    public E get(E e) {
        Iterator iter = this.iterator();
        if (this.size() < 1){
            add(e);
        return e;
        }
        else {
            while (iter.hasNext()) {
                E next = (E) iter.next();
                if (next.compareTo(e) == 0)
                    return next;
            }
            add(e);
            return e;
        }
    }
}
