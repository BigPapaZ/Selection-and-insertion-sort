/**
 * Contains several methods for sorting lists using iterators
 */
public class Sorts
{
   /**
    * Performs the Selection Sort algorithm on the list
    * that created the given iterator
    * @param begin an iterator positioned just before the first element
    */
   public static void selectionSort(SimpleListIterator begin)
   {
      SimpleListIterator a = begin.clone();
      while(a.hasNext())   //Going through all of the elements
      {
          int minIdx=a.next();
          SimpleListIterator b = a.clone();

          while(b.hasNext())    //Going through the elements in the list beginning from a certain index uptil the end
          {
              int temp=b.next();
              if(temp<minIdx)   //If the order is not ascending
              {
                  a.set(temp);
                  b.set(minIdx);
                  minIdx=temp;
              }
          }
      }
   }
   /**
    * Performs the Insertion Sort algorithm on the list
    * that created the given iterator
    * @param begin an iterator positioned just before the first element
    */
   public static void insertionSort(SimpleListIterator begin)
   {
      SimpleListIterator a= begin.clone();
      
      while(a.hasNext())    //Going through all of the elements
      {
          int minIdx=a.next();
          SimpleListIterator b = a.clone();
          
          if(b.hasNext())   //Because we might be at the end of the list
          {
              int temp=b.next();
              if(temp<minIdx)   //Only calling these steps if the order is not ascending
              {
                  a.set(temp);
                  b.set(minIdx);
                  minIdx=temp;
                  
                  while(b.hasPrevious())
                  {
                      temp=b.previous();
                      SimpleListIterator c = b.clone();//Had to do it like this because you need to go back entirely
                                                       //through the list to make sure that the order is ascending
                      if(c.hasPrevious())
                      {
                          minIdx=c.previous();
                          if(temp<minIdx)
                          {
                              b.set(minIdx);
                              c.set(temp);
                          }
                      }
                  }
              }
          }
      }
   }
   
   public static void main(String[] args)
   {
      
      String[] sortLabels = {"---Selection Sort---", "---Insertion Sort---"};
      String[] listLabels = {"Array-Backed List", "Linked List"};
      
      for(int i = 0; i < 2; i++)
      {
         System.out.println(sortLabels[i]);
         for(int j = 0; j < 2; j++)
         {
            System.out.println(listLabels[j]);
            SimpleList list;
            if(j == 0)
               list = new SimpleArrayList();
            else
               list = new SimpleLinkedList();
            for(int k = 0; k < args.length; k++)
            {
               list.add(Integer.parseInt(args[k]));
            }
            System.out.println("Before: " + list);
            if(i == 0)
               selectionSort(list.begin());
            else
               insertionSort(list.begin());
       
            System.out.println("After: " + list + "\n");
         }
      }
   }
}