package structures;

/**
 *
 * @author C-Salcedo
 * @param <T>
 */

public class LinkedList<T> 
{
    // Atributos
    private int size;
    private LinkedListElement<T> first;
    private LinkedListElement<T> last;
    
    // Constuctores
    public LinkedList()
    {
        size = 0;
    }
    
    /*
     *  Método: add(T element).
     *
     *  Agrega un elemento a la lista.
     */
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
    
    /*
     *  Método: get(int index).
     *  
     *  Obtener un elemento de la lista en base a un indice.
     */ 
    public T get(int index)
    {
        Controller.verifyIndexError((LinkedList<Object>) this, index);
        
        LinkedListElement<T> piv = searchElement(index);
        
        return piv.getValue();
    }
    
    /*
     *  Método: remove(int index).
     *
     *  Elimina un elemento de la lista en base a un indice.
     */
    public void remove(int index)
    {
        Controller.verifyIndexError((LinkedList<Object>) this, index);
        
        LinkedListElement<T> piv = searchElement(index);
        
        if(piv != first) piv.getPrevious().setNext(piv.getNext());
        if(piv != last) piv.getNext().setPrevious(piv.getPrevious());
        
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
    
    /*
     *  Método: set(T element, int index).
     *  
     *  Agrega un elemento en una posición deseada de la lista.
     */
    public void set(T element, int index)
    {    
        LinkedListElement<T> piv = searchElement(index);
        
        if(piv == first)
        {
            addFirst(element);
            return;
        }
        
        if(index == size)
        {
            add(element);
            return;
        }
        
        LinkedListElement<T> newElement = new LinkedListElement(element);
        
        newElement.setPrevious(piv.getPrevious());
        newElement.setNext(piv);
        piv.getPrevious().setNext(newElement);
        piv.setPrevious(newElement);
        
        size++;
    }
    
    /*
     *  Método: size().
     *
     *  Retorna el tamaño actual de la lista.
     */
    public int size()
    {
        return size;
    }
    
    /*
     *  Método: isEmpty().
     *  
     *  Retorna true en caso de que la lista esté vacia, de lo contrario 
     *  retonará false.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /*
     *  Método: searchElement(int index).
     *
     *  Busca un elemento del tipo LinkedListElement 
     *  (Objeto contenedor de los valores de la lista.)
     *  y lo retorna.
     */
    private LinkedListElement<T> searchElement(int index)
    {
        LinkedListElement<T> piv = first;
        for(int i = 0; i < index; i++)
        {
            piv = piv.getNext();
        }
        
        return piv;
    }
    
    /*
     *  Método: addFirst(T element)
     *
     *  Agrega un elemento al inicio de la lista.
     */
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
        
        if(size == 0) return "empty";
        
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
