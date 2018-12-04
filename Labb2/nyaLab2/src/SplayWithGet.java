public class SplayWithGet<E extends Comparable<? super E>>
                            extends AVL_Tree<E>
                            implements CollectionWithGet<E> {


    /* Rotera 1 steg i vanstervarv, dvs
               x'                 y'
              / \                / \
             A   y'  -->        x'  C
                / \            / \
               B   C          A   B
     */
    private void zig( Entry x ) {
        Entry  y  = x.right;
        E temp    = x.element;
        x.element = y.element;
        y.element = temp;
        x.right   = y.right;
        if ( x.right != null )
            x.right.parent  = x;
        y.right   = y.left;
        y.left    = x.left;
        if ( y.left != null )
            y.left.parent   = y;
        x.left    = y;
    } //   rotateLeft

    private void zag( Entry x ) {
        Entry   y = x.left;
        E    temp = x.element;
        x.element = y.element;
        y.element = temp;
        x.left    = y.left;
        if ( x.left != null )
            x.left.parent   = x;
        y.left    = y.right;
        y.right   = x.right;
        if ( y.right != null )
            y.right.parent  = y;
        x.right   = y;
    } //   rotateRight




    @Override
    public E get(E e) {
        if (!this.contains(e)) {
            this.add(e);
            return e;
        }
        else
            {
              Entry t = find(e,root);
              sort(t);
              return t == null ? null : t.element;
            }
    }
    public void sort(Entry t)
    {
        while(t.parent!=null)
        {
            if(t.equals(t.parent.left)) //om vänster om parent
                zag(t);
            else
                zig(t);                 //om höger om parent

        }

    }
    public void sort2(Entry t)
    {
        while(t.parent!=null)
        {
            if(t.element.equals(t.parent.left.element)) //om vänster om parent
                zig(t);
            else
                zag(t);                 //om höger om parent

        }

    }
}
