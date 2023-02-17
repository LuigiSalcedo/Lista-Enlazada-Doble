package structures;

/**
 *
 * @author C-Salcedo
 * @param <T>
 */

/*
 *  Add. -> Agregar elementos.
 *  Remove. -> Elimiar elementos.
 *  Size. -> Obtener tamaño.
 *  Get. -> Obtener un elemento.
 */
public class LinkedList<T> 
{
    private int size;
    private LinkedListElement<T> first;
    private LinkedListElement<T> last;
    
    public LinkedList()
    {
        size = 0;
    }
    
    public void add(T element)
    {
        if(size == 0) 
        {
            first = new LinkedListElement(element);
            last = first;
            size++;
            return;
        }
        
        LinkedListElement<T> piv = first;
        
        while(piv.getNext() != null) piv = piv.getNext();
        
        piv.setNext(new LinkedListElement(element));
        piv.getNext().setPrevious(piv);
        
        last = piv.getNext();
        size++;
    }
    
    public T get(int index)
    {
        LinkedListElement<T> piv = searchElement(index);
        
        return piv.getValue();
    }
    
    public void remove(int index)
    {
        LinkedListElement<T> piv = searchElement(index);
        
        piv.getPrevious().setNext(piv.getNext());
        piv.getNext().setPrevious(piv.getPrevious());
        
        if(piv == last)
        {
            last = piv.getPrevious();
        }
        
        if(piv == first)
        {
            first = piv.getNext();
        }
        
        size--;
    }
    
    public int size()
    {
        return size;
    }
    
    private LinkedListElement<T> searchElement(int index)
    {
        LinkedListElement<T> piv = first;
        for(int i = 0; i < index; i++)
        {
            piv = piv.getNext();
        }
        
        return piv;
    }
    
    protected void addFirst(T element)
    {
        LinkedListElement<T> newFirst = new LinkedListElement(element);
        
        newFirst.setNext(first.getNext());
        first.setPrevious(newFirst);
        first = newFirst;
    }
        
    
    @Override
    public String toString()
    {
        LinkedListElement<T> piv = first;
       
        StringBuilder sb = new StringBuilder();
        
        while(piv != last)
        {
            sb.append(piv.getValue()).append(" <--> ");
            piv = piv.getNext();
        }
        
        sb.append(last.getValue());
        
        return sb.toString();
    }
}
