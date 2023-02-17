package testlinkedlist;

import structures.LinkedList;

/**
 *
 * @author C-Salcedo
 */
public class TestLinkedList 
{
    public static void main(String[] args) 
    {
        LinkedList<Integer> list = new LinkedList();
        
        list.add(1);
        list.add(3);
        list.add(2);
        
        System.out.println(list);
        
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        
        System.out.println("Size: " + list.size());
        
        list.remove(1);
        
        System.out.println(list);
    }
}
