import java.util.Iterator;
import java.util.Objects;

import static java.util.Objects.*;

public class SCLWithGet <E extends Comparable<? super E>>
        extends LinkedCollection<E>
        implements CollectionWithGet<E> {


    public SCLWithGet() {

    }


    @Override
    public boolean add(E element)
    {
        Iterator iter = this.iterator();
        if ( element == null )
            throw new NullPointerException();
        else if(this.size() < 1)
        {
            head = new Entry( element, head );
            return true;
        }
        else {
            if(head.element.compareTo(element) > 0)
            {
                head = new Entry( element, head );
                return true;
            }
            Entry prevEntry=head;
            Entry tempEntry = head;
            E next = null;

            while (iter.hasNext()) {
                next = (E) iter.next();
                prevEntry = tempEntry;
                tempEntry=tempEntry.next;
                if (next.compareTo(element) > 0)
                {
                    Entry newEntry = new Entry(element,tempEntry);
                    prevEntry.next=newEntry;
                    return true;
                }

            }
            prevEntry.next=new Entry(element, null);
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
