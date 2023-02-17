package structures;

/**
 *
 * @author C-Salcedo
 */
class LinkedListElement<T> 
{
    private T value;
    private LinkedListElement<T> next;
    private LinkedListElement<T> previous;
    
    LinkedListElement(T value)
    {
        this.value = value;
    }
   
    // Setters
    void setValue(T value)
    {
        this.value = value;
    }
    
    void setNext(LinkedListElement<T> next)
    {
        this.next = next;
    }
    
    void setPrevious(LinkedListElement<T> previous)
    {
        this.previous = previous;
    }
    
    // Getters
    T getValue()
    {
        return value;
    }
    
    LinkedListElement<T> getNext()
    {
        return next;
    }
    
    LinkedListElement<T> getPrevious()
    {
        return previous;
    }
    
    @Override
    public String toString()
    {
        return value.toString();
    }
}
