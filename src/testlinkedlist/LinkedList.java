
package testlinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * This class implements a List by means of a linked data structure.
 * A List (also known as a <i>sequence</i>) is an ordered collection.
 * Elements in the list can be accessed by their integer index.  The
 * index of the first element in the list is zero.
 */
public class LinkedList<E> implements Iterable<E>
  {
    private Node<E> head;
    private int size;


    /**
     * A list node contains the data value and a link to the next
     * node in the linked list.
     */
    private static class Node<E>
      {
        private E data;
        private Node<E> next;


        /**
         * Construct a node with the specified data value and link.
         */
        public Node(E data, Node<E> next)
          {
            this.data = data;
            this.next = next;
          }


        /**
         * Construct a node with the given data value
         */
        public Node(E data)
          {
            this(data, null);
          }
        
        public void setData(E data){
            this.data = data;
        }
        
        public E getData(){
            return data;
        }
        
      }


    /**
     *  An iterator for this singly-linked list.
     */
    private static class LinkedListIterator<E> implements Iterator<E>
      {
        private Node<E> nextElement;


        /**
         * Construct an iterator initialized to the first element in the list.
         */
        public LinkedListIterator(Node<E> head)
          {
            nextElement = head;
          }


        /**
         * Returns true if the iteration has more elements.
         */
        @Override
        public boolean hasNext()
          {
              if(nextElement != null){
                  return true;
              } else {
                  return false;
              }
          }


        /**
         * Returns the next element in the list.
         *
         * throws NoSuchElementException if the iteration has no next element.
         */
        @Override
        public E next()
          {
            if(hasNext()){
                E data = nextElement.getData();
                nextElement = nextElement.next;
                return data;
            } else {
                throw new NoSuchElementException();
            }
          }

        // Note: Do not have to implement other methods in interface
        // Iterator since they have default implementations.
      }


    /**
     * Helper method: Find the node at a specified index.
     *
     * @return a reference to the node at the specified index
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    private Node<E> getNode(int index)
      {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        Node<E> node = head;

        for (int i = 0;  i < index;  ++i)
            node = node.next;

        return node;
      }


    /**
     * Constructs an empty list.
     */
    public LinkedList()
      {
          this.size = 0;
          this.head = null;
      }


    /**
     * Appends the specified element to the end of the list.
     */
    public void add(E element)
      {
        if (isEmpty())
            head = new Node<E>(element);
        else
          {
            Node<E> lastNode = getNode(size - 1);
            lastNode.next = new Node<E>(element);
          }

        ++size;
      }


    /**
     * Inserts the specified element at the specified position in the list.
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    public void add(int index, E element)
      {
          if(this.size < index){
              throw new IndexOutOfBoundsException();
              
          } else if(index == 0) {
              Node<E> newNode = new Node(element, this.head);
              this.head = newNode;
              
          } else if(this.size == index){
            Node<E> newNode = new Node(element, null);
            getNode(index-1).next = newNode;
        
          } else if(index < 0){
              throw new IndexOutOfBoundsException();
          }
       
          else {
           Node<E> previousNode = getNode(index -1);
           Node<E> nextNode = getNode(index);
           previousNode.next = new Node(element, nextNode);
          }
          
           ++size;
      }


    /**
     * Removes all of the elements from this list.
     */
    public void clear()
      {
        while (head != null)
          {
             Node<E> temp = head;
             head = head.next;

             temp.data = null;
             temp.next = null;
          }

        size = 0;
      }


    /**
     * Returns the element at the specified position in this list.
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E get(int index)
      {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        Node<E> node = getNode(index);
        return node.data;
      }


    /**
     * Replaces the element at the specified position in this list
     * with the specified element.
     *
     * @returns The data value previously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E set(int index, E newValue)
      {
          if(index < 0 || index > this.size - 1){
              throw new IndexOutOfBoundsException();
          }
        E oldData = this.getNode(index).getData();
        this.getNode(index).setData(newValue);
        return oldData;
      }


    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    public int indexOf(Object obj)
      {
        int index = 0;

        if (obj == null)
          {
            for (Node<E> node = head;  node != null;  node = node.next)
              {
                if (node.data == null)
                    return index;
                else
                    index++;
              }
          }
        else
          {
            for (Node<E> node = head;  node != null;  node = node.next)
              {
                if (obj.equals(node.data))
                    return index;
                else
                    index++;
              }
          }

        return -1;
    }


    /**
     * Returns <tt>true</tt> if this list contains no elements.
     */
    public boolean isEmpty()
      {
        return (this.size == 0);
      }


    /**
     * Removes the element at the specified position in this list.  Shifts
     * any subsequent elements to the left (subtracts one from their indices).
     *
     * @returns the element previously at the specified position
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E remove(int index)
      {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        } else if (index == 0){
            E removeData = getNode(index).getData();
            Node<E> removeNode = getNode(index);
            head = getNode(index + 1);
            removeNode.setData(null);
            removeNode.next = null;
            --size;
            return removeData;
            
        } else if(index == this.size -1){
            E removeData = getNode(index).getData();
            getNode(index - 1).next = null;
            --size;
            return removeData;
        } else {
            E removeData = getNode(index).getData();
            Node <E> previousNode = getNode(index -1);
            Node <E> nextNode = getNode(index + 1);
            previousNode.next = nextNode;
            --size;
            return removeData;
        }
       
      }


    /**
     * Returns the number of elements in this list.
     */
    public int size()
      {
        return this.size;
      }


    /**
     * Returns an iterator over the elements in this list in proper sequence.
     */
    @Override
    public Iterator<E> iterator()
      {
        return new LinkedListIterator(head);
        
      }


    /**
     * Returns a string representation of this list.
     */
    @Override
    public String toString()
      {
          if(this.isEmpty()){
              return "[]";
          }
          String result = "[";
          for(int i = 0; i <= size - 1; i++){
              result = result + this.getNode(i).getData();
              if(i != size -1){
                  result = result + ", ";
              }
          }
        result = result + "]";
        return result;
      }


    /*
     * Compares the specified object with this list for equality. Returns true
     * if and only if both lists contain the same elements in the same order.
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object obj)
      {
        if (obj == this)
            return true;

        if (!(obj instanceof LinkedList))
            return false;

        // cast obj to a linked list
        LinkedList listObj = (LinkedList) obj;

        // compare elements in order
        Node<E> node1 = head;
        Node    node2 = listObj.head;

        while (node1 != null && node2 != null)
          {
            // check to see if data values are equal
            if (node1.data == null)
              {
                if (node2.data != null)
                    return false;
              }
            else
              {
                if (!node1.data.equals(node2.data))
                    return false;
              }

            node1 = node1.next;
            node2 = node2.next;
          }

        return node1 == null && node2 == null;
      }


    /**
     * Returns the hash code value for this list.
     */
    @Override
    public int hashCode()
      {
        int hashCode = 1;
        Node<E> node = head;

        while (node != null)
          {
            E obj = node.data;
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
            node = node.next;
          }

        return hashCode;
      }
  }