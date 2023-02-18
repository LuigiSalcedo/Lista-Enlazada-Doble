package structures;

/**
 *
 * @author Luigi Salcedo
 */
class Controller 
{
    static void verifyIndexError(LinkedList<Object> list, int index)
    {
        if(index >= list.size())
        {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is outside the range of the list.");
        }
    }
}
