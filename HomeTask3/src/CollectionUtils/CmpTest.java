package CollectionUtils;

class CmpTest implements Comparable<CmpTest>
{
    Integer i1;
    Integer i2;
    public CmpTest(Integer i1, Integer i2)
    {
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public int compareTo(CmpTest o) {
        if(i1.compareTo(o.i1) != 0)
        {
            return i1.compareTo(o.i1);
        }
        return i2.compareTo(o.i2);
    }

    @Override
    public String toString() {
        return i1 + " " + i2;
    }
}
