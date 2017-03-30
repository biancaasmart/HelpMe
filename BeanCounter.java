
import java.util.*;
public class BeanCounter
{
    public static void main(String[] args)
    {
        //last index = size-1
        Random rand = new Random(); 
        int black = 0;
        int white = 0;
        String lastBean = "";
        int indexOne = 0;
        int indexTwo = 0;
        ArrayList<Integer> bag = new ArrayList<Integer>();
        int bean = 0;
        int newIndex = 0;
        int size = 0;
        System.out.println("Beans     Black     White     Last");
        
        for(int i = 10; i <= 60; i++)
        {
            for(int z = i; z >0; z--)
            {
                bean = rand.nextInt(2);
                if(bean == 0)
                {
                    white++;
                }
                else
                {
                    black++;
                }
                bag.add(rand.nextInt(bag.size() + 1 ), bean);
            }
            
             System.out.print(i+"     "+black+"     "+white+"     ");
           
            while( (white != 0 || black != 0)&& size > 1 )
            {
                size = bag.size();
    
                indexTwo = rand.nextInt(size);
                newIndex = rand.nextInt(size);
                
                int b1 = bag.get(indexOne);
                int b2 = bag.get(indexTwo);
                
                if(b1 == 1 && b2 == 1)
                {
                    //both black
                    bag.add(newIndex, 1);
                    bag.remove(b1);
                    bag.remove(b2);
                    black--;
                }
                else if( b1 == 1 && b2 == 0)
                {
                    //one is black 2 is white
                    bag.add(newIndex, 0);
                    bag.remove(b1);
                    bag.remove(b2);
                    black--;
                }
                else if( b2 == 1 && b1 == 0)
                {
                    //two is black and one is white
                    bag.add(newIndex, 0);
                    bag.remove(b1);
                    bag.remove(b2);
                    black--;
                }
                else if(b1 == 0 && b2 == 0)
                {
                    //both white
                    bag.add(newIndex, 1);
                    bag.remove(b1);
                    bag.remove(b2);
                    white = white-2;
                    black++;
                }
            }
            
            if(white == 0)
            {
                lastBean = "Black";
            }
            else if(black == 0)
            {
                lastBean = "White";
            }
            System.out.println(lastBean);
                white = 0;
                black = 0;
                bag.clear();
        }
        
       int index1 = 0;
       int index2 = 0;
        
        while (black != 1 || white != 1)
            {
                index1 = rand.nextInt(bag.size());
                index2 = rand.nextInt(bag.size());


                if (bag.get(index1) == 1 && bag.get(index2) == 1)
                {
                    bag.remove(index2);
                    black--;
                }
                else if (bag.get(index1) == 1 && bag.get(index2) == 2)
                {
                    bag.remove(index1);
                    black--; 
                }
                else if (bag.get(index1) == 2 && bag.get(index2) == 1)
                {
                    bag.remove(index2);
                    black--;
                }
                else if (bag.get(index1) == 2 && bag.get(index2) == 2)
                {
                    bag.remove(index1);

                    index2 = rand.nextInt(bag.size());
                    while (bag.get(index2) == 1)
                    {
                        if (bag.get(index2) == 1)
                        {
                            index2 = rand.nextInt(bag.size());
                        }
                    }

                    bag.remove(index2);
                    bag.add(rand.nextInt(bag.size() + 1), 1);
                    black++;
                    white -= 2;
                }
            }
            String last = "";
            if (white == 1)
            {
                last = "White";
            }
            else 
            {
                last = "Black";
            }

            System.out.print(last + "\n");

            bag.clear();
            black = 0;
            black = 0;
            
    }

    public static int getBean()
    {
        Random rand = new Random();
        Boolean color = rand.nextBoolean();
        if(color) //White
        {
            return 0;
        }
        else
        {
            return 1;
        }
            
    }
}

