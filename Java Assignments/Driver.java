
import java.util.*;

public class Driver {
    final int MAX_TYPE = 2;
    final static int MAX_ELEMENTS = 10000;
    //final static int MAX_ELEMENTS = 4;
    Object allObjects[] = new Object[MAX_ELEMENTS];
    HashSet aHashSet = new HashSet();
    long milliSeconds = 0;
    int objectKind = 0;
    Object first, middle, last;
   

    public Driver() {
    }

    public void init()  {
        milliSeconds = System.currentTimeMillis();
    }
    public void end()   {
        System.err.println("Time for all:       " + ( System.currentTimeMillis() - milliSeconds) );
    }

    public Object generateString()      {
        return new String( new Date().toString() + "_" +  Math.random() );
    }
    public Object generateObject()      {
        return new Object();
    }
    public Object generateMeanObject()  {
        return new MeanObject();
    }

    /*public Object objectGenerator(boolean X)    {
        return new MeanObject(MAX_ELEMENTS + 10);
    }*/
    public Object objectGenerator()     {
        if ( objectKind == 0 )
            return generateMeanObject();
       else if ( objectKind == 1 )
                return  generateObject();
        else if ( objectKind == 2 )
                return  generateString();
        else    {
                System.out.println("unkown object type - rip");
                System.exit(1);
        }
        return null;
    }
    public void addTest()       {
        for ( int index = 0; index < MAX_ELEMENTS ; index ++ )  {
                        aHashSet.add( allObjects[index] = objectGenerator() );
        }
    }
    public void containsTest()  {
        for ( int index = 0; index < MAX_ELEMENTS ; index ++ )  {
              if ( aHashSet.contains( objectGenerator() ) )
                                System.out.println("contains: " + index + " failed ");
        }
        for ( int index = 0; index < MAX_ELEMENTS; index ++ )   {
                        if ( !  aHashSet.contains( allObjects[index] ) )
                                System.out.println("contains: " + index + " failed ");
        }
    }
    public void isEmptyTest()   {
        for ( int index = 0; index < MAX_ELEMENTS ; index ++ )  {
                        aHashSet.isEmpty();
        }
    }
    public void sizeTest()      {
        for ( int index = 0; index < MAX_ELEMENTS ; index ++ )  {
                        aHashSet.size();
                        if ( aHashSet.size() != MAX_ELEMENTS )
                                System.out.println("size: " + index + " failed ");
        }
    }
    public void removeTest()    {
        Object o;
        for ( int index = 0; index < MAX_ELEMENTS ; index ++ )  {
                if ( objectKind != 0 )  {
                        if  ( aHashSet.remove( o = objectGenerator() ) )        {
                                System.out.println("remove: not existing " + index + " failed ");
                                System.out.println("\t" + o  );
                        }
                }
        }
        for ( int index = 0; index < MAX_ELEMENTS; index ++ )   {
                aHashSet.remove( allObjects[index] ) ;
        }
    }
   
   
   public void testOneKind()    {
        long milliSeconds = System.currentTimeMillis();
                for ( int index = 0; index <= MAX_TYPE; index ++ )      {
                        objectKind = index;     
                        addTest();
                }
        System.out.println("\t" + objectKind + ":add:           " + ( System.currentTimeMillis() - milliSeconds) );
        milliSeconds = System.currentTimeMillis();
        System.out.println("\t" + objectKind + ":contains:      " + ( System.currentTimeMillis() - milliSeconds) );
        milliSeconds = System.currentTimeMillis();
                isEmptyTest();
        System.out.println("\t" + objectKind + ":isEmpty:       " + ( System.currentTimeMillis() - milliSeconds) );
        milliSeconds = System.currentTimeMillis();
                sizeTest();
        System.out.println("\t" + objectKind + ":size:          " + ( System.currentTimeMillis() - milliSeconds) );
        milliSeconds = System.currentTimeMillis();
                removeTest();
        System.out.println("\t" + objectKind + ":remove:        " + ( System.currentTimeMillis() - milliSeconds) );
   }
   public void testIt() {
        aHashSet = new HashSet();
        allObjects = new Object[MAX_ELEMENTS];

        for ( int index = 0; index <= MAX_TYPE; index ++ )      {
                objectKind = index;     
                System.out.println("kind = " + objectKind );
                long milliSeconds = System.currentTimeMillis();
                testOneKind();
                System.out.println(objectKind + ":all:          " + ( System.currentTimeMillis() - milliSeconds) );
        }
   }

   public static void main(String args[] )      {
        Driver aDriver = new Driver();
        aDriver.init();
        aDriver.testIt();
        aDriver.end();
        System.exit(0);
   }
}