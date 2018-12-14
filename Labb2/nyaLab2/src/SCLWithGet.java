import java.util.Iterator;
import java.util.Objects;

import static java.util.Objects.*;

public class SCLWithGet<E extends Comparable<? super E>>
        extends LinkedCollection<E>
        implements CollectionWithGet<E> {

    /**
     * Wrapper method for the add method.
     * @param element the object to add into the list
     * @return true if element was added
     */
    @Override
    public boolean addRec(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        // For first entry.
        if (size() == 0) {
            head = new Entry(element, head);
            return true;
        }

        head = new Entry(element, head);
        add(head, head.next);
        head = head.next;
        return true;
    }

    /**
     * Adds the element in the SLC recursively and sorted.
     * @param prev The previous element before current recursion.
     * @param comp The current element.
     */
    private void addRec(Entry prev, Entry comp) {
        // Put head last.
        if (comp.next == null && head.element.compareTo(comp.element) >= 0) {
            comp.next = new Entry(head.element, null);
            return;
        }

        // Advance or put before comp.
        if (head.element.compareTo(comp.element) >= 0) {
            add(comp, comp.next);
        } else {
            Entry tmp = new Entry(head.element, comp);
            prev.next = tmp;


    @Override
    public boolean addIt(E element)
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

    /**
     * Adds and return the element.
     * @param e The element to be added and returned.
     * @return The element that was added.
     */
    @Override
    public E get(E e) {
        Iterator iter = iterator();
        if (this.size() < 1) {
            add(e);
            return e;
        } else {
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
